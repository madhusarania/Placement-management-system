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

public class PlacementManagement {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlacementManagement window = new PlacementManagement();
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
	public PlacementManagement() {
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
		
		JLabel lblNewLabel = new JLabel("PLACEMENT CELL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 66));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(160, 54, 1189, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(175, 248, 211, 67);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setForeground(Color.BLACK);
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnDisplay.setBackground(Color.CYAN);
		btnDisplay.setBounds(651, 248, 252, 67);
		frame.getContentPane().add(btnDisplay);
		
		JButton btnDisplay_1 = new JButton("SEARCH");
		btnDisplay_1.setForeground(Color.BLACK);
		btnDisplay_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnDisplay_1.setBackground(Color.CYAN);
		btnDisplay_1.setBounds(1149, 248, 252, 67);
		frame.getContentPane().add(btnDisplay_1);
		
		JButton btnModify = new JButton("MODIFY");
		btnModify.setForeground(Color.BLACK);
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnModify.setBackground(Color.CYAN);
		btnModify.setBounds(175, 497, 211, 67);
		frame.getContentPane().add(btnModify);
		frame.setBounds(500, 500, 1050, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
