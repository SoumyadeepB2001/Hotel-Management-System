import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class UpdateEmployee extends JFrame implements ActionListener {
	JButton checkButton, updateButton;
	JPanel contentPane;
	public ImageIcon i1, i2;
	public Image i3;
	public JLabel l1, l2, nameLab, ageLab, genderLab, jobLab, salaryLab, eidLab, phoneLab, emailLab;
	public JTextField name, age, salary, eid, phone, email;
	final JComboBox<String> gender, job;
	String genders[] = { "Female", "Male", "Other" };
	String jobs[] = { "Front Desk Clerk", "Porter", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress",
			"Manager", "Accountant", "Chef", "Security", "Electrician", "Plumber" };

	public static void main(String[] args) {
		new UpdateEmployee();
	}

	UpdateEmployee() {
		this.setTitle("Update Employee Information");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		l2 = new JLabel("Update Employee Information");
		l2.setFont(new Font("Serif", Font.BOLD, 19));
		l2.setBounds(345, 25, 250, 30);
		add(l2);

		// Adding the image
		i1 = new ImageIcon(getClass().getResource("Employee.jpg"));
		i3 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		i2 = new ImageIcon(i3);
		l1 = new JLabel(i1);
		l1.setBounds(410, 80, 480, 410);
		contentPane.add(l1);

		// Adding textfields and labels
		eidLab = new JLabel("Employee ID");
		eidLab.setFont(new Font("Serif", Font.BOLD, 17));
		eidLab.setBounds(50, 80, 100, 30);
		add(eidLab);
		eid = new JTextField();
		eid.setBounds(170, 80, 210, 30);
		add(eid);

		nameLab = new JLabel("Name");
		nameLab.setFont(new Font("Serif", Font.BOLD, 17));
		nameLab.setBounds(50, 130, 100, 30);
		add(nameLab);
		name = new JTextField();
		name.setBounds(170, 130, 210, 30);
		add(name);
		name.setEditable(false);

		ageLab = new JLabel("Age");
		ageLab.setFont(new Font("Serif", Font.BOLD, 17));
		ageLab.setBounds(50, 180, 100, 30);
		add(ageLab);
		age = new JTextField();
		age.setBounds(170, 180, 210, 30);
		add(age);
		age.setEditable(false);

		genderLab = new JLabel("Gender");
		genderLab.setFont(new Font("Serif", Font.BOLD, 17));
		genderLab.setBounds(50, 230, 100, 30);
		add(genderLab);
		gender = new JComboBox<>(genders);
		gender.setBounds(170, 230, 210, 30);
		add(gender);
		gender.setVisible(false);

		jobLab = new JLabel("Job");
		jobLab.setFont(new Font("Serif", Font.BOLD, 17));
		jobLab.setBounds(50, 280, 100, 30);
		add(jobLab);
		job = new JComboBox<>(jobs);
		job.setBounds(170, 280, 210, 30);
		add(job);
		job.setVisible(false);

		salaryLab = new JLabel("Salary");
		salaryLab.setFont(new Font("Serif", Font.BOLD, 17));
		salaryLab.setBounds(50, 330, 100, 30);
		add(salaryLab);
		salary = new JTextField();
		salary.setBounds(170, 330, 210, 30);
		add(salary);
		salary.setEditable(false);

		phoneLab = new JLabel("Phone No.");
		phoneLab.setFont(new Font("Serif", Font.BOLD, 17));
		phoneLab.setBounds(50, 380, 100, 30);
		add(phoneLab);
		phone = new JTextField();
		phone.setBounds(170, 380, 210, 30);
		add(phone);
		phone.setEditable(false);

		emailLab = new JLabel("Email ID");
		emailLab.setFont(new Font("Serif", Font.BOLD, 17));
		emailLab.setBounds(50, 430, 100, 30);
		add(emailLab);
		email = new JTextField();
		email.setBounds(170, 430, 210, 30);
		add(email);
		email.setEditable(false);

		updateButton = new JButton("Update");
		updateButton.setBounds(240, 490, 100, 30);
		add(updateButton);

		checkButton = new JButton("Check");
		checkButton.setBounds(90, 490, 100, 30);
		add(checkButton);

		updateButton.addActionListener(this);
		checkButton.addActionListener(this);

		setBounds(550, 200, 940, 600);
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
			String eidString = eid.getText();
			String info;
			ResultSet rs;
			if (eidString.equals("")) { // Error message for when the eid is empty
				JOptionPane.showMessageDialog(null, "Please enter the Employee ID");
				// Disabling the textfields
				name.setEditable(false);
				age.setEditable(false);
				salary.setEditable(false);
				phone.setEditable(false);
				email.setEditable(false);
				gender.setVisible(false);
				job.setVisible(false);
				// Setting the text fields
				name.setText("");
				age.setText("");
				salary.setText("");
				gender.setSelectedItem("");
				job.setSelectedItem("");
				phone.setText("");
				email.setText("");
				return;
			}
			info = "select * from employee where eid=" + eidString;
			rs = c.s.executeQuery(info);

			// Getting the corresponding values from the database
			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "Record not found");
				eid.setText("");
				// Disabling the textfields
				name.setEditable(false);
				age.setEditable(false);
				salary.setEditable(false);
				phone.setEditable(false);
				email.setEditable(false);
				gender.setVisible(false);
				job.setVisible(false);
				// Setting the text fields
				name.setText("");
				age.setText("");
				salary.setText("");
				gender.setSelectedItem("");
				job.setSelectedItem("");
				phone.setText("");
				email.setText("");
				return;
			}
			while (rs.next()) {
				String nameStr = rs.getString("name");
				int ageInt = rs.getInt("age");
				int salaryInt = rs.getInt("salary");
				String genderStr = rs.getString("gender");
				String jobStr = rs.getString("job");
				long phoneLong = rs.getLong("phone");
				String emailStr = rs.getString("email");
				// Enabling the textfields
				name.setEditable(true);
				age.setEditable(true);
				salary.setEditable(true);
				phone.setEditable(true);
				email.setEditable(true);
				gender.setVisible(true);
				job.setVisible(true);
				// Setting the text fields
				name.setText(nameStr);
				age.setText(Integer.toString(ageInt));
				salary.setText(Integer.toString(salaryInt));
				gender.setSelectedItem(genderStr);
				job.setSelectedItem(jobStr);
				phone.setText(Long.toString(phoneLong));
				email.setText(emailStr);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			ex.printStackTrace();
		}
	}

	void updateInfo() {
		if (eid.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter Employee ID");
			// Disabling the textfields
			name.setEditable(false);
			age.setEditable(false);
			salary.setEditable(false);
			phone.setEditable(false);
			email.setEditable(false);
			gender.setVisible(false);
			job.setVisible(false);
			// Setting the text fields
			name.setText("");
			age.setText("");
			salary.setText("");
			gender.setSelectedItem("");
			job.setSelectedItem("");
			phone.setText("");
			email.setText("");
			return;
		}
		try {
			String nameStr = name.getText();
			int ageInt = Integer.parseInt(age.getText());
			int salaryInt = Integer.parseInt(salary.getText());
			long phoneLong = Long.parseLong(phone.getText());
			long eidLong = Long.parseLong(eid.getText());
			String emailStr = email.getText();
			String genderStr = (String) gender.getSelectedItem();
			String jobStr = (String) job.getSelectedItem();

			DBCon db = new DBCon();
			// eid is PRIMARY KEY
			String str = "UPDATE employee SET name ='" + nameStr + "', age =" + ageInt + ",gender ='" + genderStr
					+ "', job='" + jobStr + "', salary =" + salaryInt + ", phone=" + phoneLong + ",email ='" + emailStr
					+ "' WHERE eid = " + eidLong;
			db.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "Employee details updated");
			dispose();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			ex.printStackTrace();
		}
	}
}
