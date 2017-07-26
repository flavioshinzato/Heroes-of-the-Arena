package states;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import animacoes.Button;
import controler.Save;

import org.newdawn.slick.Image;

import java.awt.Font;
import java.io.FileNotFoundException;

import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class SaveState extends BasicGameState {
	private Image bg;
	private Button save;
	private int posX, posY; 
	private Save saveData;
	private UnicodeFont ufont;
	private Button voltar;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image("background/save.png");
		save = new Button("Voltar", 95, 350);
		voltar = new Button("Voltar", 100, 70);
		saveData = new Save();
		ufont = null;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bg.draw(0, 0, 800, 600);
		voltar.getButton().draw(voltar.getX(),600-voltar.getY(), 189, 63);
		
		String loucura = saveData.readSave();
		
		try {
			   Font font = new Font("OptimusPrincepsSemiBold", Font.BOLD, 30);
			   ufont = new UnicodeFont(font, font.getSize(), font.isBold(), font.isItalic());
			   ufont.addAsciiGlyphs();
			   ufont.addGlyphs(400, 600);
			   ufont.getEffects().add(new ColorEffect(java.awt.Color.white));
			   ufont.loadGlyphs();
			} catch (SlickException e) {
			   e.printStackTrace();
			}
			g.setFont(ufont);
			g.drawString(loucura, 410, 260);
		
		
		
		posX = Mouse.getX();
		posY = Mouse.getY();
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		posX = Mouse.getX();
		posY = Mouse.getY();
		
		if(save.inArea(posX, posY)){	
			if(Mouse.isButtonDown(0)){
				sbg.enterState(1);
			}
		}
		
		if(voltar.inArea(posX, posY)){	
			if(Mouse.isButtonDown(0)){
				sbg.enterState(3);
			}
		}
	}

	@Override
	public int getID() {
		return 4;
	}

}
