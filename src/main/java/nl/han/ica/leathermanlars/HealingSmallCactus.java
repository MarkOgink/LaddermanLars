package nl.han.ica.leathermanlars;

public class HealingSmallCactus extends SmallCactus {
	private Player player;
	private LeathermanLars world;
	
	public HealingSmallCactus(LeathermanLars world ,Player player) {
		this.player = player;
		this.world = world;
	}

	@Override
	public void doCactusAction() {
		player.increaseLifePoints(1);
		world.deleteGameObject(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
