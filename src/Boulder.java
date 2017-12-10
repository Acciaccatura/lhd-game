import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Boulder extends GameObject {
    private int speed; //if negative going left; if positive going right
    private int rotate;
    public boolean hit;
    private Random r;
    
    public Boulder() {
        // initialize instance variables
    	img = Game.boulder;
    	x = 0;
        //y = Game.LevelPositionY +gravity;
        y = 0;
        setSpeed();
    }
    
    @Override
	public void draw(Graphics g) {
    	Graphics2D g2d = (Graphics2D)g;
		AffineTransform old = g2d.getTransform();
    	g2d.rotate(Math.toRadians(rotate), x + img.getWidth()/2, y+ img.getHeight()/2);
		g2d.drawImage(img, x, y, null);
		g2d.setTransform(old);
	}

	@Override
	public void action() {
		y += Game.gravity;
		if(speed > 0 && x >= Main.GAME_WIDTH) { //if going right and reached right end of screen
			x = -img.getWidth(); //bring boulder back to the left
		} else if(speed < 0 && x <= (-1)*img.getWidth()) { //if going left and reached left end of screen
			x = Main.GAME_WIDTH; //bring boulder back to the right
		} else {
			x += speed;
			rotate += 2;
		}
		
		if(y <= (-1)*img.getHeight()) { //reached top
			y = Main.GAME_HEIGHT; //reset back to bottom
			setSpeed();
		}
		
		double distance = Math.sqrt(Math.pow(x + Game.main_dude.x,2)+ Math.pow(y+ Game.main_dude.y,2));
		double maxDistance = img.getHeight() + Game.main_dude.img.getHeight();
		if(distance > maxDistance) {
			System.err.println("hit");
			hit = true;
		}
	}
	
	//random number from [-5, 5]
	private void setSpeed() {
		speed = r.nextInt(11) - 5;
		//speed = (int)(Math.random()*11) -5;
		
        if(speed == 0) { //speed can't equal 0, 20 is any random number instead
        	speed = 20;
        }
	}
}
