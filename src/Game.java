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
								platform,
								button,
								character
								;
	
	public static Character main_dude;
	public static Background bg;
	public static int gravity = 0;
	
	public static Boulder[] boulders;
	public static Platform[] platforms;
	
	public static void init() {
		try {
			character = ImageIO.read(new File("res/filler character.png"));
			boulder = ImageIO.read(new File("res/filler boulder.png"));
			background = ImageIO.read(new File("res/filler background image.png"));
			button = ImageIO.read(new File("res/filler button.png"));
			platform = ImageIO.read(new File("res/filler platform.png"));
			boulders = new Boulder[10];
			platforms = new Platform[10];
			for (int a = 0; a < boulders.length; a++) {
				boulders[a] = new Boulder();
				boulders[a].y += 78*a;
				platforms[a] = new Platform();
				platforms[a].y += 78*a;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Failed to import resources!");
			System.exit(-1);
		}
	}
	
	public Game() {
		init();
		main_dude = new Character();
		Main.frame.addKeyListener(main_dude);
		bg = new Background();

	}
	
	public void update() {
		if (gravity < -12) {
			gravity = 0;
			main_dude.jump = false;
		} else if (gravity != 0) gravity--;
		bg.action();
		main_dude.action();

		for (Boulder b: boulders) b.action();
		for (Platform p: platforms) p.action();
	}
	
	public void draw(Graphics g) {
		g.fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
		bg.draw(g);
		main_dude.draw(g);

		for (Boulder b: boulders) b.draw(g);
		for (Platform p: platforms) p.draw(g);
	}
	
	public void draw() {
		Main.frame.getGraphics().fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
		main_dude.draw(Main.frame.getGraphics());

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
