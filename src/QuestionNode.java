import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuestionNode implements DecisionNode {
	private String question;
	private DecisionNode yes;
	public DecisionNode no;


	/**
	 * Constructs a new QustionNode with the given input, yesBranch, and noBranch
	 * @param input, a String containing a question, yes = yesBranch, no = noBranch
	 * @param yes, a DecisionNode
	 * @param no, a DecisionNode
	 */
	public QuestionNode(String input, DecisionNode yes, DecisionNode no) {
		question = input;
		this.yes = yes;
		this.no = no;
	}

	/**
	 * Counts the number of GuessNodes that are lower, hierarchically, than this QuestionNode
	 */
	public int countObjects() {
		int size = 0;
		if (this.yes != null) {
			size += this.yes.countObjects();
		}
		if (this.no != null) {
			size += this.no.countObjects();
		}
		return size;
	}

	public DecisionNode sofiGuess(Scanner in) throws IOException{
		System.out.printf(question + " ");
		String response = in.nextLine().toLowerCase();
		if (response.compareTo("yes") == 0) {
			return new QuestionNode(this.question, this.yes.sofiGuess(in), this.no);
		} else if (response.toLowerCase().compareTo("no") == 0) {
			return new QuestionNode(this.question, this.yes, this.no.sofiGuess(in));
		} else {
			System.out.println("Please enter valid input: 'yes' or 'no'");
			return this.guess(in);
		}
	}
	/**
	 * Plays the game from this question node. 
	 */
	public DecisionNode guess(Scanner in) {
		System.out.printf(question + " ");
		String response = in.nextLine().toLowerCase();
		if (response.compareTo("yes") == 0) {
			return new QuestionNode(this.question, this.yes.guess(in), this.no);
		} else if (response.toLowerCase().compareTo("no") == 0) {
			return new QuestionNode(this.question, this.yes, this.no.guess(in));
		} else {
			System.out.println("Please enter valid input: 'yes' or 'no'");
			return this.guess(in);
		}
	}

	/**
	 * Writes this question to an output file.
	 */
	public void write(FileWriter out) throws IOException {
		out.write("#");
		out.write(this.question + "\n");
		if (this.yes != null) {
			this.yes.write(out);
		}
		if (this.no != null) {
			this.no.write(out);
		}
	}
}