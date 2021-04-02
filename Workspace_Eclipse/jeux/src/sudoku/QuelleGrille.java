package sudoku;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuelleGrille extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuelleGrille frame = new QuelleGrille();
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
	public QuelleGrille() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txt_Choix = new JLabel("Rentrer le numero de grille à remplir entre 1 et " + grille_max());
		txt_Choix.setBounds(10, 0, 683, 105);
		txt_Choix.setFont(new Font("Tahoma", Font.BOLD, 20));
		txt_Choix.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(txt_Choix);
		
		textField = new JTextField();
		textField.setBounds(46, 116, 153, 61);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn_choix = new JButton("Valider");
		btn_choix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choix_numero_grille_swing();
			}
		});
		btn_choix.setBounds(294, 116, 110, 61);
		contentPane.add(btn_choix);
	}
	
	public int choix_numero_grille_swing() {
		int choix_grille = Integer.parseInt(textField.getText());
		do{
			if  (choix_grille < 1 || choix_grille > grille_max()) {
				JOptionPane.showMessageDialog(btn_choix, "Le numero de grille doit etre entre 1 et "+ grille_max());
			}else {
				dispose();
			}
		}while (1 > choix_grille || choix_grille > grille_max());
		return choix_grille;
	}
	
	public int grille_max() {
		Connection connect = GetDB.getConnection();
		int max_grille = 0;
		try {
			PreparedStatement max = connect.prepareStatement("SELECT MAX(num_grille) FROM sudoku");
			ResultSet rs = max.executeQuery();
			while (rs.next()) {
				max_grille = rs.getInt(1);
				/*if(rs.getInt("num_grille") > max_grille) {
					max_grille = rs.getInt("num_grille");
				}*/
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("grille max KO");
		}
		return max_grille;
	}
}
