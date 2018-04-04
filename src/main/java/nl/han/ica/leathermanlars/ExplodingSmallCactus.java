package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class ExplodingSmallCactus extends SmallCactus {

	private LeathermanLars world;
	private Snake snake;
	
	public ExplodingSmallCactus(LeathermanLars world) {
		this.world = world;
		snake = new Snake(world);
		world.addGameObject(snake, this.getX(), this.getY() + (this.getHeight() - snake.getHeight()));
	}

	@Override
	public void doCactusAction() {
		world.deleteGameObject(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		
	}
	
}
