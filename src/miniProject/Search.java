package miniProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;

public class Search {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 500, 1050, 800);
		frame.setTitle("Placement Managemet System");
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setBounds(10, 45, 1540, 61);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter USN to Search");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel_1.setBounds(290, 164, 362, 68);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(913, 164, 334, 68);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setBounds(278, 335, 1011, 104);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				BufferedReader br = new BufferedReader(new FileReader("student.txt"));
				String name = "", usn = "", sem = "", branch = "", r;
				//System.out.println("Enter the usn");
				String usn1 = textField.getText();
				while((r= br.readLine()) !=null)
				{
					String[] result = r.split("\\|");
					name=result[0];
					usn=result[1];
					sem= result[2];
					branch=result[3];
					if(usn.equals(usn1))
					{
						//System.out.println("Match found. The details of the record are:");
						textField_1.setText(name + " " + usn + " " + sem + " " + branch);
						br.close();
						return;
					}
				}
				textField_1.setText("Record not found");
				br.close();
				}
				catch(IOException ioe) {
					System.out.println("Some error occured");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnNewButton.setBounds(712, 619, 177, 61);
		frame.getContentPane().add(btnNewButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
