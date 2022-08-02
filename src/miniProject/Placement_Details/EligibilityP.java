package miniProject.Placement_Details;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import miniProject.Placement_Details.PlacementDetails;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EligibilityP {

	JFrame eligibilityP;
	private JTable table;
	DefaultTableModel model;
	
	private JTable table1;
	DefaultTableModel model1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EligibilityP window = new EligibilityP();
					window.eligibilityP.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EligibilityP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		eligibilityP = new JFrame();
		eligibilityP.getContentPane().setBackground(new Color(135, 206, 250));
		eligibilityP.getContentPane().setLayout(null);
		eligibilityP.setExtendedState(eligibilityP.MAXIMIZED_BOTH);
		eligibilityP.setTitle("Placement Management system");
		
		JLabel lblNewLabel = new JLabel("PLACEMENT ELIGIBILITY");
		lblNewLabel.setBounds(276, 24, 1036, 61);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		eligibilityP.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlacementDetails sd = new PlacementDetails();
				sd.pd.setVisible(true);
				eligibilityP.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(665, 715, 211, 67);
		eligibilityP.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 520, 1476, 151);
		eligibilityP.getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"USN", "Name", "SEM", "Branch", "CGPA", "NOB", "Phone No.", "Email"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JTableHeader tableHeader = table.getTableHeader();
	      tableHeader.setBackground(Color.CYAN);
