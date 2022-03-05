
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

		addDrivers.setBackground(Color.WHITE);
		addDrivers.setForeground(Color.RED);
		addEmployees.setBackground(Color.WHITE);
		addEmployees.setForeground(Color.RED);
		addRooms.setBackground(Color.WHITE);
		addRooms.setForeground(Color.RED);
		delDrivers.setBackground(Color.WHITE);
		delDrivers.setForeground(Color.RED);
		delEmployees.setBackground(Color.WHITE);
		delEmployees.setForeground(Color.RED);
		delRooms.setBackground(Color.WHITE);
		delRooms.setForeground(Color.RED);
		updateDrivers.setBackground(Color.WHITE);
		updateDrivers.setForeground(Color.RED);
		updateEmployees.setBackground(Color.WHITE);
		updateEmployees.setForeground(Color.RED);
		updateRooms.setBackground(Color.WHITE);
		updateRooms.setForeground(Color.RED);

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

		else if (e.getSource() == delEmployees) {
			new DeleteEmployee();
		}

		else if (e.getSource() == addDrivers) {
			new AddDriver();
		}

		else if (e.getSource() == delDrivers) {
			new DeleteDriver();
		}

		else if (e.getSource() == addRooms) {
			new AddRoom();
		}
		
		else if (e.getSource() == delRooms) {
			new DeleteRoom();
		}

	}

	public static void main(String[] args) {
		new AdminPanel();
	}
}
