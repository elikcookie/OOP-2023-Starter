package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {


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

		@Override
		public String toString() {
			for(Follow f:follows){
				System.out.println(f.getWord() + ": " + f + "(" + f.getCount()+ ")");
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
	

	void loadFile(){
		String[] lines = loadStrings("small.txt");
		for(String line:lines){
			String[] words = split(line, ' ');
			Word[] Words = new Word[words.length];

			for(int i = 0 ; i < words.length - 1 ; i ++)
			{
				String word = words[i];
				String next = words[i + 1];
				//System.out.println(word + " -> " + next);
				Word wd = findWord(word);
				if(wd == null)
				{
					wd = new Word(word);
					Words[i] = wd;
					
				}
				Follow f = wd.findFollow(next);
				if(f == null)
				{
					f = new Follow(next, 1);
					wd.getFollows().add(f);
				}
				else
				{
					int f_count = f.getCount(); 
					f.count = f_count + 1;
				}
			}
		}


	}
	
	//finds a word in the model so you can check if it already exists, returns null if no match
	Word findWord(str){


		return null;

	}

	Follow findFollow(str){


		return null;

	}

	void printModel(){

	}

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

    public String[] writeSonnet()
    {	
		//pick random word

		//if it has no follow word use it
		// otherwise pick a follow word at random and use it
		// repeat 8 times
		//Print the Sonnet to the console
		// Print the Sonnet to the screen.
		// Add code to generate a new sonnet on keyPress
        return null;
    }

	public void setup() {
		colorMode(HSB);
		loadFile();
		//writeSonnet();


       
	}

	public void keyPressed() {
		if (keyCode == ' ')
		{
			//writeSonnet();
		}
	}

	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);
        
	}
}
