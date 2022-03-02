import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

	JLabel l1;
	JButton b1;

	public HotelManagementSystem() {
		setBounds(300, 300, 1400, 550);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		l1 = new JLabel("");
		b1 = new JButton("Next");

		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);

		JLabel lid = new JLabel("HOTEL MANAGEMENT SYSTEM");
		lid.setBounds(30, 300, 1500, 100);
		lid.setFont(new Font("serif", Font.PLAIN, 70));
		lid.setForeground(Color.red);
		l1.add(lid);

		b1.setBounds(1170, 325, 150, 50);
		l1.setBounds(0, 0, 1366, 390);

		l1.add(b1);
		add(l1);

		b1.addActionListener(this);
		setVisible(true);

		while (true) {
			lid.setVisible(false);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
			lid.setVisible(true);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}

	public void actionPerformed(ActionEvent ae) {
		// new Login().setVisible(true);
		this.setVisible(false);

	}

	public static void main(String[] args) {
		new HotelManagementSystem();
	}
}