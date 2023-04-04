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

  private void add20Player(){
    String firstNameDummy = "testerFistName";
    String[] lastNamePool = new String[20];
    for(int i = 1; i < 21; i++){
      lastNamePool[i-1] = String.format("LastNo%d", i);
    }
    for(int i = 0; i < 20; i++){
      this.testTeam.addPlayer(firstNameDummy, lastNamePool[i], 2018, 3, 12, Position.FORWARD, 9);
    }
  }

  /**
   * Test add 20 people.
   */
  @Test
  public void testAdd20Players(){
    this.add20Player();
    assertEquals(20, this.testTeam.getSize());
  }

  /**
   * Test add player when the team is full.
   */
  @Test (expected = IllegalStateException.class)
  public void testAdd21Players(){
    this.add20Player();
    this.testTeam.addPlayer("Tester", "No21", 2018, 6, 5, Position.GOALIE, 7);
  }

}