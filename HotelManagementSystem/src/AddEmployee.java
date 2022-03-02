import javax.swing.*;
//import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class AddEmployee extends JFrame implements ActionListener {
	JButton button;
	JPanel contentPane;
	public ImageIcon i1, i2;
	public Image i3;
	public JLabel l1, nameLab, ageLab, genderLab, jobLab, salaryLab, eidLab, phoneLab, emailLab;
	public JTextField name, age, salary, eid, phone, email;
	JComboBox gender, job;
	String genders[] = { "Female", "Male", "Other" };
	String jobs[] = { "Front Desk Clerk", "Porter", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress",
			"Manager", "Accountant", "Chef", "Security", "Electrician", "Plumber" };

	public static void main(String[] args) {
		new AddEmployee();
	}

	AddEmployee() {
		this.setTitle("Add Employee");
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

		// Adding textfields and labels
		nameLab = new JLabel("NAME");
		nameLab.setFont(new Font("Serif", Font.BOLD, 17));
		nameLab.setBounds(50, 80, 100, 30);
		add(nameLab);
		name = new JTextField();
		name.setBounds(170, 80, 210, 30);
		add(name);

		ageLab = new JLabel("AGE");
		ageLab.setFont(new Font("Serif", Font.BOLD, 17));
		ageLab.setBounds(50, 130, 100, 30);
		add(ageLab);
		age = new JTextField();
		age.setBounds(170, 130, 210, 30);
		add(age);

		genderLab = new JLabel("GENDER");
		genderLab.setFont(new Font("Serif", Font.BOLD, 17));
		genderLab.setBounds(50, 180, 100, 30);
		add(genderLab);
		gender = new JComboBox(genders);
		gender.setBounds(170, 180, 210, 30);
		add(gender);

		jobLab = new JLabel("JOB");
		jobLab.setFont(new Font("Serif", Font.BOLD, 17));
		jobLab.setBounds(50, 230, 100, 30);
		add(jobLab);
		job = new JComboBox(jobs);
		job.setBounds(170, 230, 210, 30);
		add(job);

		salaryLab = new JLabel("SALARY");
		salaryLab.setFont(new Font("Serif", Font.BOLD, 17));
		salaryLab.setBounds(50, 280, 100, 30);
		add(salaryLab);
		salary = new JTextField();
		salary.setBounds(170, 280, 210, 30);
		add(salary);

		eidLab = new JLabel("EMPLOYEE ID");
		eidLab.setFont(new Font("Serif", Font.BOLD, 14));
		eidLab.setBounds(50, 330, 100, 30);
		add(eidLab);
		eid = new JTextField();
		eid.setBounds(170, 330, 210, 30);
		add(eid);

		phoneLab = new JLabel("PHONE");
		phoneLab.setFont(new Font("Serif", Font.BOLD, 17));
		phoneLab.setBounds(50, 380, 100, 30);
		add(phoneLab);
		phone = new JTextField();
		phone.setBounds(170, 380, 210, 30);
		add(phone);

		emailLab = new JLabel("EMAIL");
		emailLab.setFont(new Font("Serif", Font.BOLD, 17));
		emailLab.setBounds(50, 430, 100, 30);
		add(emailLab);
		email = new JTextField();
		email.setBounds(170, 430, 210, 30);
		add(email);

		button = new JButton("SAVE");
		button.setBounds(190, 490, 100, 30);
		add(button);

		button.addActionListener(this);

		setBounds(550, 200, 940, 600);
	}

	public void actionPerformed(ActionEvent e) {
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
		String str = "INSERT INTO employee values( '" + eidLong + "', '" + nameStr + "', '" + ageInt + "','"
				+ genderStr + "', '" + jobStr + "', '" + salaryInt + "','" + phoneLong + "', '" + emailStr
				+ "')";

		try {

			db.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "New employee added");
			setVisible(false);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERROR!");
			ex.printStackTrace();
		}
		
	}
}
