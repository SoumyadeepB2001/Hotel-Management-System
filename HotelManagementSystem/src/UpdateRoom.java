import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class UpdateRoom extends JFrame implements ActionListener {
	JButton checkButton, updateButton;
	JPanel contentPane;
	public ImageIcon i1, i2;
	public Image i3;
	public JLabel l1, l2, roomNumLab, availLab, cleanLab, priceLab, roomLab, bedLab;
	public JTextField roomNum, price;
	JComboBox<String> cleaning, avail, bedType, room;
	String clean[] = { "Clean", "Not cleaned" };
	String types[] = { "Single", "Suite" };
	String beds[] = { "Single", "Double", "Queen", "King" };
	String availability[] = { "Available", "Unavailable" };

	public static void main(String[] args) {
		new UpdateRoom();
	}

	UpdateRoom() {
		this.setTitle("Update Room Information");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		l2 = new JLabel("Update Room Information");
		l2.setFont(new Font("Serif", Font.BOLD, 19));
		l2.setBounds(345, 25, 250, 30);
		add(l2);

		// Adding the image
		i1 = new ImageIcon(getClass().getResource("Bed.jpg"));
		i3 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		i2 = new ImageIcon(i3);
		l1 = new JLabel(i1);
		l1.setBounds(450, 80, 400, 335);
		contentPane.add(l1);

		// Adding textfields and labels
		roomNumLab = new JLabel("Room Number");
		roomNumLab.setFont(new Font("Serif", Font.BOLD, 17));
		roomNumLab.setBounds(50, 80, 135, 30);
		add(roomNumLab);
		roomNum = new JTextField();
		roomNum.setBounds(210, 80, 210, 30);
		add(roomNum);

		availLab = new JLabel("Availability");
		availLab.setFont(new Font("Serif", Font.BOLD, 17));
		availLab.setBounds(50, 130, 135, 30);
		add(availLab);
		avail = new JComboBox<>(availability);
		avail.setBounds(210, 130, 210, 30);
		add(avail);
		avail.setVisible(false);

		cleanLab = new JLabel("Cleaning Status");
		cleanLab.setFont(new Font("Serif", Font.BOLD, 17));
		cleanLab.setBounds(50, 180, 135, 30);
		add(cleanLab);
		cleaning = new JComboBox<>(clean);
		cleaning.setBounds(210, 180, 210, 30);
		add(cleaning);
		cleaning.setVisible(false);

		priceLab = new JLabel("Price (INR)");
		priceLab.setFont(new Font("Serif", Font.BOLD, 17));
		priceLab.setBounds(50, 230, 135, 30);
		add(priceLab);
		price = new JTextField();
		price.setBounds(210, 230, 210, 30);
		add(price);
		price.setEditable(false);

		roomLab = new JLabel("Room Type");
		roomLab.setFont(new Font("Serif", Font.BOLD, 17));
		roomLab.setBounds(50, 280, 135, 30);
		add(roomLab);
		room = new JComboBox<>(types);
		room.setBounds(210, 280, 210, 30);
		add(room);
		room.setVisible(false);

		bedLab = new JLabel("Bed Type");
		bedLab.setFont(new Font("Serif", Font.BOLD, 17));
		bedLab.setBounds(50, 330, 135, 30);
		add(bedLab);
		bedType = new JComboBox<>(beds);
		bedType.setBounds(210, 330, 210, 30);
		add(bedType);
		bedType.setVisible(false);

		checkButton = new JButton("Check");
		checkButton.setBounds(90, 390, 100, 30);
		add(checkButton);

		updateButton = new JButton("Update");
		updateButton.setBounds(240, 390, 100, 30);
		add(updateButton);

		checkButton.addActionListener(this);
		updateButton.addActionListener(this);

		setBounds(550, 200, 900, 500);
	}

	public void actionPerformed(ActionEvent evt) {
		switch (evt.getActionCommand()) {
			case "Check":
				checkInfo();
				break;

			case "Update":
				updateInfo();
				break;
		}

	}

	void checkInfo() {
		try {
			DBCon c = new DBCon();
			String roomNumString = roomNum.getText();
			String info = "select * from room where r_num='" + roomNumString + "'";
			ResultSet rs;
			if (roomNumString.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the Room number");
				// Disabling the textfields
				price.setEditable(false);
				cleaning.setVisible(false);
				avail.setVisible(false);
				bedType.setVisible(false);
				room.setVisible(false);
				// Setting the text fields
				roomNum.setText("");
				price.setText("");
				cleaning.setSelectedItem("");
				avail.setSelectedItem("");
				bedType.setSelectedItem("");
				room.setSelectedItem("");
				return;
			}
			rs = c.s.executeQuery(info);
			// Getting the corresponding values from the database
			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "Record not found");
				roomNum.setText("");
				// Disabling the textfields
				price.setEditable(false);
				cleaning.setVisible(false);
				avail.setVisible(false);
				bedType.setVisible(false);
				room.setVisible(false);
				// Setting the text fields
				roomNum.setText("");
				price.setText("");
				cleaning.setSelectedItem("");
				avail.setSelectedItem("");
				bedType.setSelectedItem("");
				room.setSelectedItem("");
				return;
			}
			while (rs.next()) {
				String roomNumStr = rs.getString("r_num");
				long priceLong = rs.getInt("price");
				String availabilty = rs.getString("availability");
				String cleaningStatus = rs.getString("cleaning_status");
				String roomType = rs.getString("type");
				String bedTypeStr = rs.getString("bed");

				// Enabling the textfields
				roomNum.setEditable(true);
				price.setEditable(true);
				cleaning.setVisible(true);
				avail.setVisible(true);
				bedType.setVisible(true);
				room.setVisible(true);
				// Setting the text fields
				roomNum.setText(roomNumStr);
				price.setText(Long.toString(priceLong));
				cleaning.setSelectedItem(cleaningStatus);
				avail.setSelectedItem(availabilty);
				bedType.setSelectedItem(bedTypeStr);
				room.setSelectedItem((roomType));
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			ex.printStackTrace();
		}
	}

	void updateInfo() {
		if(roomNum.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter the Room Number");
			// Disabling the textfields
			roomNum.setEditable(false);
			price.setEditable(false);
			cleaning.setVisible(false);
			avail.setVisible(false);
			bedType.setVisible(false);
			room.setVisible(false);
			// Setting the text fields
			roomNum.setText("");
			price.setText("");
			cleaning.setSelectedItem("");
			avail.setSelectedItem("");
			bedType.setSelectedItem("");
			room.setSelectedItem("");
			return;
		}

		try{
			String roomNumStr = roomNum.getText();
			long priceLong = Long.parseLong(price.getText());
			String availability = (String)avail.getSelectedItem();
			String cleaningStatus = (String)cleaning.getSelectedItem();
			String roomType = (String)room.getSelectedItem();
			String bedTypeStr = (String)bedType.getSelectedItem();
			DBCon db = new DBCon();
			// room number is PRIMARY KEY
			String str = "UPDATE room SET r_num ='" + roomNumStr + "', availability ='" + availability + "',cleaning_status ='" + cleaningStatus
					+ "', price=" + priceLong + ", type ='" + roomType + "', bed ='" + bedTypeStr + "' WHERE r_num = '" + roomNumStr+"'";
			db.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "Room details updated");
			dispose();
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			ex.printStackTrace();
	}
}
}
