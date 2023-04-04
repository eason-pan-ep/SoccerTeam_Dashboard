package U10Team;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
public class U10TeamModelImplTest {
  private U10TeamModel testTeam;
  private int thisYear;
  private int thisMonth;
  private int today;

  @Before public void setUp() {
    this.thisYear = LocalDate.now().getYear();
    this.thisMonth = LocalDate.now().getMonthValue();
    this.today = LocalDate.now().getDayOfMonth();

    this.testTeam = new U10TeamModelImpl();
  }

  /**
   * Add a Player just 1 day before 10-years-old.
   */
  @Test
  public void testAddPlayerNotOver10(){
    this.testTeam.addPlayer("John", "Wick", this.thisYear - 10, this.thisMonth, this.today+1, Position.DEFENDER, 8);
    assertEquals(1, this.testTeam.getSize());
  }

  /**
   * Add a player just 1 day older than 10-years-old.
   */
  @Test (expected = IllegalStateException.class)
  public void testAddPlayerOver10(){
    this.testTeam.addPlayer("John", "Wick", this.thisYear - 10, this.thisMonth, this.today-1, Position.DEFENDER, 7);
  }

}