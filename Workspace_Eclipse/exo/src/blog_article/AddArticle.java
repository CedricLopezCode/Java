package blog_article;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddArticle extends JFrame {

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
					AddArticle frame = new AddArticle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param saisieEmail 
	 */
	public AddArticle(String saisieEmail) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titre = new JTextField();
		titre.setBounds(151, 11, 532, 40);
		contentPane.add(titre);
		titre.setColumns(10);
		
		resume = new JTextField();
		resume.setBounds(0, 62, 812, 51);
		contentPane.add(resume);
		resume.setColumns(10);
		
		JTextArea contenu = new JTextArea();
		contenu.setBounds(10, 131, 802, 412);
		contentPane.add(contenu);
		
		JButton btnNewArticle = new JButton("Valider");
		btnNewArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArticleDAO aDao = new ArticleDAO();
				

				String saisieTitre = titre.getText();
				String saisieResume = contenu.getText();
				String saisieContenu = resume.getText();
				
				if( saisieTitre.equals("") || saisieResume.equals("") || saisieContenu.equals("") ) {
					JOptionPane.showMessageDialog(btnNewArticle, "Tous les champs doivent être remplis");
				}else{
					Article newArticle = new Article(saisieTitre, saisieResume, saisieContenu, 1);
					aDao.create(newArticle);
					JOptionPane.showMessageDialog(btnNewArticle, "Article Ajouté");
					ListeArticlePage liste = new ListeArticlePage(saisieEmail);
					liste.setVisible(true);
					dispose();
					
				}
			}
		});
		btnNewArticle.setBounds(375, 554, 89, 23);
		contentPane.add(btnNewArticle);
	}
}
