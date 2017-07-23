import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;

public class MenuState extends BasicGameState{
	private Image bg;
	private Button playButton;
	private Button creditButton;
	private int posX, posY;
	
	public MenuState() {
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image("background/bg2.png");
		playButton = new Button("Jogar", 280, 380);
		creditButton = new Button("Créditos", 280, 260);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bg.draw(0, 0, 800, 600);
		g.drawString("Heroes of the Arena", 280, 200);
		playButton.getButton().draw(playButton.getX(),600-playButton.getY(), 189, 63);
		creditButton.getButton().draw(creditButton.getX(),600-creditButton.getY(), 189, 63);
		

		g.drawString(""+posX+" "+posY, 200, 200);
		
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
