
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SetupClass extends StateBasedGame{
	public static final String gamename = "Heroes of the Arena";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int credit = 2;
	
	public SetupClass(String gamename) {
		super(gamename);
		this.addState(new MenuState(menu));
		this.addState(new GameState(play));
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(credit).init(gc, this);
		this.enterState(menu);
	}
	

	public static void main(String[] args) throws SlickException {	
		AppGameContainer app;
		try {
			app = new AppGameContainer(new SetupClass(gamename));
			app.setDisplayMode(800, 600, false);
			app.start();
			
		}catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	
}
