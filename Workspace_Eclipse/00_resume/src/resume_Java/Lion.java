package resume_Java;

public class Lion extends Animal implements Interface_Homme_Lion{
	//Autant d'implments qu'on veut mais 1 seul extends max
	
	protected static int comptage; 
	//static == partagé entre toustes les instances de cette classe
	
	public String nommer() {return super.nommer() + "lion";} 
		//super obligatoire pour appeler celui des parents quand meme nom
	
	public String crier() {return "rugir";};
	public String manger() {return "Viande";};
	public String dormir() {return "dodo";};
	
	//Interface
	@Override
	public String caresser() {
		return "Un futur repas vient me voir";
	}
}
