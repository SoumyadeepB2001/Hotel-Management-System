import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SearchRoom extends JFrame implements ActionListener {
	JButton backBut, searchBut;
	JTable table;
	JPanel contentPane;
	JScrollPane scroll;
	JLabel l1, l2, l3, l4, l5, l6, availabilityLab, cleanStatusLab, priceLab, roomTypeLab, bedTypeLab;
	JComboBox<String> cleaning, avail, bedType, room, price;
	String availability[] = { "Any", "Available", "Unavailable" };
	String clean[] = { "Any", "Clean", "Not cleaned" };
	String types[] = { "Any", "Single", "Suite" };
	String beds[] = { "Any", "Single", "Double", "Queen", "King" };
	String prices[] = { "Any", "price <= 1000", "price >= 1000 and price <= 2000", "price >= 2000 and price <= 3000",
			"price >= 3000 and price <= 5000", "price >= 5000 and price <= 7000", "price >= 7000 and price <= 10000",
			"price >=10000" };

	SearchRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Search Rooms");
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		availabilityLab = new JLabel("Availability");
		availabilityLab.setBounds(12, 20, 60, 32);
		contentPane.add(availabilityLab);
		avail = new JComboBox<>(availability);
		avail.setBounds(79, 20, 100, 32);
		contentPane.add(avail);

		cleanStatusLab = new JLabel("Cleaning");
		cleanStatusLab.setBounds(189, 20, 60, 32);
		contentPane.add(cleanStatusLab);
		cleaning = new JComboBox<>(clean);
		cleaning.setBounds(244, 20, 100, 32);
		contentPane.add(cleaning);

		priceLab = new JLabel("Price");
		priceLab.setBounds(354, 20, 60, 32);
		contentPane.add(priceLab);
		price = new JComboBox<>(prices);
		price.setBounds(390, 20, 218, 32);
		contentPane.add(price);

		roomTypeLab = new JLabel("Room Type");
		roomTypeLab.setBounds(618, 20, 67, 32);
		contentPane.add(roomTypeLab);
		room = new JComboBox<>(types);
		room.setBounds(688, 20, 60, 32);
		contentPane.add(room);

		bedTypeLab = new JLabel("Bed Type");
		bedTypeLab.setBounds(756, 20, 75, 32);
		contentPane.add(bedTypeLab);
		bedType = new JComboBox<>(beds);
		bedType.setBounds(816, 20, 67, 32);
		contentPane.add(bedType);

		searchBut = new JButton("Search");
		searchBut.addActionListener(this);
		searchBut.setBounds(891, 20, 80, 32);
		contentPane.add(searchBut);

		backBut = new JButton("Back");
		backBut.addActionListener(this);
		backBut.setBounds(405, 710, 86, 32);
		contentPane.add(backBut);

		l1 = new JLabel("Room No.");
		l1.setBounds(12, 75, 100, 15);
		contentPane.add(l1);
		l2 = new JLabel("Availability");
		l2.setBounds(172, 75, 100, 15);
		contentPane.add(l2);
		l3 = new JLabel("Cleaning Status");
		l3.setBounds(332, 75, 100, 15);
		contentPane.add(l3);
		l4 = new JLabel("Price");
		l4.setBounds(492, 75, 100, 15);
		contentPane.add(l4);
		l5 = new JLabel("Room Type");
		l5.setBounds(652, 75, 100, 15);
		contentPane.add(l5);
		l6 = new JLabel("Bed Type");
		l6.setBounds(812, 75, 100, 15);
		contentPane.add(l6);

		setBounds(450, 15, 1000, 800); // setBounds should be at the last

	}

	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand()) {
			case "Back":
				dispose();
				break;

			case "Search":
				search();
				break;
		}
	}

	void search() {

		String s = "", cleaning = "", avail = "", bedType = "", room = "", price = "";
		int counter = 0;

		s = "select * from room";
		if (this.avail.getSelectedItem() != "Any") {
			avail = " availability = '" + this.avail.getSelectedItem() + "'";
			counter++;
		}

		if (this.cleaning.getSelectedItem() != "Any") {
			cleaning = " cleaning_status = '" + this.cleaning.getSelectedItem() + "'";
			counter++;
			if (counter > 1)
				cleaning = " and " + cleaning;
		}

		if (this.price.getSelectedItem() != "Any") {
			price = " " + (String) this.price.getSelectedItem();
			counter++;
			if (counter > 1)
				price = " and " + price;
		}

		if (this.room.getSelectedItem() != "Any") {
			room = " type = '" + this.room.getSelectedItem() + "'";
			counter++;
			if (counter > 1)
				room = " and " + room;
		}

		if (this.bedType.getSelectedItem() != "Any") {
			bedType = " bed = '" + this.bedType.getSelectedItem() + "'";
			counter++;
			if (counter > 1)
				bedType = " and " + bedType;
		}

		if (counter > 0)
			s = "select * from room where" + avail + cleaning + price + room + bedType;
		else
			s = "select * from room";

		try {
			DBCon c = new DBCon();
			ResultSet rs = c.s.executeQuery(s);
			table = new JTable();
			table.setBounds(10, 100, 963, 600);
			contentPane.add(table);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new SearchRoom();
	}
}