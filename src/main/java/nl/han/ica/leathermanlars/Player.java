package nl.han.ica.leathermanlars;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import processing.core.PVector;

public class Player extends AnimatedSpriteObject implements ICollidableWithTiles {
	final int size=25;
	private final LeathermanLars world;

	public Player(LeathermanLars world) {
		super(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/lars.png"), 2);
		this.world = world;
		setCurrentFrameIndex(0);
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
        }
        if (keyCode == world.UP) {
            setDirectionSpeed(0, speed*4);
        }
        if (keyCode == world.RIGHT) {
            setDirectionSpeed(90, speed);
            setCurrentFrameIndex(0);
        }
        if (keyCode == world.DOWN) {
            setDirectionSpeed(180, speed);
        }
        if (key == ' ') {
            System.out.println("Spatie!");
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
	
	
}
