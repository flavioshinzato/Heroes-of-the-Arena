import org.newdawn.slick.SlickException;

public class Jogador{
	private String nome;
	private Heroi herois[] = new Heroi[3];

	
	public Jogador(String nome) throws SlickException
	{
		this.nome = nome;
		herois[0] = new Heroi("warrior", 150, 200);
		herois[1] = new Heroi("mage", 40, 180);
		herois[2] = new Heroi("archer", 30, 300);
	}
	

	public void desenhaHerois()
	{
		herois[1].getAnimacao().getPersonagem().draw(herois[1].getAnimacao().getPersonagemPosicao(0), herois[1].getAnimacao().getPersonagemPosicao(1));
		herois[1].getBarraVida().draw(herois[1].getAnimacao().getPersonagemPosicao(0)+20, herois[1].getAnimacao().getPersonagemPosicao(1)-10, 120*(herois[1].getVidaAtual())/herois[1].getVidaMaxima(), 9);
		herois[1].getBarraMana().draw(herois[1].getAnimacao().getPersonagemPosicao(0)+20, herois[1].getAnimacao().getPersonagemPosicao(1), 120*(herois[1].getManaAtual())/herois[1].getManaMaxima(), 9);
		
		herois[0].getAnimacao().getPersonagem().draw(herois[0].getAnimacao().getPersonagemPosicao(0), herois[0].getAnimacao().getPersonagemPosicao(1));
		herois[0].getBarraVida().draw(herois[0].getAnimacao().getPersonagemPosicao(0)+50, herois[0].getAnimacao().getPersonagemPosicao(1)+30, 120*(herois[0].getVidaAtual())/herois[0].getVidaMaxima(), 9);
		herois[0].getBarraMana().draw(herois[0].getAnimacao().getPersonagemPosicao(0)+50, herois[0].getAnimacao().getPersonagemPosicao(1)+40, 120*(herois[0].getManaAtual())/herois[0].getManaMaxima(), 9);
		
				
		herois[2].getAnimacao().getPersonagem().draw(herois[2].getAnimacao().getPersonagemPosicao(0), herois[2].getAnimacao().getPersonagemPosicao(1));
		herois[2].getBarraVida().draw(herois[2].getAnimacao().getPersonagemPosicao(0)+20, herois[2].getAnimacao().getPersonagemPosicao(1)+5, 120*(herois[2].getVidaAtual())/herois[2].getVidaMaxima(), 9);
		herois[2].getBarraMana().draw(herois[2].getAnimacao().getPersonagemPosicao(0)+20, herois[2].getAnimacao().getPersonagemPosicao(1)+15, 120*(herois[2].getManaAtual())/herois[2].getManaMaxima(), 9);
	}
	public String getNome() {
		return nome;
	}


	public Heroi getHerois(int i) {
		return herois[i];
	}	
}
