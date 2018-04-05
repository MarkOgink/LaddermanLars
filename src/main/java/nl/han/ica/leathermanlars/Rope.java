package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
/*
 * @author Timo Kloks & Mark Ogink
 * Klasse voor het touw
 */
public class Rope extends SpriteObject {
	/*
	 * Constructor
	 */
	public Rope() {
		this(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/rope.png"));
	}
	/*
	 * Constructor
	 * @param sprite Afbeelding voor object
	 */
	public Rope(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
