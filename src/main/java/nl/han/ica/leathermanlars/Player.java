package nl.han.ica.leathermanlars;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import processing.core.PVector;
/*
 * @author Timo Kloks & Mark Ogink
 * De spelerklasse (Lars/Cowboy)
 */

public class Player extends AnimatedSpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects {
	final int size=25;
	private final LeathermanLars world;
	private boolean onRope = false;
	private boolean active = false;
	private int lifePoints;
	private int numberOfKills = 0;
	private int currentFrame;
	
	/*
	 * Constructor
	 * @param world Referentie naar de wereld.
	 */
	public Player(LeathermanLars world) {
		super(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/lars.png"), 2);
		this.world = world;
		lifePoints = 3;
		setCurrentFrameIndex(0);
		currentFrame = 0;
        setFriction(0.1f);
        setGravity(0.5f);
	}
	/*
	 *Zorgt ervoor dat de speler binnen de map blijft. 
	 */
	@Override
	public void update() {
		if (getX()<=0) {
            setxSpeed(0);
            setX(0);
        }
        if (getY()<=0) {
            setySpeed(0);
            setY(0);
        }
        if (getX()>=world.getWidth()-size) {
            setxSpeed(0);
            setX(world.getWidth() - size);
        }
        if (getY()>=world.getHeight()-size) {
            setySpeed(0);
            setY(world.getHeight() - size);
        }
	}
	
	/*
	 * Controleert of er een knop is ingedrukt, en voert een actie uit.
	 * @param keyCode Referentie naar niet-letter knoppen op toetsenbord
	 * @param key Referentie naar letter knoppen op toetsenbord
	 */
	@Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        active = true;
	    if(!onRope) {
        	if (keyCode == world.LEFT) {
	            setDirectionSpeed(270, speed);
	            setCurrentFrameIndex(1);
	            currentFrame = 0;
	        }
	        if (keyCode == world.UP) {
	            setDirectionSpeed(0, speed*2);
	        }
	       
	        if (keyCode == world.RIGHT) {
	            setDirectionSpeed(90, speed);
	            setCurrentFrameIndex(0);
	            currentFrame = 1;
	        }
	        if (keyCode == world.DOWN) {
	            setDirectionSpeed(180, speed);
	        }
	        if (key == 's' && currentFrame == 1) {
	        	Bullet bulletRight = new Bullet(world, 1, this);
	            world.addGameObject(bulletRight, this.getX() + this.getWidth(), this.getY());
	            world.shootSound.play();
	        }
	        if (key == 's' && currentFrame == 0) {
	        	Bullet bulletLeft = new Bullet (world, 0, this);
	            world.addGameObject(bulletLeft, this.getX(), this.getY());
	            world.shootSound.play();
	        }
	    }
	    else if(onRope) {
	        if(key == 'f') {
	        	this.setGravity(0.5f);
	        }
	        else if(keyCode == world.UP) {
	        	setDirectionSpeed(0, speed/2);
	        }
	        else if(keyCode == world.DOWN) {
	        	setDirectionSpeed(180, speed/2);
	        }
	    }
    }
	/*
	 * Zorgt voor player - tile interactie
	 * @param collidedTiles lijst met tiles
	 */
	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		PVector vector;
		
		for(CollidedTile ct : collidedTiles) {
			if(ct.theTile instanceof GroundTile) {
				if(ct.collisionSide == ct.TOP) {
					vector = world.getTileMap().getTilePixelLocation(ct.theTile);
					setY(vector.y - 2*ct.theTile.getSprite().getHeight());
				}
			}
			if(ct.theTile instanceof GroundTile) {
				if(ct.collisionSide == ct.BOTTOM) {
					vector = world.getTileMap().getTilePixelLocation(ct.theTile);
					setY(vector.y + ct.theTile.getSprite().getHeight());
				}
			}
			if(ct.theTile instanceof GroundTile) {
				if(ct.collisionSide == ct.TOP) {
					onRope = false;
					this.setGravity(0.5f);
				}
			}
		}
		
	}
	/*
	 * Zorgt voor player - object interactie
	 * @param collidedGameObjects lijst met game objecten.
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for(GameObject g:collidedGameObjects) {
			if(g instanceof Cactus) {
				((Cactus) g).doCactusAction();
			}
			
			else if(g instanceof Snake && active) {
					((Snake) g).doSnakeAction();
					active = false;
					onRope = false;
			}
			
			else if(g instanceof Finish) {
				((Finish) g).endGame();
			}
			
			else if(g instanceof Rope && onRope == false) {
				onRope = true;
				this.setGravity(0);
			}
			
			else if (g instanceof Heart) {
				increaseLifePoints(((Heart) g).getLifePoints());
				world.deleteGameObject(g);
			}
		}
		
	}
	/*
	 * Retourneert huidige levenspunten.
	 * @return lifePoints aantal levens.
	 */
	public int getLifePoints() {
		return lifePoints;
	}
	
	/*
	 * Verhoogt levenspunten met nummer
	 * @param number Het te verhogen nummer
	 */
	public void increaseLifePoints(int number) {
		lifePoints = lifePoints + number;
		world.refreshDashboardText();
	}
	/*
	 * Verlaagt levenspunten met nummer.
	 * @param number Het te verlagen nummer.
	 */
	public void decreaseLifePoints(int number) {
		if(lifePoints>0 && number == 1) {
			lifePoints = lifePoints - number;
			world.refreshDashboardText();
			
		}
		else if(lifePoints > 1 && number == 2) {
			lifePoints = lifePoints - number;
			world.refreshDashboardText();
		}
	}
	/*
	 * Verhoogt het aantal kills met een.
	 */
	public void increaseKills() {
		numberOfKills++;
		world.refreshDashboardTextKills();
	}
	/*
	 * Retourneert het aantal kills.
	 * @return numberOfKills Het aantal kills.
	 */
	public int getNumberOfKills() {
		return numberOfKills;
	}
}
