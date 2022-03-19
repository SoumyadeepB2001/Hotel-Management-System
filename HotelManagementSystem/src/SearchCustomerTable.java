import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SearchCustomerTable extends JFrame implements ActionListener, WindowListener {
	JButton backBut;
	JTable table;
	JPanel contentPane;
	JScrollPane scroll;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
	String query; //Query to be executed

	SearchCustomerTable(String s) {
		query=s;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 30, 1580, 800);
		setTitle("Customers");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		backBut = new JButton("Back");
		backBut.addActionListener(this);
		backBut.setBounds(730, 710, 80, 35);
		contentPane.add(backBut);

		l1 = new JLabel("Name");
		l1.setBounds(12, 10, 100, 15);
		contentPane.add(l1);
		l2 = new JLabel("Age");
		l2.setBounds(153, 10, 100, 15);
		contentPane.add(l2);
		l3 = new JLabel("Gender");
		l3.setBounds(294, 10, 100, 15);
		contentPane.add(l3);
		l4 = new JLabel("ID Proof");
		l4.setBounds(435, 10, 100, 15);
		contentPane.add(l4);
		l5 = new JLabel("ID Number");
		l5.setBounds(576, 10, 100, 15);
		contentPane.add(l5);
		l6 = new JLabel("Country");
		l6.setBounds(717, 10, 100, 15);
		contentPane.add(l6);
		l7 = new JLabel("Phone");
		l7.setBounds(858, 10, 100, 15);
		contentPane.add(l7);
		l8 = new JLabel("Room Number");
		l8.setBounds(999, 10, 100, 15);
		contentPane.add(l8);
		l9 = new JLabel("Checked-In");
		l9.setBounds(1140, 10, 100, 15);
		contentPane.add(l9);
		l10 = new JLabel("Check-in Time");
		l10.setBounds(1281, 10, 100, 15);
		contentPane.add(l10);

		l11 = new JLabel("Deposit");
		l11.setBounds(1422, 10, 100, 15);
		contentPane.add(l11);

		addWindowListener(this);
	}

	public void windowOpened(WindowEvent e) {
		try {
			DBCon c = new DBCon();
			ResultSet rs = c.s.executeQuery(query);
			table = new JTable();
			table.setBounds(10, 40, 1550, 660);
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

}
