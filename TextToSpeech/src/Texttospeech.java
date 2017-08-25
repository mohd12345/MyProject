import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.io.*;
import java.util.ArrayList;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Texttospeech extends JFrame {
	
	private static final String VOICENAME = "kevin16";
	
	public static void main(String[] args) {
	
		Texttospeech frame = new Texttospeech();
		frame.setVisible(true);
		

	}

	public Texttospeech(){
	
		this.setSize(450, 300);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		JTextArea text = new JTextArea();
		text.setBounds(10, 10, 300, 240);
		this.getContentPane().add(text);
		JButton speech = new JButton("");
		speech.setBounds(335, 100, 80, 50);
		speech.setText("Speech");
		this.getContentPane().add(speech);
		speech.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				Voice voice;
				VoiceManager vm = VoiceManager.getInstance();
				voice = vm.getVoice(VOICENAME);
				voice.allocate();
				voice.speak(text.getText());				
			}
		});
		
	}
}
