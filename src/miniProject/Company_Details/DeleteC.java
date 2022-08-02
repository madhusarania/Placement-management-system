package miniProject.Company_Details;

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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class DeleteC {

	JFrame deleteframec;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteC window = new DeleteC();
					window.deleteframec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		deleteframec = new JFrame();
		deleteframec.setBounds(500, 500, 1050, 800);
		deleteframec.setTitle("Placement Managemet System");
		deleteframec.setExtendedState(deleteframec.MAXIMIZED_BOTH);
		deleteframec.getContentPane().setBackground(new Color(135, 206, 250));
		deleteframec.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DELETE");
		lblNewLabel.setBounds(10, 45, 1540, 61);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deleteframec.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(913, 164, 334, 68);
		deleteframec.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyDetails sd = new CompanyDetails();
				sd.cdframe.setVisible(true);
				deleteframec.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(845, 636, 211, 67);
		deleteframec.getContentPane().add(btnBack);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setBounds(913, 309, 211, 50);
		deleteframec.getContentPane().add(comboBox);
		
		JButton btnSelectCnameTo = new JButton("Enter CNAME");
		btnSelectCnameTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.removeAllItems();
				
				String selectedValue = textField.getText();
				int flag=0;
				int index2 = 0;
				String cname2, role, r2;
				String[] items2 = new String[30];
				try {
				BufferedReader br2 = new BufferedReader(new FileReader("company.txt"));
				while((r2 = br2.readLine()) != null) {
					String[] result = r2.split("\\|");
					cname2 = result[0];
					role = result[1];
					if(cname2.equals(selectedValue)) {
						items2[index2] = role;
						comboBox.addItem(items2[index2]);
						index2++;
						flag = 1;
					}
					else {
						continue;
					}
					
				}
				if(flag == 0) {
					JOptionPane.showMessageDialog(null, "Record Not found");
					textField.setText(null);
					comboBox.removeAllItems();
				}
				br2.close();
				
				}
				catch(IOException ioe) {
					ioe.printStackTrace();
				}
				
				
			}
		});
		btnSelectCnameTo.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnSelectCnameTo.setBackground(Color.CYAN);
		btnSelectCnameTo.setBounds(400, 161, 374, 68);
		deleteframec.getContentPane().add(btnSelectCnameTo);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				File file = new File("company.txt");
				BufferedReader br = new BufferedReader(new FileReader(file));
				File temp = new File("temp.txt");
				PrintWriter pw = new PrintWriter(temp);
				
				String cname = "", r;
				int count = 0;
				
				String selectedValue = textField.getText();
				String selectedValue2 = (String)comboBox.getSelectedItem();
				while((r= br.readLine())!=null)
				{
					String[] result = r.split("\\|");
					cname=result[0];
					String role = result[1];
					
					if(selectedValue.equals(cname) && selectedValue2.equals(role))
					{
					    count = 1;
						continue;
					}
					else {
						pw.println(r);				
					}
				}
			      if(count == 0) {
	                    JOptionPane.showMessageDialog(null, "Invalid CNAME");
	                    textField.setText(null);
	                    comboBox.removeAllItems();
			      }
	                else {
	                    JOptionPane.showMessageDialog(null, "Record Deleted!");
	                    textField.setText(null);
	                    comboBox.removeAllItems();
	                }
			      
			    pw.flush();
			    pw.close();
				br.close();
				
				 file.delete();
	             temp.renameTo(file);

				}
				catch(IOException ioe) {
					System.out.println("Some error occured");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setBounds(521, 637, 211, 68);
		deleteframec.getContentPane().add(btnNewButton);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Select Role");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(400, 309, 374, 61);
		deleteframec.getContentPane().add(lblNewLabel_1);
		
		
		deleteframec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
