package swing;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Insets;

public class Layout_Border extends JFrame{

	public Layout_Border() {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cda609\\Desktop\\CDA\\Ressources_Test\\Images\\triforce.png"));
		getContentPane().setBackground(Color.BLUE);
		this.setSize(750,500);
		this.setLocationRelativeTo(null);
	
		getContentPane().add(navbar(), BorderLayout.NORTH);
		getContentPane().add(footer(), BorderLayout.SOUTH);
		getContentPane().add(aside_west(), BorderLayout.WEST);
		getContentPane().add(aside_east(), BorderLayout.EAST);
		getContentPane().add(left(), BorderLayout.WEST);
		getContentPane().add(right(), BorderLayout.EAST);
		getContentPane().add(morpion(), BorderLayout.CENTER);
		
		
	}
	public JMenuBar navbar() {
		JMenuBar menu = new JMenuBar();
		menu.setBackground(Color.RED);
		JMenu acceul = new JMenu("Acceuil");
		acceul.setHorizontalAlignment(SwingConstants.CENTER);
		JMenuItem test = new JMenuItem("test");
		JMenuItem bis = new JMenuItem("bis");
		acceul.add(test);
		acceul.add(bis);
		menu.add(acceul);
		JMenu menu_1 = new JMenu("A propos");
		menu.add(menu_1);
		menu.add(new JMenu("Contact"));

		return menu;
	}
	public JMenuBar footer() {
		JMenuBar footer = new JMenuBar();
		footer.setBackground(Color.LIGHT_GRAY);
		footer.add(new JButton("Acceuil"));
		footer.add(new JButton("A propos"));
		JButton button = new JButton("Contact");
		footer.add(button);
		
		return footer;
	}
	public JMenuBar left() {
		JMenuBar left = new JMenuBar();
		left.setBackground(Color.GREEN);
		left.add(new JButton("Je suis le Bouton de l'ouest"));
		left.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		return left;
	}
	public JMenuBar right() {
		JMenuBar right = new JMenuBar();
		right.setBackground(Color.CYAN);
		right.add(new JButton("Je suis le Bouton de l'est"));
		
		return right;
	}
	public JLabel aside_east() {
		JLabel east = new JLabel("Je suis le label de l'ouest");
		east.setBackground(Color.CYAN);
		return east;
	}
	public JLabel aside_west() {
		JLabel west = new JLabel("Je suis le label de l'est");
		west.setForeground(Color.BLACK);
		west.setFont(new Font("Tahoma", Font.PLAIN, 14));
		west.setBackground(Color.GREEN);
		return west;
	}
	public JLabel morpion() {
		JLabel west = new JLabel("Je suis au centre");
		west.setHorizontalAlignment(SwingConstants.CENTER);
		west.setForeground(Color.WHITE);
		west.setFont(new Font("Tahoma", Font.PLAIN, 14));
		west.setBackground(Color.WHITE);
		return west;
	}
	
	public static void main(String[] args) {
		Layout_Border bd = new Layout_Border();
		bd.setVisible(true);

	}//*Fin Main


	
}//Fin Classe
