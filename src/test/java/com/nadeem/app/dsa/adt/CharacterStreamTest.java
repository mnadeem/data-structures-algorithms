package com.nadeem.app.dsa.adt;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.nadeem.app.dsa.adt.impl.CharacterStream;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class CharacterStreamTest {

	@Test
	public void firstNonRepeatingCharInAStreamTest() {

		Observable<Character> observable = Observable.create(new OnSubscribe<Character>() {

			@Override
			public void call(Subscriber<? super Character> subscriber) {
				subscriber.onNext('N');
				subscriber.onNext('Z');
				subscriber.onNext('B');
				subscriber.onNext('C');
				subscriber.onNext('D');
				subscriber.onNext('A');
				subscriber.onNext('C');
				subscriber.onNext('B');
				subscriber.onNext('A');
				subscriber.onNext('N');	
				//subscriber.onNext('Z');	
			}			
		});
		
		CharacterStream charStream = new CharacterStream(observable);
		assertThat(charStream.firstNonRepeating(), equalTo('Z'));
	}
}
