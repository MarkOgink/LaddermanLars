package nl.han.ica.leathermanlars;

//import com.sun.prism.image.ViewPort;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.leathermanlars.TextObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class LeathermanLars extends GameEngine{
	private Sound backgroundSound;
	private Player player;
	private int lifePoints;
	private TextObject dashboardText;
	private IPersistence persistence;

	public static void main(String[] args) {
		PApplet.main(new String[]{"nl.han.ica.leathermanlars.LeathermanLars"});
	}

	@Override
	public void setupGame() {
		int worldWidth=1000;
        int worldHeight=700;
        
        initializeSound();
        createDashBoard(worldWidth, 100);
        initializeTileMap();
        initializePersistence();
        createObjects();
		createViewWithViewport(worldWidth, worldHeight, 975, 700, 1.75f);
	}
	
	private void createViewWithViewport(int worldWidth,int worldHeight,int screenWidth,int screenHeight,float zoomFactor) {
        EdgeFollowingViewport viewPort = new EdgeFollowingViewport(player, (int)Math.ceil(screenWidth/zoomFactor),(int)Math.ceil(screenHeight/zoomFactor), 0, 400);
        viewPort.setTolerance(150, 50, 150, 150);
        View view = new View(viewPort, worldWidth,worldHeight);
        setView(view);
        size(screenWidth, screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/leathermanLars/media/achtergrond.png"));
    }
	
	private void initializeSound() {
		backgroundSound = new Sound(this, "src/main/java/nl/han/ica/leathermanlars/media/analeg.mp3");
		backgroundSound.loop(-1);
	}
	
	private void createObjects() {
        player = new Player(this);
        Snake snake = new Snake(this);
        ExplodingBigCactus ebc = new ExplodingBigCactus(this);
        ExplodingSmallCactus esc = new ExplodingSmallCactus(this);
        DamagingBigCactus dbc = new DamagingBigCactus(this);
        DamagingSmallCactus dsc = new DamagingSmallCactus(this);
        HealingBigCactus hbc = new HealingBigCactus(this);
        HealingSmallCactus hsc = new HealingSmallCactus(this);
        player.setGravity(0.5f);
        addGameObject(player, 300, 675-player.getHeight());
        addGameObject(snake, 300, 550-snake.getHeight());
        addGameObject(ebc, 150, 550-ebc.getHeight());
        addGameObject(dsc, 500, 675 - dsc.getHeight());
        addGameObject(hbc, 800, 550-hbc.getHeight());
        addGameObject(dbc, 500, 550-dbc.getHeight());
        addGameObject(esc, 500, 375 - esc.getHeight());
        addGameObject(hsc, 700, 375 - esc.getHeight());
    }
	
	private void createDashBoard(int dashboardWidth, int dashboardHeight) {
		Dashboard dashboard = new Dashboard(0,0, dashboardWidth, dashboardHeight);
		dashboardText=new TextObject("Lifes: ");
        dashboard.addGameObject(dashboardText);
        addDashboard(dashboard);
	}
	
	private void initializeTileMap() {
		TileType [] tileTypes = initializeTileTypes();
		int tileSize=25;
		int tilesMap[][]={
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1, 3, 4, 5,-1,-1,-1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                { 3, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1, 3, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
        };
		tileMap = new TileMap(tileSize, tileTypes, tilesMap);
	}
	
	private TileType [] initializeTileTypes() {
		Sprite groundSprite = new Sprite("src/main/java/nl/han/ica/leathermanlars/media/Tile/1.png");
		TileType<GroundTile> leftGroundTileType = new TileType<>(GroundTile.class, groundSprite);
		groundSprite = new Sprite("src/main/java/nl/han/ica/leathermanlars/media/Tile/2.png");
		TileType<GroundTile> middleGroundTileType = new TileType<>(GroundTile.class, groundSprite);
		groundSprite = new Sprite("src/main/java/nl/han/ica/leathermanlars/media/Tile/3.png");
		TileType<GroundTile> rightGroundTileType = new TileType<>(GroundTile.class, groundSprite);
		groundSprite = new Sprite("src/main/java/nl/han/ica/leathermanlars/media/Tile/14.png");
		TileType<GroundTile> leftPlatformTileType = new TileType<>(GroundTile.class, groundSprite);
		groundSprite = new Sprite("src/main/java/nl/han/ica/leathermanlars/media/Tile/15.png");
		TileType<GroundTile> middlePlatformTileType = new TileType<>(GroundTile.class, groundSprite);
		groundSprite = new Sprite("src/main/java/nl/han/ica/leathermanlars/media/Tile/16.png");
		TileType<GroundTile> rightPlatformTileType = new TileType<>(GroundTile.class, groundSprite);
		TileType [] tileTypes = {leftGroundTileType, middleGroundTileType, rightGroundTileType, leftPlatformTileType, middlePlatformTileType, rightPlatformTileType};
		return tileTypes;
	}
	
	@Override
	public void update() {
		
	}
	
	private void initializePersistence() {
		persistence = new FilePersistence("main/java/nl/han/ica/leathermanlars/media/lifepoints.txt");
		if (persistence.fileExists()) {
			lifePoints = Integer.parseInt(persistence.loadDataString());
			refreshDashboardText();
		}
	}
	
	public void refreshDashboardText() {
		dashboardText.setText("Lifepoints: "+lifePoints);
	}
	
	public void increaseLifePoints(int number) {
		lifePoints = lifePoints + number;
		persistence.saveData(Integer.toString(lifePoints));
		refreshDashboardText();
	}
	
	public void decreaseLifePoints(int number) {
		if(lifePoints>0 && number == 1) {
			lifePoints = lifePoints - number;
			persistence.saveData(Integer.toString(lifePoints));
			refreshDashboardText();
			
		}
		else if(lifePoints > 1 && number == 2) {
			lifePoints = lifePoints - number;
			persistence.saveData(Integer.toString(lifePoints));
			refreshDashboardText();
		}
	}
	
}
