/**
 * This class is a JUnit test to test the 10 methods in LoopFunTen
 * 
 * @author Rick Mercer and Your Name
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class LoopFunTenTest {

  // The one instance variable that is accessible to all assertion below.
  // All messages should be in the form of loopFun.methodName(argument(s))
  private LoopFunTen loopFun = new LoopFunTen();

  @Test
  public void testRangeInScanner() {
    assertEquals(2, loopFun.rangeInScanner(new Scanner("2 3 4")));
    // Add 4 or more assertions
  }

  @Test
  public void testhowMany() {
    assertEquals(2, loopFun.howMany(new Scanner("test the first test"), "test"));
    // Add 4 or more assertions
  }

  @Test
  public void testWordperfectPercentage() {
    assertEquals(0.333333, loopFun.perfectPercentage(new Scanner("1 2 100")), 0.00001);
    // Add 4 or more assertions
  }

  @Test
  public void testFibonacci() {
    assertEquals(8, loopFun.fibonacci(6));
    assertEquals(13, loopFun.fibonacci(7));
    // Add 4 or more assertions
  }

  @Test
  public void testIsPrime() {
    assertTrue(loopFun.isPrime(23));
    assertFalse(loopFun.isPrime(4));
    // Add 4 or more assertions
  }

  @Test
  public void testhowSwedish() {
    assertEquals(2, loopFun.howSwedish("abbabba"));
    // Add 4 or more assertions
  }

  @Test
  public void testDoubleUp() {
    assertEquals("aabbcc", loopFun.doubleUp("abc"));
    // Add 4 or more assertions
  }

  @Test
  public void testVowelCount() {
    assertEquals(10, loopFun.vowelCount("a e i o u A E I O U"));
    // Add 4 or more assertions
  }
  
  @Test
  public void testNumberOfPairs() {
    assertEquals(2, loopFun.numberOfPairs("abbba"));
    // Add 4 or more assertions
  }

  @Test
  public void testAllMsLeft() {
    // This line will be yellow and lose a point or 2 due to the || (or). However,
    // we are counting code coverage in LoopTenFun.java only, not this JUnit test.
    assertTrue("MBa".equals(loopFun.allMsLeft("BaM")) || "MaB".equals(loopFun.allMsLeft("BaM")));
    // Add 4 or more assertions
  }
}