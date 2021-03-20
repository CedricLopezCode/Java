package heritage_Mario_Kart;

abstract public class Arme extends Objet implements Bouclier_VS_Arme{
	
	String type = "Arme";
	
	public String armeVSbouclier() {return "Attaque déjouée";}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
