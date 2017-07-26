package states;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import animacoes.Button;

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
		newGameButton = new Button("Novo Jogo", 280, 460);
		continueButton = new Button("Continuar", 280, 320);
		voltar = new Button("Voltar", 280, 200);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bg.draw(0, 0, 800, 600);
		newGameButton.getButton().draw(newGameButton.getX(),600-newGameButton.getY(), 189, 63);
		continueButton.getButton().draw(continueButton.getX(),600-continueButton.getY(), 189, 63);
		voltar.getButton().draw(voltar.getX(),600-voltar.getY(), 189, 63);
		
				
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		posX = Mouse.getX();
		posY = Mouse.getY();
		
		if(newGameButton.inArea(posX, posY)){	
			if(Mouse.isButtonDown(0)){
				sbg.enterState(8);
			}
		}
		
		if(continueButton.inArea(posX, posY)){	
			if(Mouse.isButtonDown(0)){
				sbg.enterState(4);
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
