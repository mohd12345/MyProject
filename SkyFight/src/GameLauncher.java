
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameLauncher extends JFrame {

	private JPanel contentPane;
    static final int BOARD_HEIGHT=600;
    static final int BOARD_WIDTH=600;
	public static void main(String[] args) {		
					GameLauncher frame = new GameLauncher();
					frame.setVisible(true);				
	}
	public GameLauncher() {		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				askForClose();
				
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		this.setLocationRelativeTo(null);
		Board board = new Board();
		this.getContentPane().setLayout(null);
		this.getContentPane().add(board);
	}
 public void askForClose(){
	 int coice = JOptionPane.showConfirmDialog(this, "Do You want to close", "Game One", JOptionPane.YES_NO_OPTION);
     if(coice==JOptionPane.YES_OPTION){
    	 this.dispose();
    	 this.setVisible(false);
     }
     if(coice == JOptionPane.NO_OPTION) {
    	 return;
     }
 }
}
