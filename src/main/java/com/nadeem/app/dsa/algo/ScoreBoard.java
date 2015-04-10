package com.nadeem.app.dsa.algo;

public class ScoreBoard {

	private Score[] scores;
	private int numberOfEntries = 0;

	public ScoreBoard(int capacity) {
		this.scores = new Score[capacity];
	}

	public int addScore(String name, int value) {
		Score score =  new Score(name, value);
		if (numberOfEntries < scores.length) {
			numberOfEntries ++;
		}
		int index = numberOfEntries - 1;
		while (index > 0 && scores[index - 1].getValue() < value) {
			scores[index] = scores[index - 1];
			index--;			
		}
		this.scores[index] = score;

		return index;
	}

	public static class Score {

		private String name;
		private int value;

		Score(String name, int value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "Score [name=" + name + ", value=" + value + "]";
		}
	}
}
