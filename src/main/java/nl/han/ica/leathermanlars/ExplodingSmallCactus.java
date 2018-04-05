package nl.han.ica.leathermanlars;
/*
 * @author Timo Kloks & Mark Ogink
 * Klasse voor kleine cactus die damage doet
 */

public class ExplodingSmallCactus extends SmallCactus {
	private NonAggresiveSnake SmallSnake;
	/*
	 * Constructor
	 * @param world Referentie naar wereld
	 */
	public ExplodingSmallCactus(LeathermanLars world) {
		super(world);
	}
	/*
	 * Functie die een slang spawnt. Hierna
	 * wordt het object verwijderd.
	 */
	@Override
	public void doCactusAction() {
		world.deleteGameObject(this);
		SmallSnake = new NonAggresiveSnake(world, getX(), getY());
		world.addGameObject(SmallSnake, this.getX(), this.getY() + (this.getHeight() - SmallSnake.getHeight()));
		world.spawnSound.play();
	}
	/*
	 * Functie die een slang spawnt. Hierna
	 * wordt het object verwijderd.
	 */
	@Override
	public void update() {
		if(playerNear()) {
			doCactusAction();
		}
	}
	
}
