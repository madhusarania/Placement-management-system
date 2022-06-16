package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(761, 438);
		frame.setTitle("Placement Management System");
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 66));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(242, 53, 1189, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("STUDENT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(175, 248, 429, 114);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCompany = new JButton("COMPANY");
		btnCompany.setForeground(Color.BLACK);
		btnCompany.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnCompany.setBackground(Color.CYAN);
		btnCompany.setBounds(1085, 248, 429, 114);
		frame.getContentPane().add(btnCompany);
		
		JButton btnSummary = new JButton("SUMMARY");
		btnSummary.setForeground(Color.BLACK);
		btnSummary.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSummary.setBackground(Color.CYAN);
		btnSummary.setBounds(597, 539, 429, 114);
		frame.getContentPane().add(btnSummary);
		frame.setBounds(500, 500, 1050, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
