package serie_1_exo_2_Prof;

public class Main_Prof {

	public static void main(String[] args) {
	
		Specialite java_jee = new Specialite("JAVA/JEE");
		Specialite html_css = new Specialite("HTML/CSS");
		Specialite gestion_projet = new Specialite("Gestion de Projet");
		Specialite js = new Specialite("JS");
		Specialite php = new Specialite("PHP");
		//correction
		/*Specialite[] spe = new Specialite[5];
		spe[0] = new Specialite("JAVA/JEE");
		spe[1] = new Specialite("HTML/CSS");
		spe[2] = new Specialite("Gestion de Projet");
		spe[3] = new Specialite("JS");
		spe[4] = new Specialite("PHP");*/
		
		
		Enseignant prof_1 = new Enseignant(java_jee);
		Enseignant prof_2 = new Enseignant(java_jee);
		Enseignant prof_3 = new Enseignant(php);
		Enseignant prof_4 = new Enseignant(js);
		//correction
		/*Enseignant[] prof = new Enseignant[4];
		prof[0]= new Enseignant(spe[0]);
		prof[1]= new Enseignant(spe[0]);
		prof[2]= new Enseignant(spe[4]);
		prof[3]= new Enseignant(spe[3]);*/
				
				
			/*	
		System.out.println(java_jee);
		System.out.println(html_css);
		System.out.println(gestion_projet);
		System.out.println(js);
		System.out.println(php);
		
		System.out.println(prof_1);
		System.out.println(prof_2);
		System.out.println(prof_3);
		System.out.println(prof_4);

		*/
		//correction
		for (Specialite spec : spe) {
			System.out.println(spec);
			int compterur = 0;
			for (Enseignant enseignant : prof) {
				if (enseignant.getSpecialite().getId_specialite() == spec.getId_specialite()) {
					System.out.println("La spécialité " + spec.getId_specialite() + " a pour enseignant " + enseignant.getNom_enseignant());
					compterur = 1;
				}// else /*si pas de compteur mais repetition*/ {
					//System.out.println("Aucun eseignant pour la spécialité " + spec.getNom_specialite());}
			}
			if(compterur == 0) {
				System.out.println("Aucun eseignant pour la spécialité " + spec.getNom_specialite());
			}
		}
	}//Fin main
	
	/*SELECT count * FROM enseignant ORDER by id_specialite;
	if(count * == 0) {
		System.out.println("Aucun enseignant pour la spécialité " + id_specialite);
	}*/
}

