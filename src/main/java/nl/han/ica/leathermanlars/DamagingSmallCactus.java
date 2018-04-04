package nl.han.ica.leathermanlars;

public class DamagingSmallCactus extends SmallCactus {
	private Player player;
	private LeathermanLars world;
	
	public DamagingSmallCactus(LeathermanLars world, Player player) {
		this.world = world;
		this.player = player;
	}

	@Override
	public void doCactusAction() {
		player.decreaseLifePoints(1);
		world.deleteGameObject(this);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
