package soccerteam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Implementation of U10Team View.
 * Using Java Swing JFrame library.
 */
public class U10TeamFrameView extends JFrame implements U10TeamView {

  // Components for Overview Section
  JPanel overviewPanel;
  JLabel teamSizeLabel;
  JLabel displayTeamSize;
  JLabel teamStatusLabel;
  JLabel displayTeamStatus;
  JLabel lineupStatusLabel;
  JLabel displayLineupStatus;

  // Components for Starting Lineup Section
  JPanel lineupPanel;
  JScrollPane startingLineupContainer;
  String[][] startingLineupData;
  JTable displayStartingLineupList;

  // Components for Team Member Section
  JPanel teamMemberPanel;
  String[][] teamMemberData;
  JScrollPane teamMemberContainer;
  JTable displayTeamMemberList;

  // Components for New Player
  JPanel newPlayerPanel;
  JLabel firstNameLabel;
  JTextField firstNameInput;
  JLabel lastNameLabel;
  JTextField lastNameInput;
  JLabel dateOfBirthLabel;
  JPanel dateOfBirthDropPanel;
  JComboBox<Integer> yearDropdown;
  JComboBox<Integer> monthDropdown;
  JComboBox<Integer> dayDropdown;
  JLabel preferredPositionLabel;
  JComboBox<Position> positionDropdown;
  JLabel skillLevelLabel;
  JSlider skillLevelSlider;
  JButton discardButton;
  JButton addPlayerButton;
  JLabel addPlayerWarnings;

  // Component for Team Management Section
  JPanel teamManagementPanel;
  JLabel removePlayerLabel;
  JComboBox<Integer> jerseyNumberDropdown;
  JButton removePlayerButton;
  JButton createTeamButton;
  JButton formLineupButton;
  JLabel teamManagementWarnings;

  //Exit Button
  JButton exitButton;


