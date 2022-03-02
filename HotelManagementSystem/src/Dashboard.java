import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

	JButton receptionBut, adminButton;
	JPanel contentPane;

	Dashboard() {
		this.setTitle("Dashboard");
		setBounds(300, 300, 1000, 500);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		receptionBut = new JButton("Reception");
		adminButton = new JButton("Admin Panel");

		adminButton.setBackground(Color.BLACK);
		adminButton.setForeground(Color.WHITE);
		receptionBut.setBackground(Color.BLACK);
		receptionBut.setForeground(Color.WHITE);

		adminButton.setBounds(400, 100, 200, 60);
		receptionBut.setBounds(400, 250, 200, 60);

		add(receptionBut);
		add(adminButton);

		adminButton.addActionListener(this);
		receptionBut.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adminButton) {
			new AdminPanel();
		}

		if (e.getSource() == receptionBut) {
			new Reception();
		}

	}

	public static void main(String[] args) {
		new Dashboard();
	}
}
