package soccerteam;

/**
 * This is the Interface of U10TeamModel.
 * U10TeamModel classes will represent a U10 soccer team.
 * Signatures for all public visibility method is here.
 */
public interface U10TeamModel {
  /**
   * Add a new Player to the team, assign an unused jersey number to this Player when successfully
   * added this Player.
   *
   * @param firstName         first name of the added player.
   * @param lastName          last name of the added player.
   * @param year              the year of birth of the added player.
   * @param month             the month of birth of the added player.
   * @param day               the day of birth of the added player.
   * @param preferredPosition the preferred position of the added player.
   * @param skillLevel        the skill level a coach provides for the added player.
   * @throws IllegalArgumentException when the year is more than 10 years before the current year or
   *                                  later than current year, when the month is less than 1 or
   *                                  greater than 12, when the day is less than 1 or greater than
   *                                  31, when skillLevel is less than 0 or greater than 10.
   * @throws IllegalStateException    when the adding player is order than 10 years old, when the
   *                                  team is at full capacity (20 Players).
   */
  void addPlayer(String firstName, String lastName, int year, int month, int day,
      Position preferredPosition, int skillLevel)
      throws IllegalArgumentException, IllegalStateException;

  /**
   * Remove a player from current team by their jersey number.
   *
   * @param jerseyNumber the jersey number of the player to be removed.
   * @throws IllegalArgumentException when the number less than 1 or greater than 20, when this
   *                                  jersey number hasn't been assigned.
   * @throws IllegalStateException    when removing players from an empty team. when the team is
   *                                  formed and removing one player will cause this team has less
   *                                  than 10 player.
   */
  void removePlayer(int jerseyNumber) throws IllegalArgumentException, IllegalStateException;

  /**
   * Create a team and now the coach can form a starting lineup.
   *
   * @throws IllegalStateException when there are less than 10 Players in the team.
   */
  void createTeam() throws IllegalStateException;

  /**
   * Get a list-like string with every Player in the team with the information of the Player's first
   * name, last name, jersey number. This List is sorted in alphabetical order (last name).
   *
   * @return a 2D String array in team[i], it looks like {Name, Number}.
   */
  String[][] getTeam();

  /**
   * Form a 7 people starting lineup, in the formation of 1-2-3-1. Users may form again when they
   * added new Players. The logic to pick starting lineup players: 1. consider their preferred
   * position, fill all team member meet their preferences, sort by skill level; 2. if there are
   * more than needed in a Position, remove extras from the tail; 3. if there are Positions don't
   * have enough players, add whoever is still available and with the highest skill level to fill,
   * filling order is: goalie, defender, midfielder, forward;
   */
  void formStartingLineup();

  /**
   * Get a list-like string with every Player in the starting lineup with the information of: first
   * name, last name, jersey number, and position. This list is sorted by Position(goalie, defender,
   * midfielder, forward).
   *
   * @return a list-like string contains the information described above.
   *     A sample output
   *                        Starting Lineup
   *     -----------------------------------------------------
   *             Position      Player Name    Jersey Number
   *     -----------------------------------------------------
   *               Goalie         Jony Ive          4
   *             Defender       Tom Riddle         15
   *             Defender       Jack Asaka          5
   *           Midfielder         Iron Man          7
   *           Midfielder     Harry Potter         20
   *           Midfielder   Ronald Weasley          1
   *              Forward          Bat Man          6
   */
  String getStartingLineup();

  /**
   * Get the current size of this team.
   *
   * @return the team size.
   */
  int getSize();

  /**
   * Get the jersey number of the last added player.
   * @return the jersey number of the last added player.
   */
  int getLastAddedPlayerNumber();

}
