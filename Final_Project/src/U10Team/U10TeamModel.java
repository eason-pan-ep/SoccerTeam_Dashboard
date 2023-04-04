package U10Team;

public interface U10TeamModel {
  /**
   * Add a new Player to the team, assign an unused jersey number to this Player when successfully added this Player.
   * @param firstName first name of the added player.
   * @param lastName last name of the added player.
   * @param year the year of birth of the added player.
   * @param month the month of birth of the added player.
   * @param day the day of birth of the added player.
   * @param preferredPosition the preferred position of the added player.
   * @param skillLevel the skill level a coach provides for the added player.
   * @throws IllegalArgumentException when the year is more than 10 years before the current year or later than current year,
   *              when the month is less than 1 or greater than 12,
   *              when the day is less than 1 or greater than 31,
   *              when skillLevel is less than 0 or greater than 10.
   * @throws IllegalStateException when the adding player is order than 10 years old,
   *              when the team is at full capacity (20 Players).
   */
  void addPlayer(String firstName, String lastName, int year, int month, int day, Position preferredPosition, int skillLevel) throws IllegalArgumentException, IllegalStateException;

  /**
   * Create a team and auto generate the staring lineup.
   * @throws IllegalStateException when there are less than 10 Players in the team.
   */
  void createTeam()throws IllegalStateException;

  /**
   * Get a list-like string with every Player in the team with the information of the Player's first name, last name, jersey number.
   * This List is sorted in alphabetical order (last name).
   * @return a list-like string contains the information described above.
   */
  String getTeam();

  /**
   * Form a 7 people starting lineup,
   * in the formation of 1-2-3-1.
   * Users may form again when they added new Players.
   */
  void formStartingLineup();

  /**
   * Get a list-like string with every Player in the starting lineup with the information of: first name, last name, jersey number, and position.
   * This list is sorted by Position(goalie, defender, midfielder, forward).
   * @return a list-like string contains the information described above.
   */
  String getStartingLineup();

  /**
   * Get the current size of this team.
   * @return the team size.
   */
  int getSize();
}
