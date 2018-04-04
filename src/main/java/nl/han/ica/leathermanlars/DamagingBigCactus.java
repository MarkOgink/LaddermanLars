package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class DamagingBigCactus extends BigCactus {
	private Player player;
	private LeathermanLars world;
	
	public DamagingBigCactus(LeathermanLars world, Player player) {
		this.world = world;
		this.player = player;
	}

	@Override
	public void doCactusAction() {
		player.decreaseLifePoints(2);
		world.deleteGameObject(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
