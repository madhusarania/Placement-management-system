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

public class SearchP {

	JFrame searchframep;
	private JTable table;
	DefaultTableModel model;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchP window = new SearchP();
					window.searchframep.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		searchframep = new JFrame();
		searchframep.getContentPane().setBackground(new Color(135, 206, 250));
		searchframep.getContentPane().setLayout(null);
		searchframep.setExtendedState(searchframep.MAXIMIZED_BOTH);
		searchframep.setTitle("Placement Management system");
		
		JLabel lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setBounds(276, 24, 1036, 61);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		searchframep.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlacementDetails sd = new PlacementDetails();
				sd.pd.setVisible(true);
				searchframep.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(669, 706, 211, 67);
		searchframep.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 452, 1503, 151);
		searchframep.getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"USN", "NAME", "Branch", "Email", "P/NP", "ComName", "Role", "F/I", "CTC"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JTableHeader tableHeader = table.getTableHeader();
	      tableHeader.setBackground(Color.CYAN);
//	      tableHeader.setForeground(Color.white);
	      Font headerFont = new Font("Verdana", Font.BOLD, 25);
	      tableHeader.setFont(headerFont);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setRowHeight(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		
		scrollPane.setViewportView(table);
		
//		JButton btnNewButton = new JButton("DISPLAY");
//		btnNewButton.setEnabled(false);
//		btnNewButton.setBackground(Color.CYAN);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				try {
//					
//					String s="", c="", p="";
//					String name="", usn="", branch="", email="", pl="", np="";
//					String cname="", role="", fi="", ctc="";
//					String bp="", bnp="";
//					int id=0, flag=0;
//					
//					BufferedReader br1 = new BufferedReader(new FileReader("student.txt"));
//					BufferedReader br2 = new BufferedReader(new FileReader("company.txt"));
//					
//					File file = new File("placement.txt");
//					BufferedReader br3 = new BufferedReader(new FileReader(file));
//					
//					File temp = new File("tempOfPl.txt");
//					PrintWriter pw = new PrintWriter(temp);
//					
//					StringBuilder sb = new StringBuilder();
//					
//					while((s = br1.readLine()) != null) {
//						String[] result1 = s.split("\\|");
//						id = Integer.parseInt(result1[0]);
//						name = result1[1];
//						usn = result1[2];
//						branch = result1[4];
//						email = result1[8];
//						pl = "Placed";
//						np = "Not Placed";
//					
//						while((p = br3.readLine()) != null) {
//							String[] result = p.split("\\|");
//							int pID = Integer.parseInt(result[0]);
//							String comName = result[3];
//							String roleOff = result[4];
//							
//							if(id < pID) {
//								bnp = id + "|" + name + "|" + usn + "|" + branch + "|" + email + "|" + np + "|" + "NIL" + "|" + "NIL" + "|" + "NIL" + "|" + "NIL" + "|" + "\n";
//								sb.append(bnp);
//								s = br1.readLine();	
//								String[] result2 = s.split("\\|");
//								id = Integer.parseInt(result2[0]);
//								name = result2[1];
//								usn = result2[2];
//								branch = result2[4];
//								email = result2[8];
//								pl = "Placed";
//								np = "Not Placed";
//							}
//							
//							if(pID == id) {
//								
//								while((c = br2.readLine()) != null) {
//									String[] result2 = c.split("\\|");
//									cname = result2[0];
//									role = result2[1];
//									fi = result2[2];
//									ctc = result2[3];
//
//								if(comName.equals(cname) && roleOff.equals(role)) {
//									bp = id + "|" + name + "|" + usn + "|" + branch + "|" + email + "|" + pl + "|" + cname + "|" + role + "|" + fi + "|" + ctc + "|" + "\n";
//									sb.append(bp);
//									flag = 1;
//								}
//								else
//									continue;
//								}
//								if(flag == 1) {
//									br2 = new BufferedReader(new FileReader("company.txt"));
//									break;
//								}
//							}
//							
//							else if(pID < id) {
//									continue;
//								}
//							
//						}
//
//					 }
//						pw.print(sb.toString());
//						pw.flush();
//						pw.close();
//						br1.close();
//						br2.close();
//						br3.close();
//					}
//					catch(IOException ioe) {
//						System.out.println("Some error");
//					}
//					
//				displayToTable();	
//
//			
//		}
//	});
//	
//		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
//		btnNewButton.setBounds(208, 654, 229, 67);
//		searchframep.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(183, 189, 229, 55);
		searchframep.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Placed", "Not Placed"}));
		comboBox.setBounds(1174, 189, 277, 46);
		searchframep.getContentPane().add(comboBox);
		
		JButton btnSearch = new JButton("Search By USN");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					
					BufferedReader br = new BufferedReader(new FileReader("tempOfPl.txt"));

					String name="", usn="", branch="", email="", pnp="",cname="", role="", fi="", ctc="", s;

					Pattern pattern2 = Pattern.compile("^(\\d[a-z]{2}\\d\\d[a-z]{2}\\d{3}|\\d[A-Z]{2}\\d\\d[A-Z]{2}\\d{3})$");
					String usn1 = textField.getText();
					
					Matcher matcher2 = pattern2.matcher(usn1);
					while(!(matcher2.matches())) {
						usn1 = JOptionPane.showInputDialog("Enter valid USN");
						matcher2 = pattern2.matcher(usn1);	
						textField.setText(null);
					}

					while((s = br.readLine()) !=null)
					{
						String[] result3 = s.split("\\|");
						name = result3[1];
						usn = result3[2];
						branch = result3[3];
						email = result3[4];
						pnp = result3[5];
						cname = result3[6];
						role = result3[7];
						fi = result3[8];
						ctc = result3[9];
						
						if(usn.equals(usn1))
						{
							String[] row = {usn, name, branch, email, pnp, cname, role, fi, ctc};
							model.addRow(row);
							br.close();
							return;
						}
					}
					JOptionPane.showMessageDialog(null, "Record not found");
					br.close();
					//textField.setText(null);
					}
					catch(IOException ioe) {
						System.out.println("Some error occured");
					}
				
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSearch.setBackground(Color.CYAN);
		btnSearch.setBounds(183, 271, 229, 67);
		searchframep.getContentPane().add(btnSearch);
		
		JButton btnSearchByOption = new JButton("Search By Option");
		btnSearchByOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedValue = (String)comboBox.getSelectedItem();
				textField.setText(null);
				try {
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					
					BufferedReader br1 = new BufferedReader(new FileReader("tempOfPl.txt"));

					String name1="", usn1="", branch1="", email1="", pnp1="",cname1="", role1="", fi1="", ctc1="", s1;
					
					int flag = 0;

					while((s1 = br1.readLine()) !=null)
					{
						String[] result13 = s1.split("\\|");
						name1 = result13[1];
						usn1 = result13[2];
						branch1 = result13[3];
						email1 = result13[4];
						pnp1 = result13[5];
						cname1 = result13[6];
						role1 = result13[7];
						fi1 = result13[8];
						ctc1 = result13[9];
						
						if(selectedValue.equals(pnp1))
						{
							String[] row = {usn1, name1, branch1, email1, pnp1, cname1, role1, fi1, ctc1};
							model.addRow(row);
							flag = 1;
							
						}
						
					}
					if(flag == 1) {
						br1.close();
						return;
					}
					JOptionPane.showMessageDialog(null, "Record not found");
					br1.close();
					//textField.setText(null);
					}
					catch(IOException ioe) {
						System.out.println("Some error occured");
					}
				
				
				
			}
		});
		btnSearchByOption.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSearchByOption.setBackground(Color.CYAN);
		btnSearchByOption.setBounds(1174, 271, 277, 67);
		searchframep.getContentPane().add(btnSearchByOption);
		
		JComboBox comboBox_1 = new JComboBox();
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
		comboBox_1.setBounds(698, 195, 277, 46);
		searchframep.getContentPane().add(comboBox_1);
		
		JButton btnSearchByCompany = new JButton("Search By Company");
		btnSearchByCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				String selectedValue2 = (String)comboBox_1.getSelectedItem();
				
				try {
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					
					BufferedReader br5 = new BufferedReader(new FileReader("tempOfPl.txt"));

					String name1="", usn1="", branch1="", email1="", pnp1="",cname1="", role1="", fi1="", ctc1="", s5;
					
					int flag = 0;

					while((s5 = br5.readLine()) !=null)
					{
						String[] result13 = s5.split("\\|");
						name1 = result13[1];
						usn1 = result13[2];
						branch1 = result13[3];
						email1 = result13[4];
						pnp1 = result13[5];
						cname1 = result13[6];
						role1 = result13[7];
						fi1 = result13[8];
						ctc1 = result13[9];
						
						if(selectedValue2.equals(cname1))
						{
							String[] row = {usn1, name1, branch1, email1, pnp1, cname1, role1, fi1, ctc1};
							model.addRow(row);
							flag = 1;
							
						}
						
					}
					if(flag == 1) {
						br5.close();
						return;
					}
					JOptionPane.showMessageDialog(null, "Record not found");
					br5.close();
					//textField.setText(null);
					}
					catch(IOException ioe) {
						System.out.println("Some error occured");
					}
				
				
				
			}
		});
		btnSearchByCompany.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSearchByCompany.setBackground(Color.CYAN);
		btnSearchByCompany.setBounds(682, 271, 313, 67);
		searchframep.getContentPane().add(btnSearchByCompany);
		
		
		
		searchframep.setBounds(500, 500, 1050, 800);
		searchframep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void displayToTable() {
		String name="", usn="", branch="", email="", pnp="",cname="", role="", fi="", ctc="", s;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("tempOfPl.txt"));
			while((s = br.readLine())!=null)
			{
				String[] result3 = s.split("\\|");
				name = result3[1];
				usn = result3[2];
				branch = result3[3];
				email = result3[4];
				pnp = result3[5];
				cname = result3[6];
				role = result3[7];
				fi = result3[8];
				ctc = result3[9];
				
				String[] row = {usn, name, branch, email, pnp, cname, role, fi, ctc};
				model.addRow(row);
				

			}
			br.close();
			}
			catch(IOException ioe) {
				System.out.println("Some error");
			}
		
	}
}
