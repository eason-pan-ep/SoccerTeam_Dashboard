package soccerteam;

/**
 * This is the Interface of Player, it represents a U10 soccer team player.
 */
public interface Player {
  /**
   * Get the name of this player.
   *
   * @return a string with the player's full name in the format of "LastName, FistName".
   */
  String getName();

  /**
   * Calculate and return the age of this player.
   *
   * @return an int for the age of this player.
   */
  int getPlayerAge();

  /**
   * Get the skill level in int of this player. Scale from 0 as the worst to 10 the best.
   *
   * @return an int represents the skill level of this player.
   */
  int getPlayerSkillLevel();

  /**
   * Get the preferred position of this player.
   *
   * @return the Position this player prefers.
   */
  Position getPreferredPosition();

  /**
   * Only return the last name of this player, for sorting purposes.
   *
   * @return the last name of this player.
   */
  String getLastName();

}
