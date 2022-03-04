
//import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener {

	JButton addDrivers, addEmployees, addRooms, delDrivers, delEmployees, delRooms, updateEmployees,updateDrivers, updateRooms;
	JPanel contentPane;
	AdminPanel() {
		setBounds(300, 300, 575, 450);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Admin Panel");

		addDrivers = new JButton("Add Driver");
		addEmployees = new JButton("Add Employee");
		addRooms = new JButton("Add Room");
		delDrivers = new JButton("Delete Driver");
		delEmployees = new JButton("Delete Employee");
		delRooms = new JButton("Delete Room");
		updateDrivers = new JButton("Update Driver");
		updateEmployees = new JButton("Update Employee");
		updateRooms = new JButton("Update Room");

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
		updateDrivers.setBackground(Color.BLACK);
		updateDrivers.setForeground(Color.WHITE);
		updateEmployees.setBackground(Color.BLACK);
		updateEmployees.setForeground(Color.WHITE);
		updateRooms.setBackground(Color.BLACK);
		updateRooms.setForeground(Color.WHITE);

		addEmployees.setBounds(50, 80, 140, 60);
		delEmployees.setBounds(210, 80, 140, 60);
		updateEmployees.setBounds(370,80,140,60);

		addDrivers.setBounds(50, 180, 140, 60);
		delDrivers.setBounds(210, 180, 140, 60);
		updateDrivers.setBounds(370, 180, 140, 60);

		addRooms.setBounds(50, 280, 140, 60);
		delRooms.setBounds(210, 280, 140, 60);
		updateRooms.setBounds(370, 280, 140, 60);

		add(addDrivers);
		add(addEmployees);
		add(addRooms);
		add(delDrivers);
		add(delEmployees);
		add(delRooms);
		add(updateDrivers);
		add(updateEmployees);
		add(updateRooms);

		addEmployees.addActionListener(this);
		addDrivers.addActionListener(this);
		addRooms.addActionListener(this);
		delEmployees.addActionListener(this);
		delDrivers.addActionListener(this);
		delRooms.addActionListener(this);
		updateEmployees.addActionListener(this);
		updateDrivers.addActionListener(this);
		updateRooms.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addEmployees) {
			new AddEmployee();
		}

		if (e.getSource() == delEmployees) {
			new DeleteEmployee();
		}

		if (e.getSource() == addDrivers) {
			new AddDriver();
		}

		if (e.getSource() == delDrivers) {
			new DeleteDriver();
		}

		if (e.getSource() == addRooms) {
			new AddRoom();
		}

		
		if (e.getSource() == delRooms) {
			new DeleteRoom();
		}

	}

	public static void main(String[] args) {
		new AdminPanel();
	}
}
