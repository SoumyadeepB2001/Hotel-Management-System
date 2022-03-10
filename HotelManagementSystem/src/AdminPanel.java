import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener {

	JButton addDrivers, addEmployees, addRooms, delDrivers, delEmployees, delRooms, updateEmployees, updateDrivers,
			updateRooms, exit;
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
		exit = new JButton("Exit");

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
		exit.setBackground(Color.WHITE);
		exit.setForeground(Color.RED);

		addEmployees.setBounds(50, 50, 140, 60);
		delEmployees.setBounds(210, 50, 140, 60);
		updateEmployees.setBounds(370, 50, 140, 60);

		addDrivers.setBounds(50, 150, 140, 60);
		delDrivers.setBounds(210, 150, 140, 60);
		updateDrivers.setBounds(370, 150, 140, 60);

		addRooms.setBounds(50, 250, 140, 60);
		delRooms.setBounds(210, 250, 140, 60);
		updateRooms.setBounds(370, 250, 140, 60);

		exit.setBounds(210, 330, 140, 40);

		add(addDrivers);
		add(addEmployees);
		add(addRooms);
		add(delDrivers);
		add(delEmployees);
		add(delRooms);
		add(updateDrivers);
		add(updateEmployees);
		add(updateRooms);
		add(exit);

		addEmployees.addActionListener(this);
		addDrivers.addActionListener(this);
		addRooms.addActionListener(this);
		delEmployees.addActionListener(this);
		delDrivers.addActionListener(this);
		delRooms.addActionListener(this);
		updateEmployees.addActionListener(this);
		updateDrivers.addActionListener(this);
		updateRooms.addActionListener(this);
		exit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) { // getActionCommand() Returns the command string associated with this action.
			case "Add Employee":
				new AddEmployee();
				break;

			case "Delete Employee":
				new DeleteEmployee();
				break;

			case "Update Employee":
				new UpdateEmployee();
				break;

			case "Add Driver":
				new AddDriver();
				break;

			case "Delete Driver":
				new DeleteDriver();
				break;

			case "Update Driver":
				new UpdateDriver();
				break;

			case "Add Room":
				new AddRoom();
				break;

			case "Delete Room":
				new DeleteRoom();
				break;

			case "Update Room":
				new UpdateRoom();
				break;

			case "Exit":
				Frame[] allFrames = Frame.getFrames();
				// Iterate through the allFrames array
				for (Frame fr : allFrames) {
					fr.dispose();
				}
				new Dashboard();
				break;
		}
	}

	public static void main(String[] args) {
		new AdminPanel();
	}
}
