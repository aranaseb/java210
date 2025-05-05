// Sebastian Arana

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ProbableText {

	public static void main(String[] args) {
		ProbableText rw = new ProbableText("Alice", 6); // 6 is ngram length
		System.out.println();
		rw.printRandom(33); // #characters to print
	}

	HashMap<String, ArrayList<Character>> allNgrams;
	private String currentFileName;
	private Scanner inFile = null;
	private StringBuilder fileText;
	private String startingGram;

	public ProbableText(String fileName, int ngramLength) {
		currentFileName = fileName;
		try {
			inFile = new Scanner(new File(currentFileName));
		} catch (FileNotFoundException e) {
		}
		readFile();
		allNgrams = new HashMap<String, ArrayList<Character>>();
		generateNgrams(ngramLength);
		Object[] allKeys = allNgrams.keySet().toArray();
		startingGram = (String) allKeys[ThreadLocalRandom.current().nextInt(allKeys.length)];
	}

	private void readFile() {
		fileText = new StringBuilder();
		while (inFile.hasNext()) {
			fileText.append(inFile.next() + " ");
		}
		inFile.close();
	}

	private void generateNgrams(int gramLength) {
		for (int i = 0; i < fileText.length() - 1 - gramLength; i++) {
			String ngram = fileText.substring(i, i + gramLength);
			if (!allNgrams.containsKey(ngram)) {
				allNgrams.put(ngram, new ArrayList<Character>());
			}
			allNgrams.get(ngram).add(fileText.charAt(i + gramLength));
		}
	}

	private char generateChar(String ngram) {
		ArrayList<Character> charList = allNgrams.get(ngram);
		return charList.get(ThreadLocalRandom.current().nextInt(charList.size()));
	}

	private void printLinesOfSixty(StringBuilder data) {
		if (data.length() < 60) {
			System.out.println(data);
		} else {
			StringBuilder line = new StringBuilder(data.substring(0, 60));
			int i = 60;
			while (!(line.charAt(line.length() - 1) == ' ')) {
				line.append(data.charAt(i));
				i++;
			}
			System.out.println(line + " ");
			printLinesOfSixty(new StringBuilder(data.substring(i)));
		}

	}

	private void printRandom(int i) {
		StringBuilder result = new StringBuilder();
		String currentGram = startingGram;
		result.append(startingGram);
		for (int j = startingGram.length(); j < i; j++) {
			char newChar = generateChar(currentGram);
			currentGram = currentGram.substring(1) + newChar;
			result.append(newChar);
		}
		printLinesOfSixty(result);
	}
}
