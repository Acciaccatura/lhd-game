import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameObject {
	
	public BufferedImage img;
	public int x, y;
	
	public GameObject(BufferedImage img, int x, int y) {
		this.img = img;
		this.x = x;
		this.y = y;
	}
	
	public void action() {
		x += 1;
		y += 2;
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}

}
