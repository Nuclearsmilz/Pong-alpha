import java.awt.*;

public class PlayerPaddle {
	//global variables
	int x; //horizontal (left, right)
	int y; //vertical (up, down)
	int width = 15; //how wide it is
	int height = 70;//how long the paddle is
	int speed = 2;

	boolean up = false;
	boolean down = false;

	Rectangle boundingBox;

	public PlayerPaddle(int x, int y) {
		this.x = x;
		this.y = y;

		boundingBox = new Rectangle(x, y, width, height);
		boundingBox.setBounds(x, y, width, height);
	}

	public void tick( PongAlpha pa ) {
		boundingBox.setBounds(x, y, width, height);

		if (up && y > 0) {
			//y is equal to (=) y minus (-) speed 
			y -= speed;
		} else if (down && y < pa.getHeight() - height) {
			//y is equal to (=) y plus (+) speed 
			y += speed;
		}

		//System.out.println("Y: " + y + ", ScreenHeight - height: " + (pa.getHeight() - height));//230
	}

	public void paint( Graphics g ) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	public static void main( String[] args ) {

	}
}
