package soccerteam;

public class U10TeamFrameController implements U10TeamFeatures {
  U10TeamModel model;
  U10TeamView view;

  public U10TeamFrameController(U10TeamModel model, U10TeamView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void initializeProgram() {
    this.view.addFeatures(this);
    this.updateTeamList();
  }

  @Override
  public void addPlayer(String firstname, String lastName, int year, int month, int day, Position preferredPosition, int skillLevel) {
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

  }

  @Override
  public void updateStartingLineupStatus(boolean staringLineupStatus) {

  }

  @Override
  public void removePlayer(int removeJerseyNumber) {

  }

  @Override
  public void createTeam() {

  }

  @Override
  public void formStartingLineup() {

  }

  @Override
  public void updateTeamList() {
    String[][] teamList = this.model.getTeam();
    this.view.displayTeamList(teamList);

  }

  @Override
  public void updateStaringLineupList() {

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

  ;

  @Override
  public void exitApp() {

  }
}
