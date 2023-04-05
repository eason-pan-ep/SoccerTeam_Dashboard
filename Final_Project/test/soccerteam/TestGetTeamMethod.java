package soccerteam;

/**
 * This is a test for the outputs, since all jersey numbers are randomly assigned, it's hard to do a
 * assertEquals unit test.
 */
public class TestGetTeamMethod {

  /**
   * The main test.
   * @param args args.
   */
  public static void main(String[] args) {
    U10TeamModel testTeam = new U10TeamModelImpl();
    testTeam.addPlayer("Jack", "Asaka", 2019, 4, 15, Position.GOALIE, 6);
    testTeam.addPlayer("Jack", "Zack", 2020, 5, 6, Position.GOALIE, 4);
    testTeam.addPlayer("Jack", "Cat", 2020, 4, 2, Position.FORWARD, 5);
    testTeam.addPlayer("Jack", "Black", 2018, 4, 19, Position.DEFENDER, 10);
    testTeam.addPlayer("Jack", "Harmon", 2016, 6, 7, Position.FORWARD, 9);
    testTeam.addPlayer("Jack", "Duke", 2020, 6, 4, Position.GOALIE, 3);
    testTeam.addPlayer("Jack", "Vyoge", 2016, 7, 8, Position.GOALIE, 8);

    System.out.println(testTeam.getTeam());
  }
}
