import javax.swing.*;
//import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class UpdateCheckStatus extends JFrame implements ActionListener {
	JButton checkButton, updateButton;
	JPanel contentPane;
	public JLabel l1,c_idLab,nameLab, roomNumLab, checkLab, paidLab, pendingLab;
	public JTextField c_id, roomNum, name, check, paid, pending;

	public static void main(String[] args) {
		new UpdateCheckStatus();
	}

	UpdateCheckStatus() {
		this.setTitle("Update Check-in Details");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		l1=new JLabel("Update Check-in Details");
		l1.setFont(new Font("Serif", Font.BOLD, 17));
		l1.setBounds(120, 25, 338, 30);
		add(l1);

		// Adding textfields and labels
		c_idLab = new JLabel("Customer ID");
		c_idLab.setFont(new Font("Serif", Font.BOLD, 17));
		c_idLab.setBounds(50, 80, 100, 30);
		add(c_idLab);
		c_id = new JTextField();
		c_id.setBounds(180, 80, 210, 30);
		add(c_id);

		roomNumLab = new JLabel("Room No.");
		roomNumLab.setFont(new Font("Serif", Font.BOLD, 17));
		roomNumLab.setBounds(50, 130, 100, 30);
		add(roomNumLab);
		roomNum = new JTextField();
		roomNum.setBounds(180, 130, 210, 30);
		add(roomNum);

		nameLab = new JLabel("Name");
		nameLab.setFont(new Font("Serif", Font.BOLD, 17));
		nameLab.setBounds(50, 180, 100, 30);
		add(nameLab);
		name = new JTextField();
		name.setBounds(180, 180, 210, 30);
		add(name);

		checkLab = new JLabel("Check-in");
		checkLab.setFont(new Font("Serif", Font.BOLD, 17));
		checkLab.setBounds(50, 230, 100, 30);
		add(checkLab);
		check = new JTextField();
		check.setBounds(180, 230, 210, 30);
		add(check);

		paidLab = new JLabel("Amount Paid (₹)");
		paidLab.setFont(new Font("Serif", Font.BOLD, 17));
		paidLab.setBounds(50, 280, 125, 30);
		add(paidLab);
		paid = new JTextField();
		paid.setBounds(180, 280, 210, 30);
		add(paid);

		pendingLab = new JLabel("Pending (₹)");
		pendingLab.setFont(new Font("Serif", Font.BOLD, 17));
		pendingLab.setBounds(50, 330, 125, 30);
		add(pendingLab);
		pending = new JTextField();
		pending.setBounds(180, 330, 210, 30);
		add(pending);

		updateButton = new JButton("Update");
		updateButton.setBounds(240, 380, 100, 30);
		add(updateButton);

		checkButton = new JButton("Check");
		checkButton.setBounds(90, 380, 100, 30);
		add(checkButton);

		updateButton.addActionListener(this);
		checkButton.addActionListener(this);

		setBounds(550, 200, 438, 470);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}