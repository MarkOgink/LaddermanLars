package nl.han.ica.leathermanlars;
/*
 * @author Timo Kloks & Mark Ogink
 * Klasse voor grote cactus die damage doet
 */

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class HealingBigCactus extends BigCactus {
	/*
	 * Constructor
	 * @param world Referentie naar wereld
	 */
	public HealingBigCactus(LeathermanLars world) {
		super(world);
	}
	/*
	 * Functie die groot een hart spawnt. Hierna wordt het object verwijderd.
	 */
	@Override
	public void doCactusAction() {
		world.addGameObject(new Heart(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/bigHeart.png"), 2), getX(), getY());
		world.deleteGameObject(this);
	}
	/*
	 * Functie die controleert of het object in aanraking is met een player.
	 */
	@Override
	public void update() {
		if(playerNear()) {
			doCactusAction();
		}
	}
	
}
