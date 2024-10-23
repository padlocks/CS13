import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import LinkedList.LinkedList;

public class VocabularyManager {
	private final LinkedList<Word> words = new LinkedList<>();

	private int findIndexOfWord(String word) {
		for (Word w : this.words) {
			// System.out.println("Comparing " + w.getWord() + " with " + word);
			if (w.getWord().equals(word)) {
				// System.out.println("Found " + word);
				return words.indexOf(w);
			}
		}
		return -1;
	}

	public void addWord(String word) {
		Word newWord = new Word(word);
		int index = this.findIndexOfWord(word);
		// System.out.println("Index: " + index);
		if (index >= 0) {
			// System.out.println("Incrementing frequency of " + word);
			words.get(index).incrementFrequency();
		} else {
			words.add(newWord);
		}
	}

	public void filterStopWords(String[] stopWords) {
		for (String stopWord : stopWords) {
			int index = this.findIndexOfWord(stopWord);
			if (index >= 0) {
				words.remove(index);
			}
		}
	}

	public void sortWordsByFrequency() {
		words.sort();
	}

	public int getWordFrequency(String word) {
		int index = this.findIndexOfWord(word);
		if (index >= 0) {
			return words.get(index).getFrequency();
		} else {
			return 0;
		}
	}

	public ArrayList<Word> getTopNFrequentWords(int n) {
		ArrayList<Word> topWords = new ArrayList<>();
		for (int i = 0; i < n && i < words.size(); i++) {
			topWords.add(words.get(i));
		}
		return topWords;
	}

	public void displayTopNFrequentWords(int n) {
		ArrayList<Word> topWords = getTopNFrequentWords(n);
		for (Word word : topWords) {
			System.out.println(word.getWord() + " - " + word.getFrequency());
		}
	}

	public void exportWordFrequency(String fileName) {
		// Sort by frequency
		this.sortWordsByFrequency();

		try {
			// Check if file exists
			File f = new File (fileName);
			if (!f.exists()) {
				f.createNewFile();
			}

			FileWriter fw = new FileWriter(f.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			// Write to file
			for(Word w : words) {
				bw.write(w.toString() + System.getProperty("line.separator")); 
			}

			bw.close();
		} catch (IOException e) {
			System.out.println (e.toString());
		}
	}
}