import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener {

	JButton newCustomer, room, department, e_info, c_info, m_info, checkOut, checkStatus, roomStatus, pickUp,
			searchRoom, searchCustomer, checkOutHistory, logOut;
	JPanel contentPane;
	public ImageIcon i1, i2;
	public Image i3;
	public JLabel l1;

	public static void main(String[] args) {
		new Reception();
	}

	Reception() {
		this.setTitle("Reception");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Adding the image
		i1 = new ImageIcon(getClass().getResource("reception.jpg"));
		i3 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		i2 = new ImageIcon(i3);
		l1 = new JLabel(i1);
		l1.setBounds(220, 30, 550, 550);
		contentPane.add(l1);

		// Initializing all the buttons
		newCustomer = new JButton("New Customer Form");
		newCustomer.setBackground(Color.WHITE);
		newCustomer.setForeground(Color.RED);
		newCustomer.setBounds(10, 30, 200, 30);
		add(newCustomer);

		room = new JButton("Room Information");
		room.setBackground(Color.WHITE);
		room.setForeground(Color.RED);
		room.setBounds(10, 70, 200, 30);
		add(room);

		department = new JButton("Budget Allocation");
		department.setBackground(Color.WHITE);
		department.setForeground(Color.RED);
		department.setBounds(10, 110, 200, 30);
		add(department);

		e_info = new JButton("Employee Information");
		e_info.setBackground(Color.WHITE);
		e_info.setForeground(Color.RED);
		e_info.setBounds(10, 150, 200, 30);
		add(e_info);

		c_info = new JButton("Customer Information");
		c_info.setBackground(Color.WHITE);
		c_info.setForeground(Color.RED);
		c_info.setBounds(10, 190, 200, 30);
		add(c_info);

		m_info = new JButton("Manager Information");
		m_info.setBackground(Color.WHITE);
		m_info.setForeground(Color.RED);
		m_info.setBounds(10, 230, 200, 30);
		add(m_info);

		checkOut = new JButton("Check-out");
		checkOut.setBackground(Color.WHITE);
		checkOut.setForeground(Color.RED);
		checkOut.setBounds(10, 270, 200, 30);
		add(checkOut);

		checkStatus = new JButton("Update Customer Details");
		checkStatus.setBackground(Color.WHITE);
		checkStatus.setForeground(Color.RED);
		checkStatus.setBounds(10, 310, 200, 30);
		add(checkStatus);

		roomStatus = new JButton("Update Room Status");
		roomStatus.setBackground(Color.WHITE);
		roomStatus.setForeground(Color.RED);
		roomStatus.setBounds(10, 350, 200, 30);
		add(roomStatus);

		pickUp = new JButton("Pick Up Service");
		pickUp.setBackground(Color.WHITE);
		pickUp.setForeground(Color.RED);
		pickUp.setBounds(10, 390, 200, 30);
		add(pickUp);

		searchRoom = new JButton("Search Room");
		searchRoom.setBackground(Color.WHITE);
		searchRoom.setForeground(Color.RED);
		searchRoom.setBounds(10, 430, 200, 30);
		add(searchRoom);

		searchCustomer = new JButton("Search Customer");
		searchCustomer.setBackground(Color.WHITE);
		searchCustomer.setForeground(Color.RED);
		searchCustomer.setBounds(10, 470, 200, 30);
		add(searchCustomer);

		checkOutHistory = new JButton("Check-out History");
		checkOutHistory.setBackground(Color.WHITE);
		checkOutHistory.setForeground(Color.RED);
		checkOutHistory.setBounds(10, 510, 200, 30);
		add(checkOutHistory);

		logOut = new JButton("Log Out");
		logOut.setBackground(Color.WHITE);
		logOut.setForeground(Color.RED);
		logOut.setBounds(10, 550, 200, 30);
		add(logOut);

		setBounds(530, 200, 790, 630); // This Line is very important and should be placed at the end only after the
										// image and buttons have been initialized. Or else the JFrame will not refresh
										// itself.

		// Adding Action Listeners
		newCustomer.addActionListener(this);
		room.addActionListener(this);
		department.addActionListener(this);
		e_info.addActionListener(this);
		c_info.addActionListener(this);
		m_info.addActionListener(this);
		checkOut.addActionListener(this);
		checkStatus.addActionListener(this);
		roomStatus.addActionListener(this);
		pickUp.addActionListener(this);
		searchRoom.addActionListener(this);
		searchCustomer.addActionListener(this);
		checkOutHistory.addActionListener(this);
		logOut.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "New Customer Form":
				new NewCustomerForm();
				break;

			case "Room Information":
				new Room();
				break;

			case "Budget Allocation":
				new Department();
				break;

			case "Employee Information":
				new Employee();
				break;

			case "Customer Information":
				new Customer();
				break;

			case "Manager Information":
				new Manager();
				break;

			case "Update Customer Details":
				new UpdateCustomerDetails();
				break;

			case "Check-out":
				new CheckOut();
				break;

			case "Check-out History":
				new CheckOutHistory();
				break;

			case "Log Out":
				Frame[] allFrames = Frame.getFrames();
				// Iterate through the allFrames array
				for (Frame fr : allFrames) {
					fr.dispose();
				}
				new Login().setVisible(true);
				break;
		}

	}
}