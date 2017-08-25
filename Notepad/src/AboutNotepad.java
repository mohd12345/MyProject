
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class AboutNotepad extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					AboutNotepad frame = new AboutNotepad();
					frame.setVisible(true);
	}

	public AboutNotepad() {
		this.setResizable(false);
	this.setSize(450, 300);
	this.getContentPane().setLayout(null);
	this.setLocationRelativeTo(null);
		JLabel lblnotepadIsA = new JLabel("<html>Notepad is a text editor and source code editor for use with Microsoft Windows. It supports tabbed editing, which allows working with multiple open files in a single window. The project's name comes from the C increment operator.Notepad is distributed as free software. At first the project was hosted on SourceForge.net, from where it has been downloaded over 28 million times, and twice won the SourceForge Community Choice Award for Best Developer Tool.The project was hosted on TuxFamily (fr) from 2010 to 2015.</html>");
		lblnotepadIsA.setFont(new Font("Lucida Handwriting", Font.PLAIN, 11));
		lblnotepadIsA.setHorizontalAlignment(SwingConstants.LEFT);
		lblnotepadIsA.setVerticalAlignment(SwingConstants.TOP);
		lblnotepadIsA.setBounds(10, 11, 316, 197);
		this.getContentPane().add(lblnotepadIsA);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AboutNotepad.class.getResource("Aazam 1.jpg")));
		lblNewLabel.setBounds(336, 11, 85, 115);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mohd Aazam");
		lblNewLabel_1.setFont(new Font("Broadway", Font.BOLD, 11));
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(328, 137, 96, 14);
		this.getContentPane().add(lblNewLabel_1);
	}
}
