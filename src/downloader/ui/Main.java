package downloader.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
	Main(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel downloadlistpanel = new JPanel(new StackLayout());
		Download download = new Download(downloadlistpanel,"http://iihm.imag.fr/index.html");
		downloadlistpanel.add(download);

		JTextField textfield = new JTextField();
		JButton addbutton = new JButton();
		NewDownloadAction newdlaction = new NewDownloadAction(downloadlistpanel, textfield);
		addbutton.setAction(newdlaction);
		JToolBar toolbar = new JToolBar();
		toolbar.add(textfield);
		toolbar.add(addbutton);

		setLayout(new BorderLayout());
		add(downloadlistpanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.SOUTH);

		pack();
	}

	public static void main(String[] argv) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main("Downloader").setVisible(true);
			}
		});
	}
}
