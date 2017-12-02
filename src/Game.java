import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game {
	
	private static final long MAX_FPS = 60;
	private static final long DELTA = 1000/MAX_FPS;
	
	//resources
	public static BufferedImage boulder,
								background,
								levels,
								button,
								character
								;
	
	public Character main_dude;
	
	public static void init() {
		try {
			character = ImageIO.read(new File("res/filler character.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Failed to import resources!");
			System.exit(-1);
		}
	}
	
	public Game() {
		init();
		Main.frame.getGraphics().setColor(Color.GRAY);
		main_dude = new Character();
	}
	
	public void update() {
		main_dude.action();
	}
	
	public void draw() {
		Main.frame.getGraphics().fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
		main_dude.draw(Main.frame.getGraphics());
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