  /**
   * The constructor of the view.
   * @param appName app name.
   */
  public U10TeamFrameView(String appName) {
    super(appName);


    this.setSize(new Dimension(1000, 400));
    this.setLocation(200, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new GridBagLayout());
    this.setMinimumSize(new Dimension(830, 550));

    // Set up Overview Section.
    GridBagConstraints overviewGrid = new GridBagConstraints();
    overviewGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    overviewGrid.gridx = 0;
    overviewGrid.gridy = 0;
    overviewGrid.insets = new Insets(5, 10, 10, 5);
    overviewGrid.fill = GridBagConstraints.HORIZONTAL;
    GridLayout overviewLayout = new GridLayout(3, 2);
    overviewLayout.setHgap(10);

    this.overviewPanel = new JPanel(overviewLayout);
    TitledBorder overViewBoarder = new TitledBorder(SECTION_BORDER, "Overview");
    overViewBoarder.setTitleFont(PANEL_TITLE_FONT);
    this.overviewPanel.setBorder(overViewBoarder);

    this.teamSizeLabel = new JLabel(" Team Size: ");
    this.teamSizeLabel.setFont(CONTENT_TITLE_FONT);
    this.displayTeamSize = new JLabel("0/20");
    this.overviewPanel.add(this.teamSizeLabel);
    this.overviewPanel.add(this.displayTeamSize);

    this.teamStatusLabel = new JLabel(" Team Status: ");
    this.teamStatusLabel.setFont(CONTENT_TITLE_FONT);
    this.displayTeamStatus = new JLabel("Not Established");
    this.overviewPanel.add(this.teamStatusLabel);
    this.overviewPanel.add(this.displayTeamStatus);

    this.lineupStatusLabel = new JLabel(" Starting Lineup Status: ");
    this.lineupStatusLabel.setFont(CONTENT_TITLE_FONT);
    this.displayLineupStatus = new JLabel("Not Formed");
    this.overviewPanel.add(this.lineupStatusLabel);
    this.overviewPanel.add(this.displayLineupStatus);

    this.add(this.overviewPanel, overviewGrid);


    // Set up Starting Lineup Section
    GridBagConstraints lineupGrid = new GridBagConstraints();
    lineupGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    lineupGrid.gridx = 0;
    lineupGrid.gridy = 1;
    lineupGrid.insets = new Insets(5, 10, 10, 5);
    lineupGrid.fill = GridBagConstraints.HORIZONTAL;

    this.lineupPanel = new JPanel(new BorderLayout());
    TitledBorder lineupBoarder = new TitledBorder(SECTION_BORDER, "Starting Lineup");
    lineupBoarder.setTitleFont(PANEL_TITLE_FONT);
    this.lineupPanel.setBorder(lineupBoarder);


    this.startingLineupData = new String[7][3];
    this.displayStartingLineupList = new JTable();
    this.displayStartingLineupList.setModel(
        new DefaultTableModel(this.startingLineupData, STARTING_LINEUP_HEADER)
    );
    this.displayStartingLineupList.getTableHeader().setFont(CONTENT_TITLE_FONT);
    this.startingLineupContainer = new JScrollPane(this.displayStartingLineupList);
    this.startingLineupContainer.setPreferredSize(new Dimension(300, 150));
    this.startingLineupContainer.setBorder(BorderFactory.createEmptyBorder());
    this.lineupPanel.add(this.startingLineupContainer, BorderLayout.CENTER);

    this.add(this.lineupPanel, lineupGrid);


    // Set Team Members Section
    GridBagConstraints teamMemberGrid = new GridBagConstraints();
    teamMemberGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    teamMemberGrid.gridx = 0;
    teamMemberGrid.gridy = 2;
    teamMemberGrid.gridheight = 2;
    teamMemberGrid.insets = new Insets(5, 10, 10, 5);
    teamMemberGrid.fill = GridBagConstraints.HORIZONTAL;

    this.teamMemberPanel = new JPanel(new BorderLayout());
    TitledBorder teamMemberBoarder = new TitledBorder(SECTION_BORDER, "Team Members");
    teamMemberBoarder.setTitleFont(PANEL_TITLE_FONT);
    this.teamMemberPanel.setBorder(teamMemberBoarder);

    this.teamMemberData = new String[20][2];
    this.displayTeamMemberList = new JTable(
        new DefaultTableModel(this.teamMemberData, TEAM_LIST_HEADER)
    );
    this.displayTeamMemberList.getTableHeader().setFont(CONTENT_TITLE_FONT);
    this.teamMemberContainer = new JScrollPane(this.displayTeamMemberList);
    this.teamMemberContainer.setPreferredSize(new Dimension(300, 200));
    this.teamMemberContainer.setBorder(BorderFactory.createEmptyBorder());
    this.teamMemberPanel.add(this.teamMemberContainer);

    this.add(this.teamMemberPanel, teamMemberGrid);


    // Set New Player Section
    GridBagConstraints newPlayerGrid = new GridBagConstraints();
    newPlayerGrid.gridx = 1;
    newPlayerGrid.gridy = 0;
    newPlayerGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    newPlayerGrid.gridheight = 2;
    newPlayerGrid.insets = new Insets(5, 5, 10, 10);

    this.newPlayerPanel = new JPanel(new GridBagLayout());
    TitledBorder newPlayerBoarder = new TitledBorder(SECTION_BORDER, "New Player");
    newPlayerBoarder.setTitleFont(PANEL_TITLE_FONT);
    this.newPlayerPanel.setBorder(newPlayerBoarder);
    this.newPlayerPanel.setPreferredSize(new Dimension(440, 279));

    // Set the FirstName Part
    GridBagConstraints firstNameTitleGrid = new GridBagConstraints();
    firstNameTitleGrid.gridx = 0;
    firstNameTitleGrid.gridy = 0;
    firstNameTitleGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    this.firstNameLabel = new JLabel(" First Name:");
    this.firstNameLabel.setFont(CONTENT_TITLE_FONT);
    this.newPlayerPanel.add(this.firstNameLabel, firstNameTitleGrid);

    GridBagConstraints firstNameInputGrid = new GridBagConstraints();
    firstNameInputGrid.gridx = 1;
    firstNameInputGrid.gridy = 0;
    firstNameInputGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    this.firstNameInput = new JTextField();
    this.firstNameInput.setColumns(TEXT_INPUT_WIDTH);
    this.newPlayerPanel.add(this.firstNameInput, firstNameInputGrid);

    // Set the LastName Part
    GridBagConstraints lastNameTitleGrid = new GridBagConstraints();
    lastNameTitleGrid.gridx = 0;
    lastNameTitleGrid.gridy = 1;
    lastNameTitleGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    this.lastNameLabel = new JLabel(" Last Name:");
    this.lastNameLabel.setFont(CONTENT_TITLE_FONT);
    this.newPlayerPanel.add(this.lastNameLabel, lastNameTitleGrid);

    GridBagConstraints lastNameInputGrid = new GridBagConstraints();
    lastNameInputGrid.gridx = 1;
    lastNameInputGrid.gridy = 1;
    lastNameInputGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    this.lastNameInput = new JTextField();
    this.lastNameInput.setColumns(TEXT_INPUT_WIDTH);
    this.newPlayerPanel.add(this.lastNameInput, lastNameInputGrid);

    // Date of Birth Part
    GridBagConstraints birthLabelGrid = new GridBagConstraints();
    birthLabelGrid.gridx = 0;
    birthLabelGrid.gridy = 2;
    birthLabelGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    this.dateOfBirthLabel = new JLabel(" Date of Birth:");
    this.dateOfBirthLabel.setFont(CONTENT_TITLE_FONT);
    this.newPlayerPanel.add(this.dateOfBirthLabel, birthLabelGrid);

    GridBagConstraints birthInputGrid = new GridBagConstraints();
    birthInputGrid.gridx = 1;
    birthInputGrid.gridy = 2;
    birthLabelGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    this.dateOfBirthDropPanel = new JPanel(new GridLayout(1, 3));
    //set years dropdown
    Integer[] years = new Integer[11];
    int currentYear = LocalDate.now().getYear();
    years[0] = currentYear - 10;
    for (int i = 1; i < 11; i++) {
      years[i] = years[i - 1] + 1;
    }
    this.yearDropdown = new JComboBox<Integer>(years);

    this.dateOfBirthDropPanel.add(this.yearDropdown);
    //set month dropdown
    Integer[] months = new Integer[12];
    for (int i = 0; i < 12; i++) {
      months[i] = i + 1;
    }
    this.monthDropdown = new JComboBox<Integer>(months);
    this.dateOfBirthDropPanel.add(this.monthDropdown);
    //set day dropdown
    Integer[] days = new Integer[31];
    for (int i = 0; i < 31; i++) {
      days[i] = i + 1;
    }
    this.dayDropdown = new JComboBox<Integer>(days);
    this.dateOfBirthDropPanel.add(this.dayDropdown);
    this.newPlayerPanel.add(this.dateOfBirthDropPanel, birthInputGrid);

    // Preferred Position Part
    GridBagConstraints positionLabelGrid = new GridBagConstraints();
    positionLabelGrid.gridx = 0;
    positionLabelGrid.gridy = 3;
    positionLabelGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    this.preferredPositionLabel = new JLabel(" Preferred Position:");
    this.preferredPositionLabel.setFont(CONTENT_TITLE_FONT);
    this.newPlayerPanel.add(this.preferredPositionLabel, positionLabelGrid);

    GridBagConstraints positionInputGrid = new GridBagConstraints();
    positionInputGrid.gridx = 1;
    positionInputGrid.gridy = 3;
    positionInputGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    this.positionDropdown = new JComboBox<Position>(Position.values());
    this.positionDropdown.setSelectedItem(Position.class);
    this.newPlayerPanel.add(this.positionDropdown, positionInputGrid);

    // Skill Level Part
    GridBagConstraints skillLabelGrid = new GridBagConstraints();
    skillLabelGrid.gridx = 0;
    skillLabelGrid.gridy = 4;
    skillLabelGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    this.skillLevelLabel = new JLabel(" Skill Level:");
    this.skillLevelLabel.setFont(CONTENT_TITLE_FONT);
    this.newPlayerPanel.add(this.skillLevelLabel, skillLabelGrid);

    GridBagConstraints skillInputGrid = new GridBagConstraints();
    skillInputGrid.gridx = 1;
    skillInputGrid.gridy = 4;
    skillInputGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    this.skillLevelSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
    this.skillLevelSlider.setMajorTickSpacing(2);
    this.skillLevelSlider.setMinorTickSpacing(1);
    this.skillLevelSlider.setPaintTicks(true);
    this.skillLevelSlider.setPaintLabels(true);
    this.skillLevelSlider.setSnapToTicks(true);
    this.skillLevelSlider.setValue(0);
    this.skillLevelSlider.setPreferredSize(new Dimension(270, 40));
    this.newPlayerPanel.add(this.skillLevelSlider, skillInputGrid);

    // set warnings
    GridBagConstraints warningsGrid = new GridBagConstraints();
    warningsGrid.gridx = 0;
    warningsGrid.gridy = 5;
    warningsGrid.gridwidth = 2;
    warningsGrid.anchor = GridBagConstraints.WEST;
    warningsGrid.insets = new Insets(5, 0, 5, 0);
    this.addPlayerWarnings = new JLabel(" *Please fill all the fields");
    this.newPlayerPanel.add(this.addPlayerWarnings, warningsGrid);

    // set 2 buttons
    GridBagConstraints discardGrid = new GridBagConstraints();
    discardGrid.gridx = 0;
    discardGrid.gridy = 6;
    discardGrid.anchor = GridBagConstraints.WEST;
    discardGrid.insets = new Insets(20, 0, 0, 0);
    this.discardButton = new JButton("Discard");
    this.discardButton.setActionCommand("Discard Player Input");
    this.newPlayerPanel.add(this.discardButton, discardGrid);

    GridBagConstraints addButtonGrid = new GridBagConstraints();
    addButtonGrid.gridx = 1;
    addButtonGrid.gridy = 6;
    addButtonGrid.anchor = GridBagConstraints.EAST;
    addButtonGrid.insets = new Insets(20, 0, 0, 0);
    this.addPlayerButton = new JButton("Add Player");
    this.addPlayerButton.setActionCommand("Add Player");
    this.newPlayerPanel.add(this.addPlayerButton, addButtonGrid);

    this.add(this.newPlayerPanel, newPlayerGrid);


    // Set Team Management Section
    GridBagConstraints teamManagementGrid = new GridBagConstraints();
    teamManagementGrid.gridx = 1;
    teamManagementGrid.gridy = 2;
    teamManagementGrid.insets = new Insets(5, 5, 10, 10);
    teamManagementGrid.anchor = GridBagConstraints.NORTHWEST;
    //teamManagementGrid.fill = GridBagConstraints.HORIZONTAL;

    this.teamManagementPanel = new JPanel(new GridBagLayout());
    TitledBorder teamManagementBoarder = new TitledBorder(SECTION_BORDER, "Team Management");
    teamManagementBoarder.setTitleFont(PANEL_TITLE_FONT);
    this.teamManagementPanel.setBorder(teamManagementBoarder);
    this.teamManagementPanel.setPreferredSize(new Dimension(440, 140));

    // Remove Player Part
    GridBagConstraints removeLabelGrid = new GridBagConstraints();
    removeLabelGrid.gridx = 0;
    removeLabelGrid.gridy = 0;
    this.removePlayerLabel = new JLabel(" Removing Player's Number: ");
    this.removePlayerLabel.setFont(CONTENT_TITLE_FONT);
    this.teamManagementPanel.add(this.removePlayerLabel, removeLabelGrid);

    GridBagConstraints removeNumberGrid = new GridBagConstraints();
    removeNumberGrid.gridx = 1;
    removeNumberGrid.gridy = 0;
    Integer[] removeList = new Integer[20];
    for (int i = 0; i < 20; i++) {
      removeList[i] = i + 1;
    }
    this.jerseyNumberDropdown = new JComboBox<Integer>(removeList);
    this.jerseyNumberDropdown.setSelectedItem(0);
    this.teamManagementPanel.add(this.jerseyNumberDropdown, removeNumberGrid);

    GridBagConstraints removeButtonGrid = new GridBagConstraints();
    removeButtonGrid.gridx = 2;
    removeButtonGrid.gridy = 0;
    this.removePlayerButton = new JButton("Remove Player");
    this.removePlayerButton.setActionCommand("Remove Player");
    this.teamManagementPanel.add(this.removePlayerButton, removeButtonGrid);

    // Team Management Warnings
    GridBagConstraints teamManagementWarningGrid = new GridBagConstraints();
    teamManagementWarningGrid.gridx = 0;
    teamManagementWarningGrid.gridy = 1;
    teamManagementWarningGrid.anchor = GridBagConstraints.WEST;
    teamManagementWarningGrid.gridwidth = 3;
    this.teamManagementWarnings = new JLabel("*Be careful when removing players.");
    this.teamManagementPanel.add(this.teamManagementWarnings, teamManagementWarningGrid);

    // Create Team & Form Starting Lineup Button
    GridBagConstraints createTeamButtonGrid = new GridBagConstraints();
    createTeamButtonGrid.gridx = 0;
    createTeamButtonGrid.gridy = 2;
    createTeamButtonGrid.insets = new Insets(20, 0, 0, 0);
    createTeamButtonGrid.anchor = GridBagConstraints.WEST;
    this.createTeamButton = new JButton("Create Team");
    this.createTeamButton.setActionCommand("Create Team");
    this.teamManagementPanel.add(this.createTeamButton, createTeamButtonGrid);

    GridBagConstraints lineupButtonGrid = new GridBagConstraints();
    lineupButtonGrid.gridx = 1;
    lineupButtonGrid.gridy = 2;
    lineupButtonGrid.insets = new Insets(20, 0, 0, 0);
    lineupButtonGrid.anchor = GridBagConstraints.EAST;
    lineupButtonGrid.gridwidth = 2;
    this.formLineupButton = new JButton("Form Starting Lineup");
    this.formLineupButton.setActionCommand("Form lineup");
    this.teamManagementPanel.add(this.formLineupButton, lineupButtonGrid);

    this.add(this.teamManagementPanel, teamManagementGrid);

    // Exit
    GridBagConstraints exitAreaGrid = new GridBagConstraints();
    exitAreaGrid.gridx = 1;
    exitAreaGrid.gridy = 3;
    exitAreaGrid.insets = new Insets(0, 0, 10, 10);
    exitAreaGrid.anchor = GridBagConstraints.SOUTHEAST;
    this.exitButton = new JButton("Exit");
    this.exitButton.setActionCommand("exit");
    this.add(this.exitButton, exitAreaGrid);

    this.pack();
    this.setVisible(true);
    this.requestFocus();


  }


