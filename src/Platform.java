import java.awt.Graphics;

public class Platform extends GameObject {
	public Platform() {
		img = Game.platform;
		y = Main.GAME_HEIGHT;
	}
	
	@Override
	public void action() {
		y += Game.gravity;
		if(y <= 0) { //when reach top
			y = Main.GAME_HEIGHT; //reset back to bottom
		}
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		
	}
}
