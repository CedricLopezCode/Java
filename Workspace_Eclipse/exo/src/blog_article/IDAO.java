package blog_article;

import java.util.List;

public interface IDAO<T> {

	public void create(T object);
	public List<T> read();
	public void update(T object);
	public void delete(T object);
	public List<T> lister();
	public void findBy(T object);
	public void vider_table(T object);
	public boolean login(String email, String pwd);
	
}
