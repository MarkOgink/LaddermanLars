package nl.han.ica.leathermanlars;

import java.util.List;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public abstract class Snake extends AnimatedSpriteObject implements ICollidableWithGameObjects{
	private float xSpawn;
	private float ySpawn;
	private LeathermanLars world;
	
	public Snake(LeathermanLars world) {
		this(world, new Sprite("src/main/java/nl/han/ica/leathermanlars/media/snake.png"), 2);
	}
	
	private Snake(LeathermanLars world, Sprite sprite, int totalFrames) {
		super(sprite, totalFrames);
		this.setWorld(world);
		setxSpeed(-1);
	}
	
	public float getXSpawn() {
		return xSpawn;
	}
	
	public float getYSpawn() {
		return ySpawn-getHeight();
	}
	
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub
	}

	/**
	 * @return the world
	 */
	public LeathermanLars getWorld() {
		return world;
	}

	/**
	 * @param world the world to set
	 */
	public void setWorld(LeathermanLars world) {
		this.world = world;
	}
}
