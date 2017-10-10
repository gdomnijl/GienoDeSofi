import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;

public class DecisionTree {

	private DecisionNode root;
	
	/**
	 * Constructs a new DecisionTree with Sofia Mendez as its root.
	 */
	public DecisionTree() {
		root = new GuessNode("Sofia Mendez");
	}
	
	/**
	 * Constructs a DecisionTree from the given file that contains a serialized DecisionTree.
	 * @param file
	 * @throws IOException
	 */
	public DecisionTree(File file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		this.root = decisionTreeH(in);
	}

	public DecisionNode decisionTreeH(BufferedReader in) throws IOException {
		String instruction = in.readLine();
		if (instruction.startsWith("#")) {
			String question = instruction.substring(1);
			//?which one to read first?
			return new QuestionNode(question, decisionTreeH(in), decisionTreeH(in));
		} else {
			return new GuessNode(instruction);
		}
	}
	
	/**
	 * @return the number of Guess Nodes in this DecisionTree.
	 */
	public int countObjects() {
		return root.countObjects();
	}
	
	/**
	 * Plays the game using the referenced MemoryTree (file). Ends or continues the game after something is guessed.
	 * @param in, the user input
	 * @throws IOException
	 */
	public void guess(Scanner in) throws IOException {
		
		// Set the root equal to the input.
		this.root = this.root.guess(in);
		FileWriter out = new FileWriter("/Users/apple/Desktop/CCCC/GenioDeSofi/src/AnimalMemoryTree");
		this.write(out);
		out.close();
		// After either guessing correctly or getting new knowledge, 
		// ask if the user wants to continue
		System.out.println("Another round?");
		String input = in.nextLine().toLowerCase();
		if (input.compareTo("yes") == 0) {
			try {
				LearningGenie.main(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (input.compareTo("no") == 0) {
			
		} else {
			System.out.println("Please enter valid input, 'yes' or 'no'.");
			System.out.println("The game will now end.");
			return;
		}
	}
	
public void sofiGuess(Scanner in) throws IOException {
		
		// Set the root equal to the input.
		this.root = this.root.sofiGuess(in);
		FileWriter out = new FileWriter("/Users/apple/Desktop/CCCC/GenioDeSofi/src/AnimalMemoryTree");
		this.write(out);
		out.close();
		// After either guessing correctly or getting new knowledge, 
		// ask if the user wants to continue
		System.out.println("Another round?");
		String input = in.nextLine().toLowerCase();
		if (input.compareTo("yes") == 0) {
			try {
				LearningGenie.main(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (input.compareTo("no") == 0) {
			
		} else {
			System.out.println("Please enter valid input, 'yes' or 'no'.");
			System.out.println("The game will now end.");
			return;
		}
	}


	/**
	 * Writes the decision tree to a file.
	 * @param out, the file to be written to.
	 * @throws IOException
	 */
	public void write(FileWriter out) throws IOException {
		root.write(out);
	}
}

