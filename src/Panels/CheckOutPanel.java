package Panels;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JCheckBox;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.NumberFormatter;

import DataBase.BookingDB;
import Model.Booking;

public class CheckoutPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField NameText;
	private JTextField textField_1;
	
	private int roomdefault;
	private int cig = 0;
	private int extrabed = 0;
	private int laundry = 0;
	private int service = 0;
	private int total = 0; 
	
	private BookingDB bdb = new BookingDB();

	public CheckoutPanel(Booking b) {
		
		setBounds(0, 0, 770, 300);
		setLayout(null);
		
		roomdefault = b.getRoom().getPrice()*b.getPeriod();
		total = roomdefault+service+cig+extrabed+laundry;
		
		JLabel lblCheckout = new JLabel("Check-out");
		lblCheckout.setBounds(0, 0, 140, 18);
		lblCheckout.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblCheckout);
		
		JLabel label = new JLabel("Name of the guest");
		label.setBounds(10, 70, 150, 14);
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label);
		
		NameText = new JTextField();
		NameText.setBounds(10, 85, 150, 20);
		NameText.setToolTipText("Name");
		NameText.setText(b.getBookingGuest().getName());
		add(NameText);
		
		JLabel lblDepartureDate = new JLabel("Departure date");
		lblDepartureDate.setBounds(10, 106, 150, 14);
		lblDepartureDate.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblDepartureDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 121, 150, 20);
		textField_1.setToolTipText("To");
		textField_1.setText(b.getTo().toString());
		add(textField_1);
		
		JButton btnCheckout = new JButton("Check-out");
		btnCheckout.setBounds(608, 262, 150, 25);
		btnCheckout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bdb.deleteBooking(b.getId());
				bdb.serialize();
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent, "Checkout is complete\nBooking is deleted from database");
			}
		});
		add(btnCheckout);
		
		JTextField txtrPrice = new JTextField();
		txtrPrice.setBounds(608, 85, 150, 20);
		txtrPrice.setForeground(Color.RED);
		txtrPrice.setText(roomdefault+service+cig+extrabed+laundry+" Euro");
		txtrPrice.setFont(new Font("Arial", Font.BOLD, 14));
		
		add(txtrPrice);
		
		JLabel lblPrice = new JLabel("Total:");
		lblPrice.setBounds(608, 35, 56, 16);
		lblPrice.setFont(new Font("Arial", Font.ITALIC, 14));
		add(lblPrice);
		
		JTextField RoomType = new JTextField();
		RoomType.setBounds(172, 85, 150, 20);
		RoomType.setText(b.getRoom().getType());
		add(RoomType);
		
		JLabel lblRoomType = new JLabel("Room type");
		lblRoomType.setBounds(172, 70, 150, 14);
		lblRoomType.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblRoomType);
		
		JLabel lblGuestInformation = new JLabel("Guest information");
		lblGuestInformation.setBounds(10, 35, 150, 20);
		lblGuestInformation.setFont(new Font("Arial", Font.ITALIC, 14));
		add(lblGuestInformation);
		
		JLabel lblExpenses = new JLabel("Booking information");
		lblExpenses.setBounds(172, 35, 150, 20);
		lblExpenses.setFont(new Font("Arial", Font.ITALIC, 14));
		add(lblExpenses);
		
		JLabel lblNightsSpent = new JLabel("Nights spent");
		lblNightsSpent.setBounds(172, 106, 150, 16);
		lblNightsSpent.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblNightsSpent);
		
		JTextField textArea_1 = new JTextField();;
		textArea_1.setBounds(174, 125, 150, 20);
		textArea_1.setText((b.getPeriod())+" nights");
		add(textArea_1);
		
		JCheckBox checkBox = new JCheckBox("Room service");
		checkBox.setBounds(172, 184, 120, 22);
		checkBox.setFont(new Font("Arial", Font.PLAIN, 14));
		checkBox.setSelected(b.getExtras().getRoomService());
		add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Laundry");
		checkBox_1.setBounds(172, 211, 88, 22);
		checkBox_1.setFont(new Font("Arial", Font.PLAIN, 14));
		checkBox_1.setSelected(b.getExtras().getaundry());
		add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Extra bed");
		checkBox_2.setBounds(172, 238, 88, 22);
		checkBox_2.setFont(new Font("Arial", Font.PLAIN, 14));
		checkBox_2.setSelected(b.getExtras().getExtraBed());
		add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Smoking");
		checkBox_3.setBounds(172, 265, 88, 22);
		checkBox_3.setFont(new Font("Arial", Font.PLAIN, 14));
		checkBox_3.setSelected(b.getExtras().getSmoking());
		add(checkBox_3);
		
		JLabel lblExtras = new JLabel("Extra services");
		lblExtras.setBounds(172, 155, 150, 20);
		lblExtras.setFont(new Font("Arial", Font.ITALIC, 14));
		add(lblExtras);
		
		JLabel lblPrices = new JLabel("Prices");
		lblPrices.setBounds(375, 35, 150, 20);
		lblPrices.setFont(new Font("Arial", Font.ITALIC, 14));
		add(lblPrices);
		
		JTextField textArea_2 = new JTextField();
		textArea_2.setBounds(375, 85, 150, 20);
		textArea_2.setText(b.getRoom().getPrice()+" Euro");
		add(textArea_2);
		
		JTextField textArea_3 = new JTextField();
		textArea_3.setBounds(375, 125, 150, 20);
		textArea_3.setText(roomdefault+" Euro");
		add(textArea_3);
		
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(1000);
	    
		JTextField textArea_4 = new JFormattedTextField(formatter);
		textArea_4.setBounds(375, 184, 150, 20);
		if(b.getExtras().getRoomService()){
			service = 20;
			textArea_4.setText(service+"");
			
		}
		else{
			textArea_4.setText("");
		}
		add(textArea_4);
		textArea_4.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				if(!textArea_4.getText().isEmpty()){
				service = Integer.parseInt(textArea_4.getText());
				total = roomdefault+service+cig+extrabed+laundry;
				txtrPrice.setText(total+" Euro");
				}
			}
		});
		
		JTextField textArea_5 = new JFormattedTextField(formatter);
		textArea_5.setBounds(375, 211, 150, 20);
		if(b.getExtras().getaundry()){
			laundry = 20;
			textArea_5.setText(laundry+"");
		}
		else{
			textArea_5.setText("");
		}
		add(textArea_5);
		
		textArea_5.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				if(!textArea_5.getText().isEmpty()){
				laundry = Integer.parseInt(textArea_5.getText());
				total = roomdefault+service+cig+extrabed+laundry;
				txtrPrice.setText(total+" Euro");
				}
			}
		});
		
		JTextField textArea_6 = new JFormattedTextField(formatter);
		textArea_6.setBounds(375, 238, 150, 20);
		if(b.getExtras().getExtraBed()){
			extrabed = 20;
			textArea_6.setText(extrabed+"");
		}
		else{
			textArea_6.setText("");
		}
		add(textArea_6);
		
		textArea_6.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				if(!textArea_6.getText().isEmpty()){
				extrabed = Integer.parseInt(textArea_6.getText());
				total = roomdefault+service+cig+extrabed+laundry;
				txtrPrice.setText(total+" Euro");
				}
			}
		});
		
		JTextField textArea_7 = new JFormattedTextField(formatter);
		textArea_7.setBounds(375, 265, 150, 20);
		if(b.getExtras().getSmoking()){
			cig = 20;
			textArea_7.setText(cig+"");
		}
		else{
			textArea_7.setText("");
		}
		add(textArea_7);
		
		textArea_7.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				if(!textArea_7.getText().isEmpty()){
				cig = Integer.parseInt(textArea_7.getText());
				total = roomdefault+service+cig+extrabed+laundry;
				txtrPrice.setText(total+" Euro");
				}
			}
		});
		
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

	}
}
