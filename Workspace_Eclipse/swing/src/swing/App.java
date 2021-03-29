package swing;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//help// install new software
//work with n'importe
//Windowsbuilder Core
//Windowsbuilder Core UI
//Windows builder Java Core
//swing
public class App extends JFrame{
	
	public App() {
		super();
		
		//Creation fenetre
		this.setSize(400,1000); //taille fenetre //largeur, hauteur
		this.setLocationRelativeTo(null); //Pour nafficher la fenetre au centre de l'ecran et pas en haut a gauche
		JPanel jp = (JPanel) this.getContentPane();//getContentPane == la fenetre	
		
		//ajout
		//Possibilite passer par design: clic droit open with windowsBuilder Editor
		JButton btn = new JButton("Clique");
		jp.add(btn);
		
		JLabel label = new JLabel("label");
		jp.add(label);
		
		//Pour avoir plusieurs elements en meme temps et que ca affiche pas que le dernier
		//jp.setLayout(getLayout());
	}

	public static void main(String[] args) {
		
		//Creation fenetre
		App ap = new App();
		ap.setVisible(true);
		
		

	}//Fin MAin

}//Fin class
