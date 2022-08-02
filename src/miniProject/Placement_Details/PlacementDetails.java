package miniProject.Placement_Details;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import miniProject.Home;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlacementDetails {

	public JFrame pd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlacementDetails window = new PlacementDetails();
					window.pd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlacementDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pd = new JFrame();
		pd.setSize(761, 438);
		pd.setTitle("Placement Management System");
		pd.setExtendedState(pd.MAXIMIZED_BOTH);
		pd.getContentPane().setBackground(new Color(135, 206, 250));
		pd.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLACEMENT   DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 66));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(195, 54, 1189, 57);
		pd.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertP in = new InsertP();
				in.insertframep.setVisible(true);
				pd.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(395, 269, 265, 95);
		pd.getContentPane().add(btnNewButton);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setForeground(Color.BLACK);
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnDisplay.setBackground(Color.CYAN);
		btnDisplay.setBounds(387, 476, 273, 95);
		pd.getContentPane().add(btnDisplay);
		
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayP dis = new DisplayP();
				dis.displayframep.setVisible(true);
				pd.dispose();
			}
		});
		
		JButton btnDisplay_1 = new JButton("SEARCH");
		btnDisplay_1.setForeground(Color.BLACK);
		btnDisplay_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnDisplay_1.setBackground(Color.CYAN);
		btnDisplay_1.setBounds(908, 269, 253, 95);
		pd.getContentPane().add(btnDisplay_1);
		
		btnDisplay_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchP se = new SearchP();
				se.searchframep.setVisible(true);
				pd.dispose();
			}
		});
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.homeframe.setVisible(true);
				pd.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(675, 707, 223, 67);
		pd.getContentPane().add(btnBack);
		
		JButton btnPlacementEligibility = new JButton("ELIGIBILITY");
		btnPlacementEligibility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EligibilityP se = new EligibilityP();
				se.eligibilityP.setVisible(true);
				pd.dispose();
			}
		});
		btnPlacementEligibility.setForeground(Color.BLACK);
		btnPlacementEligibility.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnPlacementEligibility.setBackground(Color.CYAN);
		btnPlacementEligibility.setBounds(895, 465, 300, 95);
		pd.getContentPane().add(btnPlacementEligibility);
		
		pd.setBounds(500, 500, 1050, 800);
		pd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
