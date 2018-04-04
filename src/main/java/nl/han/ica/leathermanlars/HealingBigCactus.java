package nl.han.ica.leathermanlars;

public class HealingBigCactus extends BigCactus {
	
	private LeathermanLars world;
	
	public HealingBigCactus(LeathermanLars world) {
		this.world = world;
	}

	@Override
	public void doCactusAction() {
		world.increaseLifePoints(2);
		world.deleteGameObject(this);		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
