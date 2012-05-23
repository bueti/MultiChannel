package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import core.GUIHandler;
import core.IGUIHandler;

public class MultiChannelLogMonitor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel label;
	private JTextArea area;
	private JScrollPane bildlauf;

	// Konstruktor

	public MultiChannelLogMonitor() {

		logMonitor();

	}

	private void logMonitor() {
		frame = new JFrame("MultiChannel-LogMonitor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(850, 450);
		frame.setSize(500, 250);
		frame.getContentPane().setLayout(new BorderLayout());
		label = new JLabel("Multi-Channel Log-Einträge");
		area = new JTextArea();// todo - einfüllen
		// area einrichten
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setBackground(Color.WHITE);
		area.setFont(new Font("SansSerif", Font.PLAIN, 12));
		area.setEditable(false);
		// area Bildlaufleisten
		bildlauf = new JScrollPane();
		bildlauf.getViewport().setView(area);
		bildlauf.getViewport().add(area, null);
		frame.getContentPane().add(label, BorderLayout.NORTH);
		frame.getContentPane().add(area, BorderLayout.CENTER);

		this.frame.setVisible(true);
	}

}
