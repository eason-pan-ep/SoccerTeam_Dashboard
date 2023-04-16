package soccerteam;

public class U10TeamFrameController implements U10TeamFeatures {
    U10TeamModel model;
    U10TeamView view;

    public U10TeamFrameController(U10TeamModel model, U10TeamView view){
        this.model = model;
        this.view = view;
    }
    @Override
    public void initializeProgram() {
        System.out.println("It runs.");
    }

    @Override
    public void addPlayer(String firstname, String lastName, int year, int month, int day, Position preferredPosition, int skillLevel) {

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

    }

    @Override
    public void updateStaringLineupList() {

    }

    @Override
    public void exitApp() {

    }
}
