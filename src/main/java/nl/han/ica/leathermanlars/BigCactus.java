package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class BigCactus extends Cactus {
	
	public BigCactus(LeathermanLars world) {
		this(world, new Sprite("src/main/java/nl/han/ica/leathermanlars/media/cactus.png"));
	}
	
	public BigCactus(LeathermanLars world, Sprite sprite) {
		super(world, sprite);
	}
}
