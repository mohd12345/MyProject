import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missile {
	private int x ;
	private int y;
	private int height;
	private int width;
	private Image image;
	private boolean isVisible;
	
	public Missile(int x , int y){
		this.x = x; 
		this.y = y;
		this.image = new ImageIcon(Missile.class.getResource("missile.gif")).getImage();
	    this.height = image.getHeight(null);
	    this.width = image.getWidth(null);
	    this.isVisible = true;
	}
	
	public void move(){
		x =x+1;		
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
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	
	public Rectangle getMissileRec(){
		return new Rectangle(x-width+10,y,width,height);
	}
	
}
