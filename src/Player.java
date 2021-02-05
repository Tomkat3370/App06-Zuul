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

  public int energy;
  public boolean dropItem;
  public boolean collectItem;

  private String name;
  public int score;


  private ArrayList <Items> item;
  public int amount;


  public Player(String name)
  {
    this.name = name;
    score = 0;
    energy = 100;
  }

  public int getEnergy()
  {
    return energy;
  }

  public int getScore()
  {
    return score;
  }

  public void setScore(int i)
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

  public void decreaseEnergy(int i)
  {
    score = score - amount;
  }

  public void increaseEnergy(int i)
  {
    energy = energy + amount;
  }

  public void increaseScore(int i)
  {
    score = score + amount;
  }

  public ArrayList<Items> collectItem()
  {
    return item;
  }

  public String toString()
  {
    return "Name: " + getName() + " Energy: " + getEnergy() + " Score: " + getScore();
  }

}
