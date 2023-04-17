package soccerteam;

public interface U10TeamFeatures {
    void initializeProgram();

    void addPlayer(String firstname, String lastName, int year, int month, int day, Position preferredPosition, int skillLevel);

    void updateTeamStatus(boolean creationStatus);

    void updateStartingLineupStatus(boolean staringLineupStatus);

    void removePlayer(int removeJerseyNumber);

    void createTeam();

    void formStartingLineup();

    void updateTeamList();

    void updateStaringLineupList();
    void updateTeamSize();

    void updateAddPlayerWarnings(String addPlayerWarning);

    void exitApp();
}
