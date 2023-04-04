package U10Team;

import java.util.Comparator;

/**
 *
 */
public class ComparePlayerLastName implements Comparator<Player> {
  @Override public int compare(Player o1, Player o2) {
    return o1.getLastName().compareToIgnoreCase(o2.getLastName());
  }
}
