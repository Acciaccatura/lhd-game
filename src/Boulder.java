import java.awt.Graphics;
import java.awt.Graphics2D;

public class Boulder extends GameObject {
    private int speed; //if negative going left; if positive going right
    private int rotate;
    
    public Boulder() {
        // initialize instance variables
    	img = Game.boulder;
    	x = 0;
        //y = Game.LevelPositionY +gravity;
        y = 0;
        
        speed = (int)(Math.random()*10) -5; //random number from [-5, 5]
        if(speed == 0) { //speed can't equal 0
        	speed = 20;
        }
    }
    
    @Override
	public void draw(Graphics g) {
    	Graphics2D g2d = (Graphics2D)g;
    	g2d.rotate(Math.toRadians(rotate), x + img.getWidth()/2, y+ img.getHeight()/2);
		g2d.drawImage(img, x, y, null);
		g2d.rotate(Math.toRadians(-rotate));
	}

	@Override
	public void action() {
		y += Game.gravity;
		if(speed > 0 && x >= Main.GAME_WIDTH) { //if going right and reached right end of screen
			x = 0; //bring boulder back to the left
		} else if(speed < 0 && x <= (-1)*img.getWidth()) { //if going left and reached left end of screen
			x = Main.GAME_WIDTH; //bring boulder back to the right
		} else {
			x += speed;
			rotate += 2;
		}
		
		if(y <= (-1)*img.getHeight()) { //reached top
			y = Main.GAME_HEIGHT; //reset back to bottom
			speed = (int)(Math.random()*10) -5; //random number from [-5, 5]
	        if(speed == 0) { //speed can't equal 0
	        	speed = 20;
	        }
		}
	}
    
    
}
