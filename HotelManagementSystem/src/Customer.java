import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Customer extends JFrame implements ActionListener, WindowListener {
	JButton backBut;
	JTable table;
	JPanel contentPane;
	JScrollPane scroll;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;

	Customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 1295, 750);
		setTitle("Customers");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		backBut = new JButton("Back");
		backBut.addActionListener(this);
		backBut.setBounds(590, 650, 80, 40);
		contentPane.add(backBut);

		l1 = new JLabel("Name");
		l1.setBounds(12, 10, 100, 15);
		contentPane.add(l1);
		l2 = new JLabel("Age");
		l2.setBounds(138, 10, 100, 15);
		contentPane.add(l2);
		l3 = new JLabel("Gender");
		l3.setBounds(264, 10, 100, 15);
		contentPane.add(l3);
		l4 = new JLabel("ID Proof");
		l4.setBounds(390, 10, 100, 15);
		contentPane.add(l4);
		l5 = new JLabel("ID Number");
		l5.setBounds(516, 10, 100, 15);
		contentPane.add(l5);
		l6 = new JLabel("Country");
		l6.setBounds(642, 10, 100, 15);
		contentPane.add(l6);
		l7 = new JLabel("Phone");
		l7.setBounds(768, 10, 100, 15);
		contentPane.add(l7);
		l8 = new JLabel("Room Number");
		l8.setBounds(894, 10, 100, 15);
		contentPane.add(l8);
		l9 = new JLabel("Checked-In");
		l9.setBounds(1020, 10, 100, 15);
		contentPane.add(l9);
		l10 = new JLabel("Deposit");
		l10.setBounds(1146, 10, 100, 15);
		contentPane.add(l10);

		addWindowListener(this);
	}

	public void windowOpened(WindowEvent e) {
		try {
			DBCon c = new DBCon();
			String info = "select * from customer";
			ResultSet rs = c.s.executeQuery(info);
			table = new JTable();
			table.setBounds(10, 40, 1260, 600);
			contentPane.add(table);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			ex.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent ae) {
		dispose();
	}

	/*
	 * Some listener interfaces contain more than one method. For example, the
	 * MouseListener interface contains five methods: mousePressed, mouseReleased,
	 * mouseEntered, mouseExited, and mouseClicked. Even if you care only about
	 * mouse clicks, if your class directly implements MouseListener, then you must
	 * implement all five MouseListener methods. Methods for those events you do not
	 * care about can have empty bodies. So here all the methods of Window Listener
	 * must be written with empty bodies.
	 */

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	public static void main(String[] args) {
		new Customer();
	}
}
