import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	public static final int GAME_WIDTH = 468;
	public static final int GAME_HEIGHT = 694;
	
	public static JFrame frame;
	public static JPanel bootleg_canvas;
	
	public static void main(String[] args) {
		Game game = new Game();
		frame = new JFrame("some java game lol");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		bootleg_canvas = new JPanel() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				game.draw(g);
			}
			
		};
		bootleg_canvas.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		frame.add(bootleg_canvas);
		frame.pack();
		frame.setVisible(true);
		game.start();
	}
	
}