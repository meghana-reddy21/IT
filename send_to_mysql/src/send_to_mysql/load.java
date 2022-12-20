package send_to_mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class load {

	private JFrame frame;
	private JButton btnNewButton;
	private JScrollPane scrollPane_1;
	private JButton t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					load window = new load();
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
	public load() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(65, 44, 279, 156);
		frame.getContentPane().add(scrollPane_1);
		
		btnNewButton = new JButton("show data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/it","root","welcome@123");
					java.sql.Statement st=con.createStatement();
					String q="select * from student";
					ResultSet rs=st.executeQuery(q);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) t.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName= new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String name,rollnum,gender,favp,email;
					while(rs.next())
					{
						name=rs.getString(1);
						rollnum=rs.getString(2);
						gender=rs.getString(3);
						favp=rs.getString(4);
						email=rs.getString(5);
						String[]row= {name,rollnum,gender,favp,email};
						model.addRow(row);
						
						
					}
					st.close();
					con.close();
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
						
						
			}
		});
		btnNewButton.setBounds(95, 10, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		t = new JButton("clear");
		t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		t.setBounds(230, 10, 89, 23);
		frame.getContentPane().add(t);
	}
}
