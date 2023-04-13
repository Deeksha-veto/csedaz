package metrotrain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class regpage {

	private JFrame frame;
	private JTextField tn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regpage window = new regpage();
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
	public regpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Metro Train TB");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(214, 11, 204, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(68, 96, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("From St");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(68, 149, 78, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("To St");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(68, 204, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No. of tickets");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(68, 254, 106, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tn = new JTextField();
		tn.setBounds(139, 95, 204, 20);
		frame.getContentPane().add(tn);
		tn.setColumns(10);
		
		JComboBox fst = new JComboBox();
		fst.setModel(new DefaultComboBoxModel(new String[] {"Select", "Sec east", "Ameerpet", "Parade grounds", "Rasoolpoora"}));
		fst.setBounds(156, 147, 135, 22);
		frame.getContentPane().add(fst);
		
		JComboBox tst = new JComboBox();
		tst.setModel(new DefaultComboBoxModel(new String[] {"Select", "Sec east", "Ameerpet", "Parade grounds", "Rasoolpoora"}));
		tst.setBounds(156, 202, 135, 22);
		frame.getContentPane().add(tst);
		
		JComboBox n = new JComboBox();
		n.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		n.setBounds(175, 252, 116, 22);
		frame.getContentPane().add(n);
		
		JButton btnNewButton = new JButton("BOOK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tn.getText();
				String fromst=(String) fst.getSelectedItem();
				String tost=(String) tst.getSelectedItem();
				String tno=(String) n.getSelectedItem();
				int tickets=Integer.parseInt(tno);
				int bill=0;
				if(fromst.equals("Sec east") && tost.equals("Ameerpet")) {
					bill=tickets*60;
				}
				else if(fromst.equals("Sec east") && tost.equals("Parade grounds")) {
					bill=tickets*30;
				}
				else if(fromst.equals("Sec east") && tost.equals("Rasoolpoora")) {
					bill=tickets*30;
				}
				else if(fromst.equals("Ameerpet") && tost.equals("Sec east")) {
					bill=tickets*60;
				}
				else if(fromst.equals("Ameerpet") && tost.equals("Parade grounds")) {
					bill=tickets*45;
				}
				else if(fromst.equals("Ameerpet") && tost.equals("Rasoolpoora")) {
					bill=tickets*45;
				}
				else if(fromst.equals("Parade grounds") && tost.equals("Sec east")) {
					bill=tickets*30;
				}
				else if(fromst.equals("Parade grounds") && tost.equals("Ameerpet")) {
					bill=tickets*45;
				}
				else if(fromst.equals("Parade grounds") && tost.equals("Rasoolpura")) {
					bill=tickets*10;
				}
				else if(fromst.equals("Rasoolpoora") && tost.equals("Sec east")) {
					bill=tickets*30;
				}
				else if(fromst.equals("Rasoolpoora") && tost.equals("Ameerpet")) {
					bill=tickets*45;
				}
				else if(fromst.equals("Rasoolpoora") && tost.equals("Parade grounds")) {
					bill=tickets*10;
				}
				else if(fromst==tost) {
					JOptionPane.showMessageDialog(btnNewButton, "Invalid!!!");
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton, "Select valid stations!!!");
				}
			
			
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/metro","root","mrec");
					String q="Insert into ticket values('"+name+"','"+fromst+"','"+tost+"','"+tickets+"','"+bill+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "Hello:it"+name+"\nFrom:"+fromst+"\nTo:"+tost+"\nBill:"+bill);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(254, 310, 116, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
