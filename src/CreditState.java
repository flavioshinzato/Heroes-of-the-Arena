import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CreditState extends BasicGameState{
	private Image bg;
	private int posX, posY;
	private Button voltar;
	private UnicodeFont ufont;

	public CreditState() {
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		bg = new Image("background/bg2.png");
		voltar = new Button("Voltar", 50, 130);
		ufont = null;

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bg.draw(0, 0, 800, 600);
				
		String credit = "Creditos";
		String name1 = "Flávio Augusto Müller Shinzato";
		String name2 = "Jessica Abe";
		String name3 = "Luiz Henrique Cavalcante da Silva";
		
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
		g.drawString(credit, 300, 160);
		
		try {
			   Font font = new Font("OptimusPrincepsSemiBold", Font.BOLD, 15);
			   ufont = new UnicodeFont(font, font.getSize(), font.isBold(), font.isItalic());
			   ufont.addAsciiGlyphs();
			   ufont.addGlyphs(400, 600);
			   ufont.getEffects().add(new ColorEffect(java.awt.Color.white));
			   ufont.loadGlyphs();
			} catch (SlickException e) {
			   e.printStackTrace();
		}
		
		g.setFont(ufont);
		g.drawString(name1, 260, 220);
		g.drawString(name2, 330, 240);
		g.drawString(name3, 260, 260);
	
		voltar.getButton().draw(voltar.getX(),600-voltar.getY(), 189, 63);
		
		g.drawString(""+posX+" "+posY, 200, 200);
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		posX = Mouse.getX();
		posY = Mouse.getY();
		
		if(voltar.inArea(posX, posY)){	
			if(Mouse.isButtonDown(0)){
				sbg.enterState(0);
			}
		}
		
	}
	
	@Override
	public int getID() {
		return 2;
	}
	
}
