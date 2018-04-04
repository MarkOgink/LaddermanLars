package nl.han.ica.leathermanlars;

public class HealingBigCactus extends BigCactus {
	private Player player;
	private LeathermanLars world;
	
	public HealingBigCactus(LeathermanLars world, Player player) {
		this.world = world;
		this.player = player;
	}

	@Override
	public void doCactusAction() {
		player.increaseLifePoints(2);
		world.deleteGameObject(this);		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
