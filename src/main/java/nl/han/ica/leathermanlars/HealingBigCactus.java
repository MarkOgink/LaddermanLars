package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class HealingBigCactus extends BigCactus {
	private Player player;
	
	public HealingBigCactus(LeathermanLars world, Player player) {
		super(world);
		this.player = player;
	}

	@Override
	public void doCactusAction() {
		world.addGameObject(new Heart(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/bigHeart.png"), 2), getX(), getY());
		world.deleteGameObject(this);
	}

	@Override
	public void update() {
		if(playerNear()) {
			doCactusAction();
		}
	}
	
}
