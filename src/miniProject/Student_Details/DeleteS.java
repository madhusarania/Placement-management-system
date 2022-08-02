package miniProject.Student_Details;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class DeleteS {

	JFrame deleteframe;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteS window = new DeleteS();
					window.deleteframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		deleteframe = new JFrame();
		deleteframe.setBounds(500, 500, 1050, 800);
		deleteframe.setTitle("Placement Managemet System");
		deleteframe.setExtendedState(deleteframe.MAXIMIZED_BOTH);
		deleteframe.getContentPane().setBackground(new Color(135, 206, 250));
		deleteframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DELETE  RECORD");
		lblNewLabel.setBounds(10, 45, 1540, 61);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deleteframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter USN to Delete");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(297, 272, 362, 68);
		deleteframe.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(917, 260, 334, 68);
		deleteframe.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDetails sd = new StudentDetails();
				sd.sd.setVisible(true);
				deleteframe.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(899, 641, 211, 67);
		deleteframe.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				File file = new File("student.txt");
				BufferedReader br = new BufferedReader(new FileReader(file));
				File temp = new File("temp.txt");
				PrintWriter pw = new PrintWriter(temp);
				String usn = "", r;
				int count = 0;

				Pattern pattern2 = Pattern.compile("^(\\d[a-z]{2}\\d\\d[a-z]{2}\\d{3}|\\d[A-Z]{2}\\d\\d[A-Z]{2}\\d{3})$");
				String usn1 = textField.getText();
				Matcher matcher2 = pattern2.matcher(usn1);
				while(!(matcher2.matches())) {
					usn1 = JOptionPane.showInputDialog("Enter valid USN");
					matcher2 = pattern2.matcher(usn1);	
				}
				
				while((r= br.readLine()) !=null)
				{
					String[] result = r.split("\\|");
					usn=result[2];
					if(usn.equals(usn1))
					{
					    count = 1;
						continue;
					}
					else {
						pw.println(r);
						
					}
				}
			      if(count == 0)
	                    JOptionPane.showMessageDialog(null, "Record not found");
	                else
	                    JOptionPane.showMessageDialog(null, "Record Deleted!");
			      
			    pw.flush();
			    pw.close();
				br.close();
				
				 file.delete();
	             temp.renameTo(file);
	             
	             textField.setText(null);

				}
				catch(IOException ioe) {
					System.out.println("Some error occured");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setBounds(509, 641, 220, 67);
		deleteframe.getContentPane().add(btnNewButton);
		deleteframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
