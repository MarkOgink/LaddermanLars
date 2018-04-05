package nl.han.ica.leathermanlars;

/*
 * @author Timo Kloks & Mark Ogink
 * Klasse voor grote cactus die damage doet
 */
public class DamagingBigCactus extends BigCactus {
	/*
	 * Constructor
	 * @param world Referentie naar wereld
	 */
	public DamagingBigCactus(LeathermanLars world) {
		super(world);
	}
	
	/*
	 * Functie die de spelers levenspunten met twee verlaagt, mits deze groter dan 0 is.
	 * Anders wordt de speler teruggestuurt naar start. Hierna wordt het object verwijderd. 
	 * 
	 */
	@Override
	public void doCactusAction() {
		world.player.decreaseLifePoints(2);
		world.deleteGameObject(this);
		if(world.player.getLifePoints() <= 0) {
			world.player.setX(300);
			world.player.setY(700);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
