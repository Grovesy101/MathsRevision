package priestley.maths.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class NewPassword extends JFrame implements Runnable{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Thread run;
	private JPasswordField retypeNewPasswordBox;
	private JPasswordField newPasswordBox;
	
	/**
	 * Create the frame.
	 */
	public NewPassword() {
		CreateWindow();
		run = new Thread(this ,"Running");
		run.start();
	}
	
	private void CreateWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("User ID:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.BOLD, 30));
		label.setBounds(131, 104, 122, 37);
		contentPane.add(label);
		
		JTextField userIDBox = new JTextField();
		userIDBox.setEditable(false);
		userIDBox.setBounds(92, 141, 200, 30);
		contentPane.add(userIDBox);
		
		JButton btnChange = new JButton("Change");
		btnChange.setForeground(Color.WHITE);
		btnChange.setFont(new Font("Calibri", Font.BOLD, 30));
		btnChange.setBackground(Color.BLACK);
		btnChange.setBounds(128, 359, 128, 45);
		contentPane.add(btnChange);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewPassword.setBounds(78, 182, 227, 37);
		contentPane.add(lblNewPassword);
		
		JLabel lblRetypeNewPassword = new JLabel("ReType New Password:");
		lblRetypeNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetypeNewPassword.setFont(new Font("Calibri", Font.BOLD, 30));
		lblRetypeNewPassword.setBounds(34, 255, 316, 37);
		contentPane.add(lblRetypeNewPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ForgotPassword();
			}
		});
		btnBack.setRolloverEnabled(false);
		btnBack.setOpaque(false);
		btnBack.setForeground(Color.BLACK);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		retypeNewPasswordBox = new JPasswordField();
		retypeNewPasswordBox.setBounds(92, 298, 200, 30);
		contentPane.add(retypeNewPasswordBox);
		
		newPasswordBox = new JPasswordField();
		newPasswordBox.setBounds(92, 218, 200, 30);
		contentPane.add(newPasswordBox);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void run() {
		
	}
}
