package blog_article;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ListeArticlePage extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeArticlePage frame = new ListeArticlePage();
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
	/*public ListeArticlePage() {
		// TODO Auto-generated constructor stub
	}*/
	public ListeArticlePage(String saisieEmail) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 11, 875, 576);
		contentPane.add(panel);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddArticle add_Article = new AddArticle(saisieEmail);
				add_Article.setVisible(true);
				dispose();
			}
		});
		btnAdd.setBounds(908, 40, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnLire = new JButton("Lire");
		btnLire.setBounds(908, 207, 89, 23);
		//contentPane.add(btnLire);
		
		JButton btnSup = new JButton("SUPPRIMER");
		btnSup.setBounds(908, 472, 89, 23);
		//contentPane.add(btnSup);
	}

	
}
