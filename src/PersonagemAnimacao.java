import java.io.File;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PersonagemAnimacao {
	private String nome;
	private Animation wait, attack, dead, morto, hurt;
	private Animation personagem;
	private int[] personagemPosicao = new int[2];
	private int[] posicaoInicial = new int [2];
	private boolean boolAttack;
	private int time;
	private int movimento;
	private boolean stop;
	
	private Image vida, mana, stamina;
	
	private int[] nAnimacoes = new int[5];
	
	private boolean curtoAlcance;

	
	public PersonagemAnimacao(String nome, int x, int y) throws SlickException
	{
		
		this.nome = nome;
		
		nAnimacoes[0] = 1;
		Image[] wait2 = {new Image(nome+"/attack/attack_1.png")}; 
		wait = new Animation(wait2, 200);
		
		nAnimacoes[1] = new File(nome+"/attack").list().length;
		Image[] attack2 = new Image[nAnimacoes[1]];
		for(int i=0; i<nAnimacoes[1]; i++)
			attack2[i] = new Image(nome+"/attack/attack_"+(i+1)+".png"); 
		attack = new Animation(attack2, 200);
		

		
		nAnimacoes[2] = new File(nome+"/dead").list().length;
		Image[] dead2 = new Image[nAnimacoes[2]];
		for(int i=0; i<nAnimacoes[2]; i++)
			dead2[i] = new Image(nome+"/dead/dead_"+(i+1)+".png"); 
		dead = new Animation(dead2, 200);
		
		nAnimacoes[3] = 1;
		Image[] morto2 = {new Image(nome+"/dead/dead_"+nAnimacoes[2]+".png")}; 
		morto = new Animation(morto2, 200);
		
		
		nAnimacoes[4] = new File(nome+"/hurt").list().length;
		Image[] hurt2 = new Image[nAnimacoes[4]];
		for(int i=0; i<nAnimacoes[4]; i++)
			hurt2[i] = new Image(nome+"/hurt/hurt_"+(i+1)+".png"); 
		hurt = new Animation(hurt2, 200);
		
		personagem = wait;
		
		boolAttack = false;
		stop = false;
		posicaoInicial[0] = x;
		posicaoInicial[1] = y;
		personagemPosicao[0] = x;
		personagemPosicao[1] = y;
		
		if(nome == "warrior")
			curtoAlcance = true;
		else
			curtoAlcance = false;


	}


	public int getPersonagemPosicao(int x) {
		return personagemPosicao[x];
	}


	public void setPersonagemPosicao(int x, int personagemPosicao) {
		this.personagemPosicao[x] += personagemPosicao;
	}


	public String getNome() {
		return nome;
	}

	public Animation getPersonagem() {
		return personagem;
	}


	public boolean isBoolAttack() {
		return boolAttack;
	}
	
	public void attack()
	{
		personagem = attack;
		personagem.restart();
		stop = true;
		time = 0;
		boolAttack = true;
		movimento = 0;
	}
	public void attack(int delta)
	{
		time+=delta;
		
		if(time >= 200*nAnimacoes[1] && stop)
		{
			stop = false;
			personagemPosicao[0] = posicaoInicial[0];
			personagem = wait;
		}
		else if(time < 200*nAnimacoes[1] && stop && curtoAlcance)
		{
			movimento +=delta;
			personagemPosicao[0] = posicaoInicial[0] + movimento/4;
		}
		else if(movimento > 0 && !stop && curtoAlcance)
		{
			personagemPosicao[0] = posicaoInicial[0] + movimento/4;
			movimento -=delta;
		}
		else if(movimento <= 0 && !stop && curtoAlcance)
		{
			boolAttack = false;
		}
	}
	
	public int getNAnimacoes()
	{
		if(nome == "warrior")
		{
			return 800+200*(nAnimacoes[1]);
		}
		return 10+200*(nAnimacoes[1]);
		
	}
	public void morreu()
	{
		personagem = dead;
		time = 0;
		stop = true;
	}
	
	public void morreu(int delta)
	{
		time+= delta;
		if(time > nAnimacoes[2]*200)
			personagem = morto;
		
	}
	
	public int tempoMorte()
	{
		return nAnimacoes[2]*200;
	}
	
}
