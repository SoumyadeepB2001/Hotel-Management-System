import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

	JLabel l1, l2;
	JTextField t1;
	JPasswordField t2;
	JButton loginBut, cancelBut;

	Login() {

		super("Login");
		setResizable(false);
		setLayout(null);
		this.setTitle("Login");

		l1 = new JLabel("Username");
		l1.setBounds(40, 20, 100, 30);
		add(l1);

		l2 = new JLabel("Password");
		l2.setBounds(40, 70, 100, 30);
		add(l2);

		t1 = new JTextField();
		t1.setBounds(150, 20, 150, 30);
		add(t1);

		t2 = new JPasswordField();
		t2.setBounds(150, 70, 150, 30);
		add(t2);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(350, 10, 150, 150);
		add(l3);

		loginBut = new JButton("Login");
		loginBut.setBounds(40, 140, 120, 30);
		loginBut.setFont(new Font("serif", Font.BOLD, 15));
		loginBut.addActionListener(this);
		loginBut.setBackground(Color.BLACK);
		loginBut.setForeground(Color.WHITE);
		add(loginBut);

		cancelBut = new JButton("Cancel");
		cancelBut.setBounds(180, 140, 120, 30);
		cancelBut.setFont(new Font("serif", Font.BOLD, 15));
		cancelBut.setBackground(Color.BLACK);
		cancelBut.setForeground(Color.WHITE);
		add(cancelBut);

		cancelBut.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);

		setVisible(true);
		setBounds(600, 350, 545, 260);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == loginBut) {
			try {
				DBCon c1 = new DBCon();
				String u = t1.getText();
				char[] pass = t2.getPassword();
				String password = String.valueOf(pass);
				String adminQuery = "select * from login where username='" + u + "' and password='" + password
						+ "' and admin='" + "y" + "'";
				String nonAdminQuery = "select * from login where username='" + u + "' and password='" + password
						+ "' and admin='" + "n" + "'";

				ResultSet forAdmins = c1.s.executeQuery(adminQuery);
				ResultSet forNonAdmins = c1.s2.executeQuery(nonAdminQuery);

				// Here only an admin can access the dashboard.
				// Normal users (non-admins) like recptionists can only access the reception
				// frame.

				if (forAdmins.next()) {
					new Dashboard().setVisible(true);
					setVisible(false);
				} else if (forNonAdmins.next()) {
					new Reception().setVisible(true);
					setVisible(false);
				}

				else {
					JOptionPane.showMessageDialog(null, "Invalid Credentials!");
					t1.setText("");
					t2.setText("");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == cancelBut) {
			System.exit(0);
		}
	}

	public static void main(String[] arg) {
		new Login();
	}
}