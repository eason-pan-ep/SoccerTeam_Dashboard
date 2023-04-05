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

  private void addMultiplePlayer(int amountOfPlayers){
    String firstNameDummy = "testerFistName";
    String[] lastNamePool = new String[amountOfPlayers];
    for(int i = 1; i < amountOfPlayers + 1; i++){
      lastNamePool[i-1] = String.format("LastNo%d", i);
    }
    for(int i = 0; i < amountOfPlayers; i++){
      this.testTeam.addPlayer(firstNameDummy, lastNamePool[i], 2018, 3, 12, Position.FORWARD, 9);
    }
  }

  /**
   * Test add 20 people.
   */
  @Test
  public void testAdd20Players(){
    this.addMultiplePlayer(20);
    assertEquals(20, this.testTeam.getSize());
  }

  /**
   * Test add player when the team is full.
   */
  @Test (expected = IllegalStateException.class)
  public void testAdd21Players(){
    this.addMultiplePlayer(20);
    this.testTeam.addPlayer("Tester", "No21", 2018, 6, 5, Position.GOALIE, 7);
  }

  /**
   * Test remove a player while the team is empty.
   */
  @Test (expected = IllegalStateException.class)
  public void testRemovePlayerFromEmptyTeam(){
    this.testTeam.removePlayer(2);
  }

  /**
   * Test create team when there is less than 10 players.
   */
  @Test(expected = IllegalStateException.class)
  public void testCreateTeamDoNotHaveEnoughPlayer(){
    this.addMultiplePlayer(9);
    this.testTeam.createTeam();
  }

  /**
   * Test remove a player from a formed team that has 10 players.
   */
  @Test(expected = IllegalStateException.class)
  public void testRemovePlayerFromFormed10PlayerTeam(){
    this.addMultiplePlayer(10);
    this.testTeam.createTeam();
    this.testTeam.removePlayer(2);
  }

  /**
   * Test remove number 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveOutOfBoundJerseyNumber1(){
    this.addMultiplePlayer(1);
    this.testTeam.removePlayer(0);
  }

  /**
   * Test remove number 21.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveOutOfBoundJerseyNumber2(){
    this.addMultiplePlayer(1);
    this.testTeam.removePlayer(21);
  }

  /**
   * Test successfully remove a player.
   */
  @Test
  public void testRemovePlayer(){
    this.addMultiplePlayer(20);
    this.testTeam.createTeam();
    assertEquals(20, this.testTeam.getSize());
    this.testTeam.removePlayer(5);
    assertEquals(19, this.testTeam.getSize());
  }

  /**
   * Test remove a player not in this team.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemovePlayerNotInTheTeam(){
    this.addMultiplePlayer(20);
    this.testTeam.createTeam();
    assertEquals(20, this.testTeam.getSize());
    this.testTeam.removePlayer(5);
    assertEquals(19, this.testTeam.getSize());
    this.testTeam.removePlayer(5);
  }

  /**
   * Test get an empty team.
   */
  @Test
  public void testGetEmptyTeam(){
    assertEquals("This is an empty team.", this.testTeam.getTeam());
  }




}