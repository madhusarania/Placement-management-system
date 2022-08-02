package miniProject.Student_Details;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ModifyS {

	JFrame modifyframe;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyS window = new ModifyS();
					window.modifyframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModifyS() {
		initialize();
	}
	
	private void clearfield() {
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
		textField_6.setText(null);
		textField_7.setText(null);
		textField_8.setText(null);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		modifyframe = new JFrame();
		modifyframe.setTitle("Placement Management System");
		modifyframe.getContentPane().setBackground(new Color(135, 206, 250));
		modifyframe.getContentPane().setLayout(null);
		modifyframe.setExtendedState(modifyframe.MAXIMIZED_BOTH);
		
		JLabel lblNewLabel = new JLabel("MODIFY");
		lblNewLabel.setBounds(294, 20, 1036, 61);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modifyframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter USN to Modify");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(469, 116, 411, 54);
		modifyframe.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(965, 125, 303, 48);
		modifyframe.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDetails sd = new StudentDetails();
				sd.sd.setVisible(true);
				modifyframe.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(976, 705, 211, 67);
		modifyframe.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("MODIFY");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				String name = "", sem = "", branch = "", cgpa = "", nob = "", phno = "", email = "";
				String usn = "", r;
				int flag = 0;
				try {
				File file = new File("student.txt");
				BufferedReader br = new BufferedReader(new FileReader(file));
				File temp = new File("temp.txt");
				PrintWriter pw = new PrintWriter(temp);
				
				String usn1 = textField.getText();
				
				while((r= br.readLine())!=null)
				{	
					String[] result = r.split("\\|");
					usn = result[2];
						
					if(usn.equals(usn1))
					{
						flag = 1;
						//Getting name from textField_1
						Pattern pattern = Pattern.compile("^(([a-zA-Z]+ [a-zA-Z]+)+|([a-zA-Z]+ ?[a-zA-Z]\\.?))");
						String name11 = textField_1.getText();
						Matcher matcher = pattern.matcher(name11);
						while(!(matcher.matches())) {
							name11 = JOptionPane.showInputDialog("Enter valid name");
							matcher = pattern.matcher(name11);
							
						}
						
						//Getting USN from textField_2
						Pattern pattern2 = Pattern.compile("^(\\d[a-z]{2}\\d\\d[a-z]{2}\\d{3}|\\d[A-Z]{2}\\d\\d[A-Z]{2}\\d{3})$");
						String usn11 = textField_2.getText();
						Matcher matcher2 = pattern2.matcher(usn11);
						while(!(matcher2.matches())) {
							usn11 = JOptionPane.showInputDialog("Enter valid USN");
							matcher2 = pattern2.matcher(usn11);
							
						}
						
						int id=0;
						Pattern pattern1 = Pattern.compile("(\\d\\d\\d)$");
						Matcher matcher1 = pattern1.matcher(usn);
						if (matcher1.find()) //Condition will work if last three characters are digits
						{
							    id = Integer.parseInt(matcher1.group()); //converting last three digits into integer

						}

						String sem11 = textField_3.getText();
						String branch11 = textField_4.getText();
						String cgpa11 = textField_5.getText();
						String nob11 = textField_6.getText();

						//Getting Phone no. from textField_7
						Pattern pattern3 = Pattern.compile("^[1-9]\\d{9}$");
						String phno11 = textField_7.getText();
						Matcher matcher3 = pattern3.matcher(phno11);
						while(!(matcher3.matches())) {
							phno11 = JOptionPane.showInputDialog("Enter valid Phone Number");
							matcher3 = pattern3.matcher(phno11);
							
						}
						
						//Getting email from textField_8
						Pattern pattern4 = Pattern.compile("^[0-9a-zA-Z_]+@[a-z]+\\.[a-z]+$");
						String email11 = textField_8.getText();
						Matcher matcher4 = pattern4.matcher(email11);
						while(!(matcher4.matches())) {
							email11 = JOptionPane.showInputDialog("Enter valid Email");
							matcher4 = pattern4.matcher(email11);
							
						}
						
						if((usn.equals(usn11)) == false) {
							pw.println(r);
							flag = 2;
						}
						else {
						String b = id + "|" + name11 + "|" + usn11 + "|" + sem11 + "|" + branch11 + "|" + cgpa11 + "|" + nob11 + "|" + phno11 + "|" + email11;
						pw.println(b);
						}
					}
					else
					{
						pw.println(r);
					}
				}
				pw.flush();
				pw.close();
				br.close();	
				file.delete();
				temp.renameTo(file);
				if(flag==1) {
					JOptionPane.showMessageDialog(null, "File Modified");
					clearfield();
				}
				else if(flag == 2) {
					JOptionPane.showMessageDialog(null, "USN mismatch, Cannot modify record");
					clearfield();
				}
				else {
					JOptionPane.showMessageDialog(null, "USN not available in file, cannot modify record");
					clearfield();
				}
				}
				catch(IOException ioe) {
					System.out.println("Some error occured");
				}
	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setBounds(502, 705, 205, 67);
		modifyframe.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(87, 247, 251, 48);
		modifyframe.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("USN");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2_1.setBounds(87, 346, 260, 48);
		modifyframe.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("SEMESTER");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2_2.setBounds(87, 425, 251, 48);
		modifyframe.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("BRANCH");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2_3.setBounds(80, 526, 260, 48);
		modifyframe.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("CGPA");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2_4.setBounds(87, 608, 260, 48);
		modifyframe.getContentPane().add(lblNewLabel_2_4);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(374, 247, 303, 48);
		modifyframe.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(374, 346, 303, 48);
		modifyframe.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_3.setColumns(10);
		textField_3.setBounds(374, 436, 303, 48);
		modifyframe.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_4.setColumns(10);
		textField_4.setBounds(374, 526, 303, 48);
		modifyframe.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_5.setColumns(10);
		textField_5.setBounds(374, 608, 303, 48);
		modifyframe.getContentPane().add(textField_5);
		
		JLabel lblNewLabel_2_5 = new JLabel("NO. OF BACKLOGS");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2_5.setBounds(862, 258, 303, 48);
		modifyframe.getContentPane().add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("PHONE NUMBER");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2_6.setBounds(862, 346, 303, 48);
		modifyframe.getContentPane().add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("EMAIL ID");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2_7.setBounds(862, 436, 303, 48);
		modifyframe.getContentPane().add(lblNewLabel_2_7);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_6.setColumns(10);
		textField_6.setBounds(1211, 258, 303, 48);
		modifyframe.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_7.setColumns(10);
		textField_7.setBounds(1211, 346, 303, 48);
		modifyframe.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_8.setColumns(10);
		textField_8.setBounds(1211, 436, 303, 48);
		modifyframe.getContentPane().add(textField_8);
		modifyframe.setBounds(500, 500, 1050, 800);
		modifyframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
