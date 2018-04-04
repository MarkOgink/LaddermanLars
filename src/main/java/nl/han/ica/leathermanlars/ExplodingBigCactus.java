package nl.han.ica.leathermanlars;

public class ExplodingBigCactus extends BigCactus {
	
	private LeathermanLars world;
	private NonAggresiveSnake snake;
	
	public ExplodingBigCactus(LeathermanLars world) {
		this.world = world;
	}

	@Override
	public void doCactusAction() {
		world.deleteGameObject(this);
		snake = new NonAggresiveSnake(world, getX(), getY());
		world.addGameObject(snake, this.getX(), this.getY() + (this.getHeight() - snake.getHeight()));
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
