package nl.han.ica.leathermanlars;

public class DamagingSmallCactus extends SmallCactus {
	private Player player;
	
	public DamagingSmallCactus(LeathermanLars world, Player player) {
		super(world);
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
