package soccerteam;

/**
 * This is the Interface for U10 Soccer Team Controller.
 * It is designed for using JFrame library.
 */
public interface U10TeamFeatures {
  /**
   * Initialize the program by calling the view.addFeature(controller) to get action listener.
   */
  void initializeProgram();

  /**
   * Add a player.
   *
   * @param firstname         player's first name.
   * @param lastName          player's last name.
   * @param year              player's year of birth.
   * @param month             player's month of birth.
   * @param day               player's day of birth.
   * @param preferredPosition player's preferred position.
   * @param skillLevel        player's skill level rate.
   */
  void addPlayer(String firstname, String lastName, int year, int month, int day,
                 Position preferredPosition, int skillLevel);

  /**
   * update the team creation status in the dashboard.
   *
   * @param creationStatus true for created.
   */
  void updateTeamStatus(boolean creationStatus);

  /**
   * update the starting lineup status.
   *
   * @param staringLineupStatus true for there is a staring lineup formed.
   */
  void updateStartingLineupStatus(boolean staringLineupStatus);

  /**
   * remove a player from the team.
   *
   * @param removeJerseyNumber the removing player's jersey number.
   */
  void removePlayer(int removeJerseyNumber);

  /**
   * create a U10 team.
   */
  void createTeam();

  /**
   * form a starting lineup.
   */
  void formStartingLineup();

  /**
   * update the team member list on the dashboard.
   */
  void updateTeamList();

  /**
   * update the team size on the dashboard,
   * in the format of xx/20.
   */
  void updateTeamSize();

  /**
   * update the warning information in the New Player Panel.
   *
   * @param addPlayerWarning the warning information.
   */
  void updateAddPlayerWarnings(String addPlayerWarning);

  /**
   * update the warning information in the Team Management Panel.
   *
   * @param teamManagementWarning the warning information.
   */
  void updateTeamManagementWarnings(String teamManagementWarning);

  /**
   * Exit the app.
   */
  void exitApp();
}
