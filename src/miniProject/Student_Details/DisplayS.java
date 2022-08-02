package miniProject.Student_Details;

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

public class DisplayS {

	JFrame displayframe;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayS window = new DisplayS();
					window.displayframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		displayframe = new JFrame();
		displayframe.getContentPane().setBackground(new Color(135, 206, 250));
		displayframe.getContentPane().setLayout(null);
		displayframe.setExtendedState(displayframe.MAXIMIZED_BOTH);
		displayframe.setTitle("Placement Management system");
		
		JLabel lblNewLabel = new JLabel("DISPLAY");
		lblNewLabel.setBounds(276, 24, 1036, 61);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		displayframe.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDetails sd = new StudentDetails();
				sd.sd.setVisible(true);
				displayframe.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(943, 710, 211, 67);
		displayframe.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 124, 1380, 518);
		displayframe.getContentPane().add(scrollPane);
		
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
		
		JButton btnNewButton = new JButton("DISPLAY");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = "" ,usn = "" ,sem = "" ,branch = "", cgpa = "", nob ="", phno = "", email = "", s;
				
				try {
					BufferedReader br = new BufferedReader(new FileReader("student.txt"));
					while((s = br.readLine())!=null)
					{
						String[] result = s.split("\\|");
						name = result[1];
						usn = result[2];
						sem = result[3];
						branch = result[4];
						cgpa = result[5];
						nob = result[6];
						phno = result[7];
						email = result[8];
						
						String[] row = {usn, name, sem, branch, cgpa, nob, phno, email};
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
		displayframe.getContentPane().add(btnNewButton);
		
		displayframe.setBounds(500, 500, 1050, 800);
		displayframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
