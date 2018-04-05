package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
/*
 * @author Timo Kloks & Mark Ogink
 * De superklasse van alle kleine cactussen
 */
public abstract class SmallCactus extends Cactus {
	/*
	 * Constructor
	 * @param world Referentie naar de wereld
	 */
	public SmallCactus(LeathermanLars world) {
		this(world, new Sprite("src/main/java/nl/han/ica/leathermanlars/media/cactusklein.png"));
		// TODO Auto-generated constructor stub
	}
	/*
	 * Constructor
	 * @param world Referentie naar de wereld
	 * @param sprite Afbeelding voor object
	 */
	public SmallCactus(LeathermanLars world, Sprite sprite) {
		super(world, sprite);
	}
}
