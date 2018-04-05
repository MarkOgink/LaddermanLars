package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Heart extends SpriteObject{
	
	public Heart() {
		this(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/heart.png"));
	}

	public Heart(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
