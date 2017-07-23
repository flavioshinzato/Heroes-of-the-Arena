import java.io.File;
import java.util.Vector;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState  extends BasicGameState{
	
	private Personagem warrior;
	private Personagem mage;
	private Personagem archer;
	private Personagem skeleton;
	
	private Image background;
	private Image actionBar;

	
	private Button button;
	
	
	

	int posX, posY;

	public GameState(int state) {
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		background = new Image("background/fight.png");
		actionBar = new Image("background/bg1.png"); 
		
		
		warrior = new Personagem("warrior", 150, 200);
		mage = new Personagem("mage", 40, 180);
		archer = new Personagem("archer", 30, 270);
		
		skeleton = new Personagem("skeleton", 500, 200);
		
		button = new Button("attack", 100,100);
		
	
		
		//attack = new Image("button/botao.png");
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int delta) throws SlickException {
		
		posX = Mouse.getX();
		posY = Mouse.getY();
	
		if(button.inArea(posX, posY)){
			
			if(Mouse.isButtonDown(0)){
				
				warrior.attack();
			}
		}
		if(warrior.isBoolAttack()){
			warrior.attack(delta);
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		
		background.draw(0,0, 800, 600);
		mage.getPersonagem().draw(mage.getPersonagemPosicao(0), mage.getPersonagemPosicao(1));
		warrior.getPersonagem().draw(warrior.getPersonagemPosicao(0), warrior.getPersonagemPosicao(1));
		archer.getPersonagem().draw(archer.getPersonagemPosicao(0), archer.getPersonagemPosicao(1));
		skeleton.getPersonagem().draw(skeleton.getPersonagemPosicao(0), skeleton.getPersonagemPosicao(1));

		//attack.draw(500,500);
		actionBar.draw(0,500, 800, 100);
		button.getButton().draw(button.getX(),600-button.getY(), 100,100);
		
		
		
		g.drawString(""+posX+" "+posY, 200, 200);
		//g.drawString(""+button.inArea(posX, posY) + " " + button.getAltura() + " " + button.getLargura(), 300, 200);
		
	}
	
	@Override
	public int getID() {
		return 1;
	}

}
