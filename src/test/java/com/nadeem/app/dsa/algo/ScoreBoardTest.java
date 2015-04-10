package com.nadeem.app.dsa.algo;

import static org.assertj.core.api.Assertions.assertThat;
import mockit.Deencapsulation;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.dsa.algo.ScoreBoard.Score;

public class ScoreBoardTest {

	private ScoreBoard targetBeingTested;

	@Before
	public void doBeforeEachTestCase () {
		this.targetBeingTested = new ScoreBoard(5);
	}

	@Test
	public void shouldStoreFiveScores() {
		this.targetBeingTested.addScore("XYZ", 0);
		Object[] scores =  Deencapsulation.getField(targetBeingTested, "scores");
		assertThat(scores.length).isEqualTo(5);
	}

	@Test
	public void thereShouldBeAnEntryAtIndexZero() {
		this.targetBeingTested.addScore("XYZ", 0);
		Object[] scores =  Deencapsulation.getField(targetBeingTested, "scores");
		assertThat(scores[0]).isNotNull();
	}

	@Test
	public void numberOfEntriesShouldBeOne() {
		this.targetBeingTested.addScore("XYZ", 0);
		int numberOfEntries =  Deencapsulation.getField(targetBeingTested, "numberOfEntries");
		assertThat(numberOfEntries).isEqualTo(1);
	}

	@Test
	public void scoreHolderShouldBeXYZAtIndexZero() {
		this.targetBeingTested.addScore("XYZ", 0);
		Object[] scores =  Deencapsulation.getField(targetBeingTested, "scores");
		Score score = (Score) scores[0];
		assertThat(score.getName()).isEqualTo("XYZ");
	}

	@Test
	public void scoreAtIndexZeroShouldBeOne() {
		this.targetBeingTested.addScore("XYZ", 1);
		Object[] scores =  Deencapsulation.getField(targetBeingTested, "scores");
		Score score = (Score) scores[0];
		assertThat(score.getValue()).isEqualTo(1);
	}

	@Test
	public void shouldAddEntryAtIndexZero() {
		this.targetBeingTested.addScore("XYZ", 4);
		int index = this.targetBeingTested.addScore("XYZ", 5);
		assertThat(index).isEqualTo(0);
	}

	@Test
	public void shouldAddEntryAtIndexOne() {
		this.targetBeingTested.addScore("XYZ", 5);
		int index = this.targetBeingTested.addScore("XYZ", 4);
		assertThat(index).isEqualTo(1);
	}
	
	@Test
	public void shouldAddEntryAtIndexTwo() {
		this.targetBeingTested.addScore("XYZ", 5);
		this.targetBeingTested.addScore("XYZ", 4);
		this.targetBeingTested.addScore("XYZ", 2);
		this.targetBeingTested.addScore("XYZ", 1);
		int index = this.targetBeingTested.addScore("XYZ", 3);
		assertThat(index).isEqualTo(2);
	}

	@Test
	public void shouldAddEntryAtIndex2() {
		this.targetBeingTested.addScore("XYZ", 1);
		this.targetBeingTested.addScore("XYZ", 2);
		this.targetBeingTested.addScore("XYZ", 4);
		this.targetBeingTested.addScore("XYZ", 5);
		int index = this.targetBeingTested.addScore("XYZ", 3);
		assertThat(index).isEqualTo(2);
	}
}
