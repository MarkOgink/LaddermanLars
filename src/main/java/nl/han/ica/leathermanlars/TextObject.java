package nl.han.ica.leathermanlars;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;
/*
 * @author Ralph Niels
 * Klasse voor textobject
 */
public class TextObject extends GameObject{
	
	private String text;
	
	public TextObject(String text) {
		this.text = text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(PGraphics g) {
		g.textAlign(g.LEFT, g.TOP);
		g.textSize(30);
		g.text(text,getX(),getY());
	}

}
