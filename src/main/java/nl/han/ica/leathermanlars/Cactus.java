package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class Cactus extends SpriteObject {
	
	public Cactus(Sprite sprite) {
		super(sprite);
		
	}
	
	public abstract void doCactusAction();
	
}
