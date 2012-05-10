import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DecryptAction implements ActionListener{
	protected JTextField inputPath;
	protected JTextField outputPath;
	protected JPasswordField passwordField;
	protected JFrame frame;
	
	public DecryptAction(JTextField inputPath, JTextField outputPath, JPasswordField passwordField, JFrame frame) {
		this.inputPath = inputPath;
		this.outputPath = outputPath;
		this.passwordField = passwordField;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String password = passwordField.getText().trim();
		if (password.trim().equals("") || inputPath.getText().trim().equals("") || outputPath.getText().trim().equals("")) {
			String message = "The following fields are empty: ";
			if (inputPath.getText().trim().equals("")) message += "Input Path; ";
			if (outputPath.getText().trim().equals("")) message += "Output Path; ";
			if (password.trim().equals("")) message += "Password;  ";
			JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
			passwordField.setText(null);
			return;
		}
		
		try {
		new encryptFile().decrypt(password, inputPath.getText().trim(), outputPath.getText().trim());
		JOptionPane.showMessageDialog(frame, "The File Decryption Was Successful!!!", "Success!!", JOptionPane.DEFAULT_OPTION);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, e1.getMessage().toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		passwordField.setText(null);
		
	}

}
