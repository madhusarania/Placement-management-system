package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Display {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
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
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Placement Management system");
		
		JLabel lblNewLabel = new JLabel("DISPLAY");
		lblNewLabel.setBounds(264, 66, 1036, 61);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(320, 230, 935, 358);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("DISPLAY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = "" ,usn = "" ,sem = "" ,branch = "", s;
				try {
				BufferedReader br = new BufferedReader(new FileReader("student.txt"));
				while((s = br.readLine())!=null)
				{
					String[] result = s.split("\\|");
					name = result[0];
					usn = result[1];
					sem = result[2];
					branch = result[3];
					System.out.println("The details are: " + '\n' + name + " " + usn + " " + sem + " " + branch + '\n');
				}
				br.close();
				}
				catch(IOException ioe) {
					System.out.println("Some error occured");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnNewButton.setBounds(675, 674, 229, 61);
		frame.getContentPane().add(btnNewButton);
		
		frame.setBounds(500, 500, 1050, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
