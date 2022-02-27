//import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener {

	JButton addDrivers, addEmployees, addRooms;
	JPanel contentPane;

	AdminPanel() {
		setBounds(300, 300, 600, 500);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		addDrivers = new JButton("Add Driver");
		addEmployees = new JButton("Add Employee");
		addRooms = new JButton("Add Room");

		addEmployees.setBounds(200, 80, 200, 60);
		addDrivers.setBounds(200, 180, 200, 60);
		addRooms.setBounds(200, 280, 200, 60);

		add(addDrivers);
		add(addEmployees);
		add(addRooms);

		addEmployees.addActionListener(this);
		addDrivers.addActionListener(this);
		addRooms.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addEmployees) {
			System.out.println("Employee Button clicked");
		}

		if (e.getSource() == addDrivers) {
			System.out.println("Driver Button clicked");
		}

		if (e.getSource() == addRooms) {
			System.out.println("Room Button clicked");
		}

	}

	public static void main(String[] args) {
		new AdminPanel();
	}
}
