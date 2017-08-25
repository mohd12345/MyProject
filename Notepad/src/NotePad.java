import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import com.ozten.font.JFontChooser;
import java.awt.Color;

public class NotePad extends JFrame {

	private JPanel contentPane;
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane();
    UndoManager undoManager = new UndoManager();
	
	private void OpenFile() throws IOException{
		String path = "E:\\aazam";
		 
		JFileChooser showDialog = new JFileChooser(path);
		showDialog.showOpenDialog(this);
		File file = showDialog.getSelectedFile();
		String filepath = file.getPath();
	 
		textArea.setText(FileOperation.readFile(filepath));
   
	}
	private void SaveFile() throws IOException{
		String path = "E:\\aazam";
		JFileChooser showDialog = new JFileChooser(path);
		showDialog.showSaveDialog(this);
		File file = showDialog.getSelectedFile();
		String path2 = file.getPath();
        FileOperation.writeFile(textArea.getText(), path2);	
	}
	
	public static void main(String[] args) {
		
					NotePad frame = new NotePad();
					frame.setVisible(true);
				
	}

	private void resizeDisplay(){
		scrollPane.setSize(this.getWidth()-28,this.getHeight()-65);
		textArea.setSize(this.getWidth()-28,this.getHeight()-65);

	}
	public NotePad() {
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
			resizeDisplay();
			
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650,650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
	this.setJMenuBar(menuBar);
		JMenu File = new JMenu("File");
		menuBar.add(File);
		
		JMenuItem New = new JMenuItem("New       ");
		New.setIcon(new ImageIcon(NotePad.class.getResource("1491593578_Add.png")));
		New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotePad notepad = new NotePad();
				notepad.setVisible(true);
				setVisible(false);
			}
		});
		New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		File.add(New);
		
		JMenuItem Open = new JMenuItem("Open          ");
		Open.setIcon(new ImageIcon(NotePad.class.getResource("Open.png")));
		Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		Open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				OpenFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			}
		});
		
	
		File.add(Open);
		
		JMenuItem Save = new JMenuItem("Save");
		Save.setIcon(new ImageIcon(NotePad.class.getResource("save.png")));
		Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SaveFile();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		File.add(Save);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save as          ");
		mntmSaveAs.setIcon(new ImageIcon(NotePad.class.getResource("Save as.png")));
		mntmSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		File.add(mntmSaveAs);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(NotePad.class.getResource("exit.png")));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NotePad.this.dispose();
			}
		});
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mntmPrint.setIcon(new ImageIcon(NotePad.class.getResource("printer.png")));
		mntmPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob job = PrinterJob.getPrinterJob();
				job.setPrintable(null, null);
			boolean ok = job.printDialog();
			if(ok){
				try{
					job.print();
				}
				catch (PrinterException e1) {
					
				}
			}
			}
		});
		File.add(mntmPrint);
		File.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				
				undoManager.addEdit(e.getEdit());
				
			}
		});
		
		
		
		
		JMenuItem mntmUndo = new JMenuItem("Undo          ");
		mntmUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				undoManager.undo();
			}
		});
		
		mntmUndo.setIcon(new ImageIcon(NotePad.class.getResource("back.png")));
		mntmUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mnEdit.add(mntmUndo);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Redo");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				undoManager.redo();
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		mnEdit.add(mntmNewMenuItem);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	          textArea.cut();
			
			}
		});
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				textArea.copy();
			}
		});
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnEdit.add(mntmPaste);
		
		JMenuItem mntmFind = new JMenuItem("Find");
		mntmFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		       
	
			}
		});
		mntmFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mnEdit.add(mntmFind);
		
		JMenuItem mntmReplace = new JMenuItem("Replace");
		mntmReplace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.replaceSelection("askjgjk");
				System.out.println("i M");
			}
		});
		mntmReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		mnEdit.add(mntmReplace);
		
		JMenuItem mntmSelect = new JMenuItem("Select  All          ");
		mntmSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.selectAll();
			}
		});
		mntmSelect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnEdit.add(mntmSelect);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Time/Date");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				textArea.insert(new Date().toString(),textArea.getSelectionStart());
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F15, 0));
		mnEdit.add(mntmNewMenuItem_1);
		
		JMenu mnFormate = new JMenu("Format");
		menuBar.add(mnFormate);
		JMenuItem mntmFont = new JMenuItem("Font");
		mntmFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setFont(JFontChooser.showDialog(textArea));
			}
		});
		mnFormate.add(mntmFont);
		JMenuItem mntmSetPadColor = new JMenuItem("Set Pad Color          ");
		mntmSetPadColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBackgrounddialog();
			}
		});
		mnFormate.add(mntmSetPadColor);
		
		JMenuItem mntmSetTextColor = new JMenuItem("Set Text Color");
		mntmSetTextColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showForegroundColorDialog();
			}
		});
		mnFormate.add(mntmSetTextColor);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmViewHelp = new JMenuItem("View Help         ");
		mnHelp.add(mntmViewHelp);
		
		JMenuItem mntmAboutNotepad = new JMenuItem("About Notepad           ");
		mntmAboutNotepad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutNotepad ab = new AboutNotepad();
				ab.setVisible(true);
			}
		});
		mnHelp.add(mntmAboutNotepad);
		
	
		scrollPane.setBounds(6, 0, 429, 241);
		contentPane.add(scrollPane);
		textArea.setBackground(Color.WHITE);
		
	
		textArea.setFont(new Font("Consolas", Font.PLAIN, 16));
		textArea.setBounds(6, 26, 400, 241);
		scrollPane.setViewportView(textArea);
		
		
	}
	public void showBackgrounddialog(){
		JColorChooser bColorChooser = new JColorChooser();
		 JDialog bdialog = JColorChooser.createDialog(this,"set Pad Color", false, bColorChooser,new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textArea.setBackground(bColorChooser.getColor());
			}
		},null);
		 bdialog.setVisible(true);
	}
	 public void showForegroundColorDialog(){
		 
		 JColorChooser fColorChooser = new JColorChooser();
		 JDialog fdialog = JColorChooser.createDialog(this,"set Text Color", false, fColorChooser,new ActionListener() {	 
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textArea.setForeground(fColorChooser.getColor());
			}
		},null);
		 fdialog.setVisible(true);
	 }
}