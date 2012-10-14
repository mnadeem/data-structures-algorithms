package com.nadeem.app.dsa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.nadeem.app.dsa.adt.AllADTTests;
import com.nadeem.app.dsa.iterator.AllIteratorTests;
import com.nadeem.app.dsa.support.AllSupportTests;

@RunWith(Suite.class)
@SuiteClasses({AllIteratorTests.class,
	AllADTTests.class,
	AllSupportTests.class})
public class AllTests {

}
