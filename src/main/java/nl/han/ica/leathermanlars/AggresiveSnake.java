package nl.han.ica.leathermanlars;

import java.util.List;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.leathermanlars.Snake;

public class AggresiveSnake extends Snake {

	public AggresiveSnake(LeathermanLars world, float x, float y) {
		super(world, x, y);
	}
	
	public boolean isAlert() {
		float snakeX = getX();
		float playerX = getWorld().player.getX();
		float snakeY = getY();
		float playerY = getWorld().player.getY();
		
		if(snakeY - playerY >= -50 && snakeY - playerY <= 50)
		{
			if(playerX - snakeX <= 200 && snakeX - playerX <= 200)
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

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub
		
	}
}
