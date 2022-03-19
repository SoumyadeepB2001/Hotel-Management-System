import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SearchCustomer extends JFrame implements ActionListener {
	JButton searchBut, clearBut;
	JPanel contentPane;

	public JLabel l1, nameLab, ageLab, genderLab, idLab, idNumLab, countryLab, phoneLab, roomNumLab, checkStatusLab,
			depositLab, checkInLab, checkOutLab;
	public JTextField name, age, idNum, country, phone, deposit, checkInTime, checkOutTime, roomNum;
	JComboBox<String> gender, IDDocs, checkStatusBox, ageComparison, checkIn, checkOut;
	String genders[] = { "Any", "Female", "Male", "Other" };
	String checkStatus[] = { "Checked-in", "Checked-out" };
	String ID[] = { "Any", "Aadhar Card", "Voter Card", "Passport", "Driver's License", "Work ID" };
	String ageCompare[] = { "=", "<", ">", "<=", ">=" };
	String checkInTimeCompare[] = { "=", "<", ">", "<=", ">=" };
	String checkOutTimeCompare[] = { "=", "<", ">", "<=", ">=" };

	public static void main(String[] args) {
		new SearchCustomer();
	}

	SearchCustomer() {
		this.setTitle("Search Customer");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		l1 = new JLabel("Search Customer");
		l1.setFont(new Font("Serif", Font.BOLD, 19));
		l1.setBounds(190, 25, 200, 30);
		add(l1);

		// Adding textfields and labels
		nameLab = new JLabel("Name");
		nameLab.setFont(new Font("Serif", Font.BOLD, 17));
		nameLab.setBounds(50, 80, 100, 30);
		add(nameLab);
		name = new JTextField();
		name.setBounds(190, 80, 260, 30);
		add(name);

		ageLab = new JLabel("Age");
		ageLab.setFont(new Font("Serif", Font.BOLD, 17));
		ageLab.setBounds(50, 130, 100, 30);
		add(ageLab);
		age = new JTextField();
		ageComparison = new JComboBox<>(ageCompare);
		ageComparison.setBounds(190, 130, 40, 30);
		add(ageComparison);
		age.setBounds(240, 130, 210, 30);
		add(age);

		genderLab = new JLabel("Gender");
		genderLab.setFont(new Font("Serif", Font.BOLD, 17));
		genderLab.setBounds(50, 180, 100, 30);
		add(genderLab);
		gender = new JComboBox<>(genders);
		gender.setBounds(190, 180, 260, 30);
		add(gender);

		idLab = new JLabel("ID");
		idLab.setFont(new Font("Serif", Font.BOLD, 17));
		idLab.setBounds(50, 230, 100, 30);
		add(idLab);
		IDDocs = new JComboBox<>(ID);
		IDDocs.setBounds(190, 230, 260, 30);
		add(IDDocs);

		idNumLab = new JLabel("ID Number");
		idNumLab.setFont(new Font("Serif", Font.BOLD, 17));
		idNumLab.setBounds(50, 280, 100, 30);
		add(idNumLab);
		idNum = new JTextField();
		idNum.setBounds(190, 280, 260, 30);
		add(idNum);

		countryLab = new JLabel("Country");
		countryLab.setFont(new Font("Serif", Font.BOLD, 17));
		countryLab.setBounds(50, 330, 100, 30);
		add(countryLab);
		country = new JTextField();
		country.setBounds(190, 330, 260, 30);
		add(country);

		phoneLab = new JLabel("Phone No.");
		phoneLab.setFont(new Font("Serif", Font.BOLD, 17));
		phoneLab.setBounds(50, 380, 100, 30);
		add(phoneLab);
		phone = new JTextField();
		phone.setBounds(190, 380, 260, 30);
		add(phone);

		roomNumLab = new JLabel("Room No.");
		roomNumLab.setFont(new Font("Serif", Font.BOLD, 17));
		roomNumLab.setBounds(50, 430, 100, 30);
		add(roomNumLab);
		roomNum = new JTextField();
		roomNum.setBounds(190, 430, 260, 30);
		add(roomNum);

		checkStatusLab = new JLabel("Status");
		checkStatusLab.setFont(new Font("Serif", Font.BOLD, 17));
		checkStatusLab.setBounds(50, 480, 100, 30);
		add(checkStatusLab);
		checkStatusBox = new JComboBox<>(checkStatus);
		checkStatusBox.setBounds(190, 480, 260, 30);
		add(checkStatusBox);
		checkStatusBox.addActionListener(this);

		checkInLab = new JLabel("Check-in Time");
		checkInLab.setFont(new Font("Serif", Font.BOLD, 17));
		checkInLab.setBounds(50, 530, 120, 30);
		add(checkInLab);
		checkIn = new JComboBox<>(checkInTimeCompare);
		checkIn.setBounds(190, 530, 40, 30);
		add(checkIn);
		checkInTime = new JTextField();
		checkInTime.setBounds(240, 530, 210, 30);
		add(checkInTime);
		checkInTime.setToolTipText("Time Format: yyyy-MM-dd HH:mm:ss");

		checkOutLab = new JLabel("Check-out Time");
		checkOutLab.setFont(new Font("Serif", Font.BOLD, 17));
		checkOutLab.setBounds(50, 580, 120, 30);
		add(checkOutLab);
		checkOut = new JComboBox<>(checkOutTimeCompare);
		checkOut.setBounds(190, 580, 40, 30);
		add(checkOut);
		checkOut.setVisible(false);
		checkOutTime = new JTextField();
		checkOutTime.setBounds(240, 580, 210, 30);
		add(checkOutTime);
		checkOutTime.setToolTipText("Time Format: yyyy-MM-dd HH:mm:ss");
		checkOutTime.setEditable(false);

		searchBut = new JButton("Search");
		searchBut.setBounds(110, 645, 100, 30);
		add(searchBut);
		searchBut.addActionListener(this);

		clearBut = new JButton("Clear");
		clearBut.setBounds(265, 645, 100, 30);
		add(clearBut);
		clearBut.addActionListener(this);

		setBounds(500, 50, 515, 730);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == clearBut) {
			clear();
		} else if (e.getSource() == searchBut) {
			search();
		} else {
			if (((String) checkStatusBox.getSelectedItem()).equals("Checked-out")) {
				checkOut.setVisible(true);
				checkOutTime.setEditable(true);
			} else {
				checkOut.setVisible(false);
				checkOutTime.setEditable(false);
			}

		}

	}

	void search() {
		String s = "", name = "", age = "", gender = "", ID = "", idNum = "", country = "", phone = "", room = "",
				checkIn = "", checkOut = "";
		int counter = 0;

		if (!this.name.getText().equals("")) {
			name = " name ='" + this.name.getText() + "'";
			counter++;
		}

		if (!this.age.getText().equals("")) {
			age = " age " + ageComparison.getSelectedItem() + " " + this.age.getText();
			counter++;
			if (counter > 1)
				age = " and " + age;
		}

		if (this.gender.getSelectedItem() != "Any") {
			gender = " gender = '" + (String) this.gender.getSelectedItem() + "'";
			counter++;
			if (counter > 1)
				gender = " and " + gender;
		}

		if (this.IDDocs.getSelectedItem() != "Any") {
			ID = " id= '" + (String) this.IDDocs.getSelectedItem() + "'";
			counter++;
			if (counter > 1)
				ID = " and " + ID;
		}

		if (!this.idNum.getText().equals("")) {
			idNum = " idnum ='" + this.idNum.getText() + "'";
			counter++;
			if (counter > 1)
				idNum = " and " + idNum;
		}

		if (!this.country.getText().equals("")) {
			country = " country ='" + this.country.getText() + "'";
			counter++;
			if (counter > 1)
				country = " and " + country;
		}

		if (!this.phone.getText().equals("")) {
			phone = " phone =" + this.phone.getText();
			counter++;
			if (counter > 1)
				phone = " and " + phone;
		}

		if (!this.roomNum.getText().equals("")) {
			room = " r_num ='" + this.roomNum.getText() + "'";
			counter++;
			if (counter > 1)
				room = " and " + room;
		}

		if (!this.checkInTime.getText().equals("")
				&& ((String) checkStatusBox.getSelectedItem()).equals("Checked-in")) {
			checkIn = " time " + this.checkIn.getSelectedItem() + " '" + this.checkInTime.getText() + "'";
			counter++;
			if (counter > 1)
				checkIn = " and " + checkIn;
		}

		if (((String) checkStatusBox.getSelectedItem()).equals("Checked-out")) {

			if (!this.checkInTime.getText().equals("")) {
				checkIn = " checkin_time " + this.checkIn.getSelectedItem() + " '" + this.checkInTime.getText() + "'";
				counter++;
				if (counter > 1)
					checkIn = " and " + checkIn;
			}

			if (!this.checkOutTime.getText().equals("")) {
				checkOut = " checkout_time " + this.checkOut.getSelectedItem() + " '" + this.checkOutTime.getText()
						+ "'";
				counter++;
				if (counter > 1) {
					checkOut = " and " + checkOut;
				}

			}

		}

		if (counter > 0) {
			if (((String) checkStatusBox.getSelectedItem()).equals("Checked-in")) {
				s = "select * from customer where" + name + age + gender + ID + idNum + country + phone + room
						+ checkIn;
				new SearchCustomerTable(s);
			}

			else {
				s = "select * from history where" + name + age + gender + ID + idNum + country + phone + room + checkIn
						+ checkOut;
				new SearchHistoryTable(s);
			}

		} else {

			if (((String) checkStatusBox.getSelectedItem()).equals("Checked-in")) {
				s = "select * from customer";
				new SearchCustomerTable(s);
			}

			else {
				s = "select * from history";
				new SearchHistoryTable(s);
			}
		}
	}

	void clear() {

	}
}