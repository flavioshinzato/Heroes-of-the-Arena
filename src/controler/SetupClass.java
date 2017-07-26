package controler;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import states.CreditState;
import states.GameState;
import states.InterState;
import states.MenuState;
import states.NewGameState;
import states.PreGameState;
import states.SaveState;

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
		this.addState(new SaveState());
		this.addState(new NewGameState());
		this.addState(new PreGameState());
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("Heroes of The Arena"));
		app.setDisplayMode(800, 600, false);
		app.setAlwaysRender(true);
		app.start();
	}

}
