
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SetupClass extends StateBasedGame{
	
	public SetupClass(String gamename) {
		super(gamename);
	
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.addState(new MenuState());
		this.addState(new GameState());
		this.addState(new CreditState());
		this.addState(new InterState());
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test"));
		app.setDisplayMode(800, 600, false);
		app.setAlwaysRender(true);
		app.start();
	}


}
