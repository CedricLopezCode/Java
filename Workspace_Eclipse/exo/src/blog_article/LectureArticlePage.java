package blog_article;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LectureArticlePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LectureArticlePage frame = new LectureArticlePage(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param article , saisieEmail
	 */
	public LectureArticlePage(Article article, String saisieEmail) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 804);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArticleDAO aDao = new ArticleDAO();
		
		JLabel titre = new JLabel(article.getTitre());
		titre.setFont(new Font("Tahoma", Font.BOLD, 16));
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setBounds(10, 11, 854, 29);
		contentPane.add(titre);
		
		JLabel resume = new JLabel(article.getResum());
		resume.setHorizontalAlignment(SwingConstants.CENTER);
		resume.setBounds(10, 46, 844, 92);
		contentPane.add(resume);
		
		JLabel contenu = new JLabel(article.getContenu());
		contenu.setBounds(10, 151, 844, 569);
		contentPane.add(contenu);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeArticlePage listeArt = new ListeArticlePage(saisieEmail);
				listeArt.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(765, 731, 89, 23);
		contentPane.add(btnRetour);
		
		JLabel date = new JLabel(article.getCreated_at());
		date.setBounds(10, 731, 106, 30);
		contentPane.add(date);
		
		JLabel auteur = new JLabel("Auteur n° " + article.getAuteur());
		auteur.setBounds(184, 735, 106, 30);
		contentPane.add(auteur);
	}

}
