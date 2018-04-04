package nl.han.ica.leathermanlars;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import processing.core.PVector;

public abstract class Snake extends AnimatedSpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles{
	private float xSpawn;
	private float ySpawn;
	private LeathermanLars world;
	
	public Snake(LeathermanLars world, float x, float y) {
		this(world, new Sprite("src/main/java/nl/han/ica/leathermanlars/media/snake.png"), 2);
		xSpawn = x;
		ySpawn = y;
		setGravity(0.1f);
	}
	
	private Snake(LeathermanLars world, Sprite sprite, int totalFrames) {
		super(sprite, totalFrames);
		this.setWorld(world);
//		setxSpeed(-1);
	}
	
	public float getXSpawn() {
		return xSpawn;
	}
	
	public float getYSpawn() {
		return ySpawn;
	}
	
	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		PVector vector;
		System.out.println(getY());
		for(CollidedTile ct : collidedTiles) {
			if(ct.theTile instanceof GroundTile) {
				if(ct.collisionSide == ct.TOP) {
					vector = world.getTileMap().getTilePixelLocation(ct.theTile);
					setY(vector.y - getHeight());
				}
			}
		}
	}
	
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for(GameObject g:collidedGameObjects) {
			if(g instanceof Cactus) {
				setX(g.getX()-getWidth());
			}
		}
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
