package Models;

public class User {
	String username;
	int result;
	
	public User(String username, int result) {
		this.username = username;
		this.result = result;
	}
	
	@Override
	public String toString() {
		return this.username + ": " + this.result + "%";
	}
	
	public int getResult() {
		return this.result;
	}
}