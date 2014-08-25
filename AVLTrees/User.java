/**
 * This is a java representation of a user for a social network simulation
 * @author casey
 *
 */
public class User implements Comparable<User> {

	private String userName;
	private String name;
	
	/**
	 * This is the constructor for a User
	 * @param userName the username for the user
	 * @param name the name of the user
	 */
	public User(String userName, String name) {
		this.userName = userName;
		this.name = name;
	}
	
	/**
	 * This is the to string method for User.
	 * @return userName + "-" + name
	 */
	public String toString() {
		return userName + "-" + name;
	}
	
	/**
	 * This is the getter for a user's username
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This is the getter for a user's name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(User o) {
		String lowerUserName = userName.toLowerCase();
		String otherUserName = o.getUserName().toLowerCase();
		return lowerUserName.compareTo(otherUserName);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof User)) {
			return false;
		}
		return userName.equalsIgnoreCase(((User) o).getUserName());
	}
}
