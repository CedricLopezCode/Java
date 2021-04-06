package blog_article;

import java.util.List;

public interface IDAO<T> {

	public void create(T object);
	public List<T> read();
	public void update(T object);
	public void delete(int id);
	public List<T> lister();
	public T findById(int id);
	public void vider_table(T object);
	public boolean login(String email, String pwd);
	
}
