package nl.han.ica.leathermanlars;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.leathermanlars.Snake;

public class AggresiveSnake extends Snake implements ICollidableWithTiles {

	public AggresiveSnake(LeathermanLars world, float x, float y) {
		super(world, x, y);
	}
	
	public boolean isAlert() {
		float snakeX = getX();
		float playerX = getWorld().player.getX();
		float snakeY = getY();
		float playerY = getWorld().player.getY();
		if(playerY - snakeY < 100 && snakeY - playerY < 100) {
			if(snakeX - playerX <= 200 && snakeX > playerX)
			{
				return true;
			}
			if(playerX - snakeX <= 200 && playerX > snakeX) 
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	@Override
	public void update() {
		if(isAlert()) {
			if(getWorld().player.getX() > getX()) {
				setCurrentFrameIndex(1);
				setxSpeed(2);
			}
			else if(getWorld().player.getX() < getX()) {
				setCurrentFrameIndex(0);
				setxSpeed(-2);
			}
		}
		else {
			if (getX()-getXSpawn() >= 100) {
				setCurrentFrameIndex(0);
	            setxSpeed(-1);
	        }
			if(getXSpawn()-getX() >= 100) {
				setCurrentFrameIndex(1);
				setxSpeed(1);
			}
		}
	}
}
