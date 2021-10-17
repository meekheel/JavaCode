import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textUsername;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	
	Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		
		conn = SQLiteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textUsername = new JTextField();
		textUsername.setBounds(252, 75, 86, 20);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(118, 69, 78, 28);
		frame.getContentPane().add(lblNewLabel);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(118, 142, 78, 28);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(252, 148, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "SELECT * FROM EmployeeInfo WHERE Username =? AND Password =?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, textUsername.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int counter = 0;
					while(rs.next()) {
						counter++;
					}if(counter ==1){
						
						JOptionPane.showMessageDialog(null, "Password correct");
						
					}else if(counter>1){
						
						JOptionPane.showMessageDialog(null, "Duplicates");
						
					}else {

						JOptionPane.showMessageDialog(null, "Wrong Username and Password");
					}
					
					rs.close();
					pst.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(168, 201, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
