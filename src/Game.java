import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game {
	
	private static final long MAX_FPS = 60;
	private static final long DELTA = 1000000000L/MAX_FPS;
	
	//resources
	public static BufferedImage boulder,
								background,
								levels,
								button,
								character
								;
	
	public Character main_dude;
	public Background bg;
	public static int gravity = 0;
	public Boulder test_boulder;
	
	public static void init() {
		try {
			character = ImageIO.read(new File("res/filler character.png"));
			boulder = ImageIO.read(new File("res/filler boulder.png"));
			background = ImageIO.read(new File("res/filler background image.png"));
			button = ImageIO.read(new File("res/filler button.png"));
			levels = ImageIO.read(new File("res/filler level.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Failed to import resources!");
			System.exit(-1);
		}
	}
	
	public Game() {
		init();
		main_dude = new Character();
		bg = new Background();
		test_boulder = new Boulder();
	}
	
	public void update() {
		bg.action();
		main_dude.action();
		test_boulder.action();
	}
	
	public void draw(Graphics g) {
		g.fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
		bg.draw(g);
		main_dude.draw(g);
		main_dude.action();
		test_boulder.draw(g);
	}
	
	public void draw() {
		Main.frame.getGraphics().fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
		main_dude.draw(Main.frame.getGraphics());
		test_boulder.draw(Main.frame.getGraphics());
	}
	
	public void start() {
		long now = System.nanoTime();
		long prev = System.nanoTime();
		while (true) {
			now = System.nanoTime();
			if (now - prev >= DELTA) {
				update();
				Main.bootleg_canvas.repaint();
				prev = System.nanoTime();
			}
		}
	}
}
