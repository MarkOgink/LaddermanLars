package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.leathermanlars.Player;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class LeathermanLars extends GameEngine{
	private Player player;

	public static void main(String[] args) {
		PApplet.main(new String[]{"nl.han.ica.leathermanlars.LeathermanLars"});
	}

	@Override
	public void setupGame() {
		int worldWidth=1024;
        int worldHeight=683;
        createObjects();
		createViewWithViewport(worldWidth, worldHeight, 800, 800, 1.1f);
	}
	
	private void createViewWithViewport(int worldWidth,int worldHeight,int screenWidth,int screenHeight,float zoomFactor) {
        EdgeFollowingViewport viewPort = new EdgeFollowingViewport(player, (int)Math.ceil(screenWidth/zoomFactor),(int)Math.ceil(screenHeight/zoomFactor),0,0);
        viewPort.setTolerance(50, 50, 50, 50);
        View view = new View(viewPort, worldWidth,worldHeight);
        setView(view);
        size(screenWidth, screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/leathermanLars/media/Achtergrond.png"));
    }
	
	private void createObjects() {
        player = new Player(this);
        addGameObject(player, 100, 100);
    }
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
