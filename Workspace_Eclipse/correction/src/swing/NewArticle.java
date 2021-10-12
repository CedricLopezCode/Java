package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ArticleDao;
import model.Article;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewArticle extends JFrame {

	private JPanel contentPane;
	private JTextField titre;
	private JTextField resume;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewArticle frame = new NewArticle();
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
	public NewArticle() {
		
	}

	public NewArticle(String mail_saisie) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ltitre = new JLabel("Titre");
		ltitre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		ltitre.setHorizontalAlignment(SwingConstants.CENTER);
		ltitre.setBounds(20, 152, 275, 49);
		contentPane.add(ltitre);
		
		JLabel lblRsume = new JLabel("R\u00E9sume");
		lblRsume.setHorizontalAlignment(SwingConstants.CENTER);
		lblRsume.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblRsume.setBounds(494, 152, 275, 49);
		contentPane.add(lblRsume);
		
		titre = new JTextField();
		titre.setBounds(10, 199, 333, 49);
		contentPane.add(titre);
		titre.setColumns(10);
		
		resume = new JTextField();
		resume.setColumns(10);
		resume.setBounds(427, 199, 492, 69);
		contentPane.add(resume);
		
		JLabel lcontenu = new JLabel("Contenu");
		lcontenu.setHorizontalAlignment(SwingConstants.CENTER);
		lcontenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lcontenu.setBounds(258, 300, 275, 49);
		contentPane.add(lcontenu);
		
		JTextArea contenu = new JTextArea();
		contenu.setBounds(53, 346, 840, 212);
		contentPane.add(contenu);
		
		JButton ajoutArticle = new JButton("J'ajoute mon article");
		ajoutArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titre_saisie = titre.getText();
				String resume_saisie = resume.getText();
				String contenu_saisie = contenu.getText();
				
				Article article = new Article();
				
				
				article.setTitre(titre_saisie);
				article.setResume(resume_saisie);
				article.setContenu(contenu_saisie);
				
				article.setAuteur(mail_saisie);
				
				ArticleDao arDao = new ArticleDao();
				
				arDao.create(article);
			}
		});
		ajoutArticle.setBounds(346, 569, 309, 49);
		contentPane.add(ajoutArticle);
		
		JButton retour = new JButton("Retour");
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Home home = new Home(mail_saisie);
				home.setVisible(true);
			}
		});
		retour.setBounds(815, 607, 89, 23);
		contentPane.add(retour);
		
	}
}
