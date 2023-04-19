package soccerteam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * This is an implementation of U10TeamModel.
 * This class represents a U10 soccer team
 * including related methods to help coaches form a team and a staring lineup.
 */
public class U10TeamModelImpl implements U10TeamModel {
  private boolean teamFormed;
  private final List<Integer> availableJerseyNumber;
  private final Map<Position, List<Player>> startingLineup;
  private final TreeMap<Integer, Player> teamMember;
  private final List<Player> benchPlayer;

  /**
   * The constructor of U10TeamModelImpl.
   * It will initialize all fields,
   * and initialize the Jersey Number Pool (1-20).
   */
  public U10TeamModelImpl() {
    this.teamFormed = false;
    this.availableJerseyNumber = new ArrayList<Integer>();
    this.initializeJerseyNumberPool();
    this.startingLineup = new TreeMap<Position, List<Player>>();
    this.teamMember = new TreeMap<Integer, Player>();
    this.benchPlayer = new ArrayList<Player>();

  }

  @Override
  public void addPlayer(String firstName, String lastName, int year, int month, int day,
                        Position preferredPosition, int skillLevel)
      throws IllegalArgumentException, IllegalStateException {
    if (this.getSize() == 20) {
      throw new IllegalStateException(
          "This team is full, consider remove a Player before adding.");
    }
    try {
      Player newPlayer = new PlayerImpl(firstName, lastName, year, month, day, preferredPosition,
          skillLevel);
      if (newPlayer.getPlayerAge() > 9) {
        throw new IllegalStateException("Can not add players older than 10-years-old.");
      }
      int assignedJerseyNumber = this.assignJerseyNumber();
      this.teamMember.put(assignedJerseyNumber, newPlayer);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(String.format("Invalid input, %s\n", e.getMessage()));
    }
  }

  @Override
  public void removePlayer(int jerseyNumber)
      throws IllegalArgumentException, IllegalStateException {
    if (0 == this.getSize()) {
      throw new IllegalStateException("The team is empty, cannot remove anyone.");
    }
    if (this.teamFormed && 10 == this.getSize()) {
      throw new IllegalStateException(
          "Currently at minimum number of players for an established team.");
    }

    if (jerseyNumber < 1 || jerseyNumber > 20) {
      throw new IllegalArgumentException("Doesn't seem like a jersey number in this team");
    }
    if (this.availableJerseyNumber.contains(jerseyNumber)) {
      throw new IllegalArgumentException(
          "Invalid team member number, please check again.");
    }

    this.teamMember.remove(jerseyNumber);
    this.availableJerseyNumber.add(jerseyNumber);
  }

  /**
   * Assign an available jersey number to new added player. Remove this number from the pool after
   * assigned.
   *
   * @return a number for this player
   */
  private int assignJerseyNumber() {
    Random randomPick = new Random();
    int pickIndex = randomPick.nextInt(this.availableJerseyNumber.size());
    int returnNumber = this.availableJerseyNumber.get(pickIndex);
    this.availableJerseyNumber.remove(pickIndex);
    return returnNumber;
  }

  @Override
  public int getSize() {
    return this.teamMember.size();
  }

  /**
   * Initialize jersey number pool, have number 1 to 21.
   */
  private void initializeJerseyNumberPool() {
    for (int i = 1; i < 21; i++) {
      this.availableJerseyNumber.add(i);
    }
  }

  @Override
  public void createTeam() throws IllegalStateException {
    if (this.getSize() < 10) {
      throw new IllegalStateException(
          "Please make sure you have at least 10 Players.");
    }
    this.teamFormed = true;
  }

  @Override
  public String[][] getTeam() {
    if (0 == this.getSize()) {
      String[][] teamArray = new String[1][4];
      teamArray[0][0] = "";
      teamArray[0][1] = "";
      teamArray[0][2] = "";
      teamArray[0][3] = "";
      return teamArray;
    }


    List<Player> allPlayers = new ArrayList<Player>(this.teamMember.values());
    this.sortListByLastName(allPlayers);
    String[][] teamArray = new String[this.teamMember.size()][4];
    for (int i = 0; i < this.teamMember.size(); i++) {
      teamArray[i][0] = allPlayers.get(i).getName();
      teamArray[i][1] = String.valueOf(this.getJerseyNumber(allPlayers.get(i)));
      teamArray[i][2] = allPlayers.get(i).getPreferredPosition().toString();
      teamArray[i][3] = String.valueOf(allPlayers.get(i).getPlayerSkillLevel());
    }

    return teamArray;
  }

