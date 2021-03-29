package swing;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form extends JFrame{
	private JTextField user;
	private JTextField pwd;
	private JButton submit;

	public static void main(String[] args) {
		Form formulaire = new Form();
		formulaire.setVisible(true);
		
	}

	public Form(){
		super();
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel Username = new JLabel("Username");
		Username.setBounds(146, 156, 63, 14);
		getContentPane().add(Username);
		
		JLabel Pasword = new JLabel("Pasword");
		Pasword.setBounds(146, 224, 165, 14);
		getContentPane().add(Pasword);
		
		user = new JTextField();
		user.setBounds(273, 153, 273, 20);
		getContentPane().add(user);
		user.setColumns(10);
		
		pwd = new JTextField();
		pwd.setBounds(273, 221, 273, 20);
		getContentPane().add(pwd);
		pwd.setColumns(10);
		
		submit = new JButton("Envoyer");
		submit.addActionListener(new ActionListener() { //ecouteur d'evenement
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(submit, "Bonjour "+user.getText());//Boite de dialogue
			}
		});
		submit.setBounds(371, 308, 89, 23);
		getContentPane().add(submit);
	}
}
