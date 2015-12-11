package Panels;

import javax.swing.*;

import Model.Booking;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	
	private Booking booking;
	
	public CheckinPanel(){
		setBounds(0, 0, 770, 300);
		setLayout(null);
		
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
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		String[] nums = {"1","1","1"};
		comboBox.setModel(new DefaultComboBoxModel<Object>(nums));
		comboBox.setBounds(12, 55, 150, 20);

		add(comboBox);
		
		JLabel lblChooseGuest = new JLabel("Choose guest number");
		lblChooseGuest.setBounds(12, 40, 150, 14);
		lblChooseGuest.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblChooseGuest);
		
		JButton btnCheckin = new JButton("Check-in");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCheckin.setBounds(608, 239, 150, 25);
		add(btnCheckin);
		
		BookingFrom = new JTextField();
		BookingFrom.setBounds(174, 55, 150, 20);
		BookingFrom.setToolTipText("Name");
		add(BookingFrom);
	} 
	
	public CheckinPanel(Booking booking) {
		setBounds(0, 0, 770, 300);
		setLayout(null);
		
		this.booking = booking;
		
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
		
		GuestName.setText(booking.getBookingGuest().getName());
		
		JLabel label_1 = new JLabel("Address");
		label_1.setBounds(12, 130, 150, 14);
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_1);
		
		Address = new JTextField();
		Address.setBounds(12, 145, 150, 20);
		Address.setToolTipText("Name");
		Address.setText(booking.getBookingGuest().getAddress());
		add(Address);
		
		JLabel label_2 = new JLabel("Nationality");
		label_2.setBounds(12, 176, 150, 14);
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_2);
		
		Nationality = new JTextField();
		Nationality.setBounds(12, 191, 150, 20);
		Nationality.setToolTipText("Nationality");
		Nationality.setText(booking.getBookingGuest().getNationality());
		add(Nationality);
		
		JLabel label_3 = new JLabel("Birth date");
		label_3.setBounds(12, 224, 150, 14);
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_3);
		
		GuestBirthDate = new JTextField();
		GuestBirthDate.setBounds(12, 239, 150, 20);
		GuestBirthDate.setToolTipText("BirthDate");
		GuestBirthDate.setText(booking.getBookingGuest().getDateOfBirth().toString());
		add(GuestBirthDate);
		
		JLabel label_4 = new JLabel("From");
		label_4.setBounds(174, 40, 150, 14);
		label_4.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label_4);
		
		BookingTo = new JTextField();
		BookingTo.setBounds(174, 101, 150, 20);
		BookingTo.setToolTipText("To");
		BookingTo.setText(booking.getTo().toString());
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
		PhoneNum.setText(booking.getBookingGuest().getCell());
		add(PhoneNum);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(175, 178, 150, 14);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblEmail);
		
		Email = new JTextField();
		Email.setBounds(175, 193, 150, 20);
		Email.setToolTipText("Name");
		Email.setText(booking.getBookingGuest().getEmail());
		add(Email);
		
		JLabel lblPassportNumber = new JLabel("Passport number");
		lblPassportNumber.setBounds(175, 224, 150, 14);
		lblPassportNumber.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblPassportNumber);
		
		PassNumber = new JTextField();
		PassNumber.setBounds(175, 239, 150, 20);
		PassNumber.setToolTipText("Name");
		PassNumber.setText(booking.getBookingGuest().getPassport());
		add(PassNumber);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		String[] nums = new String[booking.getNumGuest()]; 
		for(int i = 0; i < booking.getNumGuest(); i++){
			nums[i] = ""+(i+1);
		}
		comboBox.setModel(new DefaultComboBoxModel<Object>(nums));
		comboBox.setBounds(12, 55, 150, 20);

		add(comboBox);
		
		JLabel lblChooseGuest = new JLabel("Choose guest number");
		lblChooseGuest.setBounds(12, 40, 150, 14);
		lblChooseGuest.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblChooseGuest);
		
		JButton btnCheckin = new JButton("Check-in");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCheckin.setBounds(608, 239, 150, 25);
		add(btnCheckin);
		
		BookingFrom = new JTextField();
		BookingFrom.setBounds(174, 55, 150, 20);
		BookingFrom.setToolTipText("Name");
		BookingFrom.setText(booking.getFrom().toString());
		add(BookingFrom);
	}
}