package nl.han.ica.leathermanlars;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Snake extends AnimatedSpriteObject implements ICollidableWithGameObjects{
	private LeathermanLars world;
	private float spawnx;
	
	public Snake(LeathermanLars world) {
		this(world, new Sprite("src/main/java/nl/han/ica/leathermanlars/media/snake.png"), 2);
	}
	
	private Snake(LeathermanLars world, Sprite sprite, int totalFrames) {
		super(sprite, totalFrames);
		this.world = world;
		spawnx = getX();
		setxSpeed(-1);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		if (getX()+getWidth()<=200) {
            setX(300);
        }
		
	}

}
