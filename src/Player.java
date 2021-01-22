/**
 * This class is all about the player, in "world of zuul".
 * The idea is to create a player, select a name, make sure energy levels are ok.
 *  You have to set tasks to be completed by the player before going to the next room.
 *
 * @ author
 * @ version
 */
public class Player {

  public static final int MAX_ENERGY = 100;
  public static final int MIN_ENERGY = 10;

  private String name;

  private int score;
  private int moves;

  private ArrayList<ItemTypes> items;


  private int energy;
  private int food;

}
// create character
//
Character Sam = new Character ("Sam", "collect food for energy")