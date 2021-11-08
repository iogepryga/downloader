package downloader.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import downloader.fc.Downloader;

public class Download extends JPanel {

	Downloader downloader;
	JProgressBar progressbar;
	JButton delbutton;
	JLabel urllabel;
	JPanel left;
	JPanel right;
	JPanel parent;

	public Download(JPanel parent, String url) {
		this.parent = parent;
		urllabel = new JLabel(url);
		progressbar = new JProgressBar(0, 100);
		progressbar.setStringPainted(true);
		downloader = new Downloader(url);
		downloader.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				progressbar.setValue(downloader.getProgress());
				progressbar.setString(downloader.getProgress() + " %");
//				if (downloader.getProgress() == 100)
//					progressbar.setString("Done !");
			}
		});

		left = new JPanel(new BorderLayout());
		left.add(urllabel, BorderLayout.NORTH);
		left.add(progressbar, BorderLayout.SOUTH);
		right = new JPanel();
		delbutton = new JButton();
		delbutton.setAction(new DelDownloadAction(parent, this, downloader));
		delbutton.setText("X");
		right.add(delbutton);

		add(left, BorderLayout.CENTER);
		add(right, BorderLayout.LINE_END);

		downloader.execute();
	}
}
