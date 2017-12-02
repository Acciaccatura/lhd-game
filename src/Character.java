import java.awt.Graphics;

public class Character extends GameObject {

	public Character() {
		img = Game.character;
		x = 60;
		y = 60;
	}
	
	@Override
	public void action() {
		x++;
		y+=2;
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}

}
