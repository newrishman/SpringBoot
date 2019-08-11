package com.newrishman;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MainTest.class, BookControllerStartTest.class, BookServiceImplTest.class, BookRepositoryTest.class})

public class SuiteTestClass {
}