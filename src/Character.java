import java.awt.Graphics;

public class Character extends GameObject {

	public Character() {
		img = Game.character;
		x = 300;
		y = 500;
	}
	
	@Override
	public void action() {
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}

}
