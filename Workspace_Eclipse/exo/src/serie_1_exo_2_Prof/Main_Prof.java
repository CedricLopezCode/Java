package serie_1_exo_2_Prof;

public class Main_Prof {

	public static void main(String[] args) {
		Specialite java_jee = new Specialite("JAVA/JEE");
		Specialite html_css = new Specialite("HTML/CSS");
		Specialite gestion_projet = new Specialite("Gestion de Projet");
		Specialite js = new Specialite("JS");
		Specialite php = new Specialite("PHP");
		
		Enseignant prof_1 = new Enseignant(1/*"JAVA/JEE"*/);
		Enseignant prof_2 = new Enseignant(1/*"JAVA/JEE"*/);
		Enseignant prof_3 = new Enseignant(5/*"PHP"*/);
		Enseignant prof_4 = new Enseignant(4/*"JS"*/);

	}//Fin main
	
	SELECT count * FROM enseignant ORDER by id_specialite;
	if(count * == 0) {
		System.out.println("Aucun enseignant pour la spécialité " + id_specialite);
	}
}

