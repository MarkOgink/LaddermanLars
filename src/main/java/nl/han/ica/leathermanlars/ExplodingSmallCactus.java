package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class ExplodingSmallCactus extends SmallCactus {

	private LeathermanLars world;
	private Snake SmallSnake;
	
	public ExplodingSmallCactus(LeathermanLars world) {
		this.world = world;
	}

	@Override
	public void doCactusAction() {
		world.deleteGameObject(this);
		SmallSnake = new Snake(world);
		world.addGameObject(SmallSnake, this.getX(), this.getY() + (this.getHeight() - SmallSnake.getHeight()));
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		
	}
	
}
