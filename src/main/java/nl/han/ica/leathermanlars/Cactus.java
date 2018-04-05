package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class Cactus extends SpriteObject {
	protected LeathermanLars world;
	
	public Cactus(LeathermanLars world, Sprite sprite) {
		super(sprite);
		this.world = world;
		
	}
	public boolean playerNear() {
		float cactusX = getX();
		float playerX = world.player.getX();
		float cactusY = getY();
		float playerY = world.player.getY();
		
		if(cactusY - playerY >= -50 && cactusY - playerY <= 50)
		{
			if(playerX - cactusX <= 100 && cactusX - playerX <= 100)
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public abstract void doCactusAction();
	
}