  @Override
  public void addFeatures(U10TeamFeatures features) {
    this.addPlayerButton.addActionListener(
        evt -> features.addPlayer(this.firstNameInput.getText(), this.lastNameInput.getText(),
            (Integer) this.yearDropdown.getSelectedItem(),
            (Integer) this.monthDropdown.getSelectedItem(),
            (Integer) this.dayDropdown.getSelectedItem(),
            (Position) this.positionDropdown.getSelectedItem(),
            this.skillLevelSlider.getValue()))
    ;
    this.discardButton.addActionListener(evt -> this.clearNewPlayerInput());
    this.removePlayerButton.addActionListener(
        evt -> features.removePlayer((Integer) this.jerseyNumberDropdown.getSelectedItem())
    );
    this.createTeamButton.addActionListener(evt -> features.createTeam());
    this.formLineupButton.addActionListener(evt -> features.formStartingLineup());
    this.exitButton.addActionListener(evt -> features.exitApp());
  }

  @Override
  public void displayTeamSize(int teamSize) {
    this.displayTeamSize.setText(String.format("%d/20", teamSize));
  }

  @Override
  public void displayTeamStatus(String creationStatus) {
    this.displayTeamStatus.setForeground(Color.BLUE);
    this.displayTeamStatus.setText(creationStatus);
  }

