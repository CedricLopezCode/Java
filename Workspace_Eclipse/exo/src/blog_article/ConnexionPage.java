package blog_article;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConnexionPage extends JFrame {

	private JPanel contentPane;
	private JTextField saisie_nom;
	private JTextField saisie_prenom;
	private JTextField saisie_email;
	private JPasswordField saisie_pwd;
	private JTextField email_connect;
	private JPasswordField pwd_connect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionPage frame = new ConnexionPage();
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
	public ConnexionPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nom_user_label = new JLabel("Nom");
		nom_user_label.setBounds(35, 164, 46, 14);
		contentPane.add(nom_user_label);
		
		JLabel prenom_user_label = new JLabel("Prenom");
		prenom_user_label.setBounds(35, 241, 46, 14);
		contentPane.add(prenom_user_label);
		
		JLabel email_user_label = new JLabel("Email");
		email_user_label.setBounds(35, 318, 46, 14);
		contentPane.add(email_user_label);
		
		JLabel pwd_label = new JLabel("Password");
		pwd_label.setBounds(35, 380, 46, 14);
		contentPane.add(pwd_label);
		
		saisie_nom = new JTextField();
		saisie_nom.setBounds(128, 149, 173, 44);
		contentPane.add(saisie_nom);
		saisie_nom.setColumns(10);
		
		saisie_prenom = new JTextField();
		saisie_prenom.setBounds(128, 222, 173, 50);
		contentPane.add(saisie_prenom);
		saisie_prenom.setColumns(10);
		
		saisie_email = new JTextField();
		saisie_email.setBounds(128, 306, 173, 39);
		contentPane.add(saisie_email);
		saisie_email.setColumns(10);
		
		saisie_pwd = new JPasswordField();
		saisie_pwd.setBounds(128, 371, 173, 32);
		contentPane.add(saisie_pwd);
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(35, 11, 216, 28);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(393, 11, 10, 525);
		contentPane.add(panel);
		
		JLabel lblConnection = new JLabel("Connection");
		lblConnection.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnection.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConnection.setBounds(499, 26, 216, 28);
		contentPane.add(lblConnection);
		
		JLabel email_user_label_1 = new JLabel("Email");
		email_user_label_1.setBounds(466, 161, 46, 14);
		contentPane.add(email_user_label_1);
		
		email_connect = new JTextField();
		email_connect.setColumns(10);
		email_connect.setBounds(559, 149, 173, 39);
		contentPane.add(email_connect);
		
		pwd_connect = new JPasswordField();
		pwd_connect.setBounds(559, 214, 173, 32);
		contentPane.add(pwd_connect);
		
		JLabel pwd_label_1 = new JLabel("Password");
		pwd_label_1.setBounds(466, 223, 46, 14);
		contentPane.add(pwd_label_1);
		
		UserDAO userDao = new UserDAO();
		
		//Début event 
		
		JButton btnCreate = new JButton("S'inscrire");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String saisieNom = saisie_nom.getText();
				String saisiePrenom = saisie_prenom.getText();
				String saisieEmail = saisie_email.getText();
				String saisiePwd = saisie_pwd.getText();
				
				if( saisieNom.equals("") || saisiePrenom.equals("") || saisieEmail.equals("") || saisiePwd.equals("") ) {
					JOptionPane.showMessageDialog(btnCreate, "Tous les champs doivent être remplis");
				}else {
					User creationUser = new User(saisieNom, saisiePrenom,saisieEmail,saisiePwd);
					userDao.create(creationUser);
					JOptionPane.showMessageDialog(btnCreate, "Inscription Terminée");
					saisie_nom.setText("");
					saisie_prenom.setText("");
					saisie_email.setText("");
					saisie_pwd.setText("");
				}
			}
		});
		btnCreate.setBounds(105, 448, 115, 44);
		contentPane.add(btnCreate);
		
		JButton btnConnect = new JButton("Se Connecter");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String saisieEmail = email_connect.getText();
				String saisiePwd = pwd_connect.getText();
				
				if( saisieEmail.equals("") || saisiePwd.equals("") ) {
					JOptionPane.showMessageDialog(btnConnect, "Tous les champs doivent être remplis");
				}else if(userDao.login(saisieEmail, saisiePwd)){
					JOptionPane.showMessageDialog(btnConnect, "Bienvenue");
					ListeArticlePage listeArt = new ListeArticlePage(saisieEmail);
					listeArt.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(btnConnect, "Vérifiez vos informations");
				}
			}
		});
		btnConnect.setBounds(581, 288, 134, 44);
		contentPane.add(btnConnect);
	}
	
}
