package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class DamagingBigCactus extends BigCactus {
	
	public DamagingBigCactus(LeathermanLars world, Player player) {
		super(world);
	}

	@Override
	public void doCactusAction() {
		world.player.decreaseLifePoints(2);
		world.deleteGameObject(this);
		if(world.player.getLifePoints() <= 0) {
			world.player.setX(300);
			world.player.setY(700);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
