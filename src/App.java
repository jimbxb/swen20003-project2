
/**
 * Sample Project for SWEN20003: Object Oriented Software Development 2018
 * by Eleanor McMurtry, University of Melbourne
 * modified by James Barnes, University of Melkbourne
 */

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Input;

/**
 * Main class for the game. Handles initialisation, input and rendering
 */
public class App extends BasicGame {

	/** screen width (px) */
	public static final int SCREEN_WIDTH = 1024;
	/** screen height (px) */
	public static final int SCREEN_HEIGHT = 768;

	/** Contained World object */
	private World world;

	public App() {
		super("Shadow Leap");
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		world = new World();
	}

	/**
	 * Update the game state
	 * 
	 * @param gc    The Slick game container object
	 * @param delta Time passed since last update (milliseconds)
	 */
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// Get data about the current input (keyboard state).
		Input input = gc.getInput();
		world.update(input, delta);
	}

	/**
	 * Render the entire screen, so it reflects the current game state
	 * 
	 * @param gc The Slick game container object
	 * @param g  The Slick graphics object, used for drawing
	 */
	public void render(GameContainer gc, Graphics g) throws SlickException {
		world.render(g);
	}

	/**
	 * Start-up method. Creates the game and runs it
	 * 
	 * @param args Command-line arguments (ignored)
	 */
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new App());
		app.setShowFPS(false);
		app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
		app.start();
	}

	/**
	 * Performs default Exception handling. Prints stackTrace and exit.
	 * 
	 * @param e Exception object
	 */
	public static void handleException(Exception e) {
		e.printStackTrace();
		System.exit(1);
	}

	/**
	 * Ends the game
	 * 
	 * @param message Message to print to console on ending game
	 */
	public static void endGame(String message) {
		System.out.println(message);
		System.exit(0);
	}
}