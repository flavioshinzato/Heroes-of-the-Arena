package states;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import animacoes.Button;
import controler.Fase;
import controler.Inimigo;
import controler.Jogador;
import controler.Save;

public class GameState  extends BasicGameState{
	

	private Jogador jogador;
	private Inimigo skeleton;
	private Inimigo skeleton2;
	private Inimigo skeleton3;
	
	private Image background;
	private Image actionBar;
	private Image borda;
	private Image actionBar2;
	
	private Button attack;
	
	private boolean press;
	private int timePress;
	
	private boolean novaAcao;
	private int tempoAcao;
	private int vezJogador;
	private Fase fase;

	private int posX, posY;
	
	private int time;
	private int jogadorAlvo;
	
	private Save save;
	
	private boolean inicializacao = false;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {	
	}
	public void init2() throws SlickException
	{
		save = new Save();
		int[] skins = save.readSaveInt();
		
		background = new Image("background/fight.png");
		actionBar = new Image("background/bg2.png"); 
		actionBar2 = new Image("background/actionbar2.png");
		borda = new Image("borda/borda2.png");
		
		
		jogador = new Jogador("player", skins[0], skins[1], skins[2]);
		
		
		skeleton = new Inimigo("skeleton", 500, 200, 5);
		skeleton2 = new Inimigo("skeleton2", 600, 100, 5);
		skeleton3 = new Inimigo("skeleton2", 600, 300, 5);
		
		attack = new Button("attack", 80,75);
		
		press= false;
		timePress = 0;
		time = 2000;
		
		novaAcao = true;
		vezJogador = 0;
	
		fase = new Fase("Fase 1-1", skeleton, skeleton2, skeleton3, jogador);
		inicializacao = true;

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int delta) throws SlickException {
		if(!inicializacao)
		{
			this.init2();
		}
		
		
		posX = Mouse.getX();
		posY = Mouse.getY();
		
		if(fase.timeHeroiVivo() && fase.timeInimigoVivo() || !novaAcao)
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
				// Turno do Inimigo
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
				//Turno do Aliado
				else
				{
					if(attack.inArea(posX, posY)){
						if(Mouse.isButtonDown(0) && !press){
							press = true;
						}
					}
					if(press)
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
							press = false;
						}
					}
				}
			}
		}
		else
		{
			
		}
	}
	
	

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		
		background.draw(0,0, 800, 600);
		
		
		jogador.desenhaHerois();
		
		skeleton.getAnimacao().getPersonagem().draw(skeleton.getAnimacao().getPersonagemPosicao(0), skeleton.getAnimacao().getPersonagemPosicao(1));
		skeleton.getBarraVida().draw(skeleton.getAnimacao().getPersonagemPosicao(0)+50, skeleton.getAnimacao().getPersonagemPosicao(1)+5, 120*(skeleton.getVidaAtual())/skeleton.getVidaMaxima(), 9);
			
		skeleton3.getAnimacao().getPersonagem().draw(skeleton3.getAnimacao().getPersonagemPosicao(0), skeleton3.getAnimacao().getPersonagemPosicao(1));
		skeleton3.getBarraVida().draw(skeleton3.getAnimacao().getPersonagemPosicao(0)+50, skeleton3.getAnimacao().getPersonagemPosicao(1)+5, 120*(skeleton3.getVidaAtual())/skeleton3.getVidaMaxima(), 9);
		


		skeleton2.getAnimacao().getPersonagem().draw(skeleton2.getAnimacao().getPersonagemPosicao(0), skeleton2.getAnimacao().getPersonagemPosicao(1));
		skeleton2.getBarraVida().draw(skeleton2.getAnimacao().getPersonagemPosicao(0)+50, skeleton2.getAnimacao().getPersonagemPosicao(1)+5, 120*(skeleton2.getVidaAtual())/skeleton2.getVidaMaxima(), 9);
		
		
	
		actionBar.draw(0,500, 800, 100);
		actionBar2.draw(30,500);
		
		attack.getButton().draw(attack.getX(), 600-attack.getY());
		
		borda.draw(0,0, 800, 600);
		
	}
	
	@Override
	public int getID() {
		return 1;
	}

}
