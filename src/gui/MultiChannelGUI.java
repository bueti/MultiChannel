package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
import exceptions.IllegalEmailAddressException;

public class MultiChannelGUI {

	/**
	 * Instanzvariablen
	 */
	private JFrame frame;
	private JPanel schedulerPanel;
	private JPanel calendarPanel;
	private JPanel reminderPanel2;
	private IGUIHandler guiHandler;
	private JComboBox comboBox;
	private JTextField tFRecipient;
	private JTextField tFSubject;
	private JTextArea messageBody;
	private JCheckBox chckbxScheduler;
	private String selectedItem;
	private JSpinner timespinner;
	private JDateChooser dateChooser;
	private SpinnerModel model;
	private JComponent editor;
	private JPanel reminderPanel1;
	private JTextField textField;
	private JCheckBox chckbxReminder;

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
				ColumnSpec.decode("min:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.MIN_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.MIN_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(46dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("bottom:max(22dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		JLabel lblReciever = new JLabel("Empfänger:");
		frame.getContentPane().add(lblReciever, "2, 2");

		tFRecipient = new JTextField();
		frame.getContentPane().add(tFRecipient, "4, 2, 25, 1, fill, default");
		tFRecipient.setColumns(10);
		
		chckbxScheduler = new JCheckBox("Scheduler: ");
		chckbxScheduler.setToolTipText("Mark if you want to schedule this message.");
		chckbxScheduler.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxScheduler.addActionListener(new SchedulerActionListener());
		
		schedulerPanel = new JPanel();
		schedulerPanel.add(chckbxScheduler);
		schedulerPanel.setVisible(false);
		schedulerPanel.setVisible(true);
		frame.getContentPane().add(schedulerPanel, "30, 2, left, fill");

		calendarPanel = datePicker(null, new Date());
		calendarPanel.setVisible(false);
		
		chckbxReminder = new JCheckBox("Reminder: ");
		chckbxScheduler.setToolTipText("Mark if you want to recieve a reminder before this message is sent.");
		chckbxReminder.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxReminder.addActionListener(new ReminderActionListener());
		
		reminderPanel2 = new JPanel();
		reminderPanel2.add(chckbxReminder);
		reminderPanel2.setVisible(false);
		frame.getContentPane().add(reminderPanel2, "30, 4, left, fill");

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(guiHandler.getAllMessageTypes()));
		frame.getContentPane().add(comboBox, "30, 6, fill, default");
				
		frame.getContentPane().add(calendarPanel, "30, 10, fill, default");

		JLabel lblSubject = new JLabel("Betreff:");
		frame.getContentPane().add(lblSubject, "2, 4");

		tFSubject = new JTextField();
		frame.getContentPane().add(tFSubject, "4, 4, 25, 1, fill, default");
		tFSubject.setColumns(10);

		JLabel lblMessage = new JLabel("Nachricht:");
		frame.getContentPane().add(lblMessage, "2, 6");

		messageBody = new JTextArea();
		frame.getContentPane().add(messageBody, "2, 8, 27, 7, fill, fill");

		JButton button = new JButton("Abschicken");
		button.addActionListener(new SendActionListener());
		
		reminderPanel1 = new JPanel();
		frame.getContentPane().add(reminderPanel1, "30, 12, fill, fill");
		reminderPanel1.setLayout(null);
		reminderPanel1.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(64, 6, 52, 28);
		reminderPanel1.add(textField);
		textField.setColumns(10);
		
		JLabel lblMinuten = new JLabel("Minuten:");
		lblMinuten.setBounds(6, 12, 61, 16);
		reminderPanel1.add(lblMinuten);

		frame.getContentPane().add(button, "30, 14, fill, fill");
	}

	/*
	 * Date Picker
	 */
	private JPanel datePicker(String label, Date value) {
		JPanel datePanel = new JPanel();
		dateChooser = new JDateChooser();
		if (value != null) {
			dateChooser.setDate(value);
		}
		for (Component comp : dateChooser.getComponents()) {
			if (comp instanceof JTextField) {
				((JTextField) comp).setColumns(50);
				((JTextField) comp).setEditable(false);
			}
		}
		
		model = new SpinnerDateModel();
		timespinner = new JSpinner(model);
		editor = new JSpinner.DateEditor(timespinner, "HH:mm");
		timespinner.setEditor(editor);
		if(value != null) {
			timespinner.setValue(value);
		}

		datePanel.add(timespinner);
		datePanel.add(dateChooser);
		
		return datePanel;
	}
	
	/*
	 * ActionListeners
	 */
	private class SendActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			try {
				selectedItem = (String)comboBox.getSelectedItem();
				// Der Methode muss eine Liste von Recipients übergeben werden
				List<String> test = new ArrayList<String>(); //Nur zum testen
				// TODO: Multi-Split: ",", ";", etc... 
				String[] addresses = tFRecipient.getText().split("\\s+");

				for (int i = 0; i<addresses.length; i++) {
					test.add(addresses[i]);
				}
				if(!chckbxScheduler.isSelected()){	
					guiHandler.sendMessage(test, tFSubject.getText(), messageBody.getText(),  selectedItem);
				}else{
				    
					//TODO: Just for test because timepicker does not work
				    //Create instance of java.util.Date
				    java.util.Date utilDate = new Date();
				    utilDate.setTime(System.currentTimeMillis() + 120000);
				    java.util.Date utilDate2 = new Date();
				    utilDate2.setTime(System.currentTimeMillis() + 110000);
					
					guiHandler.sendMessage(test, tFSubject.getText(), messageBody.getText(), selectedItem,utilDate,utilDate2);
				}
				//TODO: Felder sollten nur gecleart werden wenn keine exception auftritt
				// Clean fields
				tFRecipient.setText("");
				tFSubject.setText("");
				messageBody.setText("");				
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(frame, "Der Nachricht Typ \"" + selectedItem + "\" ist nicht implementiert!", null,
						JOptionPane.ERROR_MESSAGE);
			} catch (InstantiationException e) {
				JOptionPane.showMessageDialog(frame, "Konnte Objekt nicht instatieren!", null,
						JOptionPane.ERROR_MESSAGE);
			} catch (IllegalAccessException e) {
				JOptionPane.showMessageDialog(frame, "Konnte nicht auf's Objekt zugreifen!", null,
						JOptionPane.ERROR_MESSAGE);
			} catch (EmptyRecipientException e) {
				JOptionPane.showMessageDialog(frame, "Kein Empfänger angegeben!", null,
						JOptionPane.ERROR_MESSAGE);
			} catch (EmptySubjectAndMessageException e) {
				JOptionPane.showMessageDialog(frame, "Kein Betrefft und keine Nachricht angegeben", null,
						JOptionPane.ERROR_MESSAGE);
			} catch (IllegalEmailAddressException e) {
				JOptionPane.showMessageDialog(frame, "Ungültige Email Adresse!", null,
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private class SchedulerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(chckbxScheduler.isSelected()) {
				calendarPanel.setVisible(true);
				reminderPanel2.setVisible(true);
			} else {
				calendarPanel.setVisible(false);
				reminderPanel2.setVisible(false);
			}
		}
	}
	private class ReminderActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(chckbxReminder.isSelected()) {
				reminderPanel1.setVisible(true);
			} else {
				reminderPanel1.setVisible(false);
			}
			
		}
	}

}
