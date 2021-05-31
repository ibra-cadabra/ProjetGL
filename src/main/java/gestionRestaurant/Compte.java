package gestionRestaurant;

public class Compte {
	String login;
	String password;
	String role;
	
	public Compte(String login, String password, String role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	//Getters et setters

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Compte [login=" + login + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
