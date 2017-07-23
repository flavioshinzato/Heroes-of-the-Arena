import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;

import java.awt.Font;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class MenuState extends BasicGameState{
	private Image bg;
	private Button playButton;
	private Button creditButton;
	private int posX, posY;
	private UnicodeFont ufont;
	
	public MenuState() {
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image("background/bg2.png");
		playButton = new Button("Jogar", 280, 380);
		creditButton = new Button("Créditos", 280, 260);
		ufont = null;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bg.draw(0, 0, 800, 600);
		//g.drawString("Heroes of the Arena", 280, 200);
		playButton.getButton().draw(playButton.getX(),600-playButton.getY(), 189, 63);
		creditButton.getButton().draw(creditButton.getX(),600-creditButton.getY(), 189, 63);
		
		String title = "Heroes of the Arena";
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
		g.drawString(title, 230, 150);
		//ufont.drawString(450, 450, cad);
		
		//g.drawString(""+posX+" "+posY, 200, 200);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		posX = Mouse.getX();
		posY = Mouse.getY();
		
		if(playButton.inArea(posX, posY)){	
			if(Mouse.isButtonDown(0)){
				sbg.enterState(3);
			}
		}
		
		if(creditButton.inArea(posX, posY)){	
			if(Mouse.isButtonDown(0)){
				sbg.enterState(2);
			}
		}
			
		
	}

	@Override
	public int getID() {
		return 0;
	}

}
