import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.*;
import java.awt.*;

public class CheckOut extends JFrame implements ActionListener {
	JButton check, checkOut;
	JPanel contentPane;
	public JLabel c_idLab, r_numLab, pendingLab, nameLab;
	public JTextField name, c_id, r_num, pending;

	public static void main(String[] args) {
		new CheckOut();
	}

	CheckOut() {
		this.setTitle("Check Out");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		c_idLab = new JLabel("Customer ID");
		c_idLab.setFont(new Font("Serif", Font.BOLD, 14));
		c_idLab.setBounds(50, 50, 100, 30);
		add(c_idLab);
		c_id = new JTextField();
		c_id.setBounds(170, 50, 210, 30);
		add(c_id);

		r_numLab = new JLabel("Room No.");
		r_numLab.setFont(new Font("Serif", Font.BOLD, 14));
		r_numLab.setBounds(50, 100, 100, 30);
		add(r_numLab);
		r_num = new JTextField();
		r_num.setBounds(170, 100, 210, 30);
		add(r_num);
		r_num.setEditable(false);

		nameLab = new JLabel("Name");
		nameLab.setFont(new Font("Serif", Font.BOLD, 14));
		nameLab.setBounds(50, 150, 100, 30);
		add(nameLab);
		name = new JTextField();
		name.setBounds(170, 150, 210, 30);
		add(name);
		name.setEditable(false);

		pendingLab = new JLabel("Pending (₹)");
		pendingLab.setFont(new Font("Serif", Font.BOLD, 14));
		pendingLab.setBounds(50, 200, 100, 30);
		add(pendingLab);
		pending = new JTextField();
		pending.setBounds(170, 200, 210, 30);
		add(pending);
		pending.setEditable(false);

		check = new JButton("Check");
		check.setBounds(90, 260, 100, 30);
		add(check);

		checkOut = new JButton("Check Out");
		checkOut.setBounds(250, 260, 100, 30);
		add(checkOut);

		check.addActionListener(this);
		checkOut.addActionListener(this);

		setBounds(550, 200, 452, 340);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
			case "Check":
				check();
				break;

			case "Check Out":
				checkOut();
				break;

		}
	}

	void check() {
		try {
			DBCon c = new DBCon();
			String c_idStr = c_id.getText();
			String info;
			ResultSet rs, rs2;
			if (c_idStr.equals("")) { // Error message for when the customer id field is empty
				JOptionPane.showMessageDialog(null, "Please enter the Customer ID");

				// Setting the text fields
				name.setText("");
				r_num.setText("");
				pending.setText("");
				return;
			}
			info = "select * from customer where idnum= '" + c_idStr + "'";
			rs = c.s.executeQuery(info);

			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "Record not found");
				c_id.setText("");

				// Setting the text fields
				name.setText("");
				r_num.setText("");
				pending.setText("");
				return;
			}

			while (rs.next()) {
				String nameStr = rs.getString("name");
				int depositInt = rs.getInt("deposit");
				String roomNumStr = rs.getString("r_num");

				// Setting the textfields
				name.setText(nameStr);
				r_num.setText(roomNumStr);
				pending.setText("");

				String roomPrice = "SELECT * FROM room WHERE r_num= '" + r_num.getText() + "'";
				rs2 = c.s2.executeQuery(roomPrice);
				while (rs2.next()) {
					long priceLong = rs2.getLong("price");
					priceLong = priceLong - depositInt;
					pending.setText(Long.toString(priceLong));
				}

			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			ex.printStackTrace();
		}
	}

	void checkOut() {
		String nameStr, genderStr, countryStr, roomNumStr, idStr, idNumStr, checkin_time, checkout_time, str;
		int ageInt;
		long phoneLong;

		if (c_id.getText().equals("") || name.getText().equals("") || r_num.getText().equals("")
				|| pending.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please fill all the details");

			// Setting the text fields
			name.setText("");
			c_id.setText("");
			r_num.setText("");
			pending.setText("");
			return;
		}
		try {
			// Getting the customer details from customer table
			if (Integer.parseInt(pending.getText()) > 0) {
				JOptionPane.showMessageDialog(null, "Clear the pending dues before proceeding");
				return;
			}

			DBCon c2 = new DBCon();
			String info = "SELECT * FROM customer WHERE idnum = '" + c_id.getText() + "'";
			ResultSet rs = c2.s.executeQuery(info);

			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "Record not found");
				name.setText("");
				c_id.setText("");
				r_num.setText("");
				pending.setText("");
				return;
			}
			while (rs.next()) {
				nameStr = rs.getString("name");
				ageInt = rs.getInt("age");
				genderStr = rs.getString("gender");
				countryStr = rs.getString("country");
				phoneLong = rs.getLong("phone");
				roomNumStr = rs.getString("r_num");
				idStr = rs.getString("id");
				idNumStr = rs.getString("idnum");
				checkin_time = rs.getString("time");
				checkout_time = currentTime();

				try {
					DBCon db = new DBCon();
					// Updating the history table
					str = "INSERT INTO history values( '" + nameStr + "', " + ageInt + ", '" + genderStr + "','"
							+ idStr + "', '" + idNumStr + "', '" + countryStr + "'," + phoneLong + ", '" + roomNumStr
							+ "', '" + checkin_time + "', '" + checkout_time + "')";
					db.s.executeUpdate(str);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			try {
				DBCon db2 = new DBCon();
				// Set the current room as available
				db2.s.executeUpdate(
						"UPDATE room SET availability = 'Available' WHERE r_num = '" + r_num.getText() + "'");
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			ex.printStackTrace();
		}

		try {
			// Deleting the customer details from list of checked-in customers
			DBCon db3 = new DBCon();
			db3.s.executeUpdate("DELETE FROM customer WHERE idnum='" + c_id.getText() + "'");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		dispose();
	}

	String currentTime() {
		// returns the current system time as a String
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		return formattedDate;
	}
}
