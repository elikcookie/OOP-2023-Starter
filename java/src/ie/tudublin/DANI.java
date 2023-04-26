package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	
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
			return "Follow [count=" + count + ", word=" + word + "]";
		}
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

		@Override
		public String toString() {
			return "Word [follows=" + follows + ", word=" + word + "]";
		}
	
	}
	
	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

    public String[] writeSonnet()
    {
        return null;
    }

	public void setup() {
		colorMode(HSB);

       
	}

	public void keyPressed() {

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
