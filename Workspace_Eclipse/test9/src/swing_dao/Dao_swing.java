package swing_dao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.Client;
import dao.ClientDao;
import dao.User;
import dao.UserDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSpinner.ListEditor;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dao_swing extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField email;
	private JPasswordField pwd;
	private JTextField login_email;
	private JPasswordField login_pwd;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dao_swing frame = new Dao_swing();
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
	public Dao_swing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Pr\u00E9nom");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 112, 86, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setBounds(31, 41, 74, 50);
		contentPane.add(lblNom);
		
		nom = new JTextField();
		nom.setBounds(85, 41, 207, 50);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(85, 112, 207, 50);
		contentPane.add(prenom);
		
		JButton submit = new JButton("Ajout Client");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String saisie_nom = nom.getText();
				String saisie_prenom = prenom.getText();
				
				if(saisie_nom.equals("") || saisie_prenom.equals("")) {
					
					JOptionPane.showMessageDialog(submit, "Veuillez remplir tous les champs");
				}else {
					//JOptionPane.showMessageDialog(submit, saisie_prenom);
					
					Client cli = new Client(saisie_nom,saisie_prenom);
					
					ClientDao clientDao = new ClientDao();
					
					clientDao.create(cli);
				}
				
			}
		});
		submit.setBounds(85, 194, 207, 73);
		contentPane.add(submit);
		
		String email_user = email.getText();
		String pwd_user = pwd.getText();
		User user = new User(email_user,pwd_user);
		
		UserDao udao = new UserDao();
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(398, 50, 42, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mot de passe");
		lblNewLabel_1_1.setBounds(381, 121, 74, 32);
		contentPane.add(lblNewLabel_1_1);

		JButton btn_sup = new JButton("Supprimer");
		btn_sup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligne_a_sup = table_3.getSelectedRow();
				int id_a_sup = (int) table_3.getModel().getValueAt(ligne_a_sup, 0);
				
				udao.delete(id_a_sup);
			}
		});
		btn_sup.setBounds(533, 282, 89, 23);
		contentPane.add(btn_sup);
		btn_sup.setVisible(false);
		
		email = new JTextField();
		email.setBounds(450, 49, 252, 35);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton submit_user = new JButton("Ajout User");
		submit_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(submit_user.getText().equals("Ajout User")) {
					
					udao.create(user);
					
				}else {
					int id2 = table_3.getSelectedRow();
					user.setId((int)table_3.getModel().getValueAt(id2, 0));
					udao.update(user);
					table_3.setModel(UserDao.liste());
					//JOptionPane.showMessageDialog(submit_user, "Modifié");
					submit_user.setText("Ajout User");
					btn_sup.setVisible(false);
				}
				table_3.setModel(UserDao.liste());
				email.setText("");
				pwd.setText("");
			}
		});
		submit_user.setBounds(465, 201, 207, 59);
		contentPane.add(submit_user);
		
		pwd = new JPasswordField();
		pwd.setBounds(465, 117, 242, 41);
		contentPane.add(pwd);
		
		login_email = new JTextField();
		login_email.setColumns(10);
		login_email.setBounds(707, 49, 252, 35);
		contentPane.add(login_email);
		
		login_pwd = new JPasswordField();
		login_pwd.setBounds(717, 124, 242, 41);
		contentPane.add(login_pwd);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email_user = login_email.getText();
				String pwd_user = login_pwd.getText();
				User user = new User(email_user,pwd_user);
				
				UserDao udao = new UserDao();

				List<User> uList = new ArrayList<User>();
				//Possibilité de faire le try-catch direct ici mais pas propre
				//version comparaison apres liste
				uList = udao.lister();
				
				//version comparaison avant liste
				if (udao.login(email_user, pwd_user)) {
					System.out.println("Bienvenue");
					dispose();
					homePage home = new homePage();
					home.setVisible(true);
				}else {
					System.out.println("Vérifiez vos informations");
				}
			}
		});
		login.setBounds(736, 201, 207, 59);
		contentPane.add(login);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(707, 11, 262, 402);
		contentPane.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.YELLOW);
		panel_3.setBounds(22, 282, 469, 175);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 449, 153);
		panel_3.add(scrollPane);
		
		
		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = table_3.getSelectedRow();
				submit_user.setText("Modifier User");
				btn_sup.setVisible(true);
				int user_id = (int) table_3.getModel().getValueAt(id, 0);
				String user_email= (String) table_3.getModel().getValueAt(id, 1);
				String user_pwd = (String) table_3.getModel().getValueAt(id, 2);
				email.setText(user_email);
				pwd.setText(user_pwd);
				/*JOptionPane.showMessageDialog(scrollPane, user_id);
				JOptionPane.showMessageDialog(scrollPane, user_email);
				JOptionPane.showMessageDialog(scrollPane, user_pwd);*/
			}
		});
		scrollPane.setViewportView(table_3);
		
		table_3.setModel(UserDao.liste());
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(31, 11, 286, 268);
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		panel_2.setBounds(381, 11, 326, 254);
		contentPane.add(panel_2);
		
		
		}
}