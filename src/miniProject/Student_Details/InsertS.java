package miniProject.Student_Details;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import miniProject.Student_Details.StudentDetails;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.*;
import java.awt.event.ActionEvent;

public class InsertS {

	JFrame insertframe;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertS window = new InsertS();
					window.insertframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsertS() {
		initialize();
	}
	
	// Creating function to clear all the text fields
	private void clearfield() {
		textField_0.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
		textField_6.setText(null);
		textField_7.setText(null);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		insertframe = new JFrame();
		insertframe.getContentPane().setBackground(new Color(135, 206, 250));
		insertframe.getContentPane().setLayout(null);
		insertframe.setTitle("Placement Management System");
		insertframe.setExtendedState(insertframe.MAXIMIZED_BOTH);
		
		JLabel lblNewLabel = new JLabel("INSERT  DETAILS");
		lblNewLabel.setBounds(24, 22, 1540, 61);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		insertframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(47, 149, 212, 61);
		insertframe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("USN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(47, 243, 212, 61);
		insertframe.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SEMESTER");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_3.setBounds(47, 348, 212, 61);
		insertframe.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BRANCH");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_4.setBounds(47, 444, 212, 61);
		insertframe.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CGPA");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_5.setBounds(47, 542, 212, 61);
		insertframe.getContentPane().add(lblNewLabel_5);
		
		textField_0 = new JTextField();
		textField_0.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_0.setBounds(349, 149, 296, 50);
		insertframe.getContentPane().add(textField_0);
		textField_0.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(349, 253, 296, 50);
		insertframe.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(349, 358, 296, 50);
		insertframe.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_3.setColumns(10);
		textField_3.setBounds(349, 454, 296, 50);
		insertframe.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_4.setColumns(10);
		textField_4.setBounds(349, 552, 296, 50);
		insertframe.getContentPane().add(textField_4);
		
		//Woriking of BACK button
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDetails sd = new StudentDetails();
				sd.sd.setVisible(true);
				insertframe.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(882, 697, 211, 67);
		insertframe.getContentPane().add(btnBack);
		
		
		//Working of Insert button
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Getting name from textField
				Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z .]+$"); //Validating so that name should accept only alphabets, space, and .
				String name = textField_0.getText();
				Matcher matcher = pattern.matcher(name);
				while(!(matcher.matches())) {
					name = JOptionPane.showInputDialog("Enter valid name");
					matcher = pattern.matcher(name);
					
				}
				
				//Getting USN from textField_1
				Pattern pattern2 = Pattern.compile("^(\\d[a-z]{2}\\d\\d[a-z]{2}\\d{3}|\\d[A-Z]{2}\\d\\d[A-Z]{2}\\d{3})$");
				String usn = textField_1.getText();
				Matcher matcher2 = pattern2.matcher(usn);
				while(!(matcher2.matches())) {
					usn = JOptionPane.showInputDialog("Enter valid USN");
					matcher2 = pattern2.matcher(usn);
					
				}
				
				//Generating ID from USN
				int id=0;
				Pattern pattern1 = Pattern.compile("(\\d\\d\\d)$");
				Matcher matcher1 = pattern1.matcher(usn);
				if (matcher1.find()) //Condition will work if last three characters are digits
				{
					    id = Integer.parseInt(matcher1.group()); //converting last three digits into integer

				}
				
				String sem = textField_2.getText();
				String branch = textField_3.getText();
				String cgpa = textField_4.getText();
				String nob = textField_5.getText();
				
				//Getting Phone no. from textField_6
				Pattern pattern3 = Pattern.compile("^[1-9]\\d{9}$");
				String phno = textField_6.getText();
				Matcher matcher3 = pattern3.matcher(phno);
				while(!(matcher3.matches())) {
					phno = JOptionPane.showInputDialog("Enter valid Phone Number");
					matcher3 = pattern3.matcher(phno);
					
				}
				
				//Getting email from textField_7
				Pattern pattern4 = Pattern.compile("^[0-9a-zA-Z_]+@[a-z]+\\.[a-z]+$");
				String email = textField_7.getText();
				Matcher matcher4 = pattern4.matcher(email);
				while(!(matcher4.matches())) {
					email = JOptionPane.showInputDialog("Enter valid Email");
					matcher4 = pattern4.matcher(email);
					
				}
				
				String b = id + "|" + name + "|" + usn + "|" + sem + "|" + branch + "|" + cgpa + "|" + nob + "|" + phno + "|" + email + "|" + "\n";

				try {

				int flag=0, flag1 = 0;
				String b1="", p="", r3="";
				String name1="", usn1="", sem1="", branch1="", cgpa1="", nob1="", phno1="", email1="";
				
				File file = new File("student.txt");
				if(file.exists() == false) {
					file.createNewFile();
				}
				BufferedReader br1 = new BufferedReader(new FileReader(file));
				File temp = new File("temp1.txt");
				PrintWriter pw1 = new PrintWriter(temp);
				
				StringBuilder sb = new StringBuilder();
				
				//Inserting record if file is empty	
				if((p = br1.readLine()) == null) {
					pw1.print(b);
					JOptionPane.showMessageDialog(null,"Record Inserted");
					pw1.flush();
					pw1.close();
					br1.close();
					file.delete();
					temp.renameTo(file);
				}
				
				//Inserting record if file is not empty	
				else {
					while(true)
					{
					String[] result = p.split("\\|");
					int id1 = Integer.parseInt(result[0]);
					name1 = result[1];
					usn1 = result[2];
					sem1 = result[3];
					branch1 = result[4];
					cgpa1 = result[5];
					nob1 = result[6];
					phno1 = result[7];
					email1 = result[8];
					
					b1 = id1 + "|" + name1 + "|" + usn1 + "|" + sem1 + "|" + branch1 + "|" + cgpa1 + "|" + nob1 + "|" + phno1 + "|" + email1 + "|";
	
					
							if(id1 < id) {			//If fetched_id(usn11)_from_record < id_of_current_record going to be inserted
								String m = b1 + "\n";	//same as b
								sb.append(m);
								flag = 1;
							}
							
							else if(id1 > id) {		//If fetched_id(usn11)_from_record > id_of_current_record going to be inserted
								sb.append(b);
								flag = 2;
							}
							
							else if(id1 == id) {
								String m = b1 + "\n";	
								sb.append(m);
								flag1 = 1;
								{		
									while((p = br1.readLine()) != null) {
										
										String[] result2 = p.split("\\|");
										int id2 = Integer.parseInt(result2[0]);
										String name2 = result2[1];
										String usn2 = result2[2];
										String sem2 = result2[3];
										String branch2 = result2[4];
										String cgpa2 = result2[5];
										String nob2 = result2[6];
										String phno2 = result2[7];
										String email2 = result2[8];
										
										String b2 = id2 + "|" + name2 + "|" + usn2 + "|" + sem2 + "|" + branch2 + "|" + cgpa2 + "|" + nob2 + "|" + phno2 + "|" + email2 + "|";
										
										
										sb.append(b2 + "\n");	
										
								   }
									break;
									}
							}
							
							if(flag == 1) {
								if((p = br1.readLine()) == null) {									
									sb.append(b);
									break;
								}
								else {
									continue;
								}
							}
							
							if(flag == 2) {
								String m = b1 + "\n";
								sb.append(m);	
							}
							
							{		
							while((p = br1.readLine()) != null) {
								
								String[] result3 = p.split("\\|");
								int id3 = Integer.parseInt(result3[0]);
								String name3 = result3[1];
								String usn3 = result3[2];
								String sem3 = result3[3];
								String branch3 = result3[4];
								String cgpa3 = result3[5];
								String nob3 = result3[6];
								String phno3 = result3[7];
								String email3 = result3[8];
								
								String b3 = id3 + "|" + name3 + "|" + usn3 + "|" + sem3 + "|" + branch3 + "|" + cgpa3 + "|" + nob3 + "|" + phno3 + "|" + email3 + "|";
								
								sb.append(b3 + "\n");	
								
						   }
							break;
							}
							
							}
							
							pw1.print(sb.toString());
							if(flag1 == 0)
								JOptionPane.showMessageDialog(null,"Record Inserted");
							else
								JOptionPane.showMessageDialog(null,"Duplicate USN, cannot insert record");
							pw1.flush();
							pw1.close();
							br1.close();
							br1.close();
							file.delete();
							temp.renameTo(file);
							clearfield();
					}
				}
			
			catch(FileNotFoundException ioe) {
				System.out.println("Error occured");
			} catch (IOException e1) {
				 System.out.println("Error occured for br");
			}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setBounds(411, 697, 217, 67);
		insertframe.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("NO. OF BACKLOGS");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_6.setBounds(842, 139, 310, 61);
		insertframe.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PHONE NUMBER");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_7.setBounds(842, 243, 310, 61);
		insertframe.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("EMAIL ID");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_8.setBounds(842, 348, 312, 61);
		insertframe.getContentPane().add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_5.setColumns(10);
		textField_5.setBounds(1222, 149, 296, 50);
		insertframe.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_6.setColumns(10);
		textField_6.setBounds(1222, 243, 296, 50);
		insertframe.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_7.setColumns(10);
		textField_7.setBounds(1222, 358, 296, 50);
		insertframe.getContentPane().add(textField_7);
		
		
		insertframe.setBounds(500, 500, 1050, 800);
		insertframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
