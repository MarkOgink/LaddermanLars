package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
/*
 * @author Timo Kloks & Mark Ogink
 * Klasse voor helende kleine cactus
 */
public class HealingSmallCactus extends SmallCactus {
	/*
	 * Constructor
	 * @param world Referentie naar wereld.
	 */
	public HealingSmallCactus(LeathermanLars world) {
		super(world);
	}
	/*
	 * Functie die een klein hart spawnt. Hierna wordt het object verwijderd.
	 */
	@Override
	public void doCactusAction() {
		world.addGameObject(new Heart(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/smallHeart.png"), 1), getX(), getY());
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
