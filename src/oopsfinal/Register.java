package oopsfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField;


	public Register() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(51, 36, 110, 16);
		contentPane.add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(51, 74, 136, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(51, 111, 154, 16);
		contentPane.add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(223, 69, 164, 26);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(223, 106, 164, 26);
		contentPane.add(passwordField_2);
		
		textField = new JTextField();
		textField.setBounds(224, 31, 163, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(155, 167, 117, 29);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showConfirmDialog(null, "User Name can't be empty!");
					textField.grabFocus();
				}
				else {
					JOptionPane.showConfirmDialog(null, "Signup successful!");
					dispose();
					Validation frame2 = new Validation();
					frame2.setVisible(true);
				}
				
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(155, 204, 117, 29);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				@SuppressWarnings("unused")
				Validation frame2 = new Validation();
				frame2.setVisible(true);
				
			}
		});
	}
}
