package pkgCore;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Dictionary {

	private ArrayList<Word> words = new ArrayList<Word>();

	public Dictionary() {
		LoadDictionary();
	}

	public ArrayList<Word> getWords() {
		return words;
	}

	private void LoadDictionary() {
		InputStream is = getClass().getClassLoader().getResourceAsStream("util/words.txt");
		try (BufferedReader reader = new BufferedReader (new InputStreamReader(is))){
			while (reader.ready()) {
				String line = reader.readLine();
				words.add(new Word(line.trim()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File wordsFile = new File("src/main/resources/util/words.txt");
		Scanner words = new Scanner(wordsFile);
	}

	public Word findWord(String strWord) {
		strWord = strWord.toUpperCase();
		for (Word w:this.words) {
			if (w.getWord().equals(strWord)) {
				return w;
			}
		}
		return null;
	}

}
