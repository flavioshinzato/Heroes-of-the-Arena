package controler;
import org.newdawn.slick.SlickException;

public class Inimigo extends Personagem{
	private int nivel;
	

	public Inimigo(String nome, int x, int y, int nivel) throws SlickException
	{
		super(nome, x, y, 1);
		this.nivel = nivel;
		vidaMaxima = nivel*2;
		vidaAtual = vidaMaxima;
	}


	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public int getNivel() {
		return nivel;
	}
	
	@Override
	public void perderVida(int x){
		vidaAtual -= x;
		if(vidaAtual < 0)
			vidaAtual = 0;
	}
	@Override
	public int getDano(){
		return nivel;
	}
	
	@Override
	public void acaoPersonagem(){
		
	}
	
}
