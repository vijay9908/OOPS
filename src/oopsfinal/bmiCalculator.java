package oopsfinal;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class bmiCalculator extends JFrame implements Check {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextArea txtrWelcome;
	private JLabel lblName;
	private JTextField txtFeet;
	private JTextField txtInches;
	private JTextField txtWeight;
	private JComboBox <String> genderData;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Validation frame2 = new Validation();
					frame2.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public bmiCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(71, 101, 117, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action1) {
				int feet, inches;
				double totalinches;
				double weight , bmi;
				if (txtName.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"You left the name blank.");
					txtName.grabFocus();
					return;
				}
				
				if (txtFeet.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Feet field is empty!");
					txtFeet.grabFocus();
					return;
				}
				if (isNumber(txtFeet.getText())) {
					feet = Integer.parseInt(txtFeet.getText());
				}
				else {
					JOptionPane.showMessageDialog(null,"Enter your height in feet");
					txtFeet.grabFocus();
					return;
				}
				
				if (txtInches.getText().equals("")) {
					inches = 0;
					txtInches.setText("0");
				}
				else if (isNumber(txtInches.getText())) {
					inches = Integer.parseInt(txtInches.getText());
				}
				else {
					
					JOptionPane.showMessageDialog(null,"Enter the data in number format!");
					txtInches.grabFocus();
					return;
				}
				
				if (txtWeight.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Weight field is empty!");
					txtWeight.grabFocus();
					return;
				}
				if (isNumber(txtWeight.getText())) {
					weight = Integer.parseInt(txtWeight.getText());
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Enter weight as a number");
					txtWeight.grabFocus();
					return;
				}
				totalinches = (feet*12 + inches)* .0254f ;
				Component frame = null;
				int cmheight = (int) (totalinches*totalinches);
				Object message = weight/(cmheight);
				bmi = weight/cmheight;
				JOptionPane.showMessageDialog(frame, message);
				CheckBmi(bmi);
				//GenderAnalysis(bmi,genderData);
				
			}
		});
		btnNewButton.setBounds(71, 228, 89, 23);
		contentPane.add(btnNewButton);
		
		txtrWelcome = new JTextArea();
		txtrWelcome.setTabSize(8);
		txtrWelcome.setBackground(UIManager.getColor("Button.background"));
		txtrWelcome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtrWelcome.setLineWrap(true);
		txtrWelcome.setText("Welcome to the BMI Calculator .\r\n\r\n Please provide the necessary Details! to calculate your BMI");
		txtrWelcome.setBounds(10, 11, 386, 78);
		contentPane.add(txtrWelcome);
		
		lblName = new JLabel("Name");
		lblName.setBounds(20, 104, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(21, 136, 60, 14);
		contentPane.add(lblHeight);
		
		txtFeet = new JTextField();
		txtFeet.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFeet.setBounds(71, 133, 46, 20);
		contentPane.add(txtFeet);
		txtFeet.setColumns(10);
		
		JLabel lblFt = new JLabel("ft");
		lblFt.setBounds(121, 136, 24, 14);
		contentPane.add(lblFt);
		
		txtInches = new JTextField();
		txtInches.setHorizontalAlignment(SwingConstants.RIGHT);
		txtInches.setColumns(10);
		txtInches.setBounds(139, 133, 46, 20);
		contentPane.add(txtInches);
		
		JLabel lblIn = new JLabel("in");
		lblIn.setBounds(189, 136, 46, 14);
		contentPane.add(lblIn);
		
		JTextArea txtrResults = new JTextArea();
		txtrResults.setText("Results:");
		txtrResults.setTabSize(8);
		txtrResults.setLineWrap(true);
		txtrResults.setFont(new Font("Arial", Font.PLAIN, 12));
		txtrResults.setBackground(SystemColor.menu);
		txtrResults.setBounds(241, 105, 180, 78);
		contentPane.add(txtrResults);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(21, 164, 60, 14);
		contentPane.add(lblWeight);
		
		txtWeight = new JTextField();
		txtWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		txtWeight.setColumns(10);
		txtWeight.setBounds(71, 161, 46, 20);
		contentPane.add(txtWeight);
		
		JLabel lblLb = new JLabel("Kg");
		lblLb.setBounds(121, 164, 50, 20 );
		contentPane.add(lblLb);
		
		genderData = new JComboBox<String>();
		genderData.setBounds(71, 200, 114, 20);
		contentPane.add(genderData);
		genderData.addItem("Male");
		genderData.addItem("Female");
		
	}
	private static boolean isNumber(String n) {
		try {
			Integer.parseInt(n);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}


	
	public void CheckBmi(double data) {
		if(data < 18.5) {
			JOptionPane.showMessageDialog(null,"You are under_weight");
		}
		else if(data >= 18.5 && data<=24.9) {
			JOptionPane.showMessageDialog(null,"You have a good BMI");
		}
		else if(data>25 && data <= 29.9) {
			JOptionPane.showMessageDialog(null,"You are over_weight");
		}
		else if(data >= 30) {
			JOptionPane.showMessageDialog(null,"You are Obese");
		}
		else {
			JOptionPane.showMessageDialog(null,"You are super_Obese");
		}
		
	}

	public void GenderAnalysis(double data, String gender) {
		if(gender.equals("Female")) {
			data-= 1.6;
			CheckBmi(data);
		}
		
	}

	public void dataVisualisation() {
		// TODO Auto-generated method stub
		
	}
}