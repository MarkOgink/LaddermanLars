package nl.han.ica.leathermanlars;

public class ExplodingBigCactus extends BigCactus {
	private NonAggresiveSnake snake;
	
	public ExplodingBigCactus(LeathermanLars world) {
		super(world);
	}

	@Override
	public void doCactusAction() {
		world.deleteGameObject(this);
		snake = new NonAggresiveSnake(world, getX(), getY());
		world.addGameObject(snake, this.getX(), this.getY() + (this.getHeight() - snake.getHeight()));
		world.spawnSound.play();
		
	}

	@Override
	public void update() {
		if(playerNear()) {
			doCactusAction();
		}
	}
	
}
