package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class BigCactus extends Cactus {
	
	public BigCactus() {
		this(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/cactus.png"));
	}
	
	public BigCactus(Sprite sprite) {
		super(sprite);
	}
}
