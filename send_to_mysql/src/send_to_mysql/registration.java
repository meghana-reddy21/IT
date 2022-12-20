package send_to_mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class registration {

	private JFrame frame;
	private JTextField tname;
	private JTextField troll;
	private JTextField tmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration window = new registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 532, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(164, 11, 213, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(21, 61, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ROLLNUMB:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(21, 101, 86, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("GENDER:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(21, 136, 73, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		tname = new JTextField();
		tname.setBounds(104, 58, 86, 20);
		frame.getContentPane().add(tname);
		tname.setColumns(10);
		
		troll = new JTextField();
		troll.setBounds(114, 98, 86, 20);
		frame.getContentPane().add(troll);
		troll.setColumns(10);
		
		JRadioButton r1 = new JRadioButton("female");
		r1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		r1.setBackground(Color.ORANGE);
		r1.setBounds(104, 132, 109, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("male");
		r2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		r2.setBackground(Color.ORANGE);
		r2.setBounds(215, 134, 113, 18);
		frame.getContentPane().add(r2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JLabel lblNewLabel_4 = new JLabel("FAV PROGRAMM LANG:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(21, 181, 192, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("EMAIL:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(21, 212, 73, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		tmail = new JTextField();
		tmail.setBounds(104, 209, 86, 20);
		frame.getContentPane().add(tmail);
		tmail.setColumns(10);
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"C ", "JAVA", "DART", "PEARL", "RUBY"}));
		c1.setEditable(true);
		c1.setToolTipText("");
		c1.setBounds(202, 182, 152, 22);
		frame.getContentPane().add(c1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tname.getText();
				String rollnum=troll.getText();
				String gender;
				if( r1.isSelected()) {  gender="Female";}
				else {  gender="Male";}
				String pro=(String) c1.getSelectedItem();
				String email=tmail.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/it","root","welcome@123");
					String qry="insert into student values('"+name+"','"+rollnum+"','"+gender+"','"+pro+"','"+email+"')";
					Statement stmt=con.createStatement();
					stmt.executeUpdate(qry);
					JOptionPane.showMessageDialog(btnNewButton, "Done!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(190, 270, 109, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
