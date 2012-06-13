/**
 * This package contains all GUI classes for the application MultiChannel
 */
package ch.zhaw.multichannel.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The MultiChannelLogMonitor class is used to show log-messages include error-messages.
 *
 * @author  Benjamin Buetikofer, Roland Hofer
 * @version 1.0
 */

public class MultiChannelLogMonitor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel label;
	private JTextArea area;
	private JScrollPane scrollbar;
	private static MultiChannelLogMonitor _instance = null;

    public static MultiChannelLogMonitor getInstance() {
        if (_instance == null) {
            _instance = new MultiChannelLogMonitor();
        }
        return _instance;
    }

    /**
	 * Constructor MultiChannelLogMonitor
	 * starts the frame of MultiChannelLogMonitor
	 */
	private MultiChannelLogMonitor() {
		logMonitor();
	}
	
	/**
	 * Initialises the contents of the frame
	 * 
	 */
	private void logMonitor() {
		frame = new JFrame("MultiChannel-LogMonitor");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(500, 250);
		frame.getContentPane().setLayout(new BorderLayout());
		label = new JLabel("Multi-Channel Log-Einträge");
		area = new JTextArea();
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setBackground(Color.WHITE);
		area.setFont(new Font("SansSerif", Font.PLAIN, 12));
		area.setEditable(false);
		scrollbar = new JScrollPane();
		scrollbar.getViewport().setView(area);
		scrollbar.getViewport().add(area, null);
		frame.getContentPane().add(label, BorderLayout.NORTH);
		frame.getContentPane().add(scrollbar, BorderLayout.CENTER);
		setPosition(frame);
		frame.setVisible(true);
	}
	
	public void setPosition(JFrame frame) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - frame.getWidth();
        int y = (int) rect.getMaxY() - frame.getHeight();
        frame.setLocation(x, y);
	}
	
	/**
	 * Writes down the text parameter in the log window
	 * 
	 * @param text text to write
	 * @param status used to identify the type of the log message
	 * 
	 */
	public void logInformation(String text,int status){
		this.area.append(String.format("%td.%<tm.%<tY, %<tT", new Date())+" "+text+"\n");
		this.area.append("---------------"+"\n");
		System.out.println(String.format("%td.%<tm.%<tY, %<tT", new Date())+" "+text+"\n");
	}
	
	/**
	 * Writes down an exception to the log window
	 * 
	 * @param exception exception to log
	 * 
	 */
	public void logException(Exception exception){
		this.area.append(String.format("%td.%<tm.%<tY, %<tT", new Date())+" "+exception.getMessage()+"\n");
		this.area.append("---------------"+"\n");
		System.out.println(String.format("%td.%<tm.%<tY, %<tT", new Date())+" "+exception.getMessage()+"\n");
	}

}
