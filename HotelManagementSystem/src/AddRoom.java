import javax.swing.*;
//import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class AddRoom extends JFrame implements ActionListener {
	JButton button;
	JPanel contentPane;
	public ImageIcon i1, i2;
	public Image i3;
	public JLabel l1, l2, roomNumLab, availLab, cleanLab, priceLab, roomLab, bedLab;
	public JTextField roomNum, price;
	JComboBox cleaning, avail, bedType, room;
	String clean[] = { "Clean", "Not cleaned" };
	String types[] = { "Single", "Suite" };
	String beds[] = { "Single", "Double", "Queen", "King" };
	String availability[] = { "Available", "Unavailable" };

	public static void main(String[] args) {
		new AddRoom();
	}

	AddRoom() {
		this.setTitle("Add Room");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		l2 = new JLabel("Add New Room");
		l2.setFont(new Font("Serif", Font.BOLD, 19));
		l2.setBounds(400, 25, 200, 30);
		add(l2);

		// Adding the image
		i1 = new ImageIcon(getClass().getResource("Bed.jpg"));
		i3 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		i2 = new ImageIcon(i3);
		l1 = new JLabel(i1);
		l1.setBounds(450, 80, 400, 335);
		contentPane.add(l1);

		// Adding textfields and labels
		roomNumLab = new JLabel("Room Number");
		roomNumLab.setFont(new Font("Serif", Font.BOLD, 17));
		roomNumLab.setBounds(50, 80, 135, 30);
		add(roomNumLab);
		roomNum = new JTextField();
		roomNum.setBounds(210, 80, 210, 30);
		add(roomNum);

		availLab = new JLabel("Availability");
		availLab.setFont(new Font("Serif", Font.BOLD, 17));
		availLab.setBounds(50, 130, 135, 30);
		add(availLab);
		avail = new JComboBox(availability);
		avail.setBounds(210, 130, 210, 30);
		add(avail);

		cleanLab = new JLabel("Cleaning Status");
		cleanLab.setFont(new Font("Serif", Font.BOLD, 17));
		cleanLab.setBounds(50, 180, 135, 30);
		add(cleanLab);
		cleaning = new JComboBox(clean);
		cleaning.setBounds(210, 180, 210, 30);
		add(cleaning);

		priceLab = new JLabel("Price (INR)");
		priceLab.setFont(new Font("Serif", Font.BOLD, 17));
		priceLab.setBounds(50, 230, 135, 30);
		add(priceLab);
		price = new JTextField();
		price.setBounds(210, 230, 210, 30);
		add(price);

		roomLab = new JLabel("Room Type");
		roomLab.setFont(new Font("Serif", Font.BOLD, 17));
		roomLab.setBounds(50, 280, 135, 30);
		add(roomLab);
		room = new JComboBox(types);
		room.setBounds(210, 280, 210, 30);
		add(room);

		bedLab = new JLabel("Bed Type");
		bedLab.setFont(new Font("Serif", Font.BOLD, 17));
		bedLab.setBounds(50, 330, 135, 30);
		add(bedLab);
		bedType = new JComboBox(beds);
		bedType.setBounds(210, 330, 210, 30);
		add(bedType);

		button = new JButton("SAVE");
		button.setBounds(190, 390, 100, 30);
		add(button);

		button.addActionListener(this);

		setBounds(550, 200, 900, 500);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			String roomNumStr = roomNum.getText();
			String availStr = (String) avail.getSelectedItem();
			String cleaningStatusStr = (String) cleaning.getSelectedItem();
			String roomTypeStr = (String) room.getSelectedItem();
			long priceLong = Long.parseLong(price.getText());
			String bedStr = (String) bedType.getSelectedItem();

			DBCon db = new DBCon();
			// eid is PRIMARY KEY
			String str = "INSERT INTO room values( '" + roomNumStr + "', '" + availStr + "', '" + cleaningStatusStr
					+ "','"
					+ priceLong + "', '" + roomTypeStr + "', '" + bedStr + "')";

			db.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "New room added.");
			setVisible(false);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			ex.printStackTrace();
		}

	}
}
