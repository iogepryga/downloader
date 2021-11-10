package downloader.ui;

import java.awt.event.ActionEvent;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

import downloader.fc.Downloader;

public class PlayPauseDownloadAction extends AbstractAction {

	Downloader downloader;
	JPanel downloadlist;
	JButton button;
	ReentrantLock lock;
	
	boolean ispaused;

	public PlayPauseDownloadAction(JPanel downloadlist, JButton button, Downloader downloader){
		super("||");
		this.downloader = downloader;
		this.downloadlist = downloadlist;
		this.button = button;
		ispaused = false;
		this.lock = downloader.getLock();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(ispaused)
			play();
		else
			pause();	
		downloadlist.repaint();
	}
	
	public void play() {
		button.setText("||");
		ispaused = false;
		lock.unlock();
		downloader.play();
	}
	
	public void pause() {
		button.setText(">");
		ispaused = true;
		lock.lock();
		downloader.pause();
	}

}
