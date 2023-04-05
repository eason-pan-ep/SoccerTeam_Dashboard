package U10Team;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

/**
 * This is a unit test suit for testing Position Enum.
 */
public class PositionTest {
  /**
   * Test if the compare function is correct in Position.
   */
  @Test
  public void testPositionSortingOrder(){
    Position[] sortTest = {Position.DEFENDER, Position.GOALIE, Position.FORWARD, Position.MIDFIELDER};
    Arrays.sort(sortTest);
    StringBuilder output = new StringBuilder() ;
    for(Position i : sortTest){
      output.append(String.format("%s, ", i.toString()));
    }
    assertEquals("Goalie, Defender, Midfielder, Forward, ", output.toString());
  }

  /**
   * Test Position Order value is correct.
   */
  @Test
  public void testPositionGetOrder(){
    Position[] orderTest = {Position.GOALIE, Position.DEFENDER, Position.MIDFIELDER, Position.FORWARD};
    String testOutput = "";
    for(Position i : orderTest){
      testOutput += String.format("%d, ", i.getOrder());
    }
    assertEquals("1, 2, 3, 4, ", testOutput);
  }

  /**
   * Test the correctness of compare() Override.
   */
  @Test
  public void testPositionCompareCorrectness(){
    Position test1 = Position.GOALIE;
    Position test2 = Position.FORWARD;
    Position test3 = Position.GOALIE;

    assertEquals(0, test1.compare(test1, test3));
    assertEquals(-1, test1.compare(test1, test2));
  }

}