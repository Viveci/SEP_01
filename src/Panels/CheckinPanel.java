package Panels;

import javax.swing.*;

import DataBase.BookingDB;
import Model.Booking;
import Model.Date;
import Model.Guest;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CheckinPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField GuestName;
	private JTextField Address;
	private JTextField Nationality;
	private JTextField GuestBirthDate;
	private JTextField BookingTo;
	private JTextField PhoneNum;
	private JTextField Email;
	private JTextField PassNumber;
	private JTextField BookingFrom;
	private ArrayList<Booking> CheckedInGuests;
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private BookingDB bdb;
	
	private Booking booking;
	
	public CheckinPanel(){
		setBounds(0, 0, 770, 300);
		setLayout(null);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		String[] nums = {"1","1","1"};
		comboBox.setModel(new DefaultComboBoxModel<Object>(nums));
		comboBox.setBounds(12, 55, 150, 20);

		add(comboBox);
		
		JLabel lblCheckin = new JLabel("Check-in");
		lblCheckin.setBounds(0, 0, 140, 32);
		lblCheckin.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblCheckin);
		
		JLabel label = new JLabel("Name of the guest");
		label.setBounds(12, 86, 150, 14);
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label);
		
		GuestName = new JTextField();
		GuestName.setBounds(12, 101, 150, 20);
		GuestName.setToolTipText("Name");
		add(GuestName);
		
		JLabel label_1 = new JLabel("Address");
		label_1.setBounds(12, 130, 150, 14);
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_1);
		
		Address = new JTextField();
		Address.setBounds(12, 145, 150, 20);
		Address.setToolTipText("Name");
		add(Address);
		
		JLabel label_2 = new JLabel("Nationality");
		label_2.setBounds(12, 176, 150, 14);
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_2);
		
		Nationality = new JTextField();
		Nationality.setBounds(12, 191, 150, 20);
		Nationality.setToolTipText("Nationality");
		add(Nationality);
		
		JLabel label_3 = new JLabel("Birth date");
		label_3.setBounds(12, 224, 150, 14);
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_3);
		
		GuestBirthDate = new JTextField();
		GuestBirthDate.setBounds(12, 239, 150, 20);
		GuestBirthDate.setToolTipText("BirthDate");
		add(GuestBirthDate);
		
		JLabel label_4 = new JLabel("From");
		label_4.setBounds(174, 40, 150, 14);
		label_4.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_4);
		
		BookingTo = new JTextField();
		BookingTo.setBounds(174, 101, 150, 20);
		BookingTo.setToolTipText("To");
		add(BookingTo);
		
		JLabel label_5 = new JLabel("To");
		label_5.setBounds(174, 86, 150, 14);
		label_5.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_5);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(174, 134, 150, 14);
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblPhone);
		
		PhoneNum = new JTextField();
		PhoneNum.setBounds(174, 149, 150, 20);
		PhoneNum.setToolTipText("Name");
		add(PhoneNum);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(175, 178, 150, 14);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblEmail);
		
		Email = new JTextField();
		Email.setBounds(175, 193, 150, 20);
		Email.setToolTipText("Name");
		add(Email);
		
		JLabel lblPassportNumber = new JLabel("Passport number");
		lblPassportNumber.setBounds(175, 224, 150, 14);
		lblPassportNumber.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblPassportNumber);
		
		PassNumber = new JTextField();
		PassNumber.setBounds(175, 239, 150, 20);
		PassNumber.setToolTipText("Name");
		add(PassNumber);
		
		JLabel lblChooseGuest = new JLabel("Choose guest number");
		lblChooseGuest.setBounds(12, 40, 150, 14);
		lblChooseGuest.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblChooseGuest);
		
		JButton btnCheckin = new JButton("Check-in");
		btnCheckin.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCheckin.setBounds(608, 239, 150, 25);
		add(btnCheckin);
		
		BookingFrom = new JTextField();
		BookingFrom.setBounds(174, 55, 150, 20);
		BookingFrom.setToolTipText("Name");
		add(BookingFrom);
		
		JButton saveButton = new JButton("Save guest");
		saveButton.setFont(new Font("Arial", Font.PLAIN, 14));
		saveButton.setBounds(433, 239, 150, 25);
		add(saveButton);
	} 
	
	public CheckinPanel(Booking bookerGuest) {
		setBounds(0, 0, 770, 300);
		setLayout(null);
		
		bdb = new BookingDB();
		
		this.booking = bookerGuest;
		
		if(booking.getGuests().size()==1){
			ArrayList<Guest> list = new ArrayList<>();
			for(int i = 0; i< booking.getNumGuest(); i++){
				list.add(new Guest());
			}
			booking.setGuests(list);
		}
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		String[] nums = new String[bookerGuest.getNumGuest()]; 
		for(int i = 0; i < bookerGuest.getNumGuest(); i++){
			nums[i] = ""+(i+1);
		}
		comboBox.setModel(new DefaultComboBoxModel<Object>(nums));
		comboBox.setBounds(12, 55, 150, 20);		
		add(comboBox);
		
		JLabel lblCheckin = new JLabel("Check-in");
		lblCheckin.setBounds(0, 0, 140, 32);
		lblCheckin.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblCheckin);
		
		JLabel label = new JLabel("Name of the guest");
		label.setBounds(12, 86, 150, 14);
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label);
		
		GuestName = new JTextField();
		GuestName.setBounds(12, 101, 150, 20);
		GuestName.setToolTipText("Name");
		GuestName.setText(bookerGuest.getBookingGuest().getName());
		
		add(GuestName);
		
		JLabel label_1 = new JLabel("Address");
		label_1.setBounds(12, 130, 150, 14);
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_1);
		
		Address = new JTextField();
		Address.setBounds(12, 145, 150, 20);
		Address.setToolTipText("Name");
		Address.setText(bookerGuest.getBookingGuest().getAddress());
		
		add(Address);
		
		JLabel label_2 = new JLabel("Nationality");
		label_2.setBounds(12, 176, 150, 14);
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_2);
		
		Nationality = new JTextField();
		Nationality.setBounds(12, 191, 150, 20);
		Nationality.setToolTipText("Nationality");
		Nationality.setText(bookerGuest.getBookingGuest().getNationality());
		
		add(Nationality);
		
		JLabel label_3 = new JLabel("Birth date");
		label_3.setBounds(12, 224, 150, 14);
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_3);
		
		GuestBirthDate = new JFormattedTextField(dateFormat);
		GuestBirthDate.setBounds(12, 239, 150, 20);
		GuestBirthDate.setToolTipText("BirthDate");
		GuestBirthDate.setText(bookerGuest.getBookingGuest().getDateOfBirth().toString());

		add(GuestBirthDate);
		
		JLabel label_4 = new JLabel("From");
		label_4.setBounds(174, 40, 150, 14);
		label_4.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_4);
		
		BookingTo = new JTextField();
		BookingTo.setBounds(174, 101, 150, 20);
		BookingTo.setToolTipText("To");
		BookingTo.setText(bookerGuest.getTo().toString());
		add(BookingTo);
		
		JLabel label_5 = new JLabel("To");
		label_5.setBounds(174, 86, 150, 14);
		label_5.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_5);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(174, 134, 150, 14);
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblPhone);
		
		PhoneNum = new JTextField();
		PhoneNum.setBounds(174, 149, 150, 20);
		PhoneNum.setToolTipText("Name");
		PhoneNum.setText(bookerGuest.getBookingGuest().getCell());
		add(PhoneNum);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(175, 178, 150, 14);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblEmail);
		
		Email = new JTextField();
		Email.setBounds(175, 193, 150, 20);
		Email.setToolTipText("Name");
		Email.setText(bookerGuest.getBookingGuest().getEmail());
		add(Email);
		
		JLabel lblPassportNumber = new JLabel("Passport number");
		lblPassportNumber.setBounds(175, 224, 150, 14);
		lblPassportNumber.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblPassportNumber);
		
		PassNumber = new JTextField();
		PassNumber.setBounds(175, 239, 150, 20);
		PassNumber.setToolTipText("Name");
		PassNumber.setText(bookerGuest.getBookingGuest().getPassport());
		add(PassNumber);
		
		JLabel lblChooseGuest = new JLabel("Choose guest number");
		lblChooseGuest.setBounds(12, 40, 150, 14);
		lblChooseGuest.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblChooseGuest);
		
		JButton checkinButton = new JButton("Check-in");
		checkinButton.setBounds(608, 239, 150, 25);
		add(checkinButton);
		this.CheckedInGuests = new ArrayList<>();
		
		checkinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bdb.setBooking(booking);
				bdb.serialize();
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent, "Checkin is completed.");
			}
		});
		
		
		BookingFrom = new JTextField();
		BookingFrom.setBounds(174, 55, 150, 20);
		BookingFrom.setToolTipText("Name");
		BookingFrom.setText(bookerGuest.getFrom().toString());
		add(BookingFrom);
		
		JButton saveButton = new JButton("Save guest");
		saveButton.setFont(new Font("Arial", Font.PLAIN, 14));
		saveButton.setBounds(433, 239, 150, 25);
		add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("1")){
					booking.setBookingGuest(getTextFields());
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "Guest saved");
				}
				else{
					booking.getGuests().remove((Integer.parseInt(comboBox.getSelectedItem().toString()))-1);
					booking.getGuests().add((Integer.parseInt(comboBox.getSelectedItem().toString()))-1, getTextFields());
					System.out.println(booking.getGuests().get(1).getName());
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "Guest saved");
				}
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox.getSelectedItem().toString().equals("1"));
				if(comboBox.getSelectedItem().toString().equals("1")){
					fillTextFields(booking.getBookingGuest());
				}
				else{
				Guest temp = booking.getGuests().get((Integer.parseInt(comboBox.getSelectedItem().toString()))-1);
				fillTextFields(temp);
				}
			}
		});
	}
	
	public void fillTextFields(Guest g){
		GuestName.setText(g.getName());
		GuestBirthDate.setText(g.getDateOfBirth().toString());
		Address.setText(g.getAddress());
		Nationality.setText(g.getNationality());
		BookingFrom.setText(booking.getFrom().toString());
		BookingTo.setText(booking.getTo().toString());
		PhoneNum.setText(g.getCell());
		PassNumber.setText(g.getPassport());
		Email.setText(g.getEmail());
	}

	public Guest getTextFields(){
		Guest g = new Guest();
		g.setAddress(Address.getText());
		g.setCell(PhoneNum.getText());
		g.setDateOfBirth(new Date(GuestBirthDate.getText()));
		g.setEmail(Email.getText());
		g.setName(GuestName.getText());
		g.setNationality(Nationality.getText());
		g.setPassport(PassNumber.getText());
		return g;
	}
	
}