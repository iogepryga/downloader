package downloader.ui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
	Main(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Download download = new Download("http://iihm.imag.fr/index.html");
		add(download);

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
