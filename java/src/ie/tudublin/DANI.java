package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	private ArrayList<Word> wordsList;

	public DANI() {
		wordsList = new ArrayList<>();
	}

	class Word {
		private String word;
		private ArrayList<Follow> follows;

		public Word(String word) {
			this.word = word;
			this.follows = new ArrayList<>();
		}

		public String getWord() {
			return word;
		}

		public ArrayList<Follow> getFollows() {
			return follows;
		}

		Follow findFollow(String str) {
			for (Follow f : getFollows()) {
				if (f.getWord().equals(str)) {
					return f;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(word).append(": ");
			for (Follow f : follows) {
				sb.append(f.toString()).append(" ");
			}
			return sb.toString();
		}

	}

	class Follow {
		private String word;
		private int count;

		public Follow(String word, int count) {
			this.word = word;
			this.count = count;
		}

		public String getWord() {
			return word;
		}

		public int getCount() {
			return count;
		}

		@Override
		public String toString() {
			return word + "(" + count + ")";
		}
	}

	void loadFile() {
		String[] lines = loadStrings("small.txt");

		for (String line : lines) {
			String[] words = split(line, ' ');

			for (int i = 0; i < words.length - 1; i++) {
				String word = words[i].replaceAll("[^\\w\\s]", "").toLowerCase();
				String next = words[i + 1].replaceAll("[^\\w\\s]", "").toLowerCase();

				Word wd = findWord(word);

				if (wd == null) {
					wd = new Word(word);
					wordsList.add(wd);
				}

				Follow f = wd.findFollow(next);

				if (f == null) {
					f = new Follow(next, 1);
					wd.getFollows().add(f);
				} else {
					f.count += 1;
				}
			}
		}
	}

	// finds a word in the model so you can check if it already exists, returns null
	// if no match
	Word findWord(String str) {
		for (Word wd : wordsList) {
			if (wd.getWord().equals(str)) {
				return wd;
			}
		}
		return null;
	}

	void printModel() {
		for (Word wd : wordsList) {
			System.out.println(wd.toString());
		}
	}

	public void settings() {
		size(1000, 1000);
		// fullScreen(SPAN);
	}

	String[] sonnet;

	public String[] writeSonnet() {
		// pick random word

		// if it has no follow word use it
		// otherwise pick a follow word at random and use it
		// repeat 8 times
		// Print the Sonnet to the console
		// Print the Sonnet to the screen.
		// Add code to generate a new sonnet on keyPress
		return null;
	}

	public void setup() {
		colorMode(HSB);
		loadFile();
		// writeSonnet();

	}

	public void keyPressed() {
		if (keyCode == ' ') {
			// writeSonnet();
		}
	}

	float off = 0;

	public void draw() {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
		textAlign(CENTER, CENTER);

	}

}
