import javax.swing.*;
import java.sql.*;	
import java.awt.event.*;
import java.awt.*;
public class Reception extends JFrame {

	JButton newCustomer, room, department, e_info, c_info, m_info, checkOut, checkStatus, roomStatus, pickUp,
			searchRoom, logOut;
	JPanel contentPane;
	public ImageIcon i1, i2;
	public Image i3;
	public JLabel l1;

	public static void main(String[] args) {
		new Reception();
	}

	public Reception() {
		setVisible(true);
		setResizable(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Adding the image
		i1 = new ImageIcon(getClass().getResource("reception.jpg"));
		i3 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		i2 = new ImageIcon(i3);
		l1 = new JLabel(i1);
		l1.setBounds(220, 30, 500, 470);
		contentPane.add(l1);

		// Initializing all the buttons
		newCustomer = new JButton("New Customer Form");
		newCustomer.setBackground(Color.BLACK);
		newCustomer.setForeground(Color.WHITE);
		newCustomer.setBounds(10, 30, 200, 30);
		add(newCustomer);

		room = new JButton("Room");
		room.setBackground(Color.BLACK);
		room.setForeground(Color.WHITE);
		room.setBounds(10, 70, 200, 30);
		add(room);

		department = new JButton("Department");
		department.setBackground(Color.BLACK);
		department.setForeground(Color.WHITE);
		department.setBounds(10, 110, 200, 30);
		add(department);

		e_info = new JButton("Employee Information");
		e_info.setBackground(Color.BLACK);
		e_info.setForeground(Color.WHITE);
		e_info.setBounds(10, 150, 200, 30);
		add(e_info);

		c_info = new JButton("Customer Information");
		c_info.setBackground(Color.BLACK);
		c_info.setForeground(Color.WHITE);
		c_info.setBounds(10, 190, 200, 30);
		add(c_info);

		m_info = new JButton("Manager Information");
		m_info.setBackground(Color.BLACK);
		m_info.setForeground(Color.WHITE);
		m_info.setBounds(10, 230, 200, 30);
		add(m_info);

		checkOut = new JButton("Check Out");
		checkOut.setBackground(Color.BLACK);
		checkOut.setForeground(Color.WHITE);
		checkOut.setBounds(10, 270, 200, 30);
		add(checkOut);

		checkStatus = new JButton("Update Check Status");
		checkStatus.setBackground(Color.BLACK);
		checkStatus.setForeground(Color.WHITE);
		checkStatus.setBounds(10, 310, 200, 30);
		add(checkStatus);

		roomStatus = new JButton("Update Room Status");
		roomStatus.setBackground(Color.BLACK);
		roomStatus.setForeground(Color.WHITE);
		roomStatus.setBounds(10, 350, 200, 30);
		add(roomStatus);

		pickUp = new JButton("Pick Up Service");
		pickUp.setBackground(Color.BLACK);
		pickUp.setForeground(Color.WHITE);
		pickUp.setBounds(10, 390, 200, 30);
		add(pickUp);

		searchRoom = new JButton("Search Room");
		searchRoom.setBackground(Color.BLACK);
		searchRoom.setForeground(Color.WHITE);
		searchRoom.setBounds(10, 430, 200, 30);
		add(searchRoom);

		logOut = new JButton("Log Out");
		logOut.setBackground(Color.BLACK);
		logOut.setForeground(Color.WHITE);
		logOut.setBounds(10, 470, 200, 30);
		add(logOut);

		setBounds(530, 200, 750, 550); //This Line is very important and should be placed at the end only after the image and buttons have been initialized. Or else the JFrame will not refresh itself.

		// Adding Action Listeners

	}
}