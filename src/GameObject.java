import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class GameObject {
	
	public BufferedImage img;
	public int x, y;
	
	public GameObject() {
		
	}
	
	public abstract void action();
	
	public abstract void draw(Graphics g);

}
