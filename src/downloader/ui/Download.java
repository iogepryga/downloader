package downloader.ui;

import javax.swing.JProgressBar;
import downloader.fc.Downloader;

public class Download extends JProgressBar {

	Downloader downloader;
	Thread thread;
	PCListener pcl;

	public Download(String url) {
		this.setMinimum(0);
		this.setMaximum(100);
		this.setStringPainted(true);
		downloader = new Downloader(url);
		pcl = new PCListener(downloader, this);
		downloader.addPropertyChangeListener(pcl);
		downloader.execute();
	}
}