//	      tableHeader.setForeground(Color.white);
	      Font headerFont = new Font("Verdana", Font.BOLD, 25);
	      tableHeader.setFont(headerFont);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setRowHeight(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(3);
		table.getColumnModel().getColumn(3).setPreferredWidth(5);
		table.getColumnModel().getColumn(4).setPreferredWidth(5);
		table.getColumnModel().getColumn(5).setPreferredWidth(10);
		table.getColumnModel().getColumn(7).setPreferredWidth(200);
		scrollPane.setViewportView(table);
		
		table1 = new JTable();
		model1 = new DefaultTableModel();
		Object[] column1 = {"Company Name", "ROLE", "FULL/INTERN", "CTC", "Min CGPA ", "Max NOB"};
		model1.setColumnIdentifiers(column1);
		table1.setModel(model1);
		
		JTableHeader tableHeader1 = table1.getTableHeader();
	      tableHeader1.setBackground(Color.CYAN);
//	      tableHeader.setForeground(Color.white);
	      Font headerFont1 = new Font("Verdana", Font.BOLD, 25);
	      tableHeader1.setFont(headerFont1);
	      
	     table1.setFont(new Font("Tahoma", Font.PLAIN, 25));
	     table1.setRowHeight(30);
	      
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(27, 345, 1476, 151);
			eligibilityP.getContentPane().add(scrollPane_1);
	      scrollPane_1.setViewportView(table1);
	      
	      textField = new JTextField();
	      textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
	      textField.setBounds(1251, 173, 119, 47);
	      eligibilityP.getContentPane().add(textField);
	      textField.setColumns(10);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Min. CGPA", "Max. NOB"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(1093, 173, 119, 46);
		eligibilityP.getContentPane().add(comboBox);
		
		JButton btnSearchByOption = new JButton("Search By Option");
		btnSearchByOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedValue = (String)comboBox.getSelectedItem();
				
					double mincgpa = 0.0;
					int maxnob = 0;
					try {
						DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
						model1.setRowCount(0);	
						BufferedReader br3 = new BufferedReader(new FileReader("company.txt"));
						String cname = "", role = "", fi = "", ctc = "", r;
							
							while((r= br3.readLine()) !=null)
							{
								String[] result = r.split("\\|");
								cname=result[0];
								role=result[1];
								fi= result[2];
								ctc=result[3];
								mincgpa = Double.parseDouble(result[4]);
								maxnob = Integer.parseInt(result[5]);
		
								if(selectedValue.equals("Min. CGPA"))
								{
									double textValue = Double.parseDouble(textField.getText());
									if(mincgpa >= textValue) {
										String[] row = {cname, role, fi, ctc, String.valueOf(mincgpa), String.valueOf(maxnob)};
										model1.addRow(row);
									}
									
								}
								
								else if(selectedValue.equals("Max. NOB"))
								{
									int textValue = Integer.parseInt(textField.getText());
									if(maxnob <= textValue) {
										String[] row = {cname, role, fi, ctc, String.valueOf(mincgpa), String.valueOf(maxnob)};
										model1.addRow(row);
									}
									
								}
							}
								br3.close();
							}
					catch(IOException ioe) {
						
					}
					try {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);	
						BufferedReader br4 = new BufferedReader(new FileReader("student.txt"));
						String name = "" ,usn = "" ,sem = "" ,branch = "", phno = "", email = "", s;
						int nob = 0;
						float cgpa = 0;
							
						while((s = br4.readLine())!=null)
						{
							String[] result = s.split("\\|");
							name = result[1];
							usn = result[2];
							sem = result[3];
							branch = result[4];
							cgpa = Float.parseFloat(result[5]);
							nob = Integer.parseInt(result[6]);
							phno = result[7];
							email = result[8];
							
							if(selectedValue.equals("Min. CGPA"))
							{
								float textValue = Float.parseFloat(textField.getText());
								if(cgpa >= textValue) {
									String[] row = {usn, name, sem, branch, String.valueOf(cgpa), String.valueOf(nob), phno, email};
									model.addRow(row);
								}
								
							}
							
							else if(selectedValue.equals("Max. NOB"))
							{
								int textValue = Integer.parseInt(textField.getText());
								if(nob <= textValue) {
									String[] row = {usn, name, sem, branch, String.valueOf(cgpa), String.valueOf(nob), phno, email};
									model.addRow(row);
								}
								
							}
						}
						br4.close();
						}
					catch(IOException ioe) {
						
					}

				
			}
		});
		btnSearchByOption.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSearchByOption.setBackground(Color.CYAN);
		btnSearchByOption.setBounds(1093, 249, 277, 67);
		eligibilityP.getContentPane().add(btnSearchByOption);
		
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
		
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setBounds(358, 188, 202, 46);
		eligibilityP.getContentPane().add(comboBox_1);
		
		//Eligibility Criteria based on Company Name
		JButton btnSearchByCompany = new JButton("CHECK");
		btnSearchByCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedValue = (String)comboBox_1.getSelectedItem();
				double mincgpa = 0.0;
				int maxnob = 0;
				try {
					DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
					model1.setRowCount(0);	
					BufferedReader br = new BufferedReader(new FileReader("company.txt"));
					String cname = "", role = "", fi = "", ctc = "", r;
						
						while((r= br.readLine()) !=null)
						{
							String[] result = r.split("\\|");
							cname=result[0];
							role=result[1];
							fi= result[2];
							ctc=result[3];
							mincgpa = Double.parseDouble(result[4]);
							maxnob = Integer.parseInt(result[5]);
	
							if(selectedValue.equals(cname))
							{

								String[] row = {cname, role, fi, ctc, String.valueOf(mincgpa), String.valueOf(maxnob)};
								model1.addRow(row);
								break;
							}
						}
							br.close();
						}
				catch(IOException ioe) {
					
				}
				try {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);	
					BufferedReader br2 = new BufferedReader(new FileReader("student.txt"));
					String name = "" ,usn = "" ,sem = "" ,branch = "", phno = "", email = "", s;
					int nob = 0;
					double cgpa = 0.0;
						
					while((s = br2.readLine())!=null)
					{
						String[] result = s.split("\\|");
						name = result[1];
						usn = result[2];
						sem = result[3];
						branch = result[4];
						cgpa = Double.parseDouble(result[5]);
						nob = Integer.parseInt(result[6]);
						phno = result[7];
						email = result[8];
						
						if((cgpa >= mincgpa) && (nob <= maxnob)) {
							
							String[] row = {usn, name, sem, branch, String.valueOf(cgpa), String.valueOf(nob), phno, email};
							model.addRow(row);
							
						}
					}
					br2.close();
					}
				catch(IOException ioe) {
					
				}
				
				
			}
		});
		btnSearchByCompany.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSearchByCompany.setBackground(Color.CYAN);
		btnSearchByCompany.setBounds(356, 267, 211, 56);
		eligibilityP.getContentPane().add(btnSearchByCompany);
		
		
		JLabel lblNewLabel_1 = new JLabel("By Company");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setBounds(44, 173, 277, 61);
		eligibilityP.getContentPane().add(lblNewLabel_1);
		


		eligibilityP.setBounds(500, 500, 1050, 800);
		eligibilityP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
