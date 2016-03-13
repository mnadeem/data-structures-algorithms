package com.nadeem.app.dsa.algo;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.nadeem.app.dsa.algo.ExpressionConverter;
import com.nadeem.app.dsa.algo.PostfixToInfixConverter;

public class PostfixToInfixConverterTest {
	
	@Test
	public void test() {
		ExpressionConverter converter = new PostfixToInfixConverter();
		assertThat(converter.convert("1 2 * 3 4 * + 5 *"), equalTo("5*(4*3+2*1)"));
		assertThat(converter.convert("a b + c + 2 *"), equalTo("2*(c+b+a)"));
	}
}
