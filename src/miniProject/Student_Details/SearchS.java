package miniProject.Student_Details;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SearchS {

	JFrame searchframe;
	private JTextField textField;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchS window = new SearchS();
					window.searchframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		searchframe = new JFrame();
		searchframe.setBounds(500, 500, 1050, 800);
		searchframe.setTitle("Placement Managemet System");
		searchframe.getContentPane().setBackground(new Color(135, 206, 250));
		searchframe.getContentPane().setLayout(null);
		searchframe.setExtendedState(searchframe.MAXIMIZED_BOTH);
		
		JLabel lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setBounds(10, 45, 1540, 61);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search By");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(348, 194, 362, 68);
		searchframe.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(787, 271, 342, 63);
		searchframe.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDetails sd = new StudentDetails();
				sd.sd.setVisible(true);
				searchframe.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(969, 708, 211, 67);
		searchframe.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 443, 1351, 163);
		searchframe.getContentPane().add(scrollPane);
		
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"USN", "CGPA", "NOB"}));
		comboBox.setBounds(432, 272, 246, 61);
		searchframe.getContentPane().add(comboBox);
		
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedValue = (String)comboBox.getSelectedItem();			
				try {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);	
				BufferedReader br = new BufferedReader(new FileReader("student.txt"));
				String name = "", usn = "", sem = "", branch = "", cgpa = "", nob = "", phno = "", email = "", r;
					
					if(selectedValue == "USN") {
						
						Pattern pattern2 = Pattern.compile("^(\\d[a-z]{2}\\d\\d[a-z]{2}\\d{3}|\\d[A-Z]{2}\\d\\d[A-Z]{2}\\d{3})$");
						String usn1 = textField.getText();
						Matcher matcher2 = pattern2.matcher(usn1);
						while(!(matcher2.matches())) {
							usn1 = JOptionPane.showInputDialog("Enter valid USN");
							matcher2 = pattern2.matcher(usn1);	
							textField.setText(null);
						}
						
						while((r= br.readLine()) !=null)
						{
							String[] result = r.split("\\|");
							name=result[1];			
							usn=result[2];
							sem= result[3];
							branch=result[4];
							cgpa=result[5];
							nob=result[6];
							phno= result[7];
							email=result[8];
						
						if(usn.equals(usn1))
						{
							String[] row = {usn, name, sem, branch, cgpa, nob, phno, email};
							model.addRow(row);
							br.close();
							textField.setText(null);
							return;
						}
					}
					JOptionPane.showMessageDialog(null, "Record Not Found");
					textField.setText(null);
					br.close();
					}
					
					else if(selectedValue == "CGPA") {
						
						int flag = 0;
						
						double cgpa1 = Double.parseDouble(textField.getText());
						
						while((r= br.readLine()) !=null)
						{
							String[] result = r.split("\\|");
							name=result[1];			
							usn=result[2];
							sem= result[3];
							branch=result[4];
					double cgpa11 = Double.parseDouble(result[5]);
							nob=result[6];
							phno= result[7];
							email=result[8];
						
						if(cgpa11 > cgpa1 || cgpa11 == cgpa1)
						{
							flag = 1;
							String[] row = {usn, name, sem, branch, String.valueOf(cgpa11), nob, phno, email};
							model.addRow(row);
						}
					}
						if(flag == 0)
							JOptionPane.showMessageDialog(null, "Record Not Found");
						textField.setText(null);
						br.close();
					}
					
					
					else if(selectedValue == "NOB") {
						
						String nob1 = textField.getText();
						int flag = 0;
						
						while((r= br.readLine()) !=null)
						{
							String[] result = r.split("\\|");
							name=result[1];			
							usn=result[2];
							sem= result[3];
							branch=result[4];
							cgpa=result[5];
							nob=result[6];
							phno= result[7];
							email=result[8];
						
						if(nob.equals(nob1))
						{
							flag = 1;
							String[] row = {usn, name, sem, branch, cgpa, nob, phno, email};
							model.addRow(row);
						}
					}
						if(flag == 0)
							JOptionPane.showMessageDialog(null, "Record Not Found");
						textField.setText(null);
					br.close();
					}
					
			}
	
				catch(IOException ioe) {
					System.out.println("Some error occured");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setBounds(485, 708, 211, 67);
		searchframe.getContentPane().add(btnNewButton);
		
		
		
		searchframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
