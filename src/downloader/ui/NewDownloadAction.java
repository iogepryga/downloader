package downloader.ui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewDownloadAction extends AbstractAction{
	JPanel panel;
	JTextField textfield;
	
	public NewDownloadAction(JPanel panel, JTextField textfield) {
		super("Add");
		this.panel = panel;
		this.textfield = textfield;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel.add(new Download(textfield.getText()));
		panel.revalidate();
	}

}
