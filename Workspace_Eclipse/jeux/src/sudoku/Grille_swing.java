package sudoku;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.User;
import dao.UserDao;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;

public class Grille_swing extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grille_swing frame = new Grille_swing();
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
	public Grille_swing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(39, 11, 510, 511);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 490, 489);
		panel.add(table);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setBounds(49, 533, 39, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setBounds(110, 533, 39, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("1");
		btnNewButton_2.setBounds(159, 533, 39, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("1");
		btnNewButton_1_1.setBounds(225, 533, 39, 33);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_3 = new JButton("1");
		btnNewButton_3.setBounds(285, 533, 39, 33);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1_2 = new JButton("1");
		btnNewButton_1_2.setBounds(348, 533, 39, 33);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_2_1 = new JButton("1");
		btnNewButton_2_1.setBounds(406, 533, 39, 33);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1_1 = new JButton("1");
		btnNewButton_1_1_1.setBounds(461, 533, 39, 33);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("1");
		btnNewButton_1_1_1_1.setBounds(510, 533, 39, 33);
		contentPane.add(btnNewButton_1_1_1_1);
	}
	public DefaultTableModel grilleSwing() {
		String[] col = {"C1","C2","C3","C4","C5","C6","C7","C8","C9"};
		String[] lgn = {"L1","L2","L3","L4","L5","L6","L7","L8","L9"};
		Grille_dao ggDao = new Grille_dao(); 
		DefaultTableModel grilleModel = new DefaultTableModel(null,col);
		List<Cellule> listCellull = new ArrayList<>();
		listCellull.addAll(grille);
		
		
		return grilleModel;
		
	}
	
	
	public static DefaultTableModel liste() {
		String[] col = {"ID","Email","Pwd"};
		UserDao usDao = new UserDao();
		DefaultTableModel tab = new DefaultTableModel(null,col);
		List<User> listUser = new ArrayList<>();
		listUser.addAll(usDao.lister());
		for (int index = 0; index < listUser.size(); index++) {
			User us = listUser.get(index);
			Vector vect = new Vector(); //== ArrayList avec modif en direct sans rafraichir
			vect.add(us.getId());
			vect.add(us.getEmail());
			vect.add(us.getPassword());
			
			tab.addRow(vect);
		}
		return tab;
	}
}
