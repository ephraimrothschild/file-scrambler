import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class uiFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pathField;
	private JTextField outputPathField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uiFrame frame = new uiFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public uiFrame() {
		setResizable(false);
		setLookAndFeel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ButtonGroup radioGroup = new ButtonGroup();
		
		JButton browseButton = new JButton("Browse");
		
		JLabel lblInputPath = new JLabel("Input Path");
		
		pathField = new JTextField();
		pathField.setColumns(10);
		
		
		
		JLabel outputPathLabel = new JLabel("Output Path");
		
		outputPathField = new JTextField();
		outputPathField.setColumns(10);
		
		JButton saveButton = new JButton("Browse");
		
		JLabel lblPassword = new JLabel("Password:");
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setToolTipText("Type your password in here");
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		JRadioButton fileRadio = new JRadioButton("File", true);
		radioGroup.add(fileRadio);
		
		fileRadio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		//setSize(getWidth(), 400);
		fileRadio.setVisible(false);
		
		JRadioButton passwordRadio = new JRadioButton("Password Hash", false);
		radioGroup.add(passwordRadio);
		passwordRadio.setVisible(false);
		
		JButton encryptButton = new JButton("Encrypt");
		
		
		JButton decryptButton = new JButton("Decrypt");
		
		JButton corruptButton = new JButton("Corrupt");
		
		JTextArea hashArea = new JTextArea();
		hashArea.setBackground(Color.LIGHT_GRAY);
		hashArea.setEnabled(false);
		hashArea.setWrapStyleWord(true);
		hashArea.setEditable(false);
		hashArea.setSize(hashArea.getWidth(), 200);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblInputPath)
					.addGap(5)
					.addComponent(pathField, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(browseButton))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(outputPathLabel)
					.addGap(5)
					.addComponent(outputPathField, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(saveButton))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblPassword)
					.addGap(17)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(179)
					.addComponent(fileRadio)
					.addGap(5)
					.addComponent(passwordRadio))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(encryptButton)
					.addGap(68)
					.addComponent(decryptButton)
					.addGap(73)
					.addComponent(corruptButton))
				.addComponent(hashArea, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblInputPath))
						.addComponent(pathField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(browseButton))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(outputPathLabel))
						.addComponent(outputPathField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(saveButton))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(lblPassword))
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(fileRadio)
						.addComponent(passwordRadio))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(encryptButton)
						.addComponent(decryptButton)
						.addComponent(corruptButton))
					.addGap(5)
					.addComponent(hashArea, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		hashArea.setVisible(false);
		pack();
		setTitle("Encrypter");
		
		BrowseAction myBrowseAction = new BrowseAction(pathField, this);
		saveAction mySaveAction = new saveAction(outputPathField, this);
		encryptAction myEncryptionAction = new encryptAction(pathField, outputPathField,
				passwordField, this);
		DecryptAction myDecryptionAction = new DecryptAction(pathField, outputPathField,
				passwordField, this);
		
		encryptButton.addActionListener(myEncryptionAction);
		saveButton.addActionListener(mySaveAction);
		browseButton.addActionListener(myBrowseAction);
		decryptButton.addActionListener(myDecryptionAction);
		//encryptButton.setVisible(false);
		//corruptButton.setVisible(false);
	}
	
	 /**
	  * {@code public void setLookAndFeel()}
	  * <p>
	  * Sets the look and feel of the window.
	  *  This Method Specifically sets it to the "Nimbus look and Feel" which is done by using the UIManager
	  *  to set the look and feel to the package: " com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" 
	  *  </p>
	  *  @return void
	  *  */
	protected void setLookAndFeel() {
		
		 try {
			 UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			 SwingUtilities.updateComponentTreeUI(this);
	     } catch (Exception e) {
	    	 try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			 System.out.println("Can't set look and feel: "
			 + e.getMessage());
			 e.printStackTrace();
		 }
	 }
}
