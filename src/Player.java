import java.util.ArrayList;

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
  public static final int MIN_ENERGY = 0;
  public boolean collectItem;
  public boolean exchangeItem;

  private String name;
  private int score;
  private int moves;


  private ArrayList <Items> item;

  private int energy;
  private Items food;

  public Player(String name)
  {
    this.name = name;
    score = 0;
    energy = MAX_ENERGY;
  }

  public int getEnergy()
  {
    return energy;
  }

  public int getMoves()
  {
    return moves;
  }

  public int getScore()
  {
    return score;
  }

  public void setScore(int score)
  {
    this.score = score;
  }

  public void setEnergy(int energy)
  {
    this.energy = energy;
  }

  public void setMoves(int moves)

  {
    this.moves = moves;
  }

  public String getName()
  {
    return name;
  }

}
