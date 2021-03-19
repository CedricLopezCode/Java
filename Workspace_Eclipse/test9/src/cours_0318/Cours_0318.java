package cours_0318;

public class Cours_0318 {

	public static void main(String[] args) {
		Parent_ou_Mere mere = new Parent_ou_Mere();
		System.out.println(mere.affichage_protected());
		
		Enfant_ou_Fille fille = new Enfant_ou_Fille();
		System.out.println(fille.fille());
		
		System.out.println(fille.fillebis());
		
		Lion simba = new Lion();
		System.out.println(simba.crier());
		System.out.println(simba.identifier());
		
		
		
		
		
		
	}

	

}
