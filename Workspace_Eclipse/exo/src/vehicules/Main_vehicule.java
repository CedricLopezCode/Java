package vehicules;

public class Main_vehicule {

	public static void main(String[] args) {
		Voiture voiture_sans_param = new Voiture();
		Voiture voiture_avec_carb = new Voiture("essence");
		Voiture voiture_avec_vit = new Voiture(300);
		Voiture voiture_avec_tout = new Voiture("diesel", 250);
		
		Moto moto_sans_param = new Moto();
		Moto moto_avec_carb = new Moto("essence");
		Moto moto_avec_vit = new Moto(300);
		Moto moto_avec_tout = new Moto("diesel", 250);
		
		Pompe pompe_essence = new Pompe();
		Pompe pompe_diesel = new Pompe("diesel");
		
		System.out.println(voiture_sans_param);
		System.out.println(voiture_avec_carb);
		System.out.println(voiture_avec_vit);
		System.out.println(voiture_avec_tout);
		System.out.println(moto_sans_param);
		System.out.println(moto_avec_carb);
		System.out.println(moto_avec_vit);
		System.out.println(moto_avec_tout);
		System.out.println(pompe_essence);
		System.out.println(pompe_diesel);
		System.out.println();
		
		System.out.println("Reservoir vehicule avant: " + moto_avec_carb.getContenu_reservoir());
		moto_avec_carb.fairePlein(pompe_diesel);
		System.out.println("Reservoir vehicule apres: " + moto_avec_carb.getContenu_reservoir());
		System.out.println(pompe_diesel);
		System.out.println();
		
		moto_avec_carb.fairePlein(pompe_essence);
		System.out.println("Reservoir vehicule apres: " + moto_avec_carb.getContenu_reservoir());
		System.out.println(pompe_essence);
		
		

	}

}
