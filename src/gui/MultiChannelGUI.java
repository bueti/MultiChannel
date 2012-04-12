package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;

import core.GUIHandler;
import core.IGUIHandler;
import exceptions.EmptyRecipientException;
import exceptions.EmptySubjectAndMessageException;

public class MultiChannelGUI {

	/**
	 * Instanzvariablen
	 */
	private JFrame frame;
	private IGUIHandler guiHandler;
	private JComboBox comboBox;
	private JTextField tFRecipient;
	private JTextField tFSubject;
	private JTextArea messageBody;
	private String selectedItem;

	/**
	 * Konstruktor
	 */
	public MultiChannelGUI() {
		GUIHandler handler = new GUIHandler();
		guiHandler = (IGUIHandler)handler;
		
		this.initialize();

		this.frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 * TODO: Ersetzen durch Standard Swing Bibliothek ?
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 526, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.MIN_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.MIN_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.MIN_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.MIN_COLSPEC,},
				new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(70dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.MIN_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		JLabel lblReciever = new JLabel("Empfänger:");
		frame.getContentPane().add(lblReciever, "2, 2");

		tFRecipient = new JTextField();
		frame.getContentPane().add(tFRecipient, "4, 2, 25, 1, fill, default");
		tFRecipient.setColumns(10);

		final JCheckBox checkBox = new JCheckBox("Reminder: ");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Kalender");

			}
		});
		checkBox.setHorizontalTextPosition(SwingConstants.LEADING);
		frame.getContentPane().add(checkBox, "30, 2, center, default");

		frame.getContentPane().add(datePicker(null, new Date()), "30, 10, 1, 1, fill, default");

		JLabel lblSubject = new JLabel("Betreff:");
		frame.getContentPane().add(lblSubject, "2, 4");

		tFSubject = new JTextField();
		frame.getContentPane().add(tFSubject, "4, 4, 23, 1, fill, default");
		tFSubject.setColumns(10);

		comboBox = new JComboBox();
		// TODO: Automatische Generierung der ComboBox - Typen Liste
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Email", "Sms", "Mms", "Print"}));
		frame.getContentPane().add(comboBox, "30, 4, fill, default");

		JLabel lblMessage = new JLabel("Nachricht:");
		frame.getContentPane().add(lblMessage, "2, 6");

		messageBody = new JTextArea();
		frame.getContentPane().add(messageBody, "2, 8, 27, 5, fill, fill");

		JButton button = new JButton("Abschicken");
		button.addActionListener(new SendActionListener());

		frame.getContentPane().add(button, "30, 12, fill, fill");
	}

	/*
	 * Hübscher Date Picker
	 * TODO: Ersetzen durch Standard Java Bibliothek ?
	 */
	private JPanel datePicker(String label, Date value) {
		JPanel datePanel = new JPanel();
		JDateChooser dateChooser = new JDateChooser();
		if (value != null) {
			dateChooser.setDate(value);
		}
		for (Component comp : dateChooser.getComponents()) {
			if (comp instanceof JTextField) {
				((JTextField) comp).setColumns(50);
				((JTextField) comp).setEditable(false);
			}
		}
		

		SpinnerModel model = new SpinnerDateModel();
		JSpinner timeSpinner = new JSpinner(model);
		JComponent editor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(editor);
		if(value != null) {
			timeSpinner.setValue(value);
		}

		datePanel.add(timeSpinner);
		datePanel.add(dateChooser);
		
		return datePanel;
	}
	
	/*
	 * ActionListeners
	 */
	private class SendActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			// ClassNotFoundException, InstantiationException, IllegalAccessException;
			try {
				selectedItem = (String)comboBox.getSelectedItem();
				guiHandler.sendMessage(tFRecipient.getText(), tFSubject.getText(), messageBody.getText(),  selectedItem);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(frame, "Der Nachricht Typ \"" + selectedItem + "\" ist nicht verfügbar!", null,
						JOptionPane.ERROR_MESSAGE);
			} catch (InstantiationException e) {
				JOptionPane.showMessageDialog(frame, "Konnte Objekt nicht instatieren!", null,
						JOptionPane.ERROR_MESSAGE);
			} catch (IllegalAccessException e) {
				JOptionPane.showMessageDialog(frame, "Konnte nicht auf's Objekt zugreifen!", null,
						JOptionPane.ERROR_MESSAGE);
			} catch (EmptyRecipientException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(frame, "Kein Empfänger angegeben!", null,
						JOptionPane.ERROR_MESSAGE);
			} catch (EmptySubjectAndMessageException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(frame, "Kein Betrefft und keine Nachricht angegeben", null,
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
