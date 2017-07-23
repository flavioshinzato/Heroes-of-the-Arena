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
	

	private Jogador jogador;
	private Inimigo skeleton;
	
	private Image background;
	private Image actionBar;

	
	private Button button;
	
	private boolean press;
	private int timePress;
	
	private Fase fase;

	int posX, posY;

	public GameState() {
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		background = new Image("background/fight.png");
		actionBar = new Image("background/bg1.png"); 
		
		jogador = new Jogador("player");

		
		skeleton = new Inimigo("skeleton", 500, 200, 5);
		
		button = new Button("attack", 100,100);
		
		press= false;
		timePress = 0;
	
		fase = new Fase("Fase 1-1", skeleton, skeleton, skeleton, jogador);
		
		//attack = new Image("button/botao.png");
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int delta) throws SlickException {
		
		posX = Mouse.getX();
		posY = Mouse.getY();
	
		timePress += delta;
		if(button.inArea(posX, posY)){
			
			if(Mouse.isButtonDown(0) && !press){
				press = true;
				timePress = 0;
				jogador.getHerois(0).getAnimacao().attack();
				
				skeleton.perderVida(5);
				if(skeleton.getVidaAtual() == 0)
				{
					skeleton.getAnimacao().setPersonagemPosicao(0, -110);
					skeleton.getAnimacao().morreu();
				}
			}
		}
		if(jogador.getHerois(0).getAnimacao().isBoolAttack()){
			jogador.getHerois(0).getAnimacao().attack(delta);
		}
		if(press == true && timePress > 800)
		{
			press  = false;
			if(skeleton.getVidaAtual() == 0)
			{
				skeleton.getAnimacao().morreu(delta);
			}
		}
		

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		
		background.draw(0,0, 800, 600);
		
		jogador.desenhaHerois();
		
		skeleton.getAnimacao().getPersonagem().draw(skeleton.getAnimacao().getPersonagemPosicao(0), skeleton.getAnimacao().getPersonagemPosicao(1));
		skeleton.getBarraVida().draw(skeleton.getAnimacao().getPersonagemPosicao(0)+50, skeleton.getAnimacao().getPersonagemPosicao(1)+5, 120*(skeleton.getVidaAtual())/skeleton.getVidaMaxima(), 9);
		
		//attack.draw(500,500);
		actionBar.draw(0,500, 800, 100);
		button.getButton().draw(button.getX(),600-button.getY(), 100,100);
		
		
		
		//g.drawString(""+posX+" "+posY, 200, 200);
		//g.drawString(""+button.inArea(posX, posY) + " " + button.getAltura() + " " + button.getLargura(), 300, 200);
		
	}
	
	@Override
	public int getID() {
		return 1;
	}

}
