package soccerteam;

public interface U10TeamView {
  int TEXT_INPUT_WIDTH = 21;
  String[] TEAM_LIST_HEADING = {"Player Name", "Jersey Number"};
  String[] STARTING_LINEUP_HEADING = {"Position", "Player Name", "Jersey Number"};

  void addFeatures(U10TeamFeatures features);

  void displayTeamSize(int teamSize);

  void displayTeamStatus(String creationStatus);

  void displayStartingLineupStatus(String startingLineupStatus);

  void clearNewPlayerInput();

  void clearRemovePlayerInput();

  void displayStartingLineupList(String[][] startingLineupList);

  void displayTeamList(String[][] teamList);

  void displayAddPlayerWarnings(String addPlayerWarning);
  public void displayAddedNotice();
}
