package U10Team;
import java.time.Year;
public class PlayerImpl implements Player {
  private final String firstName;
  private final String lastName;
  private final int yearOfBirth;
  private final int monthOfBirth;
  private final int dayOfBirth;
  private final Position preferredPosition;
  private final int skillLevel;

  /**
   * The constructor of PlayerImpl. Create an PlayerImpl object represents a U10 soccer player.
   * @param firstName first name of the added player.
   * @param lastName last name of the added player.
   * @param yearOfBirth the year of birth of the added player.
   * @param monthOfBirth the month of birth of the added player.
   * @param dayOfBirth the day of birth of the added player.
   * @param preferredPosition the preferred position of the added player.
   * @param skillLevel the skill level a coach provides for the added player.
   * @throws IllegalArgumentException when the year is earlier than 1900 or later than current year,
   *  when the month is less than 1 or greater than 12,
   *  when the day is less than 1 or greater than 31,
   *  when skillLevel is less than 0 or greater than 10.
   */
  public PlayerImpl(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth, Position preferredPosition, int skillLevel) throws IllegalArgumentException{
    if(yearOfBirth < 1900 || yearOfBirth > Year.now().getValue()){
      throw new IllegalArgumentException("Doesn't look like a human current living on Earth.");
    }
    if(monthOfBirth < 1 || monthOfBirth > 12){
      throw new IllegalArgumentException("Doesn't look like a month on Earth.");
    }
    if(dayOfBirth < 1 || dayOfBirth > 31){
      throw new IllegalArgumentException("Doesn't look like a day on Earth.");
    }
    if(skillLevel < 0 || skillLevel > 10){
      throw new IllegalArgumentException("Out of skill level range.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.yearOfBirth = yearOfBirth;
    this.monthOfBirth = monthOfBirth;
    this.dayOfBirth = dayOfBirth;
    this.preferredPosition = preferredPosition;
    this.skillLevel = skillLevel;
  }


  @Override public String getName() {
    return null;
  }

  @Override public int getPlayerAge() {
    return 0;
  }

  @Override public int getPlayerKillLevel() {
    return 0;
  }

  @Override public Position getPreferredPosition() {
    return null;
  }
}
