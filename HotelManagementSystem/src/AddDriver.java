import javax.swing.*;
//import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class AddDriver extends JFrame implements ActionListener {
	JButton button;
	JPanel contentPane;
	public ImageIcon i1, i2;
	public Image i3;
	public JLabel l1, nameLab, ageLab, genderLab, companyLab, brandLab, availLab, phoneLab,salaryLab,didLab, plateLab;
	public JTextField name, age, salary, did, phone, comp, plate;
	JComboBox gender, available;
	String genders[] = { "Female", "Male", "Other" };
	String availablity[] = { "Yes", "No"};

	public static void main(String[] args) {
		new AddDriver();
	}

	AddDriver() {
		this.setTitle("Add Driver");
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

		companyLab = new JLabel("MODEL");
		companyLab.setFont(new Font("Serif", Font.BOLD, 17));
		companyLab.setBounds(50, 230, 100, 30);
		add(companyLab);
		comp=new JTextField();
		comp.setBounds(170, 230, 210, 30);
		add(comp);

		salaryLab = new JLabel("SALARY");
		salaryLab.setFont(new Font("Serif", Font.BOLD, 17));
		salaryLab.setBounds(50, 280, 100, 30);
		add(salaryLab);
		salary = new JTextField();
		salary.setBounds(170, 280, 210, 30);
		add(salary);

		didLab = new JLabel("DRIVER ID");
		didLab.setFont(new Font("Serif", Font.BOLD, 17));
		didLab.setBounds(50, 330, 100, 30);
		add(didLab);
		did = new JTextField();
		did.setBounds(170, 330, 210, 30);
		add(did);

		plateLab = new JLabel("PLATE NO.");
		plateLab.setFont(new Font("Serif", Font.BOLD, 17));
		plateLab.setBounds(50, 380, 100, 30);
		add(plateLab);
		plate = new JTextField();
		plate.setBounds(170, 380, 210, 30);
		add(plate);



		phoneLab = new JLabel("PHONE");
		phoneLab.setFont(new Font("Serif", Font.BOLD, 17));
		phoneLab.setBounds(50, 430, 100, 30);
		add(phoneLab);
		phone = new JTextField();
		phone.setBounds(170, 430, 210, 30);
		add(phone);

		availLab = new JLabel("AVAILABLE");
		availLab.setFont(new Font("Serif", Font.BOLD, 17));
		availLab.setBounds(50, 480, 100, 30);
		add(availLab);
		available = new JComboBox(availablity);
		available.setBounds(170, 480,210,30);
		add(available);

		button = new JButton("SAVE");
		button.setBounds(190, 550, 100, 30);
		add(button);

		button.addActionListener(this);

		setBounds(550, 200, 940, 650);
	}

	public void actionPerformed(ActionEvent e) {
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
		// eid is PRIMARY KEY
		String str = "INSERT INTO driver values( '" + didLong + "', '" + nameStr + "', '" + ageInt + "','"
				+ genderStr + "', '" + modelStr + "', '" + salaryInt + "','" + plateStr + "', '" + phoneLong
				+ "', '"+availStr+"')";

		try {

			db.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "New Driver added");
			setVisible(false);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "FATAL ERROR!");
			ex.printStackTrace();
		}
		
	}
}
