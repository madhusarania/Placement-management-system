package miniProject.Company_Details;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;

public class InsertC {

	JFrame insertframec;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertC window = new InsertC();
					window.insertframec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsertC() {
		initialize();
	}
	
	private void clearfield() {
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		insertframec = new JFrame();
		insertframec.getContentPane().setBackground(new Color(135, 206, 250));
		insertframec.getContentPane().setLayout(null);
		insertframec.setTitle("Placement Management System");
		insertframec.setExtendedState(insertframec.MAXIMIZED_BOTH);
		
		JLabel lblNewLabel = new JLabel("INSERT  DETAILS");
		lblNewLabel.setBounds(10, 20, 1540, 61);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		insertframec.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("COMPANY NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(107, 134, 367, 61);
		insertframec.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ROLE OFFERING");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1_1.setBounds(107, 232, 279, 61);
		insertframec.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("FULL/INTERN");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1_2.setBounds(107, 315, 212, 61);
		insertframec.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CTC OFFERING");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1_3.setBounds(112, 414, 296, 61);
		insertframec.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("MIN. CGPA REQUIREMENT");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1_4.setBounds(107, 511, 440, 61);
		insertframec.getContentPane().add(lblNewLabel_1_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(934, 134, 296, 50);
		insertframec.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(934, 223, 296, 50);
		insertframec.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(934, 315, 296, 50);
		insertframec.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_3.setColumns(10);
		textField_3.setBounds(934, 414, 296, 50);
		insertframec.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_4.setColumns(10);
		textField_4.setBounds(934, 502, 296, 50);
		insertframec.getContentPane().add(textField_4);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyDetails sd = new CompanyDetails();
				sd.cdframe.setVisible(true);
				insertframec.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(844, 696, 211, 67);
		insertframec.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname = textField.getText();
				String role = textField_1.getText();
				String fi = textField_2.getText(); 
				String ctc = textField_3.getText();
				String cgpar = textField_4.getText();
				String nobr = textField_5.getText();
				try {
				PrintWriter pw = new PrintWriter(new FileOutputStream(new File("company.txt"),true));
				String b = cname + "|" + role + "|" + fi + "|" + ctc + "|" + cgpar + "|" + nobr + "|";
				
				pw.println(b);
				pw.flush();
				pw.close();	
				JOptionPane.showMessageDialog(null, "Record Inserted");
				clearfield();
			}
			catch(IOException ioe) {
				System.out.println("Error occured");
			}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setBounds(430, 697, 217, 64);
		insertframec.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("MAX. NOB ALLOWED");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1_4_1.setBounds(107, 599, 440, 61);
		insertframec.getContentPane().add(lblNewLabel_1_4_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_5.setColumns(10);
		textField_5.setBounds(934, 599, 296, 50);
		insertframec.getContentPane().add(textField_5);
		insertframec.setBounds(500, 500, 1050, 800);
		insertframec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
