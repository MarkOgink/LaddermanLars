package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Finish extends SpriteObject{
	
	private Player player;
	private LeathermanLars world;
	
	public Finish(Player player, LeathermanLars world) {
		this(new Sprite("src/main/java/nl/han/ica/leathermanlars/media/waterwell.png"));
		this.player = player;
		this.world = world;
	}
	
	private Finish(Sprite sprite) {
		super(sprite);
	}
	
	public void endGame() {
		world.refreshDashboardTextEnd();
		world.finishSound.play();
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
