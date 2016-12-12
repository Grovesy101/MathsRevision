package priestley.maths.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import priestley.maths.database.UserDatabase;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userBox;
	private JPasswordField passwordBox;

	/**
	 * Create the frame with all the components
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserID = new JLabel("User ID:");
		lblUserID.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserID.setFont(new Font("Calibri", Font.BOLD, 30));
		lblUserID.setBounds(144, 108, 106, 52);
		contentPane.add(lblUserID);

		userBox = new JTextField();
		userBox.setBounds(119, 147, 156, 30);
		contentPane.add(userBox);
		userBox.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 30));
		lblPassword.setBounds(131, 178, 131, 52);
		contentPane.add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(UserDatabase.Login(userBox.getText(), passwordBox.getPassword())){
					System.out.println("Loged in");
				}else{
					System.out.println("Incorrect User Name Or Password");
				}
			}
		});
		btnLogin.setFont(new Font("Calibri", Font.BOLD, 30));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(144, 257, 106, 46);
		contentPane.add(btnLogin);

		passwordBox = new JPasswordField();
		passwordBox.setBounds(119, 216, 156, 30);
		contentPane.add(passwordBox);

		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgotPasswordWindow();
			}
		});
		btnForgotPassword.setBackground(Color.GRAY);
		btnForgotPassword.setRolloverEnabled(false);
		btnForgotPassword.setBorderPainted(false);
		btnForgotPassword.setOpaque(false);
		btnForgotPassword.setBounds(237, 257, 147, 23);
		contentPane.add(btnForgotPassword);

		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateUserWindow();
			}
		});
		btnCreateUser.setFont(new Font("Calibri", Font.BOLD, 14));
		btnCreateUser.setRolloverEnabled(false);
		btnCreateUser.setOpaque(false);
		btnCreateUser.setBorderPainted(false);
		btnCreateUser.setBackground(Color.GRAY);
		btnCreateUser.setBounds(-32, 11, 147, 23);
		contentPane.add(btnCreateUser);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void CreateUserWindow() {
		dispose();
		new CreateUser();
	}

	private void ForgotPasswordWindow() {
		dispose();
		new ForgotPassword();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
