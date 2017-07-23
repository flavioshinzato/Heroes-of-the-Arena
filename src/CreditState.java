import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CreditState extends BasicGameState{
	private Image bg;
	private Button voltar;
	private int posX, posY;
	
	
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		bg = new Image("background/bg1.png");
		voltar = new Button("Voltar", 550, 100);
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
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bg.draw();
		g.drawString("Crétidos:", 350, 200);
		voltar.getButton().draw(voltar.getX(),600-voltar.getY(), 189, 63);
		
		
	}
	
	@Override
	public int getID() {
		return 2;
	}
	
}
