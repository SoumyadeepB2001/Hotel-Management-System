
//import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener {

	JButton addDrivers, addEmployees, addRooms, delDrivers, delEmployees, delRooms;
	JPanel contentPane;

	AdminPanel() {
		setBounds(300, 300, 600, 750);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		addDrivers = new JButton("Add Driver");
		addEmployees = new JButton("Add Employee");
		addRooms = new JButton("Add Room");
		delDrivers = new JButton("Delete Driver");
		delEmployees = new JButton("Delete Employee");
		delRooms = new JButton("Delete Room");

		addDrivers.setBackground(Color.BLACK);
		addDrivers.setForeground(Color.WHITE);
		addEmployees.setBackground(Color.BLACK);
		addEmployees.setForeground(Color.WHITE);
		addRooms.setBackground(Color.BLACK);
		addRooms.setForeground(Color.WHITE);
		delDrivers.setBackground(Color.BLACK);
		delDrivers.setForeground(Color.WHITE);
		delEmployees.setBackground(Color.BLACK);
		delEmployees.setForeground(Color.WHITE);
		delRooms.setBackground(Color.BLACK);
		delRooms.setForeground(Color.WHITE);

		addEmployees.setBounds(200, 80, 200, 60);
		addDrivers.setBounds(200, 180, 200, 60);
		addRooms.setBounds(200, 280, 200, 60);
		delEmployees.setBounds(200, 380, 200, 60);
		delDrivers.setBounds(200, 480, 200, 60);
		delRooms.setBounds(200, 580, 200, 60);

		add(addDrivers);
		add(addEmployees);
		add(addRooms);
		add(delDrivers);
		add(delEmployees);
		add(delRooms);

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
