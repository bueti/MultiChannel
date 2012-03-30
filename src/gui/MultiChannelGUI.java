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

public class MultiChannelGUI {

	private JFrame frame;
	private IGUIHandler guiHandler;


	/**
	 * Create the application.
	 */
	public MultiChannelGUI() {
		GUIHandler handler = new GUIHandler();
		guiHandler = (IGUIHandler)handler;
		initialize();

		this.frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
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

		JTextField tFReciever = new JTextField();
		frame.getContentPane().add(tFReciever, "4, 2, 25, 1, fill, default");
		tFReciever.setColumns(10);

		final JCheckBox checkBox = new JCheckBox("Reminder: ");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Kalender");

			}
		});
		checkBox.setHorizontalTextPosition(SwingConstants.LEADING);
		frame.getContentPane().add(checkBox, "30, 2, center, default");

		frame.getContentPane().add(datePicker(null, new Date()), "30, 10, 1, 1, fill, default");

		JLabel lblBetreff = new JLabel("Betreff:");
		frame.getContentPane().add(lblBetreff, "2, 4");

		JTextField tFSubject = new JTextField();
		frame.getContentPane().add(tFSubject, "4, 4, 23, 1, fill, default");
		tFSubject.setColumns(10);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Email", "Sms", "Mms", "Print"}));
		frame.getContentPane().add(comboBox, "30, 4, fill, default");

		JLabel lblMessage = new JLabel("Nachricht:");
		frame.getContentPane().add(lblMessage, "2, 6");

		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea, "2, 8, 27, 5, fill, fill");

		JButton button = new JButton("Abschicken");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String selectedItem = (String)comboBox.getSelectedItem();

				guiHandler.sendMessage("bla","bla", selectedItem);

			}
		});
		frame.getContentPane().add(button, "30, 12, fill, fill");
	}

	/*
	 * Hübscher Date Picker
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
		datePanel.add(dateChooser);

		SpinnerModel model = new SpinnerDateModel();
		JSpinner timeSpinner = new JSpinner(model);
		JComponent editor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(editor);
		if(value != null) {
			timeSpinner.setValue(value);
		}

		datePanel.add(timeSpinner);

		return datePanel;
	}
}
