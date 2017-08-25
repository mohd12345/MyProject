import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import jaco.mp3.player.MP3Player;

public class FrontPageGame extends JWindow {
	private JPanel contentPane;
	JLabel lblIcon = new JLabel("");
	JLabel lblvisible;
	Timer timer;
	boolean visible=false;
	int counter = 0;
	JProgressBar progressBar;
	MP3Player song;
	
	public void playSong(){
		song = new MP3Player(FrontPageGame.class.getResource("S.mp3"));
        song.play();	
	}
	
              public static void main(String[] args) {		
					FrontPageGame frame = new FrontPageGame();
					frame.setVisible(true);
					frame.forVisible();
                    frame.playSong();
 }
 
 public void forVisible(){
	 timer = new Timer(130, new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(counter>=101){
				GameLauncher game =new GameLauncher();
				game.setVisible(true);
				FrontPageGame.this.dispose();
				FrontPageGame.this.setVisible(false);
				timer.stop();
                song.stop();			
			}
	              lblvisible.setVisible(visible);
	              visible = !visible;
	              progressBar.setValue(counter);
	              counter++;
		}
	});
	 timer.start();
 }
 
	public FrontPageGame() {		
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setIcon(new ImageIcon(FrontPageGame.class.getResource("a.gif")));		
		lblIcon.setBounds(10, 11, 580, 525);
		getContentPane().add(lblIcon);		
		progressBar = new JProgressBar();
		progressBar.setForeground(Color.LIGHT_GRAY);
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		progressBar.setIndeterminate(true);
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 575, 580, 14);
		getContentPane().add(progressBar);		
		lblvisible = new JLabel("Start Game");
		lblvisible.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblvisible.setForeground(Color.RED);
		lblvisible.setHorizontalAlignment(SwingConstants.CENTER);
		lblvisible.setBounds(10, 543, 580, 29);
		getContentPane().add(lblvisible);
	}
}
