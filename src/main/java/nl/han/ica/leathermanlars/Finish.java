package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
/*
 * @author Timo Kloks & Mark Ogink
 * Klasse voor het eindpunt
 */
public class Finish extends SpriteObject{
	
	private Player player;
	private LeathermanLars world;
	
	/*
	 * Constructor
	 * @param player Referentie naar speler
	 * @param world Referentie naar world
	 */
	public Finish(Player player, LeathermanLars world) {
		this(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/waterwell.png"));
		this.player = player;
		this.world = world;
	}
	
	/*
	 * Constructor
	 * @param sprite Afbeelding voor object
	 */
	private Finish(Sprite sprite) {
		super(sprite);
	}
	
	/*
	 * Functie om op het dashboard de eindtekst te laten zien, en een geluid af te spelen

	 */
	public void endGame() {
		world.refreshDashboardTextEnd();
		world.finishSound.play();
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
