import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game {
	
	private static final long MAX_FPS = 60;
	private static final long DELTA = 1000/MAX_FPS;
	
	private GameObject character;
	
	public Game() {
		try {
			Main.frame.getGraphics().setColor(Color.GRAY);
			character = new GameObject(ImageIO.read(new File("res/filler character.png")), 60, 60);
		} catch (IOException e) {
			// shit
			System.exit(-1);
			e.printStackTrace();
		}
	}
	
	public void update() {
		character.action();
	}
	
	public void draw() {
		Main.frame.getGraphics().fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
		character.draw(Main.frame.getGraphics());
	}
	
	public void start() {
		long now = System.currentTimeMillis();
		long prev = System.currentTimeMillis();
		while (true) {
			now = System.currentTimeMillis();
			if (now - prev > DELTA) {
				update();
				draw();
				prev = now;
			}
		}
	}
}
