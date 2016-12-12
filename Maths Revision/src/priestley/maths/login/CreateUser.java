package priestley.maths.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import priestley.maths.database.UserDatabase;

public class CreateUser extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordBox;
	private JPasswordField retypePasswordBox;
	private JTextField userIDBox;
	private JTextField securityQuestionBox;
	private JTextField answerBox;

	private Thread run;

	/**
	 * Create the frame.
	 */
	public CreateUser() {
		setResizable(false);
		CreateWindow();
		run = new Thread(this, "running");
		run.start();
	}

	private void CreateWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);

		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setFont(new Font("Calibri", Font.BOLD, 30));
		lblUserId.setBounds(131, 55, 122, 37);
		contentPane.add(lblUserId);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 30));
		lblPassword.setBounds(115, 122, 154, 37);
		contentPane.add(lblPassword);

		JLabel lblRetypePassword = new JLabel("ReType Password:");
		lblRetypePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetypePassword.setFont(new Font("Calibri", Font.BOLD, 30));
		lblRetypePassword.setBounds(38, 198, 308, 37);
		contentPane.add(lblRetypePassword);

		JLabel lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecurityQuestion.setFont(new Font("Calibri", Font.BOLD, 30));
		lblSecurityQuestion.setBounds(38, 289, 308, 37);
		contentPane.add(lblSecurityQuestion);

		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setFont(new Font("Calibri", Font.BOLD, 30));
		lblAnswer.setBounds(38, 358, 308, 37);
		contentPane.add(lblAnswer);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Arrays.equals(passwordBox.getPassword(), retypePasswordBox.getPassword())) {
					UserDatabase.CreateUser(userIDBox.getText(), passwordBox.getPassword(), securityQuestionBox.getText(), answerBox.getText());
					dispose();
					new Login();
				}else{
					//TODO ADD WARNING
					System.out.println("Passwords are not the same!");
				}
			}
		});
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBackground(Color.BLACK);
		btnCreate.setFont(new Font("Calibri", Font.BOLD, 30));
		btnCreate.setBounds(124, 452, 135, 45);
		contentPane.add(btnCreate);

		userIDBox = new JTextField();
		userIDBox.setBounds(92, 88, 200, 30);
		contentPane.add(userIDBox);

		passwordBox = new JPasswordField();
		passwordBox.setBounds(92, 157, 200, 30);
		contentPane.add(passwordBox);

		retypePasswordBox = new JPasswordField();
		retypePasswordBox.setBounds(92, 248, 200, 30);
		contentPane.add(retypePasswordBox);

		securityQuestionBox = new JTextField();
		securityQuestionBox.setBounds(92, 324, 200, 30);
		contentPane.add(securityQuestionBox);

		answerBox = new JTextField();
		answerBox.setBounds(92, 396, 200, 30);
		contentPane.add(answerBox);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void run() {

	}
}
