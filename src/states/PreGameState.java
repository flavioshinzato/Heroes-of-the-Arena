package states;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class PreGameState extends BasicGameState{
	private int x = 0;
	private int movimento;
	private boolean tutorial = false;
	private Image tutorials;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		tutorials = new Image("background/tutorial.png");
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		movimento-= delta;
		x = movimento/64;
		
		if(Mouse.isButtonDown(0) && movimento < -300 && !tutorial )
		{
			movimento = -640000;
			tutorial = true;
		}
		if(Mouse.isButtonDown(0) && movimento < -640300 && tutorial )
		{
			sbg.enterState(1);
		}
			
	}
	
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {

		if(tutorial)
			tutorials.draw(0,0);
		
		g.drawString("Três aventureiros, corajosos e não tão inteligentes, ", 40, 600+x);
		g.drawString("estavam a caminho de um grande festival que acontecia em uma cidade distante. ", 40, 620+x);
		g.drawString("Erik, Olaf e Baelog caminhavam incansavelmente pela estrada sinuosa, ", 40, 640+x);
		g.drawString("apenas pensando nos comes e bebes da grande festa, ", 40, 660+x);
		g.drawString("além é claro da possibilidade de toparem com uma grande empreitada. ", 40, 680+x);
		g.drawString("Porém, como inteligentes que eram, ninguém levou um mapa. ", 40, 700+x);
		g.drawString("Curvas e encruzilhadas tornaram o caminho difícil. ", 40, 720+x);
		g.drawString("Erik queria sempre ir para a direita, enquanto Olaf para a esquerda. ", 40, 740+x);
		g.drawString("Baelog apenas seguia os amigos. ", 40, 760+x);
		g.drawString("Depois de muitas idas, vindas, discussões de qual seria o melhor ", 40, 780+x);
		g.drawString("caminho ou de quem era o mais bonito, ", 40, 800+x);
		g.drawString("os três constaram o óbvio: estavam perdidos. ", 40, 820+x);
		g.drawString("Uma bondosa senhora, com verrugas no nariz, capuz preto e ", 40, 840+x);
		g.drawString("cheiro de enxofre topou com os três no caminho. ", 40, 860+x);
		g.drawString("Eles perguntaram se ela sabia qual era o caminho para o festival. ", 40, 880+x);
		g.drawString("A inofensiva e amorosa senhora, apontou para um caminho escuro e", 40, 900+x);
		g.drawString(" cheio de pedras e corvos. ", 40, 920+x);
		g.drawString("Os três, claro, seguiram. ", 40, 940+x);
		g.drawString("Por sorte do destino ou não, eles chegarem numa grandiosa", 40, 960+x);
		g.drawString(" arena chamada Nexus. ", 40, 980+x);
		g.drawString("Talvez não fosse tão grandiosa assim.", 40, 1000+x); 
		g.drawString("Lá, um senhor alto e egocêntrico disse que as vidas dos aventureiros ", 40, 1020+x);
		g.drawString("agora lhe pertenciam e eles deveriam lutar", 40, 1040+x);
		g.drawString("para sobreviver aos perigos da arena MUAHAHA. ", 40, 1060+x);
		g.drawString("Os três deram de ombros, empunharam suas armas e entraram na batalha, ", 40, 1080+x);
		g.drawString("esperando que pelo menos fosse rolar uma cerveja depois. ", 40, 1100+x);
		g.drawString("Eae, você consegue ajudar os nossos aventureiros na arena? ", 40, 1120+x);
		g.drawString("Bem vindo ao Heroes of the Arena!", 40, 1140+x);
	}



	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 9;
	}

}
