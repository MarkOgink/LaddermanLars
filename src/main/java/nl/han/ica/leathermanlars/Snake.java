package nl.han.ica.leathermanlars;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Snake extends AnimatedSpriteObject implements ICollidableWithGameObjects{
	private LeathermanLars world;
	
	public Snake(LeathermanLars world) {
		super(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/snake.png"), 2);
		this.world = world;
		
	}
	
	private Snake(Sprite sprite, int totalFrames) {
		super(sprite, totalFrames);
		setxSpeed(-1);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
