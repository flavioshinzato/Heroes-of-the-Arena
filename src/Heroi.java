import org.newdawn.slick.SlickException;

//import Itens.*; 

public class Heroi extends Personagem{
	//private Classe classe;
	//private Armadura armadura;
	
	private int defesa;
	
	private int vidaAtual;
	private int vidaMaxima;
	
	private int manaMaxima;
	private int manaAtual;
	
	public Heroi(String nome, int x, int y) throws SlickException
	{
		super(nome, x, y);
		//this.classe = classe;
		
		switch(nome){
			case("warrior"):
				vidaMaxima = 60;
				manaMaxima = 40;
				defesa = 6;
			case("mage"):
				vidaMaxima =30;
				manaMaxima = 40;
				defesa = 2;
			case("archer"):
				defesa = 4;
				vidaMaxima = 40;
				manaMaxima = 40;
		}
		vidaAtual = vidaMaxima;
		manaAtual = manaMaxima;
	}
	

/*	public Classe getClasse() {
		return classe;
	}
*/


	public int getVidaAtual() {
		return vidaAtual;
	}

	public int getDefesa() {
		return defesa;
	}


	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public int getManaMaxima() {
		return manaMaxima;
	}

	public int getManaAtual() {
		return manaAtual;
	}
	

/*
	public void addArmadura(Armadura armadura)
	{
		this.armadura = armadura;
	}
*/	
	@Override
	public void perderVida(int x){
		vidaAtual -= x;
		if(vidaAtual < 0)
			vidaAtual = 0;
	}
	@Override
	public int getDano()
	{
		return 0;
	}
}
