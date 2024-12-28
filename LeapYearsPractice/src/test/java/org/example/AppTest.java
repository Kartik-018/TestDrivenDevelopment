package org.example;

import junit.framework.Test;//An interface that represents a test in JUnit framework
import junit.framework.TestCase;//A base class for creating test cases
import junit.framework.TestSuite;

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
    }
    public void testApp()
    {
        assertTrue( true );
    }
}
