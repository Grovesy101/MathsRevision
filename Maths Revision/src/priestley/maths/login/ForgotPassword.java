package priestley.maths.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ForgotPassword extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Thread run;

	/**
	 * Create the frame.
	 */
	public ForgotPassword() {
		setResizable(false);
		CreateWindow();
		run = new Thread(this, "Running");
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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		btnBack.setBorderPainted(false);
		btnBack.setOpaque(false);
		btnBack.setRolloverEnabled(false);
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(Color.BLACK);
		btnBack.setBounds(0, 11, 89, 23);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("User ID:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.BOLD, 30));
		label.setBounds(131, 71, 122, 37);
		contentPane.add(label);
		
		JTextField userIDBox = new JTextField();
		userIDBox.setBounds(92, 104, 200, 30);
		contentPane.add(userIDBox);
		
		JButton btnGenerate = new JButton("Generate Question");
		btnGenerate.setForeground(Color.WHITE);
		btnGenerate.setFont(new Font("Calibri", Font.BOLD, 30));
		btnGenerate.setBackground(Color.BLACK);
		btnGenerate.setBounds(14, 145, 356, 45);
		contentPane.add(btnGenerate);
		
		JTextField textArea = new JTextField();
		textArea.setEditable(false);
		textArea.setBounds(14, 238, 356, 30);
		contentPane.add(textArea);
		
		JLabel lblQuestion = new JLabel("Security Question:");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setFont(new Font("Calibri", Font.BOLD, 30));
		lblQuestion.setBounds(68, 205, 248, 37);
		contentPane.add(lblQuestion);
		
		JTextField answerBox = new JTextField();
		answerBox.setBounds(92, 321, 200, 30);
		contentPane.add(answerBox);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setFont(new Font("Calibri", Font.BOLD, 30));
		lblAnswer.setBounds(131, 288, 122, 37);
		contentPane.add(lblAnswer);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new NewPassword();
			}
		});
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Calibri", Font.BOLD, 30));
		btnNext.setBackground(Color.BLACK);
		btnNext.setBounds(128, 362, 128, 45);
		contentPane.add(btnNext);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void run() {
		
	}
}
