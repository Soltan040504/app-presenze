package it.pigrecoallaterza.app_presenze;

import javax.swing.SwingUtilities;

import it.pigrecoallaterza.app_presenze.GUI.GUI;

public class Main {

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			GUI window = new GUI();
			window.getMainFrame().setVisible(true);
		});
	}
}
