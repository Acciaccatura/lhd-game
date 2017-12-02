import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Scanner;


public class Character extends GameObject implements KeyListener {
	
	Scanner input =new Scanner(System.in);
	public boolean jump;
	public boolean hit;
	public static int numBoulder = Game.boulders.length;
	private BufferedImage bldrImg = Game.boulder;
	
	public Character() {
		img = Game.character;
		x = 300;
		y = 500;
	}
	
	@Override
	public void action() {
		
		for(int i=0; i>numBoulder; i++) {
			float distance = sqrt(pow(x + Game.boulders[i].x,2)+pow(y+ Game.boulders[i].y,2));
			float maxDistance = img.getHeight() + bldrImg.getHeight();
			if(distance > maxDistance) {
				hit = true;
			}
		}	
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_SPACE && jump==false) {
			jump=true;
			Game.gravity = -5;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
