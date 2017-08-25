import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import jaco.mp3.player.MP3Player;

public class Board extends JPanel {
	Plane plane;
	Timer timer;
	int planeDelay =10;
	Enemy enemy;
	Missile missile;
	int countKillEnemy=0;
	MP3Player song;
	ArrayList<Enemy> enemyList = new ArrayList<>();
	ArrayList<Missile> missilesList = new ArrayList<>();
	
	public void prepaireEnemy(){
		int enemyPosition[][] = {
				{570,30},{870,90},{680,130},{1290,230},{1200,50},
				{1500,130},{720,430},{860,330},{1200,100},{1320,250},
				{770,109},{600,500},{1400,330},{1000,100},{890,230},
				{900,450},{1250,230},{670,330},{1500,440},{1100,130}
		};
		for(int i=0;i<enemyPosition.length;i++){
			enemyList.add(new Enemy(enemyPosition[i][0], enemyPosition[i][1]));
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D twod = (Graphics2D) g;
		if(enemyList.size()>0){
		twod.drawString("Enemy Left : "+enemyList.size(), 0, 10);
		twod.drawString("Enemy Kill : "+countKillEnemy, 500, 10);		
		twod.drawImage(new ImageIcon(Board.class.getResource("sky.gif")).getImage(), 0, 0, this);

		for(int i=0;i<enemyList.size();i++){
			enemy =  (Enemy)enemyList.get(i);
			if(enemy.isVisible()){
				enemy.move();
				twod.drawImage(enemy.getImage(), enemy.getVelX(), enemy.getVelY(), this);
			}
			if(plane.getPlaneRec().intersects(enemy.getEnemyRec())){
			enemyList.removeAll(enemyList);					
			twod.drawImage(new ImageIcon(Board.class.getResource("game.gif")).getImage(), 0, 0, this);
			timer.stop();
			song.stop();
			}
		}
			for(int j=0;j<missilesList.size();j++)
			{
				missile = (Missile)missilesList.get(j);
				if(missile.isVisible()){
					missile.move();
					twod.drawImage(missile.getImage(),missile.getX(),missile.getY(), this);
			 	}
				if(missile.getX()>=GameLauncher.BOARD_WIDTH){
					missilesList.remove(j);
				}
				for(int i=0;i<enemyList.size();i++)
				{
				enemy = enemyList.get(i);
				if(enemy.getEnemyRec().intersects(missile.getMissileRec())){
				
					enemyList.remove(i);
					missilesList.remove(j);
					enemy.setVisible(false);
					enemy.setVisible(false);
					countKillEnemy++;					
				}
			
			}	
	}		
		if(plane.isVisible()){
		twod.drawImage(plane.getImage(), plane.getX(), plane.getY(),this);
	}				
}
		else if(enemyList.size()<=0){
			twod.drawImage(new ImageIcon(Board.class.getResource("game.gif")).getImage(), 0, 0, this);
			timer.stop();
			song.stop();
		}
		
	}	
	public Board() {
		song = new MP3Player(Board.class.getResource("A.mp3"));
        song.play();
		this.setFocusable(true);
		setBounds(0, 0, GameLauncher.BOARD_WIDTH, GameLauncher.BOARD_HEIGHT);
		this.setBackground(Color.blue);
		plane = new Plane();
		
		timer = new Timer(planeDelay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				plane.move();
				repaint();	
			}
		});
		timer.start();
		this.addKeyListener(new KeyAdapter() {	
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_SPACE){
					missilesList.add(new Missile(plane.getX()+25, plane.getY()));
                    
				}
				plane.planeMove(e);
			}
			@Override
			 public void keyReleased(KeyEvent e) {
				plane.dontMove();
			}
		});
	prepaireEnemy();
	}	
}
