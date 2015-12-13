package Panels;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DataBase.BookingDB;
import DataBase.RoomDB;
import Model.Booking;
import Model.Date;
import Model.Extras;
import Model.Guest;
import Model.Room;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField GuestName;
	private JTextField GuestAddress;
	private JTextField GuestNationality;
	private JTextField BookingFrom;
	private JTextField BookingTo;
	private JTextField BookingNumGuest;
	private JTextField GuestBirth;
	private JComboBox<Object> RoomNum;
	
	private Extras extras;
	
	private JCheckBox chckbxRoomService;
	private JCheckBox chckbxLaundry;
	private JCheckBox chckbxExtraBed;
	private JCheckBox chckbxSmoking;
	
	private BookingDB bdb;
	private RoomDB db;
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public ModifyPanel(Booking b) {
		setLayout(null);
		setBounds(100, 100, 770, 300);
		
		bdb = new BookingDB();
		db = new RoomDB();
		
		extras = new Extras();
		
		JLabel lblNewLabel = new JLabel("Edit booking");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 0, 120, 24);
		add(lblNewLabel);
		
		JLabel label = new JLabel("Name of the guest");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(0, 77, 150, 14);
		add(label);
		
		GuestName = new JTextField();
		GuestName.setToolTipText("Name");
		GuestName.setBounds(0, 93, 150, 20);
		GuestName.setText(b.getBookingGuest().getName());
		add(GuestName);
		
		JLabel label_1 = new JLabel("Address");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(0, 124, 150, 14);
		add(label_1);
		
		GuestAddress = new JTextField();
		GuestAddress.setToolTipText("Name");
		GuestAddress.setBounds(0, 139, 150, 20);
		GuestAddress.setText(b.getBookingGuest().getAddress());
		add(GuestAddress);
		
		JLabel label_2 = new JLabel("Nationality");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(0, 170, 150, 14);
		add(label_2);
		
		GuestNationality = new JTextField();
		GuestNationality.setToolTipText("Nationality");
		GuestNationality.setBounds(0, 183, 150, 20);
		GuestNationality.setText(b.getBookingGuest().getNationality());
		add(GuestNationality);
		
		JLabel label_3 = new JLabel("Birth date");
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		label_3.setBounds(0, 214, 150, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("From");
		label_4.setFont(new Font("Arial", Font.PLAIN, 14));
		label_4.setBounds(170, 78, 150, 14);
		add(label_4);
		
		BookingFrom = new JFormattedTextField(dateFormat);
		BookingFrom.setToolTipText("From");
		BookingFrom.setBounds(170, 93, 150, 20);
		BookingFrom.setText(b.getFrom().toString());
		add(BookingFrom);
		
		JLabel label_5 = new JLabel("To");
		label_5.setFont(new Font("Arial", Font.PLAIN, 14));
		label_5.setBounds(170, 123, 150, 14);
		add(label_5);
		
		BookingTo = new JFormattedTextField(dateFormat);
		BookingTo.setToolTipText("To");
		BookingTo.setBounds(170, 138, 150, 20);
		BookingTo.setText(b.getTo().toString());
		add(BookingTo);
		
		JLabel label_6 = new JLabel("Number of guests");
		label_6.setFont(new Font("Arial", Font.PLAIN, 14));
		label_6.setBounds(170, 168, 150, 15);
		add(label_6);
		
		BookingNumGuest = new JTextField();
		BookingNumGuest.setToolTipText("Number of guests");
		BookingNumGuest.setBounds(170, 183, 150, 20);
		BookingNumGuest.setText(b.getNumGuest()+"");
		add(BookingNumGuest);
		
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
		
		
		RoomNum = new JComboBox<Object>();
		RoomNum.setFont(new Font("Arial", Font.PLAIN, 14));
		RoomNum.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		RoomNum.setBounds(340, 93, 98, 20);
		RoomNum.setSelectedIndex(b.getRoom().getNumber()-1);
		add(RoomNum);
		
		JLabel lblExtraServices = new JLabel("Extra services");
		lblExtraServices.setFont(new Font("Arial", Font.ITALIC, 14));
		lblExtraServices.setBounds(468, 40, 105, 16);
		add(lblExtraServices);
		
		chckbxRoomService = new JCheckBox("Room service");
		chckbxRoomService.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxRoomService.setBounds(468, 93, 111, 22);
		chckbxRoomService.setSelected(b.getExtras().getRoomService());
		add(chckbxRoomService);
		
		chckbxLaundry = new JCheckBox("Laundry");
		chckbxLaundry.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxLaundry.setBounds(468, 138, 98, 22);
		chckbxLaundry.setSelected(b.getExtras().getaundry());
		add(chckbxLaundry);
		
		chckbxExtraBed = new JCheckBox("Extra bed");
		chckbxExtraBed.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxExtraBed.setBounds(468, 183, 98, 22);
		chckbxExtraBed.setSelected(b.getExtras().getExtraBed());
		add(chckbxExtraBed);
		
		chckbxSmoking = new JCheckBox("Smoking");
		chckbxSmoking.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxSmoking.setBounds(468, 229, 92, 22);
		chckbxSmoking.setSelected(b.getExtras().getSmoking());
		add(chckbxSmoking);
		
		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.getBookingGuest().setName(GuestName.getText());
				b.getBookingGuest().setAddress(GuestAddress.getText());
				b.getBookingGuest().setNationality(GuestNationality.getText());
				b.setFrom(new Date(BookingFrom.getText()));
				b.setTo(new Date(BookingTo.getText()));
				b.setNumGuest(Integer.parseInt(BookingNumGuest.getText()));
				b.getBookingGuest().setDateOfBirth(new Date(GuestBirth.getText()));
				b.setRoom(db.getRoom((Integer.parseInt((String)RoomNum.getSelectedItem()))));
				extras.setExtraBed(chckbxExtraBed.isSelected());
				extras.setlaundry(chckbxLaundry.isSelected());
				extras.setRoomService(chckbxRoomService.isSelected());
				extras.setSmoking(chckbxSmoking.isSelected());
				b.setExtras(extras);
				bdb.setBooking(b);
				bdb.serialize();
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent, "Editing complete");
			}
		});
		btnSaveChanges.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSaveChanges.setBounds(604, 93, 150, 20);
		add(btnSaveChanges);
		
		GuestBirth = new JFormattedTextField(dateFormat);
		GuestBirth.setToolTipText("Nationality");
		GuestBirth.setBounds(0, 230, 150, 20);
		GuestBirth.setText(b.getBookingGuest().getDateOfBirth().toString());
		add(GuestBirth);
		
	}
}
