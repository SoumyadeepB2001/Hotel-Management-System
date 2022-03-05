import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Room extends JFrame implements ActionListener, WindowListener {
	JButton backBut;
	JTable table;
	JPanel contentPane;
	JScrollPane scroll;
	JLabel l1,l2,l3,l4,l5,l6;
	Room() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 640, 750);
		setTitle("Rooms");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		backBut = new JButton("Back");
		backBut.addActionListener(this);
		backBut.setBounds(260, 650, 80, 40);
		contentPane.add(backBut);

		l1 = new JLabel("Room No.");
		l1.setBounds(12,10,100,15);
		contentPane.add(l1);
		l2 = new JLabel("Availability");
		l2.setBounds(112,10,100,15);
		contentPane.add(l2);
		l3 = new JLabel("Cleaning Status");
		l3.setBounds(212,10,100,15);
		contentPane.add(l3);
		l4 = new JLabel("Price");
		l4.setBounds(312,10,100,15);
		contentPane.add(l4);
		l5 = new JLabel("Room Type");
		l5.setBounds(412,10,100,15);
		contentPane.add(l5);
		l6 = new JLabel("Bed Type");
		l6.setBounds(512,10,100,15);
		contentPane.add(l6);


		addWindowListener(this);
	}

	public void windowOpened(WindowEvent e) {
		try {
			DBCon c = new DBCon();
			String info = "select * from room";
			ResultSet rs = c.s.executeQuery(info);
			table = new JTable();
			table.setBounds(10, 40, 600, 600);
			contentPane.add(table);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			ex.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false);
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
		new Room();
	}
}