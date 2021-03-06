package com.bm.jeu;


import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.bm.jeu.MapFrame;

public class Launcher extends JFrame {
	static Timer launcherDisplaySequence;
	static Launcher launcher;
	static MapFrame mapWindow;
	
	// DEBUG VARIABLES
	static int SKIP_LAUNCHER_SPLASH = 0;
	static int SHOW_LAUNCH_TRACE = 0;

	Launcher()
	{
		setSize(500,300);
		setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		JLabel version = new JLabel("Version 0.1");
		version.setBounds(230, 30, 30, 30);
		add(version);
	}

	public static void main(String args[]) throws MalformedURLException
	{
		// Uncomment this line to skip the 5 second splash screen.
		SKIP_LAUNCHER_SPLASH = 1;
		
		launcher = new Launcher();
		mapWindow = new MapFrame();
		
		if(SKIP_LAUNCHER_SPLASH == 0)
		{
			// Timer sequence
			launcher.setVisible(true);
			launcherDisplaySequence = new Timer();
			ShowGame taskShowGame = new ShowGame();
	
			launcherDisplaySequence.schedule(taskShowGame, 5000);
		}
		else
		{
			mapWindow.setVisible(true);
		}
	}
	
	static class ShowGame extends TimerTask
	{
		@Override
		public void run() {
			launcher.setVisible(false);
			mapWindow.setVisible(true);
		}
	}
}
