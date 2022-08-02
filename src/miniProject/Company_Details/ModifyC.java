package miniProject.Company_Details;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ModifyC {

	JFrame modifyframec;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyC window = new ModifyC();
					window.modifyframec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModifyC() {
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


		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		modifyframec = new JFrame();
		modifyframec.setTitle("Placement Management System");
		modifyframec.getContentPane().setBackground(new Color(135, 206, 250));
		modifyframec.setExtendedState(modifyframec.MAXIMIZED_BOTH);
		modifyframec.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MODIFY");
		lblNewLabel.setBounds(294, 20, 1036, 61);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modifyframec.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(892, 705, 211, 67);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyDetails sd = new CompanyDetails();
				sd.cdframe.setVisible(true);
				modifyframec.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		modifyframec.getContentPane().add(btnBack);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setBounds(1177, 140, 263, 55);
		modifyframec.getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Select CNAME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.removeAllItems();
				
				String selectedValue = textField_6.getText();
				int flag=0;
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
						comboBox.addItem(items2[index2]);
						index2++;
						flag = 1;
					}
					else {
						continue;
					}
					
				}
				if(flag == 0) {
					JOptionPane.showMessageDialog(null, "Record Not found");
					comboBox.removeAllItems();
				}
				br2.close();
				
				}
				catch(IOException ioe) {
					ioe.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.setBounds(36, 138, 291, 55);
		modifyframec.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("MODIFY");
		btnNewButton.setBounds(502, 705, 205, 67);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = 0;
				String cname = "", r;
				try {
				File file = new File("company.txt");
				BufferedReader br = new BufferedReader(new FileReader(file));
				File temp = new File("temp.txt");
				PrintWriter pw = new PrintWriter(temp);

				String selectedValue = textField_6.getText();
				String selectedValue2 = (String)comboBox.getSelectedItem();
				
				while((r= br.readLine()) !=null)
				{	
					String[] result = r.split("\\|");
					String cname1=result[0];	
					String role1=result[1];
					
					if(selectedValue.equals(cname1) && selectedValue2.equals(role1)) 
					{
						flag = 1;
						String cname11 = textField.getText();
						String role11 = textField_1.getText();
						String fi11 = textField_2.getText(); 
						String ctc11 = textField_3.getText();
						String cgpar11 = textField_4.getText();
						String nobr11 = textField_5.getText();
						
						if(!(selectedValue.equals(cname11)))
						{
							JOptionPane.showMessageDialog(null, "Company Name mis-match, cannot modify");
							pw.println(r);
							flag = 0;
							clearfield();
							comboBox.removeAllItems();
							
						}
						else{
							String b = cname11 + "|" + role11 + "|" + fi11 + "|" + ctc11 + "|" + cgpar11 + "|" + nobr11 + "|";
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
					comboBox.removeAllItems();
				}
				
				}
				catch(IOException ioe) {
					System.out.println("Some error occured");
				}
	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		modifyframec.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("COMPANY NAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1_1.setBounds(36, 302, 330, 67);
		modifyframec.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ROLE OFFERING");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1_1_1.setBounds(36, 429, 330, 67);
		modifyframec.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("FULL/INTERN");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1_1_2.setBounds(47, 573, 330, 67);
		modifyframec.getContentPane().add(lblNewLabel_1_1_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(416, 314, 285, 55);
		modifyframec.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(416, 447, 285, 55);
		modifyframec.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(416, 573, 285, 55);
		modifyframec.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_3.setColumns(10);
		textField_3.setBounds(1220, 320, 285, 55);
		modifyframec.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_4.setColumns(10);
		textField_4.setBounds(1220, 447, 285, 55);
		modifyframec.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_5.setColumns(10);
		textField_5.setBounds(1220, 573, 285, 55);
		modifyframec.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_6.setColumns(10);
		textField_6.setBounds(416, 140, 291, 55);
		modifyframec.getContentPane().add(textField_6);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("CTC OFFERING");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1_1_2_1.setBounds(846, 302, 330, 67);
		modifyframec.getContentPane().add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("MIN. CGPA REQ.");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1_1_2_2.setBounds(846, 429, 330, 67);
		modifyframec.getContentPane().add(lblNewLabel_1_1_2_2);
		
		JLabel lblNewLabel_1_1_2_3 = new JLabel("MAX. NOB ALLOW");
		lblNewLabel_1_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1_1_2_3.setBounds(818, 561, 373, 67);
		modifyframec.getContentPane().add(lblNewLabel_1_1_2_3);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Select Role");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1_1_2_1_1.setBounds(855, 138, 234, 67);
		modifyframec.getContentPane().add(lblNewLabel_1_1_2_1_1);
		
		modifyframec.setBounds(500, 500, 1050, 800);
		modifyframec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
