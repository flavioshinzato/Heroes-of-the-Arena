import java.io.File;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Personagem {
	private String nome;
	private Animation wait, attack, dead, hurt;
	private Animation personagem;
	private int[] personagemPosicao = new int[2];
	private boolean boolAttack;
	private int time;
	private int movimento;
	private boolean stop;
	

	
	public Personagem(String nome, int x, int y) throws SlickException
	{
		int nAnimacoes;
		this.nome = nome;
		
		nAnimacoes = new File(nome+"/attack").list().length;
		Image[] attack2 = new Image[nAnimacoes];

		for(int i=0; i<nAnimacoes; i++)
			attack2[i] = new Image(nome+"/attack/attack_"+(i+1)+".png"); 
		
		attack = new Animation(attack2, 200);
		
		Image[] wait2 = {new Image(nome+"/attack/attack_1.png")}; 
		wait = new Animation(wait2, 200);
		
		nAnimacoes = new File(nome+"/dead").list().length;
		Image[] dead2 = new Image[nAnimacoes];
		for(int i=0; i<nAnimacoes; i++)
			dead2[i] = new Image(nome+"/dead/dead_"+(i+1)+".png"); 
		dead = new Animation(dead2, 200);
		
		nAnimacoes = new File(nome+"/hurt").list().length;
		Image[] hurt2 = new Image[nAnimacoes];
		for(int i=0; i<nAnimacoes; i++)
			hurt2[i] = new Image(nome+"/hurt/hurt_"+(i+1)+".png"); 
		hurt = new Animation(hurt2, 200);
		
		personagem = wait;
		
		boolAttack = false;
		stop = false;
		personagemPosicao[0] = x;
		personagemPosicao[1] = y;
		


	}


	public int getPersonagemPosicao(int x) {
		return personagemPosicao[x];
	}


	public void setPersonagemPosicao(int[] personagemPosicao) {
		this.personagemPosicao = personagemPosicao;
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
		stop = true;
		time = 0;
		boolAttack = true;
		movimento = 0;
	}
	public void attack(int delta)
	{
		time+=delta;
		
		if(time >= 900 && stop == true)
		{
			stop = false;
			personagemPosicao[0] = 150;
			personagem = wait;
		}
		else if(time < 900 && stop == true)
		{
			movimento +=delta;
			personagemPosicao[0] = 150 + movimento/4;
		}
		else if(movimento > 0 && stop == false)
		{
			personagemPosicao[0] =150 + movimento/4;
			movimento -=delta;
		}
		else if(movimento <= 0 && stop == false)
		{
			boolAttack = false;
		}
	}
	
}
