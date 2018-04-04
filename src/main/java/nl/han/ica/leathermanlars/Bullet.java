package nl.han.ica.leathermanlars;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import processing.core.PVector;

public class Bullet extends AnimatedSpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles {
	private LeathermanLars world;
	private int direction;
	private Player player;
	
	public Bullet(LeathermanLars world, int direction, Player player) {
		this(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/bullet.png"));
		this.world = world;
		this.player = player;
		this.direction = direction;
		setCurrentFrameIndex(direction);
	}
	
	public Bullet(Sprite sprite) {
		super(sprite, 2);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(direction == 0) {
			if(getX() <= 0) {
				world.deleteGameObject(this);
			}
			setxSpeed(-5);
		}
		else if(direction == 1) {
			if(getX() >= 1000) {
				world.deleteGameObject(this);
			}
			setxSpeed(5);
		}
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for(GameObject g:collidedGameObjects) {
			if (g instanceof Snake) {
				int margin = 20;
				if((g.getX() - this.getX()) <= margin && (g.getX() - this.getX()) >= -margin && (g.getY() - this.getY()) <= margin && (g.getY() - this.getY()) >= -margin) {
					world.deleteGameObject(this);
					world.deleteGameObject(g);
					player.increaseKills();
				}
			}	
		}
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		PVector vector;
		
		for(CollidedTile ct: collidedTiles) {
			if(ct.theTile instanceof GroundTile) {
				vector = world.getTileMap().getTilePixelLocation(ct.theTile);
				int margin = 10;
				if(ct.collisionSide == ct.RIGHT && (vector.x - this.getX()) < margin && (vector.x - this.getX()) > -margin ) {
					world.deleteGameObject(this);
				}
				else if(ct.collisionSide == ct.LEFT && (vector.x - this.getX()) < margin && (vector.x - this.getX()) > -margin ) {
					world.deleteGameObject(this);
				}
			}
		}
		
		
	}
}
