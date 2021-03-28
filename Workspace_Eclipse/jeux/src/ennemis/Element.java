package ennemis;

abstract public class Element<T> {
	
	protected T element;
	
	public void attaque() {
		System.out.println("Boule de " + element.nom);
	};
	public void defense() {
		System.out.println("Mur de " + element.getNom());
	}
	
	public Element(T element) {
		super();
		this.element = element;
	}
	@Override
	public String toString() {
		return "Element " + element;
	};
	
	
}
