package miniProject.Placement_Details;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InsertP {

	JFrame insertframep;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertP window = new InsertP();
					window.insertframep.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsertP() {
		initialize();
	}
	
	void clearField() {
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		insertframep = new JFrame();
		insertframep.getContentPane().setBackground(new Color(135, 206, 250));
		insertframep.setBounds(500, 500, 1080, 800);
		insertframep.setExtendedState(insertframep.MAXIMIZED_BOTH);
		insertframep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		insertframep.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(188, 167, 168, 47);
		insertframep.getContentPane().add(lblNewLabel);
		
		JLabel lblCompany = new JLabel("COMPANY");
		lblCompany.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblCompany.setBounds(684, 167, 168, 47);
		insertframep.getContentPane().add(lblCompany);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(134, 413, 287, 45);
		insertframep.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(647, 423, 287, 47);
		insertframep.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(1152, 423, 287, 47);
		insertframep.getContentPane().add(textField_2);
		
		
// JComboBox for inserting student names		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setMaximumRowCount(30);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				String selectedValue = (String)comboBox.getSelectedItem();
//				textField.setText(selectedValue);
			}
		});
		
		int index = 0;
		String name, r;
		String[] items = new String[30];
		try {
		BufferedReader br = new BufferedReader(new FileReader("student.txt"));
		while((r = br.readLine()) != null) {
			String[] result = r.split("\\|");
			name = result[1];
			items[index] = name;
			comboBox.addItem(items[index]);
			index++;
		}
		br.close();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(comboBox);
		comboBox.setBounds(134, 281, 287, 59);

		insertframep.getContentPane().add(comboBox);

// JComboBox for inserting company names	
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		int count = 0;
		int flag = 0;
		String cname, s;
		String[] items1 = new String[30];
		try {
		BufferedReader br1 = new BufferedReader(new FileReader("company.txt"));
		while((s = br1.readLine()) != null) {
			String[] result = s.split("\\|");
			cname = result[0];
			for(int i=0; i<5; i++) {
				if(items1[i] == null || items1[i].equals(cname)) {
					if(items1[i] == null)
					{
						break;
					}
					flag = 1;
					break;
				}
			}
			if(flag == 1) {
				continue;
			}
			else {
				items1[count] = cname;
				comboBox_1.addItem(items1[count]);
				count++;
			}
		}
		br1.close();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setMaximumRowCount(30);
		comboBox.addActionListener(comboBox);
		comboBox_1.setBounds(647, 281, 287, 59);
		insertframep.getContentPane().add(comboBox_1);
		
	
		
		JLabel lblRole = new JLabel("ROLE");
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRole.setBounds(1196, 167, 168, 47);
		insertframep.getContentPane().add(lblRole);
		
// JComboBox for inserting role 
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		comboBox_2.setSelectedItem(0);
		comboBox.addActionListener(comboBox);
		comboBox_2.setMaximumRowCount(30);
		comboBox_2.setBounds(1152, 281, 287, 59);
		insertframep.getContentPane().add(comboBox_2);
		
		JButton btnNewButton_3 = new JButton("SELECT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedValue = (String)comboBox.getSelectedItem();
				textField.setText(selectedValue);
				
			}
		});
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(172, 535, 168, 47);
		insertframep.getContentPane().add(btnNewButton_3);
		
		
		JButton btnNewButton_4 = new JButton("SELECT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox_2.removeAllItems();
				
				String selectedValue = (String)comboBox_1.getSelectedItem();
				textField_1.setText(selectedValue);
				
				int index2 = 0;
				String cname2, role, r2;
				String[] items2 = new String[30];
				try {
				BufferedReader br2 = new BufferedReader(new FileReader("company.txt"));
				while((r2 = br2.readLine()) != null) {
					String[] result = r2.split("\\|");
					cname2 = result[0];
					role = result[1];
					if(cname2.equals(selectedValue)) {
						items2[index2] = role;
						comboBox_2.addItem(items2[index2]);
						index2++;
					}
					else {
						continue;
					}
					
				}
				br2.close();
				
				}
				catch(IOException ioe) {
					ioe.printStackTrace();
				}
				
			}
		});
		
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4.setBounds(711, 535, 168, 47);
		insertframep.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("SELECT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedValue = (String)comboBox_2.getSelectedItem();
				textField_2.setText(selectedValue);
				
			}
		});
		btnNewButton_5.setBackground(Color.CYAN);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_5.setBounds(1217, 535, 168, 47);
		insertframep.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_1 = new JButton("INSERT");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			//Pattern pattern = Pattern.compile("(\\d\\d\\d)$");
			
			public void actionPerformed(ActionEvent e) {
				
				int flag=0;
				String b = "", p = "", r3 = "";
				String studentName = textField.getText();
				String companyName = textField_1.getText();
				String roleOffered = textField_2.getText(); 
				
				try {
				BufferedReader br6 = new BufferedReader(new FileReader("student.txt"));
				
				File file = new File("placement.txt");
				boolean bool = file.createNewFile();
				BufferedReader br7 = new BufferedReader(new FileReader(file));
				
				File temp = new File("temp.txt");
				PrintWriter pw6 = new PrintWriter(temp);
				
				StringBuilder sb6 = new StringBuilder();
				
				while((r3 = br6.readLine())!=null)
				{
					String[] result = r3.split("\\|");
					int id = Integer.parseInt(result[0]);
					String name = result[1];
					String usn = result[2];
					if(studentName.equals(name)) {
  
						    b = id + "|" + studentName + "|" + usn + "|" + companyName + "|" + roleOffered + "|" + "\n";
						
						if((p = br7.readLine()) == null) {
							pw6.print(b);
							pw6.flush();
							pw6.close();
							br7.close();
							br6.close();
							file.delete();
							temp.renameTo(file);
							break;
						}
						
						else {
							while(true) {
							String[] result1 = p.split("\\|");
							int usn1 = Integer.parseInt(result1[0]);
							
							if(usn1 < id) {
								String m = p + "\n";
								sb6.append(m);
								flag = 1;
							}
							
							else if(usn1 > id) {
								sb6.append(b);
								flag = 2;
							}
							
							if(flag == 1) {
								if((p = br7.readLine()) == null) {
									sb6.append(b);
									break;
								}
								else {
									continue;
								}
							}
							
							if(flag == 2) {
								String m = p + "\n";
								sb6.append(m);	
							}
							
							{		
							while((p = br7.readLine()) != null) {
								sb6.append(p + "\n");	
								
						   }
							break;
							}
							
							}
							
							pw6.print(sb6.toString());
							pw6.flush();
							pw6.close();
							br6.close();
							br7.close();
							file.delete();
							temp.renameTo(file);
							break;
					}
					}
					
					else
						continue;
				}
			JOptionPane.showMessageDialog(null, "Record Inserted");
			clearField();
				}
			catch(FileNotFoundException foe) {
					System.out.println("File error occured");
				}
			catch(IOException ioe) {
				System.out.println("Error occured");
			}
			}

		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(447, 698, 217, 64);
		insertframep.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PlacementDetails sd = new PlacementDetails();
				sd.pd.setVisible(true);
				insertframep.dispose();
//				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(948, 698, 217, 64);
		insertframep.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("INSERT  DETAILS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel_1.setBounds(37, 22, 1540, 61);
		insertframep.getContentPane().add(lblNewLabel_1);
		
		
	}
}
