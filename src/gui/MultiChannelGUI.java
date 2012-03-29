package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import core.GUIHandler;
import core.IGUIHandler;

public class MultiChannelGUI {

	private JFrame frame;
	private IGUIHandler guiHandler;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiChannelGUI window = new MultiChannelGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

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
				FormFactory.DEFAULT_COLSPEC,
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

		//		JLabel lblReminder = new JLabel("Reminder:");
		//		frame.getContentPane().add(lblReminder, "30, 2");

		final JCheckBox checkBox = new JCheckBox("Reminder: ");
		checkBox.setHorizontalTextPosition(SwingConstants.LEADING);
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkBox.isSelected()) {
					System.out.println("Gib Kalender!");
				}
			}
		});
		frame.getContentPane().add(checkBox, "30, 2, center, default");

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

}
