import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	
	public static final int GAME_WIDTH = 600;
	public static final int GAME_HEIGHT = 1000;
	
	public static JFrame frame;
	
	public static void main(String[] args) {
		frame = new JFrame("some java game lol");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		frame.pack();
		frame.setVisible(true);
		Game g = new Game();
		g.start();
	}
	
}