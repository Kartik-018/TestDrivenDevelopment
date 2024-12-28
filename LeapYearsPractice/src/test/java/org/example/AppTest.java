package org.example;

import junit.framework.Test;//An interface that represents a test in JUnit framework
import junit.framework.TestCase;//A base class for creating test cases
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }


    public  void leapYearDivisibleBy400(){
        assertTrue(LeapYear.isLeapYear(4000));
        assertTrue(LeapYear.isLeapYear(2000));
    }
    public void leapYearDivisibleBy4ButNotBy100(){
        assertTrue(LeapYear.isLeapYear(2024));
        assertTrue(LeapYear.isLeapYear(2016));
        assertTrue(LeapYear.isLeapYear(1996));
        assertTrue(LeapYear.isLeapYear(2104));
        assertTrue(LeapYear.isLeapYear(4*PrimeGenerator.getPrime()));
    }
    public void yearWhichIsNotLeap(){
        assertFalse(LeapYear.isLeapYear(2100));
        assertFalse(LeapYear.isLeapYear(1900));
        assertFalse(LeapYear.isLeapYear(1800));
        assertFalse(LeapYear.isLeapYear(RandNum.getRandNum()));
    }

    public void testApp()
    {
        leapYearDivisibleBy400();
        leapYearDivisibleBy4ButNotBy100();
        yearWhichIsNotLeap();
    }
}
