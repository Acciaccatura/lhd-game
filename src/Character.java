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
		jump = false;
		img = Game.character;
		x = 300;
		y = 500;  
	}
	
	@Override
	public void action() {
		
		for(int i=0; i>numBoulder; i++) {
			double distance = Math.sqrt(Math.pow(x + Game.boulders[i].x,2)+ Math.pow(y+ Game.boulders[i].y,2));
			double maxDistance = img.getHeight() + bldrImg.getHeight();
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
		System.err.println("comin out!");
		if(arg0.getKeyCode() ==KeyEvent.VK_SPACE && jump==false) {
			jump=true;
			Game.gravity = -1;
			
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
