import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class InterState extends BasicGameState {
	private Image bg;
	private Button newGameButton;
	private Button continueButton;
	private Button voltar;
	private int posX, posY;
	
	
	public InterState() {
	}
		
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image("background/bg2.png");
		newGameButton = new Button("Novo Jogo", 280, 380);
		continueButton = new Button("Continuar", 280, 260);
		voltar = new Button("Voltar", 280, 140);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bg.draw(0, 0, 800, 600);
		g.drawString("Heroes of the Arena", 280, 200);
		newGameButton.getButton().draw(newGameButton.getX(),600-newGameButton.getY(), 189, 63);
		continueButton.getButton().draw(continueButton.getX(),600-continueButton.getY(), 189, 63);
		voltar.getButton().draw(voltar.getX(),600-voltar.getY(), 189, 63);
		
		
		posX = Mouse.getX();
		posY = Mouse.getY();
		g.drawString(""+posX+" "+posY, 200, 200);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(newGameButton.inArea(posX, posY)){	
			if(Mouse.isButtonDown(0)){
				sbg.enterState(3);
			}
		}
		
		if(continueButton.inArea(posX, posY)){	
			if(Mouse.isButtonDown(0)){
				sbg.enterState(1);
			}
		}
		
		if(voltar.inArea(posX, posY)){	
			if(Mouse.isButtonDown(0)){
				sbg.enterState(0);
			}
		}
	}

	@Override
	public int getID() {
		return 3;
	}

}
