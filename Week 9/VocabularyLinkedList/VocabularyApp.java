public class VocabularyApp {
	public static void main(String[] args) {
		VocabularyManager vocabularyManager = new VocabularyManager();
		TextParser textParser = new TextParser(vocabularyManager);
		textParser.parseTextFile("test.txt");

		String[] stopWords = {"the", "is", "in", "and", "to", "of", "it"};
		vocabularyManager.filterStopWords(stopWords);

		vocabularyManager.sortWordsByFrequency();

		System.out.println("Frequency of 'ai': " + vocabularyManager.getWordFrequency("ai"));

		vocabularyManager.displayTopNFrequentWords(5);

		vocabularyManager.exportWordFrequency("output.txt");
	}
}