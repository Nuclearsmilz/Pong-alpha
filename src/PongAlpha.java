import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class PongAlpha extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	// global variables
	public static PlayerPaddle player;
	public static AIPaddle ai;
	public static Ball ball;
	InputHandler ih;
	
	JFrame frame; // game window (un-initialized)
	public final int WIDTH = 400; // width of the frame
	public final int HEIGHT = 300;// height of the frame (aspect ratio)
	public final Dimension gameSize = new Dimension(WIDTH, HEIGHT); // width and height within one variable
	public final String TITLE = "Pong: Alpha";
	
	//public int ScreenWidth;
	//public int ScreenHeight;
	
	BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	static boolean gameRunning = false; // if the game is running
	
	int p1Score, p2Score;

	public void run() {
		while (gameRunning){ //while gameRunning is true
			tick();
			paint();
			
			try{
				Thread.sleep(7);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void start(){
		//start the start method
		gameRunning = true;
		new Thread(this).start();
		//end the start method
	}
	public static synchronized void stop(){
		//start the stop method
		gameRunning = false;
		System.exit(0);
		//end the stop method
	}

	public PongAlpha(){
		frame = new JFrame();

		setMinimumSize(gameSize);
		setMaximumSize(gameSize);
		setPreferredSize(gameSize);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setTitle(TITLE);
		frame.setLocationRelativeTo(null);

		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		//ScreenWidth = getWidth();
		//ScreenHeight = getHeight();

		ih = new InputHandler(this);
								 //x, y
		player = new PlayerPaddle(10, 60);
	  //player = new PlayerPaddle(50, 120);
	  //ai = new AIPaddle(375, 60);
		ai = new AIPaddle(getWidth() - 25, 60);
		ball = new Ball(getWidth()/2, getHeight()/2);
	}

	public void tick(){
		player.tick(this);
		ai.tick(this);
		ball.tick(this);
	}
	
	public void paint(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.setColor(Color.WHITE);
		
		g.drawString("Player 1: " + p1Score, 0, 10);
		g.drawString("Player 2: " + p2Score, getWidth() - 60, 10);
		
		player.paint(g);
		ai.paint(g);
		ball.paint(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args){
		PongAlpha pa = new PongAlpha();
		pa.start();
	}
}
