package blog_article;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ListeArticlePage extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeArticlePage frame = new ListeArticlePage(null);
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
		ArticleDAO adao = new ArticleDAO();
		
		
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 855, 554);
		panel.add(scrollPane);
		
		JButton btnLire = new JButton("Lire");
		JButton btnSup = new JButton("SUPPRIMER");
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnLire.setVisible(true);
				btnSup.setVisible(true);
			}
		});
		scrollPane.setColumnHeaderView(table);
		table.setModel(ArticleDAO.liste());
		
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
		
		//JButton btnLire = new JButton("Lire");
		btnLire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = table.getSelectedRow();
				int article_id = (int) table.getModel().getValueAt(id, 0);
				Article a_lire = adao.findById(article_id);
				
				LectureArticlePage lect_Article = new LectureArticlePage(a_lire,saisieEmail);
				lect_Article.setVisible(true);
				dispose();
			}
		});
		btnLire.setBounds(908, 207, 89, 23);
		contentPane.add(btnLire);
		
		//JButton btnSup = new JButton("SUPPRIMER");
		btnSup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = table.getSelectedRow();
				int article_id = (int) table.getModel().getValueAt(id, 0);
				adao.delete(article_id);
			}
		});
		btnSup.setBounds(908, 472, 89, 23);
		contentPane.add(btnSup);
	}
}
