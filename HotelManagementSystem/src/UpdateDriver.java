import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class UpdateDriver extends JFrame implements ActionListener {
	JButton checkButton, updateButton;
	JPanel contentPane;
	public ImageIcon i1, i2;
	public Image i3;
	public JLabel l1, l2, nameLab, ageLab, genderLab, companyLab, brandLab, availLab, phoneLab, salaryLab, didLab,
			plateLab;
	public JTextField name, age, salary, did, phone, comp, plate;
	JComboBox<String> gender, available;
	String genders[] = { "Female", "Male", "Other" };
	String availablity[] = { "Yes", "No" };

	public static void main(String[] args) {
		new UpdateDriver();
	}

	UpdateDriver() {
		this.setTitle("Update Driver Details");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Adding the image
		i1 = new ImageIcon(getClass().getResource("Employee.jpg"));
		i3 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		i2 = new ImageIcon(i3);
		l1 = new JLabel(i1);
		l1.setBounds(410, 80, 480, 410);
		contentPane.add(l1);

		l2 = new JLabel("Update Driver Details");
		l2.setFont(new Font("Serif", Font.BOLD, 19));
		l2.setBounds(400, 25, 200, 30);
		add(l2);
		// Adding textfields and labels
		didLab = new JLabel("Driver ID");
		didLab.setFont(new Font("Serif", Font.BOLD, 17));
		didLab.setBounds(50, 80, 100, 30);
		add(didLab);
		did = new JTextField();
		did.setBounds(170, 80, 210, 30);
		add(did);

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

		companyLab = new JLabel("Model");
		companyLab.setFont(new Font("Serif", Font.BOLD, 17));
		companyLab.setBounds(50, 280, 100, 30);
		add(companyLab);
		comp = new JTextField();
		comp.setBounds(170, 280, 210, 30);
		add(comp);
		comp.setEditable(false);

		salaryLab = new JLabel("Salary");
		salaryLab.setFont(new Font("Serif", Font.BOLD, 17));
		salaryLab.setBounds(50, 330, 100, 30);
		add(salaryLab);
		salary = new JTextField();
		salary.setBounds(170, 330, 210, 30);
		add(salary);
		salary.setEditable(false);

		plateLab = new JLabel("Plate No.");
		plateLab.setFont(new Font("Serif", Font.BOLD, 17));
		plateLab.setBounds(50, 380, 100, 30);
		add(plateLab);
		plate = new JTextField();
		plate.setBounds(170, 380, 210, 30);
		add(plate);
		plate.setEditable(false);

		phoneLab = new JLabel("Phone No.");
		phoneLab.setFont(new Font("Serif", Font.BOLD, 17));
		phoneLab.setBounds(50, 430, 100, 30);
		add(phoneLab);
		phone = new JTextField();
		phone.setBounds(170, 430, 210, 30);
		add(phone);
		phone.setEditable(false);

		availLab = new JLabel("Available");
		availLab.setFont(new Font("Serif", Font.BOLD, 17));
		availLab.setBounds(50, 480, 100, 30);
		add(availLab);
		available = new JComboBox<>(availablity);
		available.setBounds(170, 480, 210, 30);
		add(available);
		available.setVisible(false);

		updateButton = new JButton("Update");
		updateButton.setBounds(240, 550, 100, 30);
		add(updateButton);

		checkButton = new JButton("Check");
		checkButton.setBounds(90, 550, 100, 30);
		add(checkButton);

		updateButton.addActionListener(this);
		checkButton.addActionListener(this);

		setBounds(550, 200, 940, 650);
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
			String didStr = did.getText();
			String info;
			ResultSet rs;
			if (didStr.equals("")) { // Error message for when the eid is empty
				JOptionPane.showMessageDialog(null, "Please enter the Driver ID");
				// Disabling the textfields
				name.setEditable(false);
				age.setEditable(false);
				salary.setEditable(false);
				phone.setEditable(false);
				comp.setEditable(false);
				plate.setEditable(false);
				gender.setVisible(false);
				available.setVisible(false);
				// Setting the text fields
				name.setText("");
				age.setText("");
				salary.setText("");
				comp.setText("");
				gender.setSelectedItem("");
				phone.setText("");
				plate.setText("");
				available.setSelectedItem("");
			} else {
				info = "select * from driver where d_id=" + didStr;
				rs = c.s.executeQuery(info);

				// Getting the corresponding values from the database
				if (!rs.isBeforeFirst()) {
					JOptionPane.showMessageDialog(null, "Record not found");
					did.setText("");
					// Disabling the textfields
					name.setEditable(false);
					age.setEditable(false);
					salary.setEditable(false);
					phone.setEditable(false);
					comp.setEditable(false);
					plate.setEditable(false);
					gender.setVisible(false);
					available.setVisible(false);
					// Setting the text fields
					name.setText("");
					age.setText("");
					salary.setText("");
					comp.setText("");
					gender.setSelectedItem("");
					phone.setText("");
					plate.setText("");
					available.setSelectedItem("");
				} else {
					while (rs.next()) {
						String nameStr = rs.getString("name");
						int ageInt = rs.getInt("age");
						int salaryInt = rs.getInt("salary");
						String genderStr = rs.getString("gender");
						String modelStr = rs.getString("model");
						long phoneLong = rs.getLong("phone");
						String plateStr = rs.getString("plate");
						String availStr = rs.getString("avail");
						// Enabling the textfields
						name.setEditable(true);
						age.setEditable(true);
						salary.setEditable(true);
						phone.setEditable(true);
						comp.setEditable(true);
						plate.setEditable(true);
						gender.setVisible(true);
						available.setVisible(true);
						// Setting the text fields
						name.setText(nameStr);
						age.setText(Integer.toString(ageInt));
						salary.setText(Integer.toString(salaryInt));
						comp.setText(modelStr);
						gender.setSelectedItem(genderStr);
						phone.setText(Long.toString(phoneLong));
						plate.setText(plateStr);
						available.setSelectedItem(availStr);
					}
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			ex.printStackTrace();
		}
	}

	void updateInfo() {
		if (did.getText().equals("")) { // Error message for when the eid is empty
			JOptionPane.showMessageDialog(null, "Please enter the Driver ID");
			// Disabling the textfields
			name.setEditable(false);
			age.setEditable(false);
			salary.setEditable(false);
			phone.setEditable(false);
			comp.setEditable(false);
			plate.setEditable(false);
			gender.setVisible(false);
			available.setVisible(false);
			// Setting the text fields
			name.setText("");
			age.setText("");
			salary.setText("");
			comp.setText("");
			gender.setSelectedItem("");
			phone.setText("");
			plate.setText("");
			available.setSelectedItem("");
		} else {
			try {
				String nameStr = name.getText();
				String plateStr = plate.getText();
				int ageInt = Integer.parseInt(age.getText());
				int salaryInt = Integer.parseInt(salary.getText());
				long phoneLong = Long.parseLong(phone.getText());
				long didLong = Long.parseLong(did.getText());
				String genderStr = (String) gender.getSelectedItem();
				String availStr = (String) available.getSelectedItem();
				String modelStr = comp.getText();

				DBCon db = new DBCon();
				// did is PRIMARY KEY
				String str = "UPDATE driver SET name ='" + nameStr + "', age =" + ageInt + ",gender ='" + genderStr
						+ "', model='" + modelStr + "', salary =" + salaryInt + ", phone=" + phoneLong + ", plate='"
						+ plateStr + "', avail ='" + availStr + "' WHERE d_id = " + didLong;
				db.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Driver details updated");
				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				ex.printStackTrace();
			}
		}
	}
}
