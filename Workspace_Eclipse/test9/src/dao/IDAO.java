package dao;

public interface IDAO<T> {//typage generique
	//T  ou S ou U = Typage 
	//E = element de tableau 
	//K,V ==key = indice, value
	
	//preparation interface
	public void create(T object); //object par convention
	public void read();
	public void update(T object, int id, String nv_nom);
	public void delete(T object, int id);
	public void findBy(T object);
	public void vider_table(T object);
	
	
	
	
}
