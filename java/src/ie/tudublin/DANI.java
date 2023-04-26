//C21320836 26/04/2023
package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import java.util.Random;


public class DANI extends PApplet {

	private ArrayList<Word> wordsList;
	private Random random;

    public DANI() {
        wordsList = new ArrayList<>();
        random = new Random();
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
		String[] lines = loadStrings("shakespere.txt");
	
		for (String line : lines) {
			String[] words = split(line, ' ');
	
			for (int i = 0; i < words.length; i++) {
				String word = words[i].replaceAll("[^\\w\\s]", "").toLowerCase();
	
				if (i < words.length - 1) {
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
				} else {
					// If it is the last word in the line, check if it exists in wordsList
					// If not, add it with an empty follows list
					Word wd = findWord(word);
					if (wd == null) {
						wd = new Word(word);
						wordsList.add(wd);
					}
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

    public void writeSonnet() {
        sonnet = new String[14];

        for (int i = 0; i < 14; i++) {
            StringBuilder line = new StringBuilder();

            Word currentWord = wordsList.get(random.nextInt(wordsList.size()));
            for (int j = 0; j < 8; j++) {
                line.append(currentWord.getWord()).append(" ");

                ArrayList<Follow> follows = currentWord.getFollows();
                if (follows.isEmpty()) {
                    break;
                }

                Follow follow = follows.get(random.nextInt(follows.size()));
                currentWord = findWord(follow.getWord());
            }

            sonnet[i] = line.toString();
            System.out.println(sonnet[i]);
        }
    }

	public void setup() {
		colorMode(HSB);
		loadFile();
		writeSonnet();

	}

	public void keyPressed() {
		if (keyCode == ' ') {
			writeSonnet();
			redraw();
		}
	}

	float off = 0;

	public void draw() {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
		textAlign(CENTER, CENTER);

		if (sonnet != null) {
            for (int i = 0; i < sonnet.length; i++) {
                text(sonnet[i], width / 2, (i + 1) * 40);
            }
        }

	}

}
