package com.nadeem.app.dsa.algo;

import mockit.Deencapsulation;

import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

public class ScoreBoardTest {
	
	private ScoreBoard targetBeingTested;
	
	@Before
	public void doBeforeEachTestCase () {
		this.targetBeingTested = new ScoreBoard(5);
	}

	@Test
	public void shouldStoreFiveScores() {
		this.targetBeingTested.addScore("Hello", 0);
		Object[] scores =  Deencapsulation.getField(targetBeingTested, "scores");
		assertThat(scores.length).isEqualTo(5);
	}
	
	@Test
	public void thereShouldBeAnEntryAtIndexZero() {
		this.targetBeingTested.addScore("Hello", 0);
		Object[] scores =  Deencapsulation.getField(targetBeingTested, "scores");
		assertThat(scores[0]).isNotNull();
	}
	
	@Test
	public void numberOfEntriesShouldBeOne() {
		this.targetBeingTested.addScore("Hello", 0);
		int numberOfEntries =  Deencapsulation.getField(targetBeingTested, "numberOfEntries");
		assertThat(numberOfEntries).isEqualTo(1);
	}

}
