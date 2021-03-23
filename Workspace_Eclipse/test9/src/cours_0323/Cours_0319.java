package cours_0323;

public class Cours_0319 {
	//Polymorphisme
	public static void main(String[] args) {
		Polo p = new Polo();
		Porche pr = new Porche();
		
		System.out.println(p);
		System.out.println(pr);
		
		Voiture polo2 = new Polo();
		Voiture porche2 = new Porche();

		System.out.println(polo2);
		System.out.println(porche2);
	}
	
	//DAO //Database Access Object
	//my sql jar //classe drivers
	//file / properties / build path / librairy / add EXTERNAL librairy 
	//dans clath path et pas module path 
}
