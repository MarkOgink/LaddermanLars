package nl.han.ica.leathermanlars;

public class DamagingSmallCactus extends SmallCactus {

	private LeathermanLars world;
	
	public DamagingSmallCactus(LeathermanLars world) {
		this.world = world;
	}

	@Override
	public void doCactusAction() {
		world.decreaseLifePoints(1);
		world.deleteGameObject(this);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
