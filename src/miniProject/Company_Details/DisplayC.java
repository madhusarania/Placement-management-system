package miniProject.Company_Details;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DisplayC {

	JFrame displayframec;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayC window = new DisplayC();
					window.displayframec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		displayframec = new JFrame();
		displayframec.getContentPane().setBackground(new Color(135, 206, 250));
		displayframec.getContentPane().setLayout(null);
		displayframec.setExtendedState(displayframec.MAXIMIZED_BOTH);
		displayframec.setTitle("Placement Management system");
		
		JLabel lblNewLabel = new JLabel("DISPLAY");
		lblNewLabel.setBounds(276, 24, 1036, 61);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		displayframec.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyDetails sd = new CompanyDetails();
				sd.cdframe.setVisible(true);
				displayframec.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(943, 710, 211, 67);
		displayframec.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 124, 1380, 518);
		displayframec.getContentPane().add(scrollPane);
		
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
//		table.getColumnModel().getColumn(2).setPreferredWidth(3);
//		table.getColumnModel().getColumn(3).setPreferredWidth(5);
//		table.getColumnModel().getColumn(4).setPreferredWidth(5);
//		table.getColumnModel().getColumn(5).setPreferredWidth(10);
//		table.getColumnModel().getColumn(7).setPreferredWidth(200);
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("DISPLAY");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cname = "", role = "", fi = "", ctc = "", r;
				
				try {
					BufferedReader br = new BufferedReader(new FileReader("company.txt"));
					while((r = br.readLine())!=null)
					{
						String[] result = r.split("\\|");
						cname=result[0];
						role=result[1];
						fi= result[2];
						ctc=result[3];					
						
						String [] row = {cname, role, fi, ctc};
						model.addRow(row);
						

					}
					br.close();
					}
					catch(IOException ioe) {
						System.out.println("Some error");
					}
					
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setBounds(458, 710, 229, 67);
		displayframec.getContentPane().add(btnNewButton);
		
		displayframec.setBounds(500, 500, 1050, 800);
		displayframec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
