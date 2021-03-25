package dao;

import java.util.List;

public interface IDAO<T> {//typage generique
	//T  ou S ou U = Typage 
	//E = element de tableau 
	//K,V ==key = indice, value
	
	//preparation interface
	public void create(T object); //object par convention
	public void afficher();
	public List<T> lister();
	public void update(int id, String nv_nom);
	public void delete(int id);
	public void findBy(T object);
	public void vider_table();
	
	
	
	
}
