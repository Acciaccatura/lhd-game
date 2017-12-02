import java.awt.Graphics;

public class Background extends GameObject {
	
	public Background() {
		img = Game.background;
		x = 0;
		y = 0;
	}

	@Override
	public void action() {
		y += Game.gravity;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		g.drawImage(img, x, y+Main.GAME_HEIGHT, null);
		if (y <= -Main.GAME_HEIGHT) y = 0;
		
	}
	
}
