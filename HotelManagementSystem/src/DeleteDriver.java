import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class DeleteDriver extends JFrame implements ActionListener {
	JButton button;
	JPanel contentPane;
	public JLabel d_idLab;
	public JTextField d_id;

	public static void main(String[] args) {
		new DeleteDriver();
	}

	DeleteDriver() {
		this.setTitle("Delete Driver");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		d_idLab = new JLabel("Driver ID");
		d_idLab.setFont(new Font("Serif", Font.BOLD, 14));
		d_idLab.setBounds(50, 50, 100, 30);
		add(d_idLab);
		d_id = new JTextField();
		d_id.setBounds(170, 50, 210, 30);
		add(d_id);

		button = new JButton("Delete");
		button.setBounds(190, 100, 100, 30);
		add(button);

		button.addActionListener(this);

		setBounds(550, 200, 452, 200);
	}

	public void actionPerformed(ActionEvent e) {

		try {
			DBCon c = new DBCon();
			String d_idString = d_id.getText();

			String info = "select * from driver where d_id=" + d_idString;
			String delete = "DELETE FROM driver WHERE d_id=" + d_idString;
			ResultSet rs = c.s.executeQuery(info);

			// Getting the corresponding values from the database
			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "Record not found.");
				d_id.setText("");
			} else {
				while (rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					int salary = rs.getInt("salary");
					String gender = rs.getString("gender");
					String model = rs.getString("model");
					long phone = rs.getLong("phone");
					String plate = rs.getString("plate");
					String avail = rs.getString("avail");

					if (JOptionPane.showConfirmDialog(null,
							"Are you sure you want to delete this record?\nName: " + name + "\nAge: " + age
									+ "\nGender: "
									+ gender + "\nModel: " + model + "\nSalary: " + salary + "\nPlate: " + plate
									+ "\nPhone: " + phone + "\nAvailability: "
									+ avail,
							"WARNING",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						c.s.executeUpdate(delete);
						JOptionPane.showMessageDialog(null, "Record deleted.");
						// break out of the loop to avoid errors
						d_id.setText("");
						break;
					} else {
						d_id.setText("");
						break;
					}
				}
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Record not found.");
			ex.printStackTrace();
		}

	}
}
