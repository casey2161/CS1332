import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Driver {
	public static void main(String[] args) {
		String needle;
		String haystack;
		List<Integer> matches = new ArrayList<Integer>();
		StringSearch ss = new StringSearch();
		Scanner in = new Scanner(System.in);
		boolean done = false;
		long start;
		long time;
		while (!done) {
			System.out.println("Input the haystack to search.");
			haystack = in.nextLine();
			System.out.println("Input the needle to search for.");
			needle = in.nextLine();
			
			System.out.println("Choose which method to use.\n" 
					+ "1. Boyer-Moore\n"
					+ "2. Rabin-Karp");
			int choice = Integer.parseInt(in.nextLine());
			if (choice == 1) {
				start = System.nanoTime();
				matches = ss.boyerMoore(needle, haystack);
				time = System.nanoTime() - start;
				System.out.print("Boyer-Moore found matches at ");
				if (matches.size() > 0) {
					for (Integer i : matches) {
						System.out.print(i + " ");
					}
					System.out.println();
				} else {
					System.out.println("no indeces");
				}
				System.out.println("It took " + time / 1000000000.0 + "seconds");
			} else if (choice == 2) {
				start = System.nanoTime();
				matches = ss.rabinKarp(needle, haystack);
				time = System.nanoTime() - start;
				System.out.print("Rabin-Karp found matches at ");
				if (matches.size() > 0) {
					for (Integer i : matches) {
						System.out.print(i + " ");
					}
					System.out.println();
				} else {
					System.out.println("no indeces");
				}
				System.out.println("It took " + time / 1000000000.0 + "seconds");
			}
			System.out.println("Enter 1 to quit.");
			done = Integer.parseInt(in.nextLine()) == 1;
		}
		in.close();
	}
}
