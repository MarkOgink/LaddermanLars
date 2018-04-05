package nl.han.ica.leathermanlars;

/*
 * @author Timo Kloks & Mark Ogink
 */
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Heart extends SpriteObject{
	private int lifePoints;
	/*
	 * Constructor
	 * @param sprite Afbeelding van object
	 * @param lifePoints Aantal levenspunten dat het hart geeft
	 */
	public Heart(Sprite sprite, int lifePoints) {
		super(sprite);
		this.setLifePoints(lifePoints);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the lifePoints
	 */
	public int getLifePoints() {
		return lifePoints;
	}

	/**
	 * @param lifePoints the lifePoints to set
	 */
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

}
