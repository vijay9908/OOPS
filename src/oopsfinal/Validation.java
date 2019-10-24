package oopsfinal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Validation extends JFrame {
	private static final long serialVersionUID = 1L;
	protected static final Object Successful = null;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnSignUp;


	public Validation() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserNmae = new JLabel("User Name");
		lblUserNmae.setBounds(84, 50, 92, 23);
		contentPane.add(lblUserNmae);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(84, 85, 61, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(206, 48, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(206, 82, 130, 21);
		contentPane.add(passwordField);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(162, 161, 117, 29);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String (passwordField.getPassword());
				if(textField.getText().equals("admin") && pass.equals("admin") ) {
					JOptionPane.showMessageDialog(null, "Login Successful !");
					dispose();
					@SuppressWarnings("unused")
					bmiCalculator frame = new bmiCalculator();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Credentials !!");
				}
				
			}
		});
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(162, 200, 117, 29);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				@SuppressWarnings("unused")
				Register frame3 = new Register();
				frame3.setVisible(true);
				
				
			}
		});
		
		JRadioButton rdbtnStayLoggedIn = new JRadioButton("Stay Logged in");
		rdbtnStayLoggedIn.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		rdbtnStayLoggedIn.setBounds(206, 115, 141, 23);
		contentPane.add(rdbtnStayLoggedIn);
	}
}
