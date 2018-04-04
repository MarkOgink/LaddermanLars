package nl.han.ica.leathermanlars;

public class HealingSmallCactus extends SmallCactus {
	private LeathermanLars world;
	
	public HealingSmallCactus(LeathermanLars world) {
		this.world = world;
	}

	@Override
	public void doCactusAction() {
		world.increaseLifePoints(1);
		world.deleteGameObject(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
