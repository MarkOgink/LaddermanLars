package nl.han.ica.leathermanlars;
/*
 * @author Timo Kloks & Mark Ogink
 * Klasse voor grote cactus die damage doet
 */

public class ExplodingBigCactus extends BigCactus {
	private NonAggresiveSnake snake;
	/*
	 * Constructor
	 * @param world Referentie naar wereld
	 */
	public ExplodingBigCactus(LeathermanLars world) {
		super(world);
	}
	/*
	 * Functie die een slang spawnt. Hierna
	 * wordt het object verwijderd.
	 */
	@Override
	public void doCactusAction() {
		world.deleteGameObject(this);
		snake = new NonAggresiveSnake(world, getX(), getY());
		world.addGameObject(snake, this.getX(), this.getY() + (this.getHeight() - snake.getHeight()));
		world.spawnSound.play();
		
	}
	/*
	 * Functie die controleert of object in de buurt van de player is. 
	 */
	@Override
	public void update() {
		if(playerNear()) {
			doCactusAction();
		}
	}
	
}
