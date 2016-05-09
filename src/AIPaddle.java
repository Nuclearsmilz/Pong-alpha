import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AIPaddle {
 //global variables
  int x; //horizontal (left, right)
  int y; //vertical (up, down)
  int width = 15; //how wide it is
  int height = 70;//how long the paddle is
  double speed = 1;
  
  boolean up = false;
  boolean down = false;

  Rectangle boundingBox;
  
  public AIPaddle(int x, int y){
   this.x = x;
   this.y = y;
   
   boundingBox = new Rectangle(x, y, width, height);
   boundingBox.setBounds(x, y, width, height);
  }
  
  public void tick(PongAlpha pa) {
   boundingBox.setBounds(x, y, width, height);
   
   if(PongAlpha.ball.y < y && y >= 0){
    //y is equal to (=) y minus (-) speed 
    y -= speed;
    //y--;
   }
   else if(PongAlpha.ball.y > y && y + height <= pa.getHeight()){
    //y is equal to (=) y plus (+) speed 
    y += speed;
    //y++;
   }
  }
  
  public void paint(Graphics g){
   g.setColor(Color.PINK);
   g.fillRect(x, y, width, height);
  }
  
  public static void main(String[] args) {

  }
}
