import java.util.List;
import java.util.Scanner;

/**
 * This is a simulation of a social networking site
 * @author casey
 *
 */
public class Driver {

	/**
	 * This is the driver that runs the simulation
	 * @param args should be empty
	 */
	public static void main(String[] args) {
		BST<User> bst = new BST<User>();
		boolean done = false;
		Scanner in = new Scanner(System.in);
		while (!done) {
			System.out.println("1. Add a user.\n"
					+ "2. Remove a user.\n"
					+ "3. Find a specific user.\n"
					+ "4. List users.\n"
					+ "5. Debug.\n"
					+ "6. Quit.");
			int choice = Integer.parseInt(in.nextLine());
			if (choice == 1) {
				System.out.println("Enter the name of the new user.");
				String name = in.nextLine();
				System.out.println("Enter the username of the new user");
				String username = in.nextLine();
				User toAdd = new User(username, name);
				if (!bst.contains(toAdd)) {
					bst.add(toAdd);
				} else {
					System.out.println("User already exists!");
				}
			} else if (choice == 2) {
				System.out.println("Enter the username you would like to remove");
				String username = in.nextLine();
				if (!bst.contains(new User(username, ""))) {
					System.out.println("User does not exist");
				} else {
					try {
						bst.remove(new User(username, ""));
						System.out.println("Remove successful");
					} catch (Exception e) {
						System.out.println("Null data is not acceptable");
					}
				}
			} else if (choice == 3) {
				System.out.println("Enter the username of the user");
				String username = in.nextLine();
				if (bst.contains(new User(username, ""))) {
					System.out.println("Their name is: " + bst.get(new User(username, "")).getName());
				} else {
					System.out.println("User does not exist!");
				}
			} else if (choice == 4) {
				List<User> inOrder = bst.inOrder();
				for (User u : inOrder) {
					System.out.println(u);
				}
			} else if (choice == 5) {
				System.out.println(bst);
			} else if (choice == 6) {
				done = true;
			} else {
				System.out.println("Invalid option");
			}
		}
		in.close();
	}
}
