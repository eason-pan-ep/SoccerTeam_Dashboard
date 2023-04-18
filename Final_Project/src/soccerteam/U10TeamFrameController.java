package soccerteam;

/**
 * The implementation of U10Team Controller Interface.
 * This serves as a controller connects the view and the model.
 */
public class U10TeamFrameController implements U10TeamFeatures {
  U10TeamModel model;
  U10TeamView view;

  /**
   * Constructor of U10TeamFrameController.
   * @param model the U10TeamModel.
   * @param view the U10TeamFrameView.
   * @throws IllegalArgumentException when model or/and view is null.
   */
  public U10TeamFrameController(U10TeamModel model, U10TeamView view)
      throws IllegalArgumentException {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Model or/and view is not setup properly.");
    }
    this.model = model;
    this.view = view;
  }

  @Override
  public void initializeProgram() {
    this.view.addFeatures(this);
    this.updateTeamList();
  }

  @Override
  public void addPlayer(String firstname, String lastName, int year, int month, int day,
                        Position preferredPosition, int skillLevel) {
    try {
      this.model.addPlayer(firstname, lastName, year, month, day, preferredPosition, skillLevel);
      this.updateTeamList();
      this.view.clearNewPlayerInput();
      this.view.displayAddedNotice();
      this.updateTeamSize();
    } catch (IllegalArgumentException | IllegalStateException | NullPointerException e) {
      this.updateAddPlayerWarnings(e.getMessage());
    }

  }

  @Override
  public void updateTeamStatus(boolean creationStatus) {
    if (creationStatus) {
      this.view.displayTeamStatus("Established");
    }
  }

  @Override
  public void updateStartingLineupStatus(boolean staringLineupStatus) {
    if (staringLineupStatus) {
      this.view.displayStartingLineupStatus("Formed");
    }
  }

  @Override
  public void removePlayer(int removeJerseyNumber) {
    try {
      this.model.removePlayer(removeJerseyNumber);
      this.updateTeamList();
      this.updateTeamSize();
      this.view.displayTeamManagementNotice(" Player Removed.");
    } catch (IllegalArgumentException | IllegalStateException e) {
      this.updateTeamManagementWarnings(e.getMessage());
    }

  }

  @Override
  public void createTeam() {
    try {
      this.model.createTeam();
      this.updateTeamStatus(true);
      this.view.displayTeamManagementNotice("Team Established");
    } catch (IllegalStateException e) {
      this.updateTeamManagementWarnings(e.getMessage());
    }

  }

  @Override
  public void formStartingLineup() {
    try {
      this.model.formStartingLineup();
      String[][] startingLineup = this.model.getStartingLineup();
      this.updateStartingLineupStatus(true);
      this.view.displayStartingLineupList(startingLineup);
      this.view.displayTeamManagementNotice("Starting Lineup formed");
    } catch (IllegalStateException e) {
      this.updateTeamManagementWarnings(e.getMessage());
    }
  }

  @Override
  public void updateTeamList() {
    String[][] teamList = this.model.getTeam();
    this.view.displayTeamList(teamList);

  }

  @Override
  public void updateTeamSize() {
    int teamSize = this.model.getSize();
    this.view.displayTeamSize(teamSize);
  }


  @Override
  public void updateAddPlayerWarnings(String addPlayerWarning) {
    this.view.displayAddPlayerWarnings(addPlayerWarning);
  }

  @Override
  public void updateTeamManagementWarnings(String teamManagementWarning) {
    this.view.displayTeamManagementWarnings(teamManagementWarning);
  }

  ;

  @Override
  public void exitApp() {
    System.exit(0);
  }
}
