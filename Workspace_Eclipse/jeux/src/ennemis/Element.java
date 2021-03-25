package ennemis;

abstract public class Element<T> {
	
	protected T element;
	
	public void attaque() {
		System.out.println("Boule de " + element.getNom());
	};
	public void defense() {
		System.out.println("Mur de " + element.getNom());
	};
}
