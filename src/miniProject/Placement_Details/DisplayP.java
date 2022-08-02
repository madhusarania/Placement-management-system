package miniProject.Placement_Details;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

public class DisplayP {

	JFrame displayframep;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayP window = new DisplayP();
					window.displayframep.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		displayframep = new JFrame();
		displayframep.getContentPane().setBackground(new Color(135, 206, 250));
		displayframep.getContentPane().setLayout(null);
		displayframep.setExtendedState(displayframep.MAXIMIZED_BOTH);
		displayframep.setTitle("Placement Management system");
		
		JLabel lblNewLabel = new JLabel("DISPLAY");
		lblNewLabel.setBounds(276, 24, 1036, 61);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		displayframep.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlacementDetails sd = new PlacementDetails();
				sd.pd.setVisible(true);
				displayframep.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(943, 710, 211, 67);
		displayframep.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 124, 1503, 518);
		displayframep.getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"USN", "NAME", "Branch", "Email", "P/NP", "ComName", "Role", "F/I", "CTC"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JTableHeader tableHeader = table.getTableHeader();
	      tableHeader.setBackground(Color.CYAN);
//	      tableHeader.setForeground(Color.white);
	      Font headerFont = new Font("Verdana", Font.BOLD, 25);
	      tableHeader.setFont(headerFont);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setRowHeight(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("DISPLAY");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String s="", c="", p="";
					String name="", usn="", branch="", email="", pl="", np="";
					String cname="", role="", fi="", ctc="";
					String bp="", bnp="";
					int id=0, flag=0;
					
					BufferedReader br1 = new BufferedReader(new FileReader("student.txt"));
					BufferedReader br2 = new BufferedReader(new FileReader("company.txt"));
					
					File file = new File("placement.txt");
					BufferedReader br3 = new BufferedReader(new FileReader(file));
					
					File temp = new File("tempOfPl.txt");
					PrintWriter pw = new PrintWriter(temp);
					
					StringBuilder sb = new StringBuilder();
					
					while((s = br1.readLine()) != null) {
						
						String[] result1 = s.split("\\|");
						id = Integer.parseInt(result1[0]);
						name = result1[1];
						usn = result1[2];
						branch = result1[4];
						email = result1[8];
						pl = "Placed";
						np = "Not Placed";
						
					while(true) {
						if((p = br3.readLine()) != null) {
							String[] result = p.split("\\|");
							int pID = Integer.parseInt(result[0]);
							String comName = result[3];
							String roleOff = result[4];
							
							while(id < pID) {
								bnp = id + "|" + name + "|" + usn + "|" + branch + "|" + email + "|" + np + "|" + "NIL" + "|" + "NIL" + "|" + "NIL" + "|" + "NIL" + "|" + "\n";
								sb.append(bnp);
								s = br1.readLine();	
								String[] result2 = s.split("\\|");
								id = Integer.parseInt(result2[0]);
								name = result2[1];
								usn = result2[2];
								branch = result2[4];
								email = result2[8];
								pl = "Placed";
								np = "Not Placed";
							}
							
							if(pID == id) {
								
								while((c = br2.readLine()) != null) {
									String[] result2 = c.split("\\|");
									cname = result2[0];
									role = result2[1];
									fi = result2[2];
									ctc = result2[3];

								if(comName.equals(cname) && roleOff.equals(role)) {
									bp = id + "|" + name + "|" + usn + "|" + branch + "|" + email + "|" + pl + "|" + cname + "|" + role + "|" + fi + "|" + ctc + "|" + "\n";
									sb.append(bp);
									flag = 1;
								}
								else
									continue;
								}
								if(flag == 1) {
									br2 = new BufferedReader(new FileReader("company.txt"));
									break;
								}
							}
							
							else if(pID < id) {
									continue;
								}
						}
						else {
							bnp = id + "|" + name + "|" + usn + "|" + branch + "|" + email + "|" + np + "|" + "NIL" + "|" + "NIL" + "|" + "NIL" + "|" + "NIL" + "|" + "\n";
							sb.append(bnp);
							break;
						}
							
						}

					 }
						pw.print(sb.toString());
						pw.flush();
						pw.close();
						br1.close();
						br2.close();
						br3.close();
					}
					catch(FileNotFoundException foe) {
						JOptionPane.showMessageDialog(null, "Records have not been inserted");
					}
					catch(IOException ioe) {
						System.out.println("Some error");
					}
					
				displayToTable();	

			
		}
	});
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setBounds(458, 710, 229, 67);
		displayframep.getContentPane().add(btnNewButton);
		
		displayframep.setBounds(500, 500, 1050, 800);
		displayframep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void displayToTable() {
		String name="", usn="", branch="", email="", pnp="",cname="", role="", fi="", ctc="", s;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("tempOfPl.txt"));
			while((s = br.readLine())!=null)
			{
				String[] result3 = s.split("\\|");
				name = result3[1];
				usn = result3[2];
				branch = result3[3];
				email = result3[4];
				pnp = result3[5];
				cname = result3[6];
				role = result3[7];
				fi = result3[8];
				ctc = result3[9];
				
				String[] row = {usn, name, branch, email, pnp, cname, role, fi, ctc};
				model.addRow(row);
				

			}
			br.close();
			}
			catch(IOException ioe) {
				System.out.println("Some error");
			}
		
	}

}
