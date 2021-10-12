package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import model.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField log_email;
	private JPasswordField login_pwd;

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

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(10, 11, 909, 103);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 125, 888, 494);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel login_email = new JLabel("Email");
		login_email.setFont(new Font("Tahoma", Font.ITALIC, 20));
		login_email.setHorizontalAlignment(SwingConstants.CENTER);
		login_email.setBounds(57, 106, 318, 53);
		panel_1.add(login_email);
		
		JLabel llogin_pwd = new JLabel("Mot de passe");
		llogin_pwd.setHorizontalAlignment(SwingConstants.CENTER);
		llogin_pwd.setFont(new Font("Tahoma", Font.ITALIC, 20));
		llogin_pwd.setBounds(57, 207, 318, 53);
		panel_1.add(llogin_pwd);
		
		log_email = new JTextField();
		log_email.setBounds(412, 106, 430, 53);
		panel_1.add(log_email);
		log_email.setColumns(10);
		
		JButton submit_login = new JButton("Je me connecte");
		submit_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail_saisie = log_email.getText();
				String pwd_saisie = login_pwd.getText();
				
				User nouveau = new User();
				
				nouveau.setEmail(mail_saisie);
				nouveau.setPassword(pwd_saisie);
				
				UserDao usDao = new UserDao();
				
				usDao.login(mail_saisie, pwd_saisie);
				
				if(usDao.login(mail_saisie, pwd_saisie)) {
					
					JOptionPane.showMessageDialog(submit_login, "Félicitation");
					//Redirection vers la page de login apres l'inscription
					
					//dispose: permet de fermer le jframe courant
					dispose();
					
					Home home = new Home(mail_saisie);
					home.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(submit_login, "Impossible de se connecter");
				}
				
				
			}
		});
		submit_login.setBounds(272, 357, 466, 65);
		panel_1.add(submit_login);
		
		login_pwd = new JPasswordField();
		login_pwd.setBounds(412, 207, 440, 53);
		panel_1.add(login_pwd);
	}

}
