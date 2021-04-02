package dao;

public class User {
	private int id;
	private String email;
	private String password;
	protected static int comptage=1;
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		comptage++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}