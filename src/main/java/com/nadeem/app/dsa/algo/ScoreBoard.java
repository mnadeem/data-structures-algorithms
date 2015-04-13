package com.nadeem.app.dsa.algo;

public class ScoreBoard {

	private Score[] scores;
	private int numberOfEntries = 0;

	public ScoreBoard(int capacity) {
		this.scores = new Score[capacity];
	}

	public int addScore(String name, int value) {

		if (isBoardFull() && shouldThisScoreBeIgnored(value)) {
			return -1;
		}

		Score score =  new Score(name, value);
		if (thereIsSpaceForNewScore()) {
			numberOfEntries ++;
		}
		int index = numberOfEntries - 1;
		while (shouldSwap(value, index)) {
			scores[index] = scores[index - 1];
			index--;			
		}
		this.scores[index] = score;

		return index;
	}

	private boolean shouldSwap(int value, int index) {
		return index > 0 && scores[index - 1].getValue() < value;
	}

	private boolean thereIsSpaceForNewScore() {
		return numberOfEntries < scores.length;
	}

	private boolean shouldThisScoreBeIgnored(int value) {
		return value < this.scores[numberOfEntries - 1].getValue();
	}

	private boolean isBoardFull() {
		return numberOfEntries - 1  == this.scores.length;
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
