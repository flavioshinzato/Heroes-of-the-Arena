import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Personagem {
	protected String nome;
	protected int vidaAtual;
	protected int vidaMaxima;
	protected PersonagemAnimacao animacao;
	protected Image barraVida;
	protected Image barraMana;
	
	public Personagem(String nome, int x, int y) throws SlickException
	{
		barraVida = new Image("barra/vida.png");
		barraMana = new Image("barra/stamina.png");
		if(nome == "mage")
		{
			barraMana = new Image("barra/mana.png");
		}
		this.nome = nome;
		animacao = new PersonagemAnimacao(nome, x, y); 
	}
	
	public int getDano()
	{
		return 0;
	}
	
	public void perderVida(int x){
	}
	
	public int getVidaAtual()
	{
		return vidaAtual;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void acaoPersonagem(){
	}

	public PersonagemAnimacao getAnimacao() {
		return animacao;
	}

	public Image getBarraVida() {
		return barraVida;
	}
	
	public Image getBarraMana()
	{
		return barraMana;
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}
	
	
	
}
