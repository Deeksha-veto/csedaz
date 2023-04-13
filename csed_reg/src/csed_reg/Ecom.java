package csed_reg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ecom {

	private JFrame frame;
	int i=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ecom window = new Ecom();
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
	public Ecom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admim\\Desktop\\vodywash.png"));
		lblNewLabel.setBounds(22, 41, 131, 280);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\admim\\Desktop\\bodyscrub.png"));
		lblNewLabel_1.setBounds(163, 41, 201, 280);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\admim\\Desktop\\loofah.png"));
		lblNewLabel_2.setBounds(380, 41, 181, 280);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "250ml", "500ml", "250+250ml"}));
		comboBox.setBounds(22, 332, 107, 22);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Lavendar", "Vanilla ", "Coffee"}));
		comboBox_1.setBounds(205, 332, 131, 22);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select", "Pack of 1", "Pack of 2", "Pack of 3"}));
		comboBox_2.setBounds(419, 332, 107, 22);
		frame.getContentPane().add(comboBox_2);
		
		JLabel c = new JLabel("CART:");
		c.setFont(new Font("Tahoma", Font.BOLD, 15));
		c.setBounds(413, 11, 113, 19);
		frame.getContentPane().add(c);
		
		JLabel lblNewLabel_3 = new JLabel("699/-");
		lblNewLabel_3.setBounds(245, 360, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("295/-");
		lblNewLabel_4.setBounds(58, 365, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("250/-");
		lblNewLabel_5.setBounds(445, 360, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Add to cart");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				c.setText("CART:"+i);
			}
		});
		btnNewButton.setBounds(22, 382, 107, 22);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add to cart");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				c.setText("CART:"+i);
			}
		});
		btnNewButton_1.setBounds(216, 382, 107, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add to cart");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				c.setText("CART:"+i);
			}
		});
		btnNewButton_2.setBounds(429, 385, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
