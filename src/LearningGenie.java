import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LearningGenie {

	/**
	 * Prints the introductory sequence for a given DecisionTree (game).
	 * @param tree, a DecisionTree
	 */
	public static void showIntro(DecisionTree tree, Scanner in) {
		
		System.out.println("\u00A1"+"Hola!");
		System.out.println("\u00A1Soy el genio de Sofia!");
		in.nextLine();
		System.out.println("I can figure out WHOEVER Sofi has a crush on \nby asking questions.");
		in.nextLine();
		System.out.println("\n\nMuahahahaha [^0^]");
		int guesses = tree.countObjects();
		System.out.printf("I have %d candidate(s) in mind!\n\n", guesses);
		System.out.printf("Hit 'Enter' to begin\ntype 'Yes' or 'No' to answer questions");
	}

	public static void main(String[] args) throws IOException {
		DecisionTree tree = new DecisionTree
				(new File("/Users/apple/Desktop/CCCC/GenioDeSofi/src/AnimalMemoryTree"));
		Scanner in = new Scanner(System.in);
		Scanner punread = new Scanner(new File("/Users/apple/Desktop/CCCC/GenioDeSofi/src/Punishment"));
		System.out.println("Hit 'Enter' to continue\n");
		in.nextLine();
		
		showIntro(tree, in);
		in.nextLine();
		System.out.println("\nIs it Sofi playing this game?");
		if (in.nextLine().toLowerCase().compareTo("yes") == 0){
			System.out.println("sofiguess");
			tree.sofiGuess(in);
		} else {
			tree.guess(in);
		}
		
		
	}
}
