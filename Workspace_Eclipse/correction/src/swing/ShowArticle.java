package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ArticleDao;
import dao.CommentaireDao;
import model.Article;
import model.Commentaire;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowArticle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowArticle frame = new ShowArticle();
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
	public ShowArticle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		panel.setBounds(0, 11, 574, 630);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*JLabel ltitre_show = new JLabel("Titre");
		ltitre_show.setHorizontalAlignment(SwingConstants.CENTER);
		ltitre_show.setBounds(134, 63, 133, 28);
		panel.add(ltitre_show);*/
		
		JLabel lresume_show = new JLabel("resume_show");
		lresume_show.setBounds(134, 152, 133, 28);
		panel.add(lresume_show);
		
		JLabel lContenu_show = new JLabel("Contenu");
		lContenu_show.setBounds(134, 348, 133, 28);
		panel.add(lContenu_show);
		
		JLabel titre_show = new JLabel();
		titre_show.setBounds(24, 93, 407, 62);
		panel.add(titre_show);
		
		JLabel resume_show = new JLabel("New label");
		resume_show.setBounds(24, 191, 407, 105);
		panel.add(resume_show);
		
		JLabel contenu_show = new JLabel("New label");
		contenu_show.setBounds(24, 387, 407, 232);
		panel.add(contenu_show);
		
		JLabel ldate_pub = new JLabel("New label");
		ldate_pub.setBounds(10, 11, 183, 28);
		panel.add(ldate_pub);
		
		JLabel lauteur = new JLabel("New label");
		lauteur.setBounds(381, 11, 183, 28);
		panel.add(lauteur);
		
		JLabel date_pub = new JLabel("New label");
		date_pub.setBounds(10, 50, 183, 28);
		panel.add(date_pub);
		
		JLabel auteur_pub = new JLabel("New label");
		auteur_pub.setBounds(381, 50, 183, 28);
		panel.add(auteur_pub);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(580, 11, 339, 630);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lcommentaire = new JLabel("Commentaires");
		lcommentaire.setBackground(new Color(233, 150, 122));
		lcommentaire.setHorizontalAlignment(SwingConstants.CENTER);
		lcommentaire.setBounds(10, 11, 319, 54);
		panel_1.add(lcommentaire);
		
		JTextArea commentaire = new JTextArea();
		commentaire.setBounds(10, 262, 319, 142);
		panel_1.add(commentaire);
		
		JButton ajoutCommentaire = new JButton("Laissez votre commentaire");
		ajoutCommentaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String comment_saisie = commentaire.getText();
				
				Commentaire comment = new Commentaire();
				
				comment.setCommentaire(comment_saisie);
				comment.setAuteur("test");
				comment.setArticle_id(3);
				
				CommentaireDao commentDao = new CommentaireDao();
				
				commentDao.create(comment);
				
			}
		});
		ajoutCommentaire.setBounds(64, 427, 236, 30);
		panel_1.add(ajoutCommentaire);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBounds(10, 43, 319, 195);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel llisting = new JLabel("Listing");
		llisting.setBounds(0, 0, 94, 24);
		panel_2.add(llisting);
		
		CommentaireDao comDao = new CommentaireDao();
		
		List<Commentaire> listCom = new ArrayList<>();
		listCom.addAll(comDao.findById(3));
		
		JLabel[] auteur_com = new JLabel[listCom.size()];
		JLabel[] date_com = new JLabel[listCom.size()];
		JLabel[] contenu_com = new JLabel[listCom.size()];
		
		JEditorPane[] content = new JEditorPane[listCom.size()];
		
		for (int i = 0; i < listCom.size(); i++) {
			auteur_com[i] = new JLabel();
			auteur_com[i].setBounds(10, 35+(i*20), 250, 14);
			auteur_com[i].setText(listCom.get(i).getAuteur());
			//panel_2.add(auteur_com[i]);
			
			//Les dates
			date_com[i] = new JLabel();
			date_com[i].setBounds(10, 55+(i*20), 250, 14);
			date_com[i].setText(listCom.get(i).getCreated_at());
			
			//Contenu com
			contenu_com[i] = new JLabel();
			contenu_com[i].setBounds(10, 65+(i*20), 250, 14);
			contenu_com[i].setText(listCom.get(i).getCommentaire());
			
			content[i] = new JEditorPane();
			content[i].setContentType("text/html");
			content[i].setText("<html> "
					+ "<em> Posté par :"+ auteur_com[i].getText() +"</em>"
							+ "   le "+date_com[i].getText()+"<br>"
									+ contenu_com[i].getText()+"<hr>"
					+ "</html>");
			content[i].setBounds(10, 30+(i*50), 350, 50);
			content[i].setEditable(false);
			
			panel_2.add(content[i]);
		}
	}

	public ShowArticle(int article_id) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		panel.setBounds(0, 11, 454, 630);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel ltitre_show = new JLabel("Titre");
		ltitre_show.setHorizontalAlignment(SwingConstants.CENTER);
		ltitre_show.setBounds(134, 63, 133, 28);
		panel.add(ltitre_show);
		
		JLabel lresume_show = new JLabel("resume_show");
		lresume_show.setBounds(134, 152, 133, 28);
		panel.add(lresume_show);
		
		JLabel lContenu_show = new JLabel("Contenu");
		lContenu_show.setBounds(134, 348, 133, 28);
		panel.add(lContenu_show);
		
		/*JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(24, 93, 407, 62);
		panel.add(lblNewLabel_3);*/
		
		JLabel titre_show = new JLabel();
		titre_show.setBounds(24, 93, 407, 62);
		panel.add(titre_show);
		
		JLabel resume_show = new JLabel("New label");
		resume_show.setBounds(24, 191, 407, 105);
		panel.add(resume_show);
		
		JLabel contenu_show = new JLabel("New label");
		contenu_show.setBounds(24, 387, 407, 232);
		panel.add(contenu_show);
		
		JLabel ldate_pub = new JLabel("New label");
		ldate_pub.setBounds(10, 11, 183, 28);
		panel.add(ldate_pub);
		
		JLabel lauteur = new JLabel("New label");
		lauteur.setBounds(381, 11, 183, 28);
		panel.add(lauteur);
		
		JLabel date_pub = new JLabel("New label");
		date_pub.setBounds(10, 50, 183, 28);
		panel.add(date_pub);
		
		JLabel auteur_pub = new JLabel("New label");
		auteur_pub.setBounds(381, 50, 183, 28);
		panel.add(auteur_pub);
		
		ArticleDao articleDao = new ArticleDao();
		
		List<Article> list = new ArrayList<>();
		
		list.addAll(articleDao.findById(article_id));
		
		for (int i = 0; i < list.size(); i++) {
			
			titre_show.setText(list.get(i).getTitre());
			resume_show.setText(list.get(i).getResume());
			contenu_show.setText(list.get(i).getContenu());
			date_pub.setText(list.get(i).getCreated_at());
			auteur_pub.setText(list.get(i).getAuteur());
			
		}
		
		//Les commentaires
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(580, 11, 339, 630);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lcommentaire = new JLabel("Commentaires");
		lcommentaire.setBackground(new Color(233, 150, 122));
		lcommentaire.setHorizontalAlignment(SwingConstants.CENTER);
		lcommentaire.setBounds(10, 11, 319, 54);
		panel_1.add(lcommentaire);
		
		JTextArea commentaire = new JTextArea();
		commentaire.setBounds(10, 262, 319, 142);
		panel_1.add(commentaire);
		
		JButton ajoutCommentaire = new JButton("Laissez votre commentaire");
		ajoutCommentaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String comment_saisie = commentaire.getText();
				
				Commentaire comment = new Commentaire();
				
				comment.setCommentaire(comment_saisie);
				comment.setAuteur(auteur_pub.getText());
				comment.setArticle_id(article_id);
				
				CommentaireDao commentDao = new CommentaireDao();
				
				commentDao.create(comment);
				
				if (commentDao.create(comment)) {
					JOptionPane.showMessageDialog(null, "Merci pour votre commentaire");
					commentaire.setText("");
				}else {
					
					JOptionPane.showMessageDialog(null, "Oups, impossible de commenter");
				}
				
			}
		});
		ajoutCommentaire.setBounds(64, 427, 236, 30);
		panel_1.add(ajoutCommentaire);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBounds(10, 43, 319, 195);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel llisting = new JLabel("Listing");
		llisting.setBounds(0, 0, 94, 24);
		panel_2.add(llisting);
		
		CommentaireDao comDao = new CommentaireDao();
		
		List<Commentaire> listCom = new ArrayList<>();
		listCom.addAll(comDao.findById(article_id));
		
		JLabel[] auteur_com = new JLabel[listCom.size()];
		JLabel[] date_com = new JLabel[listCom.size()];
		JLabel[] contenu_com = new JLabel[listCom.size()];
		
		JEditorPane[] content = new JEditorPane[listCom.size()];
		
		if(listCom.size() > 0) {
			
		
			for (int i = 0; i < listCom.size(); i++) {
				auteur_com[i] = new JLabel();
				auteur_com[i].setBounds(10, 35+(i*20), 250, 14);
				auteur_com[i].setText(listCom.get(i).getAuteur());
				//panel_2.add(auteur_com[i]);
				
				//Les dates
				date_com[i] = new JLabel();
				date_com[i].setBounds(10, 55+(i*20), 250, 14);
				date_com[i].setText(listCom.get(i).getCreated_at());
				
				//Contenu com
				contenu_com[i] = new JLabel();
				contenu_com[i].setBounds(10, 65+(i*20), 250, 14);
				contenu_com[i].setText(listCom.get(i).getCommentaire());
				
				content[i] = new JEditorPane();
				content[i].setContentType("text/html");
				content[i].setText("<html> "
						+ "<em> Posté par :"+ auteur_com[i].getText() +"</em>"
								+ "   le "+date_com[i].getText()+"<br>"
										+ contenu_com[i].getText()+"<hr>"
						+ "</html>");
				content[i].setBounds(10, 30+(i*50), 350, 50);
				content[i].setEditable(false);
				
				panel_2.add(content[i]);
			}
		}else {
			//JOptionPane.showMessageDialog(llisting, "Aucun commentaire disponible");
			JLabel msg = new JLabel("Aucun commentaire disponible");
			msg.setBounds(10, 30, 350, 50);
			
			panel_2.add(msg);
		}
	}
}
