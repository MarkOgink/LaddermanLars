package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
/*
 *@author Timo Kloks & Mark Ogink
 *superklasse voor alle grote cactussen
 */
public abstract class BigCactus extends Cactus {
	/*
	 * Constructor
	 * @param world Referentie naar de wereld
	 */
	public BigCactus(LeathermanLars world) {
		this(world, new Sprite("src/main/java/nl/han/ica/leathermanlars/media/cactus.png"));
	}
	/*
	 * Constructor
	 * @param world Referentie naar de wereld
	 * @param sprite Afbeelding van object
	 */
	public BigCactus(LeathermanLars world, Sprite sprite) {
		super(world, sprite);
	}
}
