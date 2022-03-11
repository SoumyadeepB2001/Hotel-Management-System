import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewCustomerForm extends JFrame implements ActionListener {
	JButton button;
	JPanel contentPane;
	public ImageIcon i1, i2;
	public Image i3;
	public JLabel l1, l2, nameLab, ageLab, genderLab, idLab, idNumLab, countryLab, phoneLab, roomNumLab, checkInLab,
			depositLab, timeLab;
	public JTextField name, age, idNum, country, phone, deposit, time;
	JComboBox<String> gender, IDDocs, checkedIn;
	Choice roomNum; //To get the currently available rooms.
	String genders[] = { "Female", "Male", "Other" };
	String yes_no[] = { "Yes", "No" };
	String ID[] = { "Aadhar Card", "Voter Card", "Passport", "Driver's License", "Work ID" };

	public static void main(String[] args) {
		new NewCustomerForm();
	}

	NewCustomerForm() {
		this.setTitle("Add New Customer");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		l2 = new JLabel("New Customer Form");
		l2.setFont(new Font("Serif", Font.BOLD, 19));
		l2.setBounds(400, 25, 200, 30);
		add(l2);

		// Adding the image
		i1 = new ImageIcon(getClass().getResource("Employee.jpg"));
		i3 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		i2 = new ImageIcon(i3);
		l1 = new JLabel(i1);
		l1.setBounds(410, 80, 480, 410);
		contentPane.add(l1);

		// Adding textfields and labels
		nameLab = new JLabel("Name");
		nameLab.setFont(new Font("Serif", Font.BOLD, 17));
		nameLab.setBounds(50, 80, 100, 30);
		add(nameLab);
		name = new JTextField();
		name.setBounds(170, 80, 210, 30);
		add(name);

		ageLab = new JLabel("Age");
		ageLab.setFont(new Font("Serif", Font.BOLD, 17));
		ageLab.setBounds(50, 130, 100, 30);
		add(ageLab);
		age = new JTextField();
		age.setBounds(170, 130, 210, 30);
		add(age);

		genderLab = new JLabel("Gender");
		genderLab.setFont(new Font("Serif", Font.BOLD, 17));
		genderLab.setBounds(50, 180, 100, 30);
		add(genderLab);
		gender = new JComboBox<>(genders);
		gender.setBounds(170, 180, 210, 30);
		add(gender);

		idLab = new JLabel("ID");
		idLab.setFont(new Font("Serif", Font.BOLD, 17));
		idLab.setBounds(50, 230, 100, 30);
		add(idLab);
		IDDocs = new JComboBox<>(ID);
		IDDocs.setBounds(170, 230, 210, 30);
		add(IDDocs);

		idNumLab = new JLabel("ID Number");
		idNumLab.setFont(new Font("Serif", Font.BOLD, 17));
		idNumLab.setBounds(50, 280, 100, 30);
		add(idNumLab);
		idNum = new JTextField();
		idNum.setBounds(170, 280, 210, 30);
		add(idNum);

		countryLab = new JLabel("Country");
		countryLab.setFont(new Font("Serif", Font.BOLD, 17));
		countryLab.setBounds(50, 330, 100, 30);
		add(countryLab);
		country = new JTextField();
		country.setBounds(170, 330, 210, 30);
		add(country);

		phoneLab = new JLabel("Phone No.");
		phoneLab.setFont(new Font("Serif", Font.BOLD, 17));
		phoneLab.setBounds(50, 380, 100, 30);
		add(phoneLab);
		phone = new JTextField();
		phone.setBounds(170, 380, 210, 30);
		add(phone);

		roomNumLab = new JLabel("Room No.");
		roomNumLab.setFont(new Font("Serif", Font.BOLD, 17));
		roomNumLab.setBounds(50, 430, 100, 30);
		add(roomNumLab);
		roomNum = new Choice();
		try{
			DBCon c = new DBCon();
			ResultSet rs = c.s.executeQuery("SELECT * FROM room WHERE availability = 'Available'"); //Fetches the list of currently available rooms
			while(rs.next()){
				roomNum.add(rs.getString("r_num"));    
			}
		}catch(Exception ex){ 
			ex.printStackTrace();
		}
		roomNum.setBounds(170, 430, 210, 30);
		add(roomNum);

		checkInLab = new JLabel("Checked In");
		checkInLab.setFont(new Font("Serif", Font.BOLD, 17));
		checkInLab.setBounds(50, 480, 100, 30);
		add(checkInLab);
		checkedIn = new JComboBox<>(yes_no);
		checkedIn.setBounds(170, 480, 210, 30);
		add(checkedIn);

		timeLab = new JLabel("Time");
		timeLab.setFont(new Font("Serif", Font.BOLD, 17));
		timeLab.setBounds(50, 530, 100, 30);
		add(timeLab);
		time = new JTextField(currentTime()); // Here we call the currentTime() to show the current time on this
												// textfield
		time.setBounds(170, 530, 210, 30);
		add(time);
		time.setToolTipText("Time Format: yyyy-MM-dd HH:mm:ss");

		depositLab = new JLabel("Deposit");
		depositLab.setFont(new Font("Serif", Font.BOLD, 17));
		depositLab.setBounds(50, 580, 100, 30);
		add(depositLab);
		deposit = new JTextField();
		deposit.setBounds(170, 580, 210, 30);
		add(deposit);

		button = new JButton("Save");
		button.setBounds(190, 630, 100, 30);
		add(button);

		button.addActionListener(this);

		setBounds(500, 50, 940, 710);
	}

	String currentTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		return formattedDate;
	}

	public void actionPerformed(ActionEvent e) {

		try {
			String nameStr = name.getText();
			int ageInt = Integer.parseInt(age.getText());
			int depositInt = Integer.parseInt(deposit.getText());
			String roomNUmStr = (String) roomNum.getSelectedItem();
			long phoneLong = Long.parseLong(phone.getText());
			String countryStr = country.getText();
			String idNumStr = idNum.getText();
			String checkInStr = (String) checkedIn.getSelectedItem();
			String genderStr = (String) gender.getSelectedItem();
			String timeStr = time.getText();
			String idStr = (String) IDDocs.getSelectedItem();

			DBCon db = new DBCon();
			// idNum is PRIMARY KEY
			String str = "INSERT INTO customer values( '" + nameStr + "', " + ageInt + ", '" + genderStr + "','"
					+ idStr + "', '" + idNumStr + "', '" + countryStr + "'," + phoneLong + ", '" + roomNUmStr
					+ "', '" + checkInStr + "', '" + timeStr + "', '" + depositInt + "')";

			db.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "New customer added.");
			setVisible(false);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex+"\nFill all the details");
			ex.printStackTrace();
		}

	}
}