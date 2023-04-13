package csed_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class details {

	private JFrame frame;
	private JTextField tn;
	private JTextField te;
	private JTextField tp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					details window = new details();
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
	public details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(47, 85, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(47, 121, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fav prog lang");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(47, 146, 120, 39);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(47, 196, 61, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone No");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(47, 230, 97, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tn = new JTextField();
		tn.setBounds(118, 84, 86, 20);
		frame.getContentPane().add(tn);
		tn.setColumns(10);
		
		te = new JTextField();
		te.setBounds(118, 120, 86, 20);
		frame.getContentPane().add(te);
		te.setColumns(10);
		
		JComboBox cp = new JComboBox();
		cp.setModel(new DefaultComboBoxModel(new String[] {"Select", "Java", "C", "R", "Python"}));
		cp.setBounds(166, 156, 97, 22);
		frame.getContentPane().add(cp);
		
		JRadioButton r1 = new JRadioButton("Female");
		r1.setFont(new Font("Tahoma", Font.BOLD, 14));
		r1.setBounds(121, 192, 109, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Male");
		r2.setFont(new Font("Tahoma", Font.BOLD, 14));
		r2.setBounds(241, 194, 109, 23);
		frame.getContentPane().add(r2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		tp = new JTextField();
		tp.setBounds(140, 229, 86, 20);
		frame.getContentPane().add(tp);
		tp.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tn.getText();
				String email=te.getText();
				String favpl=(String) cp.getSelectedItem();
				String gender;
				if(r1.isSelected())
				{
					gender="Female";
				}
				else if(r2.isSelected())
				{
					gender="Male";
				}
				else
				{
					gender="Invalid";
				}
			String ph=tp.getText();
			int phno=Integer.parseInt(ph);
			
			JOptionPane.showMessageDialog(btnNewButton, "Hello\n"+name+"\nRegistration done!");
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/csed", "root", "mrec");
				String q="Insert into student values('"+name+"', '"+email+"','"+favpl+"', '"+gender+"', '"+phno+"')";
				Statement sta=con.createStatement();
				sta.execute(q);
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
		}
			);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(218, 291, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
