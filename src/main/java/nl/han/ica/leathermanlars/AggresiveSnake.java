package nl.han.ica.leathermanlars;

import nl.han.ica.leathermanlars.Snake;

public class AggresiveSnake extends Snake {
	

	public AggresiveSnake(LeathermanLars world) {
		super(world);
	}
	
	public boolean isAlert() {
		if((getWorld().player.getX()-getX() <= 200 || getWorld().player.getX()-getX() >= 200) && getWorld().player.getY() - getY() <= 0)
		{
			return true;
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
