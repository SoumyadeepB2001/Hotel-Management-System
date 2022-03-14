import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class CheckOut extends JFrame implements ActionListener {
	JButton check, checkOut;
	JPanel contentPane;
	public JLabel c_idLab, r_numLab, pendingLab, nameLab;
	public JTextField name, c_id,r_num, pending;

	public static void main(String[] args) {
		new CheckOut();
	}

	CheckOut() {
		this.setTitle("Check Out");
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		c_idLab=new JLabel("Customer ID");
		c_idLab.setFont(new Font("Serif", Font.BOLD, 14));
		c_idLab.setBounds(50, 50, 100, 30);
		add(c_idLab);
		c_id = new JTextField();
		c_id.setBounds(170, 50, 210, 30);
		add(c_id);

		r_numLab = new JLabel("Room No.");
		r_numLab.setFont(new Font("Serif", Font.BOLD, 14));
		r_numLab.setBounds(50, 100, 100, 30);
		add(r_numLab);
		r_num = new JTextField();
		r_num.setBounds(170, 100, 210, 30);
		add(r_num);
		r_num.setEditable(false);

		nameLab = new JLabel("Name");
		nameLab.setFont(new Font("Serif", Font.BOLD, 14));
		nameLab.setBounds(50, 150, 100, 30);
		add(nameLab);
		name = new JTextField();
		name.setBounds(170, 150, 210, 30);
		add(name);
		name.setEditable(false);

		pendingLab = new JLabel("Pending (₹)");
		pendingLab.setFont(new Font("Serif", Font.BOLD, 14));
		pendingLab.setBounds(50, 200, 100, 30);
		add(pendingLab);
		pending = new JTextField();
		pending.setBounds(170, 200, 210, 30);
		add(pending);
		pending.setEditable(false);

		check = new JButton("Check");
		check.setBounds(90, 260, 100, 30);
		add(check);

		checkOut = new JButton("Check Out");
		checkOut.setBounds(250, 260, 100, 30);
		add(checkOut);

		check.addActionListener(this);
		checkOut.addActionListener(this);

		setBounds(550, 200, 452, 340);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
	}
}
