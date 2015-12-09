package Panels;

import javax.swing.JPanel;
import javax.swing.JButton;

public class CheckoutPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CheckoutPanel() {
		
		setBounds(0, 0, 770, 300);
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(321, 216, 89, 23);
		add(btnNewButton);

	}

}
