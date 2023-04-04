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

}