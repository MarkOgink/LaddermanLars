package nl.han.ica.leathermanlars;


public class ExplodingSmallCactus extends SmallCactus {

	private LeathermanLars world;
	private NonAggresiveSnake SmallSnake;
	
	public ExplodingSmallCactus(LeathermanLars world) {
		this.world = world;
	}

	@Override
	public void doCactusAction() {
		world.deleteGameObject(this);
		SmallSnake = new NonAggresiveSnake(world, getX(), getY());
		world.addGameObject(SmallSnake, this.getX(), this.getY() + (this.getHeight() - SmallSnake.getHeight()));
		world.spawnSound.play();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		
	}
	
}
