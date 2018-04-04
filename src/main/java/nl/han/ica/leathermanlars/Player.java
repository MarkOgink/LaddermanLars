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

public class Player extends AnimatedSpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects {
	final int size=25;
	private final LeathermanLars world;
	private int lifePoints = 3;
	private int numberOfKills = 0;
	private int currentFrame;

	public Player(LeathermanLars world) {
		super(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/lars.png"), 2);
		this.world = world;
		setCurrentFrameIndex(0);
		currentFrame = 0;
        setFriction(0.1f);
	}

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
	
	@Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 5;
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
        }
        if (key == 's' && currentFrame == 0) {
        	Bullet bulletLeft = new Bullet (world, 0, this);
            world.addGameObject(bulletLeft, this.getX(), this.getY());
        }
    }

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
		}
		
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for(GameObject g:collidedGameObjects) {
			if(g instanceof Cactus) {
				((Cactus) g).doCactusAction();
			}
			
			if(g instanceof Finish) {
				((Finish) g).endGame();
			}
		}
		
	}
	
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int number) {
		lifePoints = number;
		world.refreshDashboardText();
	}
	
	public void increaseLifePoints(int number) {
		lifePoints = lifePoints + number;
		world.refreshDashboardText();
	}
	
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
	
	public void increaseKills() {
		numberOfKills++;
		world.refreshDashboardTextKills();
	}
	
	public int getNumberOfKills() {
		return numberOfKills;
	}
}
