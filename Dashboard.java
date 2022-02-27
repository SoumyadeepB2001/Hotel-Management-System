import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

	JButton receptionBut, adminButton;
	JPanel contentPane;

	 Dashboard() {
		setBounds(300, 300, 1000, 500);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		receptionBut = new JButton("Reception");
		adminButton = new JButton("Admin Panel");

		adminButton.setBackground(Color.WHITE);
		adminButton.setForeground(Color.BLACK);
		receptionBut.setBackground(Color.WHITE);
		receptionBut.setForeground(Color.BLACK);

		adminButton.setBounds(400, 100, 200, 60);
		receptionBut.setBounds(400, 250, 200, 60);

		add(receptionBut);
		add(adminButton);

		adminButton.addActionListener(this);
		receptionBut.addActionListener(this);
	}

	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==adminButton)
		 {
			System.out.println("Admin Button clicked");
		 }

		 if(e.getSource()==receptionBut)
		 {
			System.out.println("Reception Button clicked");
		 }

	 }

	public static void main(String[] args) {
		new Dashboard();
	}
}
