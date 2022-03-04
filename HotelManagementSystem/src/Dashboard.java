import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

	JButton receptionBut, adminButton, logOutBut;
	JPanel contentPane;

	Dashboard() {
		this.setTitle("Dashboard");
		setBounds(300, 300, 600, 420);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		receptionBut = new JButton("Reception");
		adminButton = new JButton("Admin Panel");
		logOutBut = new JButton("Log Out");

		adminButton.setBackground(Color.BLACK);
		adminButton.setForeground(Color.WHITE);
		receptionBut.setBackground(Color.BLACK);
		receptionBut.setForeground(Color.WHITE);
		logOutBut.setBackground(Color.BLACK);
		logOutBut.setForeground(Color.WHITE);

		adminButton.setBounds(190, 40, 200, 60);
		receptionBut.setBounds(190, 160, 200, 60);
		logOutBut.setBounds(190, 280, 200, 60);

		add(receptionBut);
		add(adminButton);
		add(logOutBut);

		adminButton.addActionListener(this);
		receptionBut.addActionListener(this);
		logOutBut.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adminButton) {
			new AdminPanel();
		}

		if (e.getSource() == receptionBut) {
			new Reception();
		}

		if (e.getSource() == logOutBut) {
			new Login().setVisible(true);
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		new Dashboard();
	}
}
