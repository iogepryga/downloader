package downloader.ui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import downloader.fc.Downloader;

public class DelDownloadAction extends AbstractAction {

	Download download;
	Downloader downloader;
	JPanel downloadlist;

	public DelDownloadAction(JPanel downloadlist, Download download, Downloader downloader) {
		this.download = download;
		this.downloader = downloader;
		this.downloadlist = downloadlist;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		downloader.cancel(enabled);
		downloadlist.remove(download);
		downloadlist.revalidate();
		downloadlist.repaint();
	}

}
