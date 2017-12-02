import java.awt.Graphics;

public class Boulder extends GameObject {
    private int speed; //if negative going left; if positive going right
    
    public Boulder() {
        // initialise instance variables
    	img = Game.boulder;
        x = 0;
        //y = Game.LevelPositionY;
        
        speed = (int)(Math.random()*10) -5; //random number from [-5, 5]
        if(speed == 0) { //speed can't equal 0
        	speed = 20;
        }
    }
    
    @Override
	public void draw(Graphics g) {
    	//g.rotate(Math.toRadians(3)); cant rotate yet- need graphics 2D
		g.drawImage(img, x, y, null);
	}

	@Override
	public void action() {
		if(speed > 0 && x >= Main.GAME_WIDTH) { //if going right and reached right end of screen
			x = 0; //bring boulder back to the left
		} else if(speed < 0 && x <= 0) { //if going left and reached left end of screen
			x = Main.GAME_WIDTH; //bring boulder back to the right
		} else {
			x += speed;
		}
	}
    
    
}
