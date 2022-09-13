package pkgCore;

import java.util.UUID;

public class Word implements Comparable<Word> {

	private UUID WordID;
	private String Word;

	public Word (String word)
	{
		this.WordID = UUID.randomUUID();
		this.Word = word;
	}
	@Override
	public boolean equals(Object obj) {
		Word w = (Word)obj;
		return (w.getWord().equals(this.getWord()));
	}

	@Override
	public int compareTo(Word o) {
		return (this.getWord().compareTo(o.getWord()));
	}

	public String getWord() {
		return Word;
	}
	public UUID getWordID() {
		return WordID;
	}

}
