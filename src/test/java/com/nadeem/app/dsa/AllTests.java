package com.nadeem.app.dsa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.nadeem.app.dsa.adt.AllADTTests;
import com.nadeem.app.dsa.iterator.AllIteratorTests;

@RunWith(Suite.class)
@SuiteClasses({AllIteratorTests.class,
	AllADTTests.class})
public class AllTests {

}
