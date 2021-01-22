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
  private Player player;
  private int score;
  private int moves;

  private ArrayList<ItemTypes> items;


  private int energy;
  private Item food;
  public Player()
  {
    player = new PLayer;
  }
}
// create player
//
player = new player ("collect food for energy");
