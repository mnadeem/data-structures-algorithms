package com.nadeem.app.dsa.algo;

public class ScoreBoard {

	private Score[] scores;
	private int numberOfEntries = 0;

	public ScoreBoard(int capacity) {
		this.scores = new Score[capacity];
	}

	public void addScore(String name, int value) {
		Score score =  new Score(name, value);
		this.scores[0] = score;
		numberOfEntries++;
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
