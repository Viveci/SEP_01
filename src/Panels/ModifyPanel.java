package Panels;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DataBase.BookingDB;
import DataBase.RoomDB;
import Model.Booking;
import Model.Date;
import Model.Guest;
import Model.Room;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class ModifyPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public ModifyPanel() {
		setLayout(null);
		setBounds(100, 100, 770, 300);
		
		JLabel lblNewLabel = new JLabel("Modify booking");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 0, 120, 24);
		add(lblNewLabel);
		
		JLabel label = new JLabel("Name of the guest");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(0, 77, 150, 14);
		add(label);
		
		textField = new JTextField();
		textField.setToolTipText("Name");
		textField.setBounds(0, 93, 150, 20);
		add(textField);
		
		JLabel label_1 = new JLabel("Address");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(0, 124, 150, 14);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Name");
		textField_1.setBounds(0, 139, 150, 20);
		add(textField_1);
		
		JLabel label_2 = new JLabel("Nationality");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(0, 170, 150, 14);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Nationality");
		textField_2.setBounds(0, 183, 150, 20);
		add(textField_2);
		
		JLabel label_3 = new JLabel("Birth date");
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		label_3.setBounds(0, 214, 150, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("From");
		label_4.setFont(new Font("Arial", Font.PLAIN, 14));
		label_4.setBounds(170, 78, 150, 14);
		add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("From");
		textField_4.setBounds(170, 93, 150, 20);
		add(textField_4);
		
		JLabel label_5 = new JLabel("To");
		label_5.setFont(new Font("Arial", Font.PLAIN, 14));
		label_5.setBounds(170, 123, 150, 14);
		add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("To");
		textField_5.setBounds(170, 138, 150, 20);
		add(textField_5);
		
		JLabel label_6 = new JLabel("Number of guests");
		label_6.setFont(new Font("Arial", Font.PLAIN, 14));
		label_6.setBounds(170, 168, 150, 15);
		add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Number of guests");
		textField_6.setBounds(170, 183, 150, 20);
		add(textField_6);
		
		JLabel lblGuest = new JLabel("Guest");
		lblGuest.setFont(new Font("Arial", Font.ITALIC, 14));
		lblGuest.setBounds(1, 40, 56, 16);
		add(lblGuest);
		
		JLabel lblBooking = new JLabel("Booking");
		lblBooking.setFont(new Font("Arial", Font.ITALIC, 14));
		lblBooking.setBounds(170, 40, 56, 16);
		add(lblBooking);
		
		JLabel lblNewLabel_1 = new JLabel("Room number");
		lblNewLabel_1.setFont(new Font("Arial", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(340, 40, 98, 16);
		add(lblNewLabel_1);
		
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		comboBox.setBounds(340, 93, 98, 20);
		add(comboBox);
		
		JLabel lblExtraServices = new JLabel("Extra services");
		lblExtraServices.setFont(new Font("Arial", Font.ITALIC, 14));
		lblExtraServices.setBounds(468, 40, 105, 16);
		add(lblExtraServices);
		
		JCheckBox chckbxRoomService = new JCheckBox("Room service");
		chckbxRoomService.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxRoomService.setBounds(468, 93, 111, 22);
		add(chckbxRoomService);
		
		JCheckBox chckbxLaundry = new JCheckBox("Laundry");
		chckbxLaundry.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxLaundry.setBounds(468, 138, 98, 22);
		add(chckbxLaundry);
		
		JCheckBox chckbxExtraBed = new JCheckBox("Extra bed");
		chckbxExtraBed.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxExtraBed.setBounds(468, 183, 98, 22);
		add(chckbxExtraBed);
		
		JCheckBox chckbxSmoking = new JCheckBox("Smoking");
		chckbxSmoking.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxSmoking.setBounds(468, 229, 92, 22);
		add(chckbxSmoking);
		
		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSaveChanges.setBounds(604, 93, 150, 20);
		add(btnSaveChanges);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new java.util.Date(1449702000000L), new java.util.Date(-2208992400000L), new java.util.Date(1449702000000L), Calendar.DAY_OF_YEAR));
		spinner.setBounds(0, 229, 150, 21);
		add(spinner);
		
	}
}