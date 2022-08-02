package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import miniProject.Company_Details.CompanyDetails;
import miniProject.Placement_Details.PlacementDetails;
import miniProject.Student_Details.StudentDetails;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	public JFrame homeframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.homeframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homeframe = new JFrame();
		homeframe.setSize(761, 438);
		homeframe.setTitle("Placement Management System"); 	// Adding title for JFrame
		homeframe.getContentPane().setBackground(new Color(135, 206, 250));
		homeframe.setExtendedState(homeframe.MAXIMIZED_BOTH);   // Maximizing JFrame
		homeframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 66));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(192, 62, 1189, 57);
		homeframe.getContentPane().add(lblNewLabel);
		
		//Creating button to switch to 'Student Details' JFrame
		
		JButton btnNewButton = new JButton("STUDENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				StudentDetails sd = new StudentDetails();  //creating an object of StudentDetails class (StudentDetials.java)
				sd.sd.setVisible(true);						//Making StudentDetails JFrame visible
				homeframe.dispose();					   //Disposing current JFrame
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(192, 248, 371, 114);
		homeframe.getContentPane().add(btnNewButton);
		
		//Creating button to switch to 'Company Details' JFrame
		
		JButton btnCompany = new JButton("COMPANY");				
		btnCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyDetails cd = new CompanyDetails();			//creating an object of StudentDetails class (StudentDetials.java)
				cd.cdframe.setVisible(true);						//Making StudentDetails JFrame visible
				homeframe.dispose();								//Disposing current JFrame
			}
		});
		btnCompany.setForeground(Color.BLACK);
		btnCompany.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnCompany.setBackground(Color.CYAN);
		btnCompany.setBounds(997, 248, 381, 114);
		homeframe.getContentPane().add(btnCompany);
		
		//Creating button to switch to 'Placement Details' JFrame
		
		JButton btnSummary = new JButton("PLACEMENT");
		btnSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlacementDetails pd = new PlacementDetails();			//creating an object of PlacementDetails class (PlacementDetails.java)
				pd.pd.setVisible(true);						//Making PlacementDetails JFrame visible
				homeframe.dispose();	
			}
		});

		btnSummary.setForeground(Color.BLACK);
		btnSummary.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSummary.setBackground(Color.CYAN);
		btnSummary.setBounds(586, 538, 381, 114);
		homeframe.getContentPane().add(btnSummary);
		homeframe.setBounds(500, 500, 1050, 800);
		homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//Action to be performed when Close button is pressed
	}
}
