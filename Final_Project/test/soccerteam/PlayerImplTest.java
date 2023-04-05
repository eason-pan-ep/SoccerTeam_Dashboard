package soccerteam;

import static org.junit.Assert.assertEquals;

import java.time.Year;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the unit test suit for PlayerImpl.
 */
public class PlayerImplTest {

  private Player tester;
  private Player tester2;

  /**
   * Setting up 2 PlayerImpl instances for testing.
   */
  @Before public void setUp() {
    this.tester = new PlayerImpl("John", "Wick", 2015, 9, 11, Position.DEFENDER, 7);

    this.tester2 = new PlayerImpl("Apple", "Rotate", 2020, 3, 2, Position.FORWARD, 2);

  }

  /**
   * The next 8 tests are testing constructing a PlayerImpl object with illegal arguments. Checking
   * whether the constructor throws exceptions as designed. Test year before 1900.
   */
  @Test
      (expected = IllegalArgumentException.class) public void testIllegalArgsConstructor1() {
    PlayerImpl test1 = new PlayerImpl("Tom", "L.", 1899, 12, 21, Position.GOALIE, 6);
  }

  /**
   * Test year after current year.
   */
  @Test
      (expected = IllegalArgumentException.class) public void testIllegalArgsConstructor2() {
    int yearTest = Year.now().getValue() + 1;
    PlayerImpl test2 = new PlayerImpl("Tom", "L.", yearTest, 12, 21, Position.GOALIE, 6);
  }

  /**
   * Test month less than 1.
   */
  @Test
      (expected = IllegalArgumentException.class) public void testIllegalArgsConstructor3() {
    PlayerImpl test3 = new PlayerImpl("Tom", "L.", 2020, 0, 21, Position.GOALIE, 6);
  }

  /**
   * Test month greater than 12.
   */
  @Test
      (expected = IllegalArgumentException.class) public void testIllegalArgsConstructor4() {
    PlayerImpl test4 = new PlayerImpl("Tom", "L.", 2020, 13, 21, Position.GOALIE, 6);
  }

  /**
   * Test day less than 1.
   */
  @Test
      (expected = IllegalArgumentException.class) public void testIllegalArgsConstructor5() {
    PlayerImpl test5 = new PlayerImpl("Tom", "L.", 2020, 12, 0, Position.GOALIE, 6);
  }

  /**
   * Test day greater than 31.
   */
  @Test
      (expected = IllegalArgumentException.class) public void testIllegalArgsConstructor6() {
    PlayerImpl test6 = new PlayerImpl("Tom", "L.", 2020, 12, 32, Position.GOALIE, 6);
  }

  /**
   * Test skill level less than 0.
   */
  @Test
      (expected = IllegalArgumentException.class) public void testIllegalArgsConstructor7() {
    PlayerImpl test7 = new PlayerImpl("Tom", "L.", 2020, 12, 21, Position.GOALIE, -1);
  }

  /**
   * Test skill level greater than 10.
   */
  @Test
      (expected = IllegalArgumentException.class) public void testIllegalArgsConstructor8() {
    PlayerImpl test8 = new PlayerImpl("Tom", "L.", 2020, 12, 21, Position.GOALIE, 11);
  }

  /**
   * Test the getName method can get the full name of this Player.
   */
  @Test public void testGetFullName() {
    assertEquals("John Wick", this.tester.getName());
    assertEquals("Apple Rotate", this.tester2.getName());
  }

  /**
   * Test get correct age of this Player.
   */
  @Test public void testGetAge() {
    assertEquals(7, this.tester.getPlayerAge());
    assertEquals(3, this.tester2.getPlayerAge());
  }

  /**
   * Test whether we can get the correct skill level of this player.
   */
  @Test public void testGetSkillLevel() {
    assertEquals(7, this.tester.getPlayerSkillLevel());
    assertEquals(2, this.tester2.getPlayerSkillLevel());
  }

  /**
   * Test whether we can get the correct preferred position level of this player.
   */
  @Test public void testGetPreferredPosition() {
    assertEquals(Position.DEFENDER, this.tester.getPreferredPosition());
    assertEquals(Position.FORWARD, this.tester2.getPreferredPosition());
  }

}