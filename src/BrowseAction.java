import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class BrowseAction implements ActionListener{
	JTextField pathField;
	JFrame frame;
	
	public BrowseAction(JTextField pathField, JFrame frame) {
		this.pathField = pathField;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*** creats a file filter**/ 
		/*FileFilter csvFilter = new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "CSV Files";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				String name = f.getName().toLowerCase();
				if (f.isDirectory()) return true;
		        return name.endsWith(".csv");
			}
		};
		fc.setFileFilter(csvFilter);*/
		
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(frame);
		pathField.setText(fc.getSelectedFile().getPath());
	}

}
