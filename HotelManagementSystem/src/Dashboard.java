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

		adminButton.setBackground(Color.WHITE);
		adminButton.setForeground(Color.RED);
		receptionBut.setBackground(Color.WHITE);
		receptionBut.setForeground(Color.RED);
		logOutBut.setBackground(Color.WHITE);
		logOutBut.setForeground(Color.RED);

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

		else if (e.getSource() == receptionBut) {
			new Reception();
		}

		else if (e.getSource() == logOutBut) {
			Frame[] allFrames = Frame.getFrames();
			// Iterate through the allFrames array
			for (Frame fr : allFrames) {
				fr.dispose();
			}
			new Login().setVisible(true);
		}

	}

	public static void main(String[] args) {
		new Dashboard();
	}
}
