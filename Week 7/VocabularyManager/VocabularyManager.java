import java.util.ArrayList;

public class VocabularyManager {
	private ArrayList<Word> words = new ArrayList<>();

	public int findIndexOfWord(String word) {
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

	public Word getWord(String word) {
		int index = this.findIndexOfWord(word);
		if (index >= 0) {
			return words.get(index);
		} else {
			return null;
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
		words.sort((word1, word2) -> word2.getFrequency() - word1.getFrequency());
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
}