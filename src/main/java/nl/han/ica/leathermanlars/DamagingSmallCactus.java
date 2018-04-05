package nl.han.ica.leathermanlars;
/*
 * @author Timo Kloks & Mark Ogink
 * Klasse voor grote cactus die damage doet
 */
public class DamagingSmallCactus extends SmallCactus {
	
	/*
	 * Constructor
	 * @param world Referentie naar de wereld.
	 */
	public DamagingSmallCactus(LeathermanLars world) {
		super(world);
		
	}
	/*
	 * Functie die de spelers levenspunten met een verlaagt, mits deze groter dan 0 is.
	 * Anders wordt de speler teruggestuurt naar start. Hierna wordt het object verwijderd. 
	 * 
	 */
	@Override
	public void doCactusAction() {
		world.player.decreaseLifePoints(1);
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
