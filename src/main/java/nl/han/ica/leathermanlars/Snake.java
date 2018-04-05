package nl.han.ica.leathermanlars;
/*
 * @author Timo Kloks & Mark Ogink
 * superklasse van alle slangen
 */
import java.util.List;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public abstract class Snake extends AnimatedSpriteObject{
	private float xSpawn;
	private float ySpawn;
	private LeathermanLars world;
	/*
	 * Constructor
	 *@param world Referentie naar de wereld
	 *@param x xSpawn van slang
	 *@param y ySpawn van slang
	 */
	public Snake(LeathermanLars world, float x, float y) {
		this(world, new Sprite("src/main/java/nl/han/ica/leathermanlars/media/snake.png"), 2);
		xSpawn = x;
		ySpawn = y;
	}
	/*
	 * Constructor
	 * @param world Referentie naar de wereld
	 * @param sprite Afbeelding van object
	 * @param totalFrames aantal frames
	 */
	private Snake(LeathermanLars world, Sprite sprite, int totalFrames) {
		super(sprite, totalFrames);
		this.setWorld(world);
		setxSpeed(-1);
	}
	/*
	 * Retourneert het x-spawn coordinaat
	 * @return xSpawn
	 */
	public float getXSpawn() {
		return xSpawn;
	}
	/*
	 * Retourneert het y-spawn coordinaat
	 * @return ySpawn
	 */
	public float getYSpawn() {
		return ySpawn-getHeight();
	}
	/*
	 * Functie die de speler een stukje naar achter gooit. En de levenspunten verminderd. 
	 * Als levenspunten <= 0 dan wordt de speler terug gezet naar start.
	 */
	public void doSnakeAction() {
		if(getX()<world.player.getX()) {
			world.player.setxSpeed(20);
			world.player.decreaseLifePoints(1);
			if(world.player.getLifePoints() <= 0) {
				world.player.setX(300);
				world.player.setY(675-world.player.getHeight());
			}
		}
		else if(getX()>world.player.getX()) {
			world.player.setxSpeed(-20);
			world.player.decreaseLifePoints(1);
			if(world.player.getLifePoints() <= 0) {
				world.player.setX(300);
				world.player.setY(700);
			}
		}
	}

	/**
	 * @return the world
	 */
	public LeathermanLars getWorld() {
		return world;
	}
	/*
	 * @param world 
	 */
	private void setWorld(LeathermanLars world) {
		this.world = world;
		
	}
}
