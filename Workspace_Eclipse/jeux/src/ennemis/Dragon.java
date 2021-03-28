package ennemis;

public class Dragon<T> extends Monstre{
	
	protected T element;
	
	public void souffle() {
		System.out.println("Envoie un souffle de " + element.getNom());
	}

	public Dragon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dragon(T element) {
		super();
		this.element = element;
	}
	
	
}//fin Class
