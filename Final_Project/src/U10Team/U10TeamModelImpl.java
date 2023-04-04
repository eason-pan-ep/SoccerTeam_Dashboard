package U10Team;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class U10TeamModelImpl implements U10TeamModel {
  private boolean teamFormed;
  private List<Integer> availableJerseyNumber;
  private Map<Position, Player> startingLineup;
  private Map<Integer, Player> teamMember;

  public U10TeamModelImpl(){
    this.teamFormed = false;
    this.availableJerseyNumber = new ArrayList<Integer>();
    this.initializeJerseyNumberPool();
    this.startingLineup = new TreeMap<Position, Player>();
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

  @Override public void removePlayer(int jerseyNumber) {

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

  }

  @Override public String getTeam() {
    return null;
  }

  @Override public void formStartingLineup() {

  }

  @Override public String getStartingLineup() {
    return null;
  }

}

