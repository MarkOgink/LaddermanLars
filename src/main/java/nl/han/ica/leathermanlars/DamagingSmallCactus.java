package nl.han.ica.leathermanlars;

public class DamagingSmallCactus extends SmallCactus {
	
	public DamagingSmallCactus(LeathermanLars world, Player player) {
		super(world);
		
	}

	@Override
	public void doCactusAction() {
		world.player.decreaseLifePoints(1);
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
