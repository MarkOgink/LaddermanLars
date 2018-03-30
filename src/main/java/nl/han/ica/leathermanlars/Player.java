package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Player extends AnimatedSpriteObject{
	final int size=25;
	private final LeathermanLars world;

	public Player(LeathermanLars world) {
		super(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/sheriff_ned_featured.png"), 1);
		this.world = world;
		setCurrentFrameIndex(0);
        setFriction(0.05f);
	}

	@Override
	public void update() {
		if (getX()<=0) {
            setxSpeed(0);
            setX(0);
        }
        if (getY()<=0) {
            setySpeed(0);
            setY(0);
        }
        if (getX()>=world.getWidth()-size) {
            setxSpeed(0);
            setX(world.getWidth() - size);
        }
        if (getY()>=world.getHeight()-size) {
            setySpeed(0);
            setY(world.getHeight() - size);
        }
	}
}
