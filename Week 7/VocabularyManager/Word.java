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
	public String toString() {
		return this.word + " - " + this.frequency;
	}

	@Override
	public int compareTo(Word other) {
		// http://www.javapractices.com/topic/TopicAction.do?Id=10
		final int BEFORE = -1;
   		// final int EQUAL = 0;
    	final int AFTER = 1;

		// compare by frequency
		if (this.frequency > other.frequency) {
			return BEFORE;
		} else if (this.frequency < other.frequency) {
			return AFTER;
		} else {
			// compare strings alphabetically
			return this.word.compareTo(other.word);
		}
	}
}