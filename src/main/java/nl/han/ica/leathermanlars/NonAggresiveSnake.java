package nl.han.ica.leathermanlars;

public class NonAggresiveSnake extends Snake {

	public NonAggresiveSnake(LeathermanLars world) {
		super(world);
	}

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