  @Override
  public void displayStartingLineupStatus(String startingLineupStatus) {
    this.displayLineupStatus.setForeground(Color.BLUE);
    this.displayLineupStatus.setText(startingLineupStatus);
  }

  @Override
  public void clearNewPlayerInput() {
    this.firstNameInput.setText("");
    this.lastNameInput.setText("");
    this.yearDropdown.setSelectedIndex(0);
    this.monthDropdown.setSelectedIndex(0);
    this.dayDropdown.setSelectedIndex(0);
    this.positionDropdown.setSelectedIndex(0);
    this.skillLevelSlider.setValue(0);
  }

  @Override
  public void displayStartingLineupList(String[][] startingLineupList) {
    this.startingLineupData = startingLineupList;
    DefaultTableModel startingLineupTableModel =
        (DefaultTableModel) this.displayStartingLineupList.getModel();
    startingLineupTableModel.setDataVector(this.startingLineupData, STARTING_LINEUP_HEADER);
    startingLineupTableModel.fireTableDataChanged();
  }

  @Override
  public void displayTeamList(String[][] teamList) {
    this.teamMemberData = teamList.clone();
    DefaultTableModel teamMemberTableModel =
        (DefaultTableModel) this.displayTeamMemberList.getModel();
    teamMemberTableModel.setDataVector(this.teamMemberData, TEAM_LIST_HEADER);
    teamMemberTableModel.fireTableDataChanged();
  }

  @Override
  public void displayAddPlayerWarnings(String addPlayerWarning) {
    this.addPlayerWarnings.setForeground(Color.RED);
    this.addPlayerWarnings.setText(addPlayerWarning);
  }

  @Override
  public void displayAddedNotice() {
    this.addPlayerWarnings.setForeground(Color.BLUE);
    this.addPlayerWarnings.setText(" Player Added.");
  }

  @Override
  public void displayTeamManagementWarnings(String teamManagementWarning) {
    this.teamManagementWarnings.setForeground(Color.RED);
    this.teamManagementWarnings.setText(teamManagementWarning);
  }

  @Override
  public void displayTeamManagementNotice(String notice) {
    this.teamManagementWarnings.setForeground(Color.BLUE);
    this.teamManagementWarnings.setText(notice);
  }
}
