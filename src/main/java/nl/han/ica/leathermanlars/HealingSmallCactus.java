package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class HealingSmallCactus extends SmallCactus {
	
	public HealingSmallCactus(LeathermanLars world) {
		super(world);
	}

	@Override
	public void doCactusAction() {
		world.addGameObject(new Heart(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/smallHeart.png"), 1), getX(), getY());
		world.deleteGameObject(this);
	}

	@Override
	public void update() {
		if(playerNear()) {
			doCactusAction();
		}
	}
	
	
}
