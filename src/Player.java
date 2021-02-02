import java.util.ArrayList;

/**
 * This class is all about the player, in "world of zuul".
 * The idea is to create a player, select a name, make sure energy levels are ok.
 *  You have to set tasks to be completed by the player before going to the next room.
 *
 * @ author Kate Gordon and Sarah Cunningham
 * @ version 29/01/2020
 */
public class Player {

  public static final int MAX_ENERGY = 100;
  public static final int MIN_ENERGY = 0;
  public boolean collectItem;
  public boolean exchangeItem;
  public boolean collectFood;
  public int energy;
  public boolean dropItem;
  public int increaseEnergy;
  public int increaseScore;

  private String name;
  public int score;
  public int removeEnergy;

  private ArrayList <Items> item;


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

  public String getName()
  {
    return name;
  }

  public void decreaseEnergy()
  {
    removeEnergy = energy - 20;
  }

  public void increaseEnergy()
  {
    increaseEnergy = energy + 10;
  }

  public void increaseScore()
  {
    increaseScore = score + 20;
  }

  public String toString()
  {
    return "Player {" +
            "name: " + name +  "/n" +
            "energy: " + energy + "/n" +
            "score: " + score + "n/" +
            "}";
  }
}
