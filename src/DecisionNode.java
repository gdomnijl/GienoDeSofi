import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public interface DecisionNode {
	public int countObjects();
	public DecisionNode guess(Scanner in);
	public DecisionNode sofiGuess(Scanner in) throws IOException;
	public void write(FileWriter out) throws IOException;
}
