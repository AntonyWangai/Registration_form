

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;

public class Registration_form {

	private JFrame frame;
	private JTextField Name;
	private JTextField Username;
	private JTextField Email;
	private JTextField Phone;
	private JTextField Address;
	private JPasswordField Confirm;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration_form window = new Registration_form();
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
	public Registration_form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201, 192, 184));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(174, 11, 112, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(39, 50, 93, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(39, 74, 104, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		Name = new JTextField();
		Name.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Name.setBounds(142, 48, 237, 20);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		Username = new JTextField();
		Username.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Username.setBounds(142, 72, 237, 20);
		frame.getContentPane().add(Username);
		Username.setColumns(10);
		
		Email = new JTextField();
		Email.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Email.setBounds(142, 147, 237, 20);
		frame.getContentPane().add(Email);
		Email.setColumns(10);
		
		Phone = new JTextField();
		Phone.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Phone.setBounds(142, 172, 237, 20);
		frame.getContentPane().add(Phone);
		Phone.setColumns(10);
		
		Address = new JTextField();
		Address.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Address.setBounds(142, 200, 237, 20);
		frame.getContentPane().add(Address);
		Address.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password :");
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(39, 99, 93, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Confirm Password :");
		lblNewLabel_2_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(10, 124, 133, 14);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Email :");
		lblNewLabel_2_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2_3.setBounds(39, 149, 104, 14);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Phone");
		lblNewLabel_2_4.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2_4.setBounds(39, 174, 104, 14);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Address");
		lblNewLabel_2_5.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2_5.setBounds(39, 202, 104, 14);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				
				Class.forName("com.mysql.cj.jdbc.Driver");	
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","antony2003");
				String sql="INSERT INTO register (Name,Username,Password,Confirm_password,Email,Phone,Address) VALUES (?,?,?,?,?,?,?)";
				PreparedStatement pr = con.prepareStatement(sql);
				
				char p[]=Password.getPassword();
				String password=new String(p);
				
				char cp[]=Confirm.getPassword();
				String cpassword=new String(cp);
						
				pr.setString(1,Name.getText());
				pr.setString(2,Username.getText());
				pr.setString(3,password);
				pr.setString(4,cpassword);
				pr.setString(5,Email.getText());
				pr.setString(6,Phone.getText());
				pr.setString(7,Address.getText());
				
				
				if (cpassword.equals(password))
				{
					int count = pr.executeUpdate();
				
						if (count==1)
						{
							JOptionPane.showMessageDialog(null,"Record added successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Record not added");
							con.close();
						}
				
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Passwords dont match ");
					Password.setText("");
					Confirm.setText("");
				}
			}
				catch (Exception d)
				{
					
					    d.printStackTrace();
					

				}
				
			}
		});
		Submit.setBounds(117, 231, 89, 23);
		frame.getContentPane().add(Submit);
		
		JButton Reset = new JButton("Reset");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Name.setText("");
				Username.setText("");
				Password.setText("");
				Confirm.setText("");
				Email.setText("");
				Phone.setText("");
				Address.setText("");
			}
		});
		Reset.setBounds(216, 231, 89, 23);
		frame.getContentPane().add(Reset);
		
		JButton Close = new JButton("Close");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
			
		});
		Close.setBounds(312, 231, 89, 23);
		frame.getContentPane().add(Close);
		
		Confirm = new JPasswordField();
		Confirm.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Confirm.setBounds(142, 122, 237, 20);
		frame.getContentPane().add(Confirm);
		
		Password = new JPasswordField();
		Password.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Password.setBounds(142, 97, 237, 20);
		frame.getContentPane().add(Password);
	}
}
