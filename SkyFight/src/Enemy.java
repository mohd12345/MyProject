import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy {
	private int x;
	private int y;
	private int height;
	private int width;
	private boolean isVisible = false;
	private Image image;
	private int velX;
	private int velY;
	
	public Enemy(int x,int y){
	this.x = this.velX = x;
	this.y = this.velY = y;
	image = new ImageIcon(Enemy.class.getResource("EnemyImage.gif")).getImage();
	isVisible = true;
	height = image.getHeight(null);
	width = image.getWidth(null);
	}
	
	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
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
		if(velX<=0){
			velX=x;
		}
		else{
			if(velX>0)
		velX = velX - 1;
	}
	}
	public Rectangle getEnemyRec(){
		return new Rectangle(velX,velY,width,height);
	}
}