  private void sortListByLastName(List<Player> sortingList) {
    sortingList.sort(new Comparator<Player>() {
      @Override
      public int compare(Player o1, Player o2) {
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
      }
    });
  }

  /**
   * Get a player's jersey number.
   *
   * @param playerObj the player object.
   * @return the jersey number of the given player. Return -1 if this player isn't in the team
   */
  private int getJerseyNumber(Player playerObj) {
    for (int i : this.teamMember.keySet()) {
      if (playerObj.equals(this.teamMember.get(i))) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public void formStartingLineup() throws IllegalStateException {
    if (!this.teamFormed) {
      throw new IllegalStateException("Team is not established, create a team first.");
    }
    this.startingLineup.put(Position.GOALIE, new ArrayList<Player>());
    this.startingLineup.put(Position.DEFENDER, new ArrayList<Player>());
    this.startingLineup.put(Position.MIDFIELDER, new ArrayList<Player>());
    this.startingLineup.put(Position.FORWARD, new ArrayList<Player>());

    this.addPlayersByPreferences();

    //sort all Lists in the initial starting lineup by skill level
    for (List<Player> i : this.startingLineup.values()) {
      this.sortPlayerListBySkillLevel(i);
    }

    this.moveTailsToBench();
    this.fillSpots();

    for (List<Player> i : this.startingLineup.values()) {
      this.sortListByLastName(i);
    }

  }

  /**
   * if there are Positions don't have enough players, add whoever is still available on the Bench
   * with the highest skill level to fill, filling order is: goalie, defender, midfielder, forward.
   */
  private void fillSpots() {
    int[] lineupFormation = {1, 2, 3, 1};
    Position[] formationPosition = {Position.GOALIE, Position.DEFENDER, Position.MIDFIELDER,
        Position.FORWARD};

    for (int i = 0; i < lineupFormation.length; i++) {
      while (lineupFormation[i] > this.startingLineup.get(formationPosition[i]).size()) {
        this.startingLineup.get(formationPosition[i]).add(this.benchPlayer.get(0));
        this.benchPlayer.remove(0);
      }
    }
  }

  /**
   * if there are more than needed in a Position, move extras from the tails to bench, sort bench
   * players by their skill level.
   */
  private void moveTailsToBench() {
    int[] lineupFormation = {1, 2, 3, 1};
    Position[] formationPosition = {Position.GOALIE, Position.DEFENDER, Position.MIDFIELDER,
        Position.FORWARD};

    for (int i = 0; i < lineupFormation.length; i++) {
      while (lineupFormation[i] < this.startingLineup.get(formationPosition[i]).size()) {
        this.benchPlayer.add(this.startingLineup.get(formationPosition[i]).get(lineupFormation[i]));
        this.startingLineup.get(formationPosition[i]).remove(lineupFormation[i]);
      }
    }
    this.sortPlayerListBySkillLevel(this.benchPlayer);
  }

  /**
   * consider their preferred position, fill all team member meet their preferences.
   */
  private void addPlayersByPreferences() {
    for (Player i : this.teamMember.values()) {
      for (Position j : this.startingLineup.keySet()) {
        if (j == i.getPreferredPosition()) {
          this.startingLineup.get(j).add(i);
        }
      }
    }
  }

  /**
   * Sort a player list by their skill level.
   *
   * @param sortingList the player list need to be sorted.
   */
  private void sortPlayerListBySkillLevel(List<Player> sortingList) {
    sortingList.sort(new Comparator<Player>() {
      @Override
      public int compare(Player o1, Player o2) {
        return o2.getPlayerSkillLevel() - o1.getPlayerSkillLevel();
      }
    });
  }

  @Override
  public String[][] getStartingLineup() {
    String[][] output = new String[7][3];
    int playerIndex = 0;
    for (Position i : this.startingLineup.keySet()) {
      for (Player j : this.startingLineup.get(i)) {
        output[playerIndex][0] = i.toString();
        output[playerIndex][1] = j.getName();
        output[playerIndex][2] = String.valueOf(this.getJerseyNumber(j));
        playerIndex += 1;
      }
    }
    return output;
  }
}

