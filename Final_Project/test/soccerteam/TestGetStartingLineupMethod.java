package soccerteam;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is a dedicated test Class for testing getStartingLineup method from U10TeamModelImpl.
 * Having this separate testing class is
 * due to random generated jersey number output can hardly be tested suing assertEquals.
 */
public class TestGetStartingLineupMethod {

  /**
   * The main test.
   * @param args args.
   */
  public static void main(String[] args) {
    U10TeamModel testTeam2 = new U10TeamModelImpl();
    testTeam2.addPlayer("Jack", "Asaka", 2020, 3, 2, Position.DEFENDER, 4);
    testTeam2.addPlayer("John", "Wick", 2018, 3, 4, Position.FORWARD, 8);
    testTeam2.addPlayer("Tom", "Riddle", 2014, 5, 6, Position.DEFENDER, 5);
    testTeam2.addPlayer("Harry", "Potter", 2015, 2, 3, Position.MIDFIELDER, 10);
    testTeam2.addPlayer("Ronald", "Weasley", 2015, 6, 8, Position.MIDFIELDER, 8);
    testTeam2.addPlayer("Neville", "Longbottom", 2014, 7, 9, Position.MIDFIELDER, 6);
    testTeam2.addPlayer("Iron", "Man", 2014, 7, 9, Position.MIDFIELDER, 10);
    testTeam2.addPlayer("Bat", "Man", 2016, 8, 9, Position.FORWARD, 10);
    testTeam2.addPlayer("Jony", "Ive", 2014, 9, 10, Position.FORWARD, 9);
    testTeam2.addPlayer("Bill", "Gates", 2017, 10, 3, Position.FORWARD, 5);
    testTeam2.createTeam();
    testTeam2.formStartingLineup();
    System.out.println(Arrays.deepToString(testTeam2.getStartingLineup()));


    testTeam2.addPlayer("UTF", "Names", 2014, 9, 11, Position.MIDFIELDER, 9);
    testTeam2.formStartingLineup();
    System.out.println("Add one more player and re-form.\n");
    System.out.println(Arrays.deepToString(testTeam2.getStartingLineup()));



  }

}
