package miniProject.Company_Details;

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

public class SearchC {

	JFrame searchframec;
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
					SearchC window = new SearchC();
					window.searchframec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		searchframec = new JFrame();
		searchframec.setBounds(500, 500, 1050, 800);
		searchframec.setTitle("Placement Managemet System");
		searchframec.getContentPane().setBackground(new Color(135, 206, 250));
		searchframec.getContentPane().setLayout(null);
		searchframec.setExtendedState(searchframec.MAXIMIZED_BOTH);
		
		JLabel lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setBounds(10, 45, 1540, 61);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchframec.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search By");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(348, 194, 362, 68);
		searchframec.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(787, 271, 342, 63);
		searchframec.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyDetails sd = new CompanyDetails();
				sd.cdframe.setVisible(true);
				searchframec.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(969, 708, 211, 67);
		searchframec.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 443, 1351, 163);
		searchframec.getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Company Name", "ROLE", "FULL/INTERN", "CTC"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JTableHeader tableHeader = table.getTableHeader();
	      tableHeader.setBackground(Color.CYAN);
//	      tableHeader.setForeground(Color.white);
	      Font headerFont = new Font("Verdana", Font.BOLD, 25);
	      tableHeader.setFont(headerFont);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setRowHeight(30);
		
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Company Name", "ROLE", "Full/Intern"}));
		comboBox.setBounds(432, 272, 246, 61);
		searchframec.getContentPane().add(comboBox);
		
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedValue = (String)comboBox.getSelectedItem();			
				try {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);	
					BufferedReader br = new BufferedReader(new FileReader("company.txt"));
					String cname = "", role = "", fi = "", ctc = "", r;
					
					if(selectedValue == "Company Name") {
					
						String cname1 = textField.getText();
						int flag = 0;
						
						while((r= br.readLine()) !=null)
						{
							String[] result = r.split("\\|");
							cname=result[0];
							role=result[1];
							fi= result[2];
							ctc=result[3];					
	
							if(cname1.equals(cname))
							{
								flag = 1;
								String [] row = {cname, role, fi, ctc};
								model.addRow(row);
							}
						}
							if(flag == 0)
								JOptionPane.showMessageDialog(null, "Record Not Found");
							br.close();
						}
						
					
					else if(selectedValue == "ROLE") {
					
						String role1 = textField.getText();
						int flag = 0;
						
						while((r= br.readLine()) !=null)
						{
							String[] result = r.split("\\|");
							cname=result[0];
							role=result[1];
							fi= result[2];
							ctc=result[3];					
	
							if(role1.equals(role))
							{
								flag = 1;
								String [] row = {cname, role, fi, ctc};
								model.addRow(row);
							}
						}
							if(flag == 0)
								JOptionPane.showMessageDialog(null, "Record Not Found");
							br.close();
						}
					
					
					else if(selectedValue == "Full/Intern") {
						
						String fi1 = textField.getText();
						int flag = 0;
						
						while((r= br.readLine()) !=null)
						{
							String[] result = r.split("\\|");
							cname=result[0];
							role=result[1];
							fi= result[2];
							ctc=result[3];					
	
							if(fi1.equals(fi))
							{
								flag = 1;
								String [] row = {cname, role, fi, ctc};
								model.addRow(row);
							}
						}
							if(flag == 0)
								JOptionPane.showMessageDialog(null, "Record Not Found");
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
		searchframec.getContentPane().add(btnNewButton);
		
		
		
		searchframec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
