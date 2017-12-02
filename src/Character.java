import java.awt.Graphics;
import java.awt.event;

public class Character extends GameObject {

	public Character() {
		img = Game.character;
		x = 300;
		y = 500;
	}
	
	@Override
	public void action() {
		keyPressed(VK_SPACE);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			y+=10;
		}
	}

}
