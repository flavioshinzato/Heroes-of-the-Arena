package animacoes;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Button {
	private String nome;
	private Image button;
	private double altura;
	private double largura;
	private int x;
	private int y;
	
	public Button(String nome, int x, int y) throws SlickException
	{
		button = new Image("button/"+nome+".png");
		altura = 2* button.getCenterOfRotationY();
		largura = 2* button.getCenterOfRotationX();
		this.x = x;
		this.y = y;
	}
	
	public double teste()
	{
		return button.getTextureHeight();
	}
	
	public boolean inArea(int posX, int posY)
	{
		if((posX> x && posX< x + largura)&&(posY < y && posY>y-altura) )
			return true;
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Image getButton() {
		return button;
	}

	public double getAltura() {
		return altura;
	}

	public double getLargura() {
		return largura;
	}
	
}
