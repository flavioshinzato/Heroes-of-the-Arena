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
	private Inimigo skeleton2;
	private Inimigo skeleton3;
	
	private Image background;
	private Image actionBar;
	private Image borda;
	private Image actionBar2;
	
	private Button button;
	
	private boolean press;
	private int timePress;
	
	private boolean novaAcao;
	private int tempoAcao;
	private int vezJogador;
	private Fase fase;

	private int posX, posY;
	
	private int time;
	private int jogadorAlvo;
	
	
	

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		background = new Image("background/fight.png");
		actionBar = new Image("background/bg2.png"); 
		actionBar2 = new Image("background/actionbar2.png");
		borda = new Image("borda/borda2.png");
		
		jogador = new Jogador("player");
		
		
		skeleton = new Inimigo("skeleton", 500, 200, 5);
		skeleton2 = new Inimigo("skeleton2", 600, 100, 5);
		skeleton3 = new Inimigo("skeleton2", 600, 300, 5);
		
		button = new Button("attack", 100,100);
		
		press= false;
		timePress = 0;
		time = 2000;
		
		novaAcao = true;
		vezJogador = 3;
	
		fase = new Fase("Fase 1-1", skeleton, skeleton2, skeleton3, jogador);
		
		//attack = new Image("button/botao.png");
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int delta) throws SlickException {
		
		posX = Mouse.getX();
		posY = Mouse.getY();
	
		if(fase.timeHeroiVivo() && fase.timeInimigoVivo())
		{
			if(novaAcao)
			{
				vezJogador = fase.vezJogador();
				tempoAcao = fase.getPersonagens(vezJogador).getAnimacao().getNAnimacoes();
				novaAcao = false;
				time = 0;
			}
			else
			{
				if(vezJogador < 3)
				{
					if(time == 0){
						jogadorAlvo = fase.combateJogadores(vezJogador);
						if(fase.getPersonagens(jogadorAlvo).getVidaAtual() == 0)
							tempoAcao += fase.getPersonagens(jogadorAlvo).getAnimacao().tempoMorte();
						time += delta;
					}
					else if(time < tempoAcao)
					{
						fase.getPersonagens(vezJogador).getAnimacao().attack(delta);
						if(fase.getPersonagens(jogadorAlvo).getVidaAtual() == 0)
							fase.getPersonagens(jogadorAlvo).getAnimacao().morreu(delta);
						time += delta;
					}
					else if(time >= tempoAcao)
					{
						novaAcao = true;
					}
				}
				else
				{
					if(button.inArea(posX, posY)){
						if(Mouse.isButtonDown(0) && !press){
							press = true;
						}
					}
					if(press)
					{
						if(time == 0){
							fase.combateJogadores(vezJogador);
							time += delta;
						}
						else if(time < fase.getPersonagens(vezJogador).getAnimacao().getNAnimacoes())
						{
							fase.getPersonagens(vezJogador).getAnimacao().attack(delta);
							time += delta;
						}
						else if(time >= fase.getPersonagens(vezJogador).getAnimacao().getNAnimacoes())
						{
							novaAcao = true;
							press = false;
						}
					}
				}
			}
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		
		background.draw(0,0, 800, 600);
		
		
		jogador.desenhaHerois();
		
		skeleton3.getAnimacao().getPersonagem().draw(skeleton3.getAnimacao().getPersonagemPosicao(0), skeleton3.getAnimacao().getPersonagemPosicao(1));
		skeleton3.getBarraVida().draw(skeleton3.getAnimacao().getPersonagemPosicao(0)+50, skeleton3.getAnimacao().getPersonagemPosicao(1)+5, 120*(skeleton2.getVidaAtual())/skeleton2.getVidaMaxima(), 9);
		

		skeleton2.getAnimacao().getPersonagem().draw(skeleton2.getAnimacao().getPersonagemPosicao(0), skeleton2.getAnimacao().getPersonagemPosicao(1));
		skeleton2.getBarraVida().draw(skeleton2.getAnimacao().getPersonagemPosicao(0)+50, skeleton2.getAnimacao().getPersonagemPosicao(1)+5, 120*(skeleton2.getVidaAtual())/skeleton2.getVidaMaxima(), 9);
		
		
		skeleton.getAnimacao().getPersonagem().draw(skeleton.getAnimacao().getPersonagemPosicao(0), skeleton.getAnimacao().getPersonagemPosicao(1));
		skeleton.getBarraVida().draw(skeleton.getAnimacao().getPersonagemPosicao(0)+50, skeleton.getAnimacao().getPersonagemPosicao(1)+5, 120*(skeleton.getVidaAtual())/skeleton.getVidaMaxima(), 9);
		
		
		
		
		//attack.draw(500,500);
		actionBar.draw(0,500, 800, 100);
		actionBar2.draw(30,500);
		//button.getButton().draw(button.getX(),600-button.getY(), 100,100);
		
		borda.draw(0,0, 800, 600);
		
		
		
		//g.drawString(""+posX+" "+posY, 200, 200);
		//g.drawString(""+button.inArea(posX, posY) + " " + button.getAltura() + " " + button.getLargura(), 300, 200);
		
	}
	
	@Override
	public int getID() {
		return 1;
	}

}
