package soccerteam;

import java.awt.*;

public interface U10TeamView {
  int TEXT_INPUT_WIDTH = 21;
  String[] TEAM_LIST_HEADER = {"Player Name", "Jersey Number"};
  String[] STARTING_LINEUP_HEADER = {"Position", "Player Name", "Jersey Number"};
  Font PANEL_TITLE_FONT = new Font("Arial", Font.BOLD, 20);
  Font CONTENT_TITLE_FONT = new Font("Arial", Font.BOLD, 14);

  void addFeatures(U10TeamFeatures features);

  void displayTeamSize(int teamSize);

  void displayTeamStatus(String creationStatus);

  void displayStartingLineupStatus(String startingLineupStatus);

  void clearNewPlayerInput();

  void displayStartingLineupList(String[][] startingLineupList);

  void displayTeamList(String[][] teamList);

  void displayAddPlayerWarnings(String addPlayerWarning);
  void displayAddedNotice();
  void displayTeamManagementWarnings(String teamManagementWarning);
  void displayTeamManagementNotice(String notice);

}
