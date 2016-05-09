import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
 int x, y;
 int size = 16;
 int speed = 0.2;
 int vx, vy;
 //v = velocity, s = speed
 
 Rectangle boundingBox;
 
 public Ball(int x, int y){
  this.x = x;
  this.y = y;
  
  vx = speed;
  vy = speed;
  
  boundingBox = new Rectangle(x , y, size, size);
  boundingBox.setBounds(x, y, size, size);
 }

 public void tick(PongAlpha pa){
  boundingBox.setBounds(x, y, size, size);
  
  //if top left is 0
  if(x <= 0){
   pa.p2Score++;
   vx = speed;
  }
  //if x of the ball plus the top right corner is greater 
  //than the far right of the screen
  else if(x + size >= pa.getWidth()){
   pa.p1Score++;
   vx = -speed;
  }
  //if bottom left is 0
  if(y <= 0){
   vy = speed;
  }
  //if x of the ball plus the bottom right corner is greater 
  //than the bottom of the screen
  else if(y + size >= pa.getHeight()){
   vy = -speed;
  }
  
  x += vx;
  y += vy;
 
  paddleCollide(pa);
 }
 
 private void paddleCollide(PongAlpha pa){
  if(boundingBox.intersects(PongAlpha.player.boundingBox)){
   vx = speed;
  }
  else if(boundingBox.intersects(PongAlpha.ai.boundingBox)){
   vx = -speed;
  }
 }

 public void paint(Graphics g){
  g.setColor(Color.WHITE);
  g.fillOval(x, y, size, size);
 }
}