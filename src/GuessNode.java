import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class GuessNode implements DecisionNode {
	public String guessObj;

	/**
	 * Constructs a new guess node containing the "guess" input
	 * @param guess, a string
	 */
	public GuessNode(String guess) {
		guessObj = guess;
	}

	/**
	 * Counts the number of guess nodes in a Decision Tree. 
	 * The actual "counting" occurs in the QuestionNode method
	 */
	public int countObjects() {
		return 1;
	}

	/**
	 * Plays the game starting at the current guess node ("this").
	 * If the current guess is correct, returns the current, correct guess node.
	 * If not, returns a new question node (question, current guess node's guess, correct guess)
	 * @param in, Scanner input from the user. Entered in the console.
	 */
	public DecisionNode guess(Scanner in) {
		System.out.printf("Is it " + guessObj + "? ");
		String response = in.nextLine().toLowerCase();
		if (response.compareTo("yes") == 0) {
			
			return this; 
		} else if (response.compareTo("no") == 0) {
			System.out.println("Okay, fine.");
			System.out.println("Who is it?");
			String crtObj = in.nextLine();
			System.out.println("What is a yes/no question that distinguishes "
					+ guessObj + " from " + crtObj);
			System.out.println("(Yes corresponds to " + guessObj + 
					"; No corresponds to " + crtObj + ")");
			String inputQuestion = in.nextLine();
			System.out.println("Yay! I know one more person!");
			GuessNode noBranch = new GuessNode(crtObj);
			QuestionNode question = 
					new QuestionNode(inputQuestion, this, noBranch);
			return question;
		} else {
			return this.guess(in);
		}
	}
	public void punishment(Scanner in) throws  IOException {
		System.out.println("Since "+ guessObj + "is your crush, s/he will do this for you: ");
		System.out.println("Choose a number between 1-100: ");
		Scanner punread = new Scanner
				(new File("/Users/apple/Desktop/CCCC/GenioDeSofi/src/Punishment"));
		int punInd = (int)Integer.parseInt(in.nextLine());
		while (punInd-- % 5 > 0) {
			punread.nextLine();
		}
		System.out.println(punread.nextLine());
	}
	
	public DecisionNode sofiGuess(Scanner in) throws IOException {
		System.out.println("It's " + guessObj + "! ");
		System.out.printf("Hit 'Enter' for their surprise 8)");
		in.nextLine();
			System.out.println("Happy Birthday Sofi!!!");
			this.punishment(in);
			return this; 
		
	}
	/**
	 * Writes the data from this guess node to a file
	 */
	public void write(FileWriter out) throws IOException {
		out.write(this.guessObj + "\n");
	}
}
