import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CreditState extends BasicGameState{
	private Image bg;
	private int posX, posY;
	private Button voltar;

	public CreditState() {
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		bg = new Image("background/bg2.png");
		voltar = new Button("Voltar", 50, 130);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bg.draw(0, 0, 800, 600);
		g.drawString("Créditos:", 350, 200);
		g.drawString("Flávio Augusto Müller Shinzato", 260, 220);
		g.drawString("Jessica Abe", 330, 240);
		g.drawString("Luiz Henrique Cavalcante da Silva", 260, 260);
		voltar.getButton().draw(voltar.getX(),600-voltar.getY(), 189, 63);
		posX = Mouse.getX();
		posY = Mouse.getY();
		g.drawString(""+posX+" "+posY, 200, 200);
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(voltar.inArea(posX, posY)){	
			if(Mouse.isButtonDown(0)){
				sbg.enterState(0);
			}
		}
		
	}
	
	@Override
	public int getID() {
		return 2;
	}
	
}
