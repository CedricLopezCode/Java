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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField email;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription frame = new Inscription();
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
	public Inscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 11, 397, 619);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 230, 140));
		panel_1.setBounds(417, 11, 502, 619);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscrpition");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(35, 11, 424, 77);
		panel_1.add(lblNewLabel);
		
		JLabel lnom = new JLabel("Nom");
		lnom.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lnom.setHorizontalAlignment(SwingConstants.CENTER);
		lnom.setBounds(10, 148, 168, 47);
		panel_1.add(lnom);
		
		JLabel lprenom = new JLabel("Pr\u00E9nom");
		lprenom.setHorizontalAlignment(SwingConstants.CENTER);
		lprenom.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lprenom.setBounds(10, 242, 168, 47);
		panel_1.add(lprenom);
		
		JLabel lemail = new JLabel("Email");
		lemail.setHorizontalAlignment(SwingConstants.CENTER);
		lemail.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lemail.setBounds(10, 330, 168, 47);
		panel_1.add(lemail);
		
		JLabel lpwd = new JLabel("Mot de passe");
		lpwd.setHorizontalAlignment(SwingConstants.CENTER);
		lpwd.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lpwd.setBounds(10, 414, 168, 47);
		panel_1.add(lpwd);
		
		JButton submit = new JButton("Je cr\u00E9e mon compte");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nom_saisie = nom.getText();
				String prenom_saisie = prenom.getText();
				String email_saisie = email.getText();
				String pwd_saisie = pwd.getText();
				
				UserDao usDao = new UserDao();
				
				User nouveau = new User(nom_saisie,prenom_saisie,email_saisie,pwd_saisie);
				
				if(usDao.mailExist(email_saisie)) {
					usDao.ecrire(nouveau);
					
					//Redirection vers la page de login apres l'inscription
					
					///dispose: permet de fermer le jframe courant
					dispose();
					
					Login login = new Login();
					login.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(submit, "Ce mail " +email_saisie + " existe deja" );
				}
			}
		});
		submit.setFont(new Font("Tahoma", Font.ITALIC, 20));
		submit.setBounds(72, 510, 341, 56);
		panel_1.add(submit);
		
		nom = new JTextField();
		nom.setBounds(180, 148, 279, 40);
		panel_1.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(180, 227, 279, 40);
		panel_1.add(prenom);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(180, 317, 279, 40);
		panel_1.add(email);
		
		pwd = new JPasswordField();
		pwd.setBounds(188, 414, 279, 47);
		panel_1.add(pwd);
	}
}
