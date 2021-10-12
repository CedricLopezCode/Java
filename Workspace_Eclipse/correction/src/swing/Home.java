package swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ArticleDao;
import model.Article;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		
	}

	public Home(String mail_saisie) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 0, 872, 104);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbienvenue = new JLabel("Bienvenue "+mail_saisie);
		lbienvenue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lbienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		lbienvenue.setBounds(204, 28, 538, 52);
		panel.add(lbienvenue);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 115, 896, 515);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 876, 330);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = table.getSelectedRow();
				
				int article_id = (int) table.getModel().getValueAt(id, 0);
				
				ShowArticle show = new ShowArticle(article_id);
				show.setVisible(true);
			}
			
			/*
			 * public void mouseClicked(MouseEvent e) {
                int id = table.getSelectedRow();

                String artID =  table.getModel().getValueAt(id, 0).toString();
                String artTitre =  table.getModel().getValueAt(id, 1).toString();
                String artArticle =  table.getModel().getValueAt(id, 2).toString();
                String artResume =  table.getModel().getValueAt(id, 3).toString();

                titrelbl.setText(artTitre);
                articlelbl.setText(artArticle);
                resumelbl.setText(artResume);

            }
			 * */
		});
		scrollPane.setViewportView(table);
		table.setRowHeight(100);
		
		table.setModel(liste());
		
		JButton ajoutArt = new JButton("Ajout Article");
		ajoutArt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				NewArticle nouvelAr = new NewArticle(mail_saisie);
				nouvelAr.setVisible(true);
			}
		});
		ajoutArt.setBounds(655, 438, 204, 40);
		panel_1.add(ajoutArt);
	}
	
	//Liste des articles
	
	public DefaultTableModel liste() {
		
		String [] col = {"ID","Titre","Résumé", "Date création", "Auteur"};
		DefaultTableModel tab = new DefaultTableModel(null, col);
		
		ArticleDao cliDao = new ArticleDao();
		
		
		List<Article> listArticle = new ArrayList<>();
		listArticle.addAll(cliDao.read());
		
		 for (int index =0; index<listArticle.size(); index++ ) {
			 Article cli = listArticle.get(index);
			 
			 Vector vect = new Vector();
			 vect.add(cli.getId());
			 vect.add(cli.getTitre());
			 vect.add(cli.getResume());
			 vect.add(cli.getCreated_at());
			 vect.add(cli.getAuteur());
			 
			 tab.addRow(vect);
		 }
		return tab;
	}
	
}
