package soccerteam;

public interface U10TeamView {
    void addFeatures(U10TeamFeatures features);

    void displayTeamSize(int teamSize);

    void displayTeamStatus(String creationStatus);

    void displayStartingLineupStatus(String startingLineupStatus);

    void clearNewPlayerInput();

    void clearRemovePlayerInput();

    void displayStartingLineupList(String startingLineupList);

    void displayTeamList(String teamList);
}