import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextParser {
	private final VocabularyManager vocabularyManager;

	public TextParser(VocabularyManager vocabularyManager) {
		this.vocabularyManager = vocabularyManager;
	}

	public void parseTextFile(String fileName) {
		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNext()) {
				String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
				if (word.length() > 0) {
					// check if the word is already in the vocabulary
					vocabularyManager.addWord(word);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		}
	}
}