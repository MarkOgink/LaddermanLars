package nl.han.ica.leathermanlars;

public class ExplodingBigCactus extends BigCactus {
	
	private LeathermanLars world;
	private Snake snake;
	
	public ExplodingBigCactus(LeathermanLars world) {
		this.world = world;
	}

	@Override
	public void doCactusAction() {
		world.deleteGameObject(this);
		snake = new AggresiveSnake(world);
		world.addGameObject(snake, this.getX(), this.getY() + (this.getHeight() - snake.getHeight()));
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
