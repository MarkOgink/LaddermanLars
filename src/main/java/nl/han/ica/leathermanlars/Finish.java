package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Finish extends SpriteObject{
	
	private Player player;
	private LeathermanLars world;
	
	public Finish(Player player, LeathermanLars world) {
		this(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/cactus.png"));
		this.player = player;
		this.world = world;
	}
	
	private Finish(Sprite sprite) {
		super(sprite);
	}
	
	public void resetPlayer() {
		player.setX(300);
		player.setY(675 - player.getHeight());
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
