public class Word implements Comparable<Word> {
	private String word;
	private int frequency;

	public Word(String word) {
		this.word = word;
		this.frequency = 1;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getFrequency() {
		return this.frequency;
	}

	public void incrementFrequency() {
		this.frequency += 1;
	}

	@Override
	public int compareTo(Word other) {
		return this.word.compareTo(other.getWord());
	}
}