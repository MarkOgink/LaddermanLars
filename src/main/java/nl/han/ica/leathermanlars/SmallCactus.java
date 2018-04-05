package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class SmallCactus extends Cactus {
	
	public SmallCactus(LeathermanLars world) {
		this(world, new Sprite("src/main/java/nl/han/ica/leathermanlars/media/cactusklein.png"));
		// TODO Auto-generated constructor stub
	}
	
	public SmallCactus(LeathermanLars world, Sprite sprite) {
		super(world, sprite);
	}
}
