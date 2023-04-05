package soccerteam;

import java.util.Comparator;

/**
 * Enum for Positions in a U10 soccer team.
 */
public enum Position implements Comparator<Position> {
  GOALIE(1), DEFENDER(2), MIDFIELDER(3), FORWARD(4);

  private final int order;

  Position(int order) {
    this.order = order;
  }

  /**
   * get the order of this Position.
   *
   * @return an int represents the order of the Position for comparison.
   */
  public int getOrder() {
    return this.order;
  }

  @Override public String toString() {
    switch (this) {
      case GOALIE:
        return "Goalie";
      case DEFENDER:
        return "Defender";
      case MIDFIELDER:
        return "Midfielder";
      case FORWARD:
        return "Forward";
      default:
        return "No Position Record";
    }
  }

  @Override public int compare(Position o1, Position o2) {
    return Integer.compare(o1.getOrder(), o2.getOrder());
  }
}
