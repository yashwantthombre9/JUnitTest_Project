package junit;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BMICalc extends JFrame {
	
	public static double findBMI(int weight,int meter) {
		double bmi =  (weight / Math.pow(meter, 2));
		return bmi;
	}

	private JPanel contentPane;
	private JTextField txtFeet;
	private JTextField txtInches;
	private JTextField txtWeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMICalc frame = new BMICalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BMICalc() {
		setTitle("BMI Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnWelcome = new JTextPane();
		txtpnWelcome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnWelcome.setBackground(UIManager.getColor("Button.background"));
		txtpnWelcome.setText("Welcome to the BMI Calculator\r\nby YASHWANT THOMBRE (WADIA COLLEGE GROUP)\r\n\r\nIn order to get your Body Mass Index, we will need your height\r\n(in Meter) and weight in kg.");
		txtpnWelcome.setBounds(10, 0, 414, 93);
		contentPane.add(txtpnWelcome);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHeight.setFont(new Font("Arial", Font.PLAIN, 12));
		lblHeight.setBounds(10, 104, 46, 14);
		contentPane.add(lblHeight);
		
		txtFeet = new JTextField();
		txtFeet.setBounds(49, 104, 86, 20);
		contentPane.add(txtFeet);
		txtFeet.setColumns(10);
		
		JLabel lblFeet = new JLabel("Meter.");
		lblFeet.setBounds(139, 107, 46, 14);
		contentPane.add(lblFeet);
		
//		txtInches = new JTextField();
//		txtInches.setColumns(10);
//		txtInches.setBounds(166, 104, 86, 20);
//		contentPane.add(txtInches);
//		
//		JLabel lblInches = new JLabel("in.");
//		lblInches.setBounds(256, 107, 46, 14);
//		contentPane.add(lblInches);
		
		JTextPane txtpnResults = new JTextPane();
		txtpnResults.setBackground(UIManager.getColor("Button.background"));
		txtpnResults.setText("Results:");
		txtpnResults.setBounds(266, 132, 145, 119);
		contentPane.add(txtpnResults);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Declare our variables
				int meter,weight;
				double bmi;
				String results;
				// Make sure required fields are not empty
				if (txtFeet.getText().equals("")) {
					// alert the user
					JOptionPane.showMessageDialog(null, "You must enter your height in Meter " +
														"(whole numbers only please).");
					txtFeet.requestFocus();	// move cursor to txtFeet input box
					return; // halts all execution in actionPerformed - stops processing bmi
				}
				// Make sure we can convert txtFeet input (string) into an integer
				if ( isNumber(txtFeet.getText()) ) {
					meter = Integer.parseInt(txtFeet.getText()); // if it's a number, set feet
				}
				else {
					// It's not a number, alert the user and halt processing
					JOptionPane.showMessageDialog(null, 
							"You must enter Meter as a whole number--not text.");
					// delete text from txtFeet field
					txtFeet.setText("");
					txtFeet.requestFocus();
					return;
				}
				// Validate inches field (NOTE: empty will become 0 inches)
			
				
				
				// Validate weight (just like we did with feet)
				if (txtWeight.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "You must enter your weight, please.");
					txtWeight.grabFocus();
					return;
				}
				if (isNumber(txtWeight.getText())) {
					weight = Integer.parseInt(txtWeight.getText());
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"You must enter weight as a whole number only, please.");
					txtWeight.setText("");
					txtWeight.grabFocus();
					return;
				}
				// If we haven't returned, we can process BMI
				
				
			  bmi = findBMI(weight,meter);
				// Use string formatter to craft our results
				results = String.format("With a weight of %d Kg. and a height of %d Meter", weight,
						meter);
				results += String.format("\nyour BMI is %2.2f.", bmi);
				txtpnResults.setText(results); // Show results in the TextPane
			}
		});
		btnSubmit.setBounds(163, 203, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setVerticalAlignment(SwingConstants.BOTTOM);
		lblWeight.setFont(new Font("Arial", Font.PLAIN, 12));
		lblWeight.setBounds(10, 145, 46, 14);
		contentPane.add(lblWeight);
		
		txtWeight = new JTextField();
		txtWeight.setColumns(10);
		txtWeight.setBounds(49, 145, 86, 20);
		contentPane.add(txtWeight);
		
		JLabel lblLb = new JLabel("Kg.");
		lblLb.setBounds(139, 145, 46, 14);
		contentPane.add(lblLb);
		
	}
	// Create isNumber Method - takes a string, tries to convert it to an integer
	// Returns true if it can convert the string, false if it cannot, & uses exception handling
	private boolean isNumber(String n) {
		try {
			Integer.parseInt(n);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}