package downloader.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoundedRangeModel;

import downloader.fc.Downloader;

public class PCListener implements PropertyChangeListener {

	Download download;
	Downloader downloader;

	public PCListener(Downloader downloader, Download download) {
		this.downloader = downloader;
		this.download = download;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		download.setValue(downloader.getProgress());
		download.setString(downloader.getProgress() + " %");
	}

}
