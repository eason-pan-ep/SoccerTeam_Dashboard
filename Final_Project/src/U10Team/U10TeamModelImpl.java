package U10Team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Random;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class U10TeamModelImpl implements U10TeamModel {
  private boolean teamFormed;
  private List<Integer> availableJerseyNumber;
  private Map<Position, List<Player>> startingLineup;
  private Map<Integer, Player> teamMember;

  public U10TeamModelImpl(){
    this.teamFormed = false;
    this.availableJerseyNumber = new ArrayList<Integer>();
    this.initializeJerseyNumberPool();
    this.startingLineup = new TreeMap<Position, List<Player>>();
    this.teamMember = new TreeMap<Integer, Player>();

  }

  @Override public void addPlayer(String firstName, String lastName, int year, int month, int day,
      Position preferredPosition, int skillLevel)
      throws IllegalArgumentException, IllegalStateException {
    if(this.getSize() == 20){
      throw new IllegalStateException("This team is full, consider remove a Player before add new Player.");
    }
    try{
      Player newPlayer = new PlayerImpl(firstName, lastName, year, month, day, preferredPosition, skillLevel);
      if(newPlayer.getPlayerAge() > 9){
        throw new IllegalStateException("Can not add players older than 10-years-old.");
      }
      int assignedJerseyNumber = this.assignJerseyNumber();
      this.teamMember.put(assignedJerseyNumber, newPlayer);
    }catch (IllegalArgumentException e){
      throw new IllegalArgumentException("Invalid input, %s\n.", e);
    }
  }

  @Override public void removePlayer(int jerseyNumber) throws IllegalArgumentException, IllegalStateException{
    if(0 == this.getSize()){
      throw new IllegalStateException("The team is empty, cannot remove anyone.");
    }
    if(this.teamFormed && 10 == this.getSize()){
      throw new IllegalStateException("Removing one player will cause the team below the minimum member requirement to be a formed team.");
    }

    if(jerseyNumber < 1 || jerseyNumber > 20){
      throw new IllegalArgumentException("Doesn't seem like a jersey number in this team");
    }
    if(this.availableJerseyNumber.contains(jerseyNumber)){
        throw new IllegalArgumentException("This jersey number does not belong to anyone in the team, please check again.");
    }

    this.teamMember.remove(jerseyNumber);
    this.availableJerseyNumber.add(jerseyNumber);
  }

  /**
   * Assign an available jersey number to new added player.
   * Remove this number from the pool after assigned.
   * @return a number for this player
   */
  private int assignJerseyNumber(){
    Random randomPick = new Random();
    int pickIndex = randomPick.nextInt(this.availableJerseyNumber.size());
    int returnNumber = this.availableJerseyNumber.get(pickIndex);
    this.availableJerseyNumber.remove(pickIndex);
    return returnNumber;
  }

 @Override
  public int getSize(){
    return this.teamMember.size();
  }


  /**
   * Initialize jersey number pool,
   * have number 1 to 21
   */
  private void initializeJerseyNumberPool(){
    for(int i = 1; i < 21; i++){
      this.availableJerseyNumber.add(i);
    }
  }


  @Override public void createTeam() throws IllegalStateException {
    if(this.getSize() < 10){
      throw new IllegalStateException("There are less than 10 players in this team, can't form a team right now. Please add more players.");
    }
    this.teamFormed = true;
  }

  @Override public String getTeam() {
    if(0 == this.getSize()){
      return "This is an empty team.";
    }
    List<Player> allPlayers = this.sortTeamByLastName();
    Formatter outputFormatter = new Formatter();
    outputFormatter.format("%34s", "All Team Member\n");
    outputFormatter.format("-----------------------------------------------------\n");

    outputFormatter.format("%19s %19s\n", "Player Name", "Jersey Number");
    outputFormatter.format("-----------------------------------------------------\n");
    for(Player i : allPlayers){
      outputFormatter.format("%19s %16d\n", i.getName(), this.getJerseyNumber(i));
    }
    return outputFormatter.toString();
  }

  private List<Player> sortTeamByLastName(){
    ArrayList<Player> allTeamMember = new ArrayList<Player>(this.teamMember.values());
    allTeamMember.sort(new Comparator<Player>() {
      @Override public int compare(Player o1, Player o2) {
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
      }
    });
    return allTeamMember;
  }

  /**
   * Get a player's jersey number
   * @param playerObj the player object.
   * @return the jersey number of the given player.
   * Return -1 if this player isn't in the team
   */
  private int getJerseyNumber(Player playerObj){
    for(int i : this.teamMember.keySet()){
      if(playerObj.equals(this.teamMember.get(i))){
        return i;
      }
    }
    return -1;
  }

  @Override public void formStartingLineup() {

  }


  @Override public String getStartingLineup() {
    return null;
  }


}

