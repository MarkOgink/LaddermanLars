package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
/*
 * @author Timo Kloks & Mark Ogink
 * De superklasse van alle cactussen
 */
public abstract class Cactus extends SpriteObject {
	/*
	 * Referentie naar de wereld
	 */
	public LeathermanLars world;
	
	/*
	 * Constructor
	 * @param world Referentie naar de wereld
	 * @param sprite Afbeelding object
	 */
	public Cactus(LeathermanLars world, Sprite sprite) {
		super(sprite);
		this.world = world;
		
	}
	/*
	 * Controleert of de speler in de buurt is
	 * @return true/false
	 */
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
	/*
	 *Abstracte methode voor cactusactie.
	 */
	public abstract void doCactusAction();
	
}
