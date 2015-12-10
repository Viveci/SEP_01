package Panels;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JCheckBox;

public class CheckoutPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	public CheckoutPanel() {
		
		setBounds(0, 0, 770, 300);
		setLayout(null);
		
		JLabel lblCheckout = new JLabel("Check-out");
		lblCheckout.setBounds(0, 0, 140, 32);
		lblCheckout.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblCheckout);
		
		JLabel label = new JLabel("Name of the guest");
		label.setBounds(10, 70, 150, 14);
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label);
		
		textField = new JTextField();
		textField.setBounds(10, 85, 150, 20);
		textField.setToolTipText("Name");
		add(textField);
		
		JLabel lblDepartureDate = new JLabel("Departure date");
		lblDepartureDate.setBounds(10, 106, 150, 14);
		lblDepartureDate.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblDepartureDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 121, 150, 20);
		textField_1.setToolTipText("To");
		add(textField_1);
		
		JButton btnCheckout = new JButton("Check-out");
		btnCheckout.setBounds(608, 262, 150, 25);
		add(btnCheckout);
		
		JTextArea txtrPrice = new JTextArea();
		txtrPrice.setBounds(608, 85, 150, 20);
		txtrPrice.setForeground(Color.RED);
		txtrPrice.setFont(new Font("Arial", Font.BOLD, 14));
		add(txtrPrice);
		
		JLabel lblPrice = new JLabel("Total:");
		lblPrice.setBounds(608, 39, 56, 16);
		lblPrice.setFont(new Font("Arial", Font.ITALIC, 14));
		add(lblPrice);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(172, 85, 150, 20);
		add(textArea);
		
		JLabel lblRoomType = new JLabel("Room type");
		lblRoomType.setBounds(172, 70, 150, 14);
		lblRoomType.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblRoomType);
		
		JLabel lblGuestInformation = new JLabel("Guest information");
		lblGuestInformation.setBounds(10, 37, 150, 20);
		lblGuestInformation.setFont(new Font("Arial", Font.ITALIC, 14));
		add(lblGuestInformation);
		
		JLabel lblExpenses = new JLabel("Booking information");
		lblExpenses.setBounds(172, 37, 150, 20);
		lblExpenses.setFont(new Font("Arial", Font.ITALIC, 14));
		add(lblExpenses);
		
		JLabel lblNightsSpent = new JLabel("Nights spent");
		lblNightsSpent.setBounds(172, 106, 150, 14);
		lblNightsSpent.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblNightsSpent);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(174, 125, 150, 20);
		add(textArea_1);
		
		JCheckBox checkBox = new JCheckBox("Room service");
		checkBox.setBounds(172, 184, 120, 22);
		checkBox.setFont(new Font("Arial", Font.PLAIN, 14));
		add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Laundry");
		checkBox_1.setBounds(172, 211, 88, 22);
		checkBox_1.setFont(new Font("Arial", Font.PLAIN, 14));
		add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Extra bed");
		checkBox_2.setBounds(172, 238, 88, 22);
		checkBox_2.setFont(new Font("Arial", Font.PLAIN, 14));
		add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Smoking");
		checkBox_3.setBounds(172, 265, 88, 22);
		checkBox_3.setFont(new Font("Arial", Font.PLAIN, 14));
		add(checkBox_3);
		
		JLabel lblExtras = new JLabel("Extra services");
		lblExtras.setBounds(172, 155, 150, 20);
		lblExtras.setFont(new Font("Arial", Font.ITALIC, 14));
		add(lblExtras);
		
		JLabel lblPrices = new JLabel("Prices");
		lblPrices.setBounds(375, 37, 150, 20);
		lblPrices.setFont(new Font("Arial", Font.ITALIC, 14));
		add(lblPrices);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(375, 85, 150, 20);
		add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(375, 125, 150, 20);
		add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(375, 184, 150, 20);
		add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(375, 211, 150, 20);
		add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(375, 238, 150, 20);
		add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(375, 265, 150, 20);
		add(textArea_7);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(330, 95, 35, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(330, 133, 35, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(288, 196, 79, 2);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(262, 223, 101, 2);
		add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(268, 249, 95, 2);
		add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(262, 275, 101, 2);
		add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(0, 56, 770, 2);
		add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(571, 56, 2, 244);
		separator_7.setOrientation(SwingConstants.VERTICAL);
		add(separator_7);

	}
}
