import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class StudentManagement {

	private Connection connection;
	private JFrame frame;
	private JTextField textFieldID;
	private JTextField textFieldStuName;
	private JTextField textFieldFees;
	private JTextField textFieldDOB;
	private JTable table;
	private JTextField textFieldSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagement window = new StudentManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void loadTable() {
		
		
		try {
			
			String query = "select ID, Name, Fees, Date_of_birth from StudentInfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			textFieldID.setText(null);
			textFieldStuName.setText(null);
			textFieldFees.setText(null);
			textFieldDOB.setText(null);
			
			
			rs.close();
			pst.close();
			
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2);
		}
	}

	/**
	 * Create the application.
	 */
	public StudentManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		connection = SqlConnection.dbConnector();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.setBounds(100, 100, 884, 645);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LaSalle College - Student Dashboard");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(229, 11, 355, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\LASALLE\\SEMESTER 4\\ADVANCE OBJECT OREINTED\\StudentFormManagement\\Resources\\download.png"));
		lblNewLabel_1.setBounds(10, 52, 195, 196);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("International School - Montreal Canada");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(253, 53, 292, 31);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(253, 115, 69, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Student Name:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(253, 157, 105, 31);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Fees:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(253, 199, 69, 31);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Date of Birth:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3.setBounds(253, 248, 93, 31);
		frame.getContentPane().add(lblNewLabel_3_3);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldID.setBounds(426, 115, 136, 25);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldStuName = new JTextField();
		textFieldStuName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldStuName.setColumns(10);
		textFieldStuName.setBounds(426, 157, 136, 31);
		frame.getContentPane().add(textFieldStuName);
		
		textFieldFees = new JTextField();
		textFieldFees.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldFees.setColumns(10);
		textFieldFees.setBounds(426, 204, 136, 31);
		frame.getContentPane().add(textFieldFees);
		
		textFieldDOB = new JTextField();
		textFieldDOB.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDOB.setColumns(10);
		textFieldDOB.setBounds(426, 253, 136, 26);
		frame.getContentPane().add(textFieldDOB);
		
		JButton btnNew = new JButton("New ");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select ID, Name, Fees, Date_of_birth from StudentInfo";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst.close();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
		});
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNew.setIcon(new ImageIcon("C:\\LASALLE\\SEMESTER 4\\ADVANCE OBJECT OREINTED\\StudentFormManagement\\Resources\\button_violet_delete.png"));
		btnNew.setBounds(621, 106, 175, 48);
		frame.getContentPane().add(btnNew);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "insert into StudentInfo (ID, Name ,Fees ,Date_of_birth) values (?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setString(1, textFieldID.getText());
					pst.setString(2, textFieldStuName.getText());
					pst.setString(3, textFieldFees.getText());
					pst.setString(4, textFieldDOB.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					pst.close();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					
					JOptionPane.showMessageDialog(null, e2);
				}
				
				loadTable();
				
			}
		});
		btnInsert.setIcon(new ImageIcon("C:\\LASALLE\\SEMESTER 4\\ADVANCE OBJECT OREINTED\\StudentFormManagement\\Resources\\button_blue_add.png"));
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsert.setBounds(621, 157, 175, 48);
		frame.getContentPane().add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					

					String query = "update StudentInfo set ID='"+ textFieldID.getText() + "', Name='" + textFieldStuName.getText() +
							"', Fees='" + textFieldFees.getText() + "',Date_of_birth='"+ textFieldDOB.getText() +"' where ID='" + 
							textFieldID.getText() + "'";
					
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
			
			
		} catch (Exception e2) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(null, e2);
		}
		
		loadTable();
			}
		});
		btnUpdate.setIcon(new ImageIcon("C:\\LASALLE\\SEMESTER 4\\ADVANCE OBJECT OREINTED\\StudentFormManagement\\Resources\\button_pink_close.png"));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(621, 216, 175, 48);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int action = JOptionPane.showConfirmDialog(null, "Are Yu sure to delete?", "Delete",JOptionPane.YES_NO_OPTION);
				
				if (action == 0) {
					
					
					try {
						

						String query = "delete from StudentInfo where ID='" + textFieldID.getText() + "'";
						
						PreparedStatement pst = connection.prepareStatement(query);
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Data Removed");
						pst.close();
				
				
					} catch (Exception e2) {
						// TODO: handle exception
						
						JOptionPane.showMessageDialog(null, e2);
					}
					
					
					
				}
				
				
		
				loadTable();
			}
		});
		btnDelete.setIcon(new ImageIcon("C:\\LASALLE\\SEMESTER 4\\ADVANCE OBJECT OREINTED\\StudentFormManagement\\Resources\\button_red_stop.png"));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(621, 270, 175, 48);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblNewLabel_4 = new JLabel("Search Student By Name :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(62, 359, 185, 40);
		frame.getContentPane().add(lblNewLabel_4);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
try {
					
					int row = table.getSelectedRow();
					String StuId = (table.getModel().getValueAt(row, 0)).toString();
					
					String query = "select * from StudentInfo where ID='" + StuId + "'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while (rs.next()) {
						
						
						textFieldID.setText(rs.getString("ID"));
						textFieldStuName.setText(rs.getString("Name"));
						textFieldFees.setText(rs.getString("Fees"));
						textFieldDOB.setText(rs.getString("Date_of_birth"));
						
					}
					
					
					rs.close();
					pst.close();
					
					
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
			}
		});
		table.setBounds(59, 413, 737, 163);
		frame.getContentPane().add(table);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				

				try {
					
					String selected = "Name";

					String query = "select ID, Name, Fees, Date_of_birth from StudentInfo where " + selected  + "=?";
					
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldSearch.getText());
					
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst.close();
			
			
				} catch (Exception e2) {
					// TODO: handle exception
					
					JOptionPane.showMessageDialog(null, e2);
				}
				
				//loadTable();
			}
		});
		textFieldSearch.setBounds(253, 359, 355, 31);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
	}
}
