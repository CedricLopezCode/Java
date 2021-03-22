package seie_2_equipe;

public class Main_equipe {

	public static void main(String[] args) {
		
		Roles cp = new Roles("Chef de projet", "CP");
		Roles mn = new Roles("Manager", "MN");
		Roles dp = new Roles("Développeur", "DP");

		Utilisateur cedric = new Utilisateur("cedric", mn) ;
		Utilisateur moussa = new Utilisateur("moussa", mn) ;
		Utilisateur dernier = new Utilisateur("dernier", dp) ;
		
		
		System.out.println(cp);
		System.out.println(mn);
		System.out.println(dp);
		System.out.println();
		System.out.println(cedric);
		System.out.println(moussa);
		System.out.println(dernier);
	}

}
