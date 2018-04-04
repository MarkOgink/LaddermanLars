package nl.han.ica.leathermanlars;

//import com.sun.prism.image.ViewPort;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.leathermanlars.TextObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class LeathermanLars extends GameEngine{
	private boolean trackSelected = false;
	private Sound backgroundSound;
	public Sound spawnSound;
	public Sound finishSound;
	public Sound dieSound;
	public Sound shootSound;
	public Player player;
	private TextObject dashboardText;
	private TextObject dashboardTextEnd;
	private TextObject dashboardTextKills;

	public static void main(String[] args) {
		PApplet.main(new String[]{"nl.han.ica.leathermanlars.LeathermanLars"});
	}

	@Override
	public void setupGame() {
		int worldWidth=1000;
        int worldHeight=700;
        
        initializeSound();
        createDashBoard(worldWidth, 100);
        createDashBoardEnd(worldWidth, 100);
        createDashBoardKills(worldWidth, 100);
        initializeTileMap();
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
		Random rand = new Random();
		int track = rand.nextInt(4) + 1;
		spawnSound = new Sound(this, "src/main/java/nl/han/ica/leathermanlars/media/hisssound.mp3");
		finishSound = new Sound(this, "src/main/java/nl/han/ica/leathermanlars/media/endmusic.mp3");
		dieSound = new Sound(this, "src/main/java/nl/han/ica/leathermanlars/media/spawnsound.mp3");
		shootSound = new Sound(this, "src/main/java/nl/han/ica/leathermanlars/media/shootingsound.mp3");
		shootSound.play();
		
		
		if(track == 1 && !trackSelected) {
			backgroundSound = new Sound(this, "src/main/java/nl/han/ica/leathermanlars/media/analeg.mp3");
		}

		else if(track == 2 && !trackSelected) {
			backgroundSound = new Sound(this, "src/main/java/nl/han/ica/leathermanlars/media/fraud_3.mp3");
		}

		else if(track == 3 && !trackSelected) {
			backgroundSound = new Sound(this, "src/main/java/nl/han/ica/leathermanlars/media/innit.mp3");
		}

		else if(track == 4 && !trackSelected) {
			backgroundSound = new Sound(this, "src/main/java/nl/han/ica/leathermanlars/media/pleck 6.mp3");
		}
		backgroundSound.loop(-1);
		trackSelected = true;
	}
	
	public void createObjects() {
        player = new Player(this);
        Finish endpoint = new Finish(player, this);
        Rope rope = new Rope();
        Rope rope0 = new Rope();
        AggresiveSnake snake = new AggresiveSnake(this, 300, 550);
        AggresiveSnake snake0 = new AggresiveSnake(this,400 ,350);
        AggresiveSnake snake1 = new AggresiveSnake(this, 500, 350);
        AggresiveSnake snake2 = new AggresiveSnake(this, 550, 140);
        AggresiveSnake snake3 = new AggresiveSnake (this, 700, 140);
        ExplodingBigCactus ebc = new ExplodingBigCactus(this);
        ExplodingBigCactus ebc0 = new ExplodingBigCactus(this);
        ExplodingSmallCactus esc = new ExplodingSmallCactus(this);
        DamagingBigCactus dbc = new DamagingBigCactus(this, player);
        DamagingBigCactus dbc0 = new DamagingBigCactus(this, player);
        DamagingSmallCactus dsc = new DamagingSmallCactus(this, player);
        HealingBigCactus hbc = new HealingBigCactus(this, player);
        HealingSmallCactus hsc = new HealingSmallCactus(this, player);
        player.setGravity(0.5f);
        
        
        
	    addGameObject(player, 300, 675-player.getHeight());
	    addGameObject(rope, 670, 400);
	    addGameObject(rope0, 280, 275);
	    addGameObject(endpoint, 880, 140 - endpoint.getHeight());
	    addGameObject(snake, 300, 550-snake.getHeight());
	    addGameObject(snake0, 500, 375-snake.getHeight());
	    addGameObject(snake1, 600, 375-snake.getHeight());
	    addGameObject(snake2, 600, 130-snake.getHeight());
	    addGameObject(snake3, 600, 130-snake.getHeight());
	    addGameObject(ebc, 150, 550-ebc.getHeight());
	    addGameObject(ebc0, 500, 130 - ebc.getHeight());
	    addGameObject(dsc, 920, 675 - dsc.getHeight());
	    addGameObject(hbc, 780, 550- hbc.getHeight());
	    addGameObject(dbc, 500, 550- dbc.getHeight());
	    addGameObject(dbc0, 50, 250 - dbc.getHeight());
	    addGameObject(esc, 800, 375 - esc.getHeight());
	    addGameObject(hsc, 840, 375 - esc.getHeight());
        
        
        
        
    }
	
	private void createDashBoard(int dashboardWidth, int dashboardHeight) {
		Dashboard dashboard = new Dashboard(0,0, dashboardWidth, dashboardHeight);
		dashboardText=new TextObject("Lifepoints: 3");
        dashboard.addGameObject(dashboardText);
        addDashboard(dashboard);
	}
	
	private void createDashBoardEnd(int dashboardWidth, int dashboardHeight) {
		Dashboard dashboard = new Dashboard(200, 0, dashboardWidth, dashboardHeight);
		dashboardTextEnd=new TextObject("");
        dashboard.addGameObject(dashboardTextEnd);
        addDashboard(dashboard);
	}
	
	private void createDashBoardKills(int dashboardWidth, int dashboardHeight) {
		Dashboard dashboard = new Dashboard(350, 0, dashboardWidth, dashboardHeight);
		dashboardTextKills=new TextObject("Number of kills: 0");
		dashboard.addGameObject(dashboardTextKills);
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
                {-1,-1,-1,-1,-1, 3, 4, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {-1, 3, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1, 3, 4, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 5,-1,-1,-1,-1,-1},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 4, 5},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 5,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1, 3, 4, 5,-1,-1,-1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                { 3, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1, 3, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 5,-1,-1, 3, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 3, 5,-1,-1,-1,-1},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 4},
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
	
	public void refreshDashboardText() {
		dashboardText.setText("Lifepoints: "+player.getLifePoints());
	}
	
	public void refreshDashboardTextEnd() {
		dashboardTextEnd.setText("YOU WON!");
	}
	
	public void refreshDashboardTextKills() {
		dashboardTextKills.setText("Number of kills: "+player.getNumberOfKills());
	}
	
}
