import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import javafx.scene.input.KeyCode;

public class Plane {
 
	private int x;
	private int y;
	private int height;
	private int width;
	private boolean isVisible = false;
	private Image image;
	int velX = 0;
	int velY = 0;
	
	public Plane() {
		this.x = 50;
		this.y = 50;
		this.image = new ImageIcon(Plane.class.getResource("Helicopter.gif")).getImage();
	    this.height = image.getHeight(null);
	    this.width = image.getWidth(null);
	    this.isVisible = true;
	}
	
	public Rectangle getPlaneRec(){
		return new Rectangle(x-40, y, width, height);
	}
	
	public void dontMove(){
		velX = 0;
		velY = 0;
	}
	
	public void planeMove(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_UP){
			if(y<=5){
				velY=0; 
			}else{
			velY=-2;
		}
	}
		else
			if(e.getKeyCode()==KeyEvent.VK_DOWN){
				if(y>=GameLauncher.BOARD_HEIGHT-100){
					velY=0;
				}
				else{
	        		velY=2;
	   	}
	}
			else
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					if(x<=5){
						velX=0;
					}
					else{
					velX=-2;
				}
			}
				else
					if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					if(x>=GameLauncher.BOARD_WIDTH-width){
						velX=0;
					}
					else{
						velX=2;
				}
			}
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	} 
  
	public void move(){
		x = x + velX;
		y = y + velY;
	}
   
}
