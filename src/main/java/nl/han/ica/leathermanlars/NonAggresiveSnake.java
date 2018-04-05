package nl.han.ica.leathermanlars;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
/*
 * @author Timo Kloks & Mark Ogink
 * Klasse voor niet agressieve slang
 */
public class NonAggresiveSnake extends Snake {
	/*
	 * Constructor
	 * @param world Referentie naar wereld
	 * @param x xSpawn 
	 * @param y ySpawn
	 */
	public NonAggresiveSnake(LeathermanLars world, float x, float y) {
		super(world, x, y);
	}
	/*
	 * Functie voor het heen en weer laten lopen van het object
	 */
	@Override
	public void update() {
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
