package soccerteam;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

/**
 * The U10 Team View Interface.
 * Designed to use JFrame library.
 */
public interface U10TeamView {

  /**
   * Text input field width, 21 columns.
   */
  int TEXT_INPUT_WIDTH = 21;

  /**
   * The Header of Team Member Table.
   */
  String[] TEAM_LIST_HEADER = {"Player Name", "Jersey Number"};

  /**
   * The Header of Starting Lineup Table.
   */
  String[] STARTING_LINEUP_HEADER = {"Position", "Player Name", "Jersey Number"};

  /**
   * Panel title font.
   */
  Font PANEL_TITLE_FONT = new Font("Arial", Font.BOLD, 20);

  /**
   * Content heading font.
   */
  Font CONTENT_TITLE_FONT = new Font("Arial", Font.BOLD, 14);

  /**
   * Section Panel Border.
   */
  LineBorder SECTION_BORDER = new LineBorder(Color.LIGHT_GRAY, 1, true);

  /**
   * Add action listeners to connect UIs and controller.
   * @param features a controller implementation.
   */
  void addFeatures(U10TeamFeatures features);

  /**
   * Shows the team size,
   * in the format of xx/20.
   * @param teamSize team size data from the model passed by the controller.
   */
  void displayTeamSize(int teamSize);

  /**
   * Show team creation status.
   * @param creationStatus the description of team status.
   */
  void displayTeamStatus(String creationStatus);

  /**
   * Show the staring lineup creation status.
   * @param startingLineupStatus the description of status.
   */
  void displayStartingLineupStatus(String startingLineupStatus);

  /**
   * Clear all the selections and inputs in the new player adding panel.
   */
  void clearNewPlayerInput();

  /**
   * Show the staring lineup table.
   * @param startingLineupList starting lineup data.
   */
  void displayStartingLineupList(String[][] startingLineupList);

  /**
   * Show team member table.
   * @param teamList team member data.
   */
  void displayTeamList(String[][] teamList);

  /**
   * Show warnings in the add player section.
   * @param addPlayerWarning warning info.
   */
  void displayAddPlayerWarnings(String addPlayerWarning);

  /**
   * Show action success info in the add player section.
   */
  void displayAddedNotice();

  /**
   * Show warnings in the team management section.
   * @param teamManagementWarning warning info.
   */
  void displayTeamManagementWarnings(String teamManagementWarning);

  /**
   * Show action success info in the team management section.
   * @param notice action success info.
   */
  void displayTeamManagementNotice(String notice);

}
