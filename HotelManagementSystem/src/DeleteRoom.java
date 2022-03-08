import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class DeleteRoom extends JFrame implements ActionListener {
	JButton button;
	JPanel contentPane;
	public JLabel r_numLab;
	public JTextField r_num;

	public static void main(String[] args) {
		new DeleteRoom();
	}

	DeleteRoom() {
		this.setTitle("Delete Room");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		r_numLab = new JLabel("Room No.");
		r_numLab.setFont(new Font("Serif", Font.BOLD, 14));
		r_numLab.setBounds(50, 50, 100, 30);
		add(r_numLab);
		r_num = new JTextField();
		r_num.setBounds(170, 50, 210, 30);
		add(r_num);

		button = new JButton("Delete");
		button.setBounds(190, 100, 100, 30);
		add(button);

		button.addActionListener(this);

		setBounds(550, 200, 452, 200);
	}

	public void actionPerformed(ActionEvent e) {

		try {
			DBCon c = new DBCon();
			String r_numString = r_num.getText();
			String info = "select * from room where r_num='" + r_numString + "'";
			String delete = "DELETE FROM room WHERE r_num='" + r_numString + "'";
			ResultSet rs = c.s.executeQuery(info);
			// Getting the corresponding values from the database
			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "Record not found.");
				r_num.setText("");
			} else {
				while (rs.next()) {
					String roomNum = rs.getString("r_num");
					long price = rs.getInt("price");
					String availability = rs.getString("availability");
					String cleaningStatus = rs.getString("cleaning_status");
					String roomType = rs.getString("type");
					String bedType = rs.getString("bed");

					if (JOptionPane.showConfirmDialog(null,
							"Are you sure you want to delete this record?\nRoom Number: " + roomNum + "\nAvailability: "
									+ availability
									+ "\nCleaning Status: "
									+ cleaningStatus + "\nPrice: " + price + "\nRoom Type: " + roomType + "\nBed Type: "
									+ bedType,
							"WARNING",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						c.s.executeUpdate(delete);
						JOptionPane.showMessageDialog(null, "Record deleted.");
						// break out of the loop to avoid errors
						r_num.setText("");
						break;
					} else {
						r_num.setText("");
						break;
					}
				}
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERROR!");
			ex.printStackTrace();
		}

	}
}
