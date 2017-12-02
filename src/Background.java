import java.awt.Graphics;

public class Background extends GameObject {
	
	public Background() {
		img = Game.background;
		int x = 0;
		int y = 0;
	}

	@Override
	public void action() {
		y += 2;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		g.drawImage(img, x, y+Main.GAME_HEIGHT, null);
		if (y <= -Main.GAME_HEIGHT) y = 0;
		
	}
	
}
