package miniProject.Student_Details;

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

public class StudentDetails {

	public JFrame sd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails window = new StudentDetails();
					window.sd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		sd = new JFrame();
		sd.setSize(761, 438);
		sd.setTitle("Placement Management System");
		sd.setExtendedState(sd.MAXIMIZED_BOTH);
		sd.getContentPane().setBackground(new Color(135, 206, 250));
		sd.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT   DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 66));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(195, 54, 1189, 57);
		sd.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertS in = new InsertS();
				in.insertframe.setVisible(true);
				sd.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(314, 247, 211, 67);
		sd.getContentPane().add(btnNewButton);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setForeground(Color.BLACK);
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnDisplay.setBackground(Color.CYAN);
		btnDisplay.setBounds(665, 381, 223, 67);
		sd.getContentPane().add(btnDisplay);
		
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayS dis = new DisplayS();
				dis.displayframe.setVisible(true);
				sd.dispose();
			}
		});
		
		JButton btnDisplay_1 = new JButton("SEARCH");
		btnDisplay_1.setForeground(Color.BLACK);
		btnDisplay_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnDisplay_1.setBackground(Color.CYAN);
		btnDisplay_1.setBounds(1068, 247, 223, 67);
		sd.getContentPane().add(btnDisplay_1);
		
		btnDisplay_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchS se = new SearchS();
				se.searchframe.setVisible(true);
				sd.dispose();
			}
		});
		
		JButton btnModify = new JButton("MODIFY");
		btnModify.setForeground(Color.BLACK);
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnModify.setBackground(Color.CYAN);
		btnModify.setBounds(314, 505, 211, 67);
		sd.getContentPane().add(btnModify);
		
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyS mod = new ModifyS();
				mod.modifyframe.setVisible(true);
				sd.dispose();
			}
		});
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnDelete.setBackground(Color.CYAN);
		btnDelete.setBounds(1068, 505, 223, 67);
		sd.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.homeframe.setVisible(true);
				sd.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(665, 665, 223, 67);
		sd.getContentPane().add(btnBack);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteS del = new DeleteS();
				del.deleteframe.setVisible(true);
				sd.dispose();
			}
		});
		
		sd.setBounds(500, 500, 1050, 800);
		sd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
