package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Rope extends SpriteObject {
	
	public Rope() {
		this(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/rope.png"));
	}
	
	public Rope(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
