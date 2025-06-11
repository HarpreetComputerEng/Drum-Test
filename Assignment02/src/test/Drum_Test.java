package test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import graphicalInterface.DrumPanel;
import java.awt.Container;
import java.awt.Dimension;

/**
 * Test various types of drums and our Graphical Framework.
 */
public class Drum_Test		{

	/**
	 * Main entry point/launcher for this GUI Application test.
	 * @param args	Command line argument list (not used)
	 */
	public static void main(String[] args) {
		initLookAndFeel();

		/*	Schedule a job for the event dispatch thread:
		 * creating and showing this application's GUI.
		 */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(new DrumPanel());
			}
		});

    }
	
	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event dispatch thread.
	 */
	private static void createAndShowGUI(JPanel mainPanel) {
		/* Create and set up the window. */
		JFrame frame = new JFrame("Drum Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 350);
		frame.setPreferredSize(new Dimension(575, 600));
		frame.setMaximumSize(new Dimension(575, 600));
		Container c = frame.getContentPane();
		c.add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}

	
	/**
	 * Set the look and feel for this GUI app.
	 */
	private static void initLookAndFeel() {
		try {
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
			UIManager.setLookAndFeel(new MetalLookAndFeel());
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
		
		/* Turn off metal's use bold fonts */
//		UIManager.put("swing.boldMetal", Boolean.FALSE);

	
	}

}
