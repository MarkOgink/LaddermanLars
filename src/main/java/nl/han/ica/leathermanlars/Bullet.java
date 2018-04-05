package nl.han.ica.leathermanlars;
/*
 * @author Timo Kloks & Mark Ogink
 * klasse voor de kogel 
 */
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
	
	/*
	 * Constructor
	 * @param world Referentie naar de wereld
	 * @param direction Richting van player
	 * @param player Referentie naar player
	 */
	public Bullet(LeathermanLars world, int direction, Player player) {
		this(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/bullet.png"));
		this.world = world;
		this.player = player;
		this.direction = direction;
		setCurrentFrameIndex(direction);
	}
	/*
	 * Constructor
	 * @param sprite Afbeelding van object
	 */
	public Bullet(Sprite sprite) {
		super(sprite, 2);
	}
	/*
	 * Functie die de richting van de kogel aangeeft en deze beweegt, afhankelijk van de richting van de speler.
	 * Als het object buiten het scherm valt wordt het object verwijderd.
	 */
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
	/*
	 *Functie voor het detecteren van aanrakingen tussen this en andere objecten.
	 *Wanneer het object een slang is wordt dit object verwijderd, en het slang object.
	 *Ook wordt het aantal kills verhoogt, en speelt er een geluid.
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for(GameObject g:collidedGameObjects) {
			if (g instanceof Snake) {
				int margin = 20;
				if((g.getX() - this.getX()) <= margin && (g.getX() - this.getX()) >= -margin && (g.getY() - this.getY()) <= margin && (g.getY() - this.getY()) >= -margin) {
					world.deleteGameObject(this);
					world.deleteGameObject(g);
					player.increaseKills();
					world.dieSound.play();
				}
			}	
		}
	}
	/*
	 * Functie voor het detecteren van aanrakingen tussen this en tiles.
	 * Wanneer de tile een groundTile is wordt het object verwijderd.
	 */
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
