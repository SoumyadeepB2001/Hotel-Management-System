import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class DeleteEmployee extends JFrame implements ActionListener {
	JButton button;
	JPanel contentPane;
	public JLabel eidLab;
	public JTextField eid;

	public static void main(String[] args) {
		new DeleteEmployee();
	}

	DeleteEmployee() {
		this.setTitle("Delete Employee");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		eidLab = new JLabel("Employee ID");
		eidLab.setFont(new Font("Serif", Font.BOLD, 14));
		eidLab.setBounds(50, 50, 100, 30);
		add(eidLab);
		eid = new JTextField();
		eid.setBounds(170, 50, 210, 30);
		add(eid);

		button = new JButton("Delete");
		button.setBounds(190, 100, 100, 30);
		add(button);

		button.addActionListener(this);

		setBounds(550, 200, 452, 200);
	}

	public void actionPerformed(ActionEvent e) {

		try {
			DBCon c = new DBCon();
			String eidString = eid.getText();

			String info = "select * from employee where eid=" + eidString;
			String delete = "DELETE FROM employee WHERE eid=" + eidString;
			ResultSet rs = c.s.executeQuery(info);

			// Getting the corresponding values from the database
			if (!rs.isBeforeFirst() ) {    
				JOptionPane.showMessageDialog(null,"Record not found.");   
				eid.setText("");
			}  else {
				while (rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					int salary = rs.getInt("salary");
					String gender = rs.getString("gender");
					String job = rs.getString("job");
					long phone = rs.getLong("phone");
					String email = rs.getString("email");

					if (JOptionPane.showConfirmDialog(null,
							"Are you sure you want to delete this record?\nName: " + name + "\nAge: " + age
									+ "\nGender: "
									+ gender + "\nJob: " + job + "\nSalary: " + salary + "\nPhone: " + phone
									+ "\nEmail: "
									+ email,
							"WARNING",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						c.s.executeUpdate(delete);
						JOptionPane.showMessageDialog(null, "Record deleted.");
						// break out of the loop to avoid errors
						eid.setText("");
						break;
					} else {
						eid.setText("");
						break;
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
