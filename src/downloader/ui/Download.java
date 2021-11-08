package downloader.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;
import downloader.fc.Downloader;

public class Download extends JProgressBar {

	Downloader downloader;

	public Download(String url) {
		this.setMinimum(0);
		this.setMaximum(100);
		this.setStringPainted(true);
		downloader = new Downloader(url);
		downloader.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				setValue(downloader.getProgress());
				setString(downloader.getProgress() + " %");
			}
		});
		downloader.execute();
	}
}
