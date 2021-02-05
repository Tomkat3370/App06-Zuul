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

  private static final int MIN_ENERGY = 0;
  public static final int MAX_ENERGY = 100;

  public int energy;
  public boolean dropItem;
  public boolean collectItem;

  private String name;
  public int score;


  private ArrayList <Items> item;
  public int amount;
  private boolean dead;


  public Player(String name)
  {
    this.name = name;
    score = 0;
    energy = 100;

    dead = false;
  }

  public int getEnergy()
  {
    return energy;
  }

  public int getScore()
  {
    return this.score;
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

  public void setName(String name)
  {
    this.name = name;
  }

  public void decreaseEnergy(int decrease)
  {
    this.energy -= decrease;
    if(energy < MIN_ENERGY)
    {
      dead = true;
    }
  }

  public void increaseEnergy(int increase)
  {
    this.energy += increase;
    if(energy > MIN_ENERGY)
    {
      dead = false;
    }
  }

  public void increaseScore(int amount)
  {
    score = score + amount;
  }

  public ArrayList<Items> collectItem()
  {
    return item;
  }

  /**
   * This checks to see if the player is dead
   */
  public boolean isDead()
  {
    return this.dead;
  }

  public void setDead()
  {
    this.dead = true;
  }

  public String toString()
  {
    return "Name: " + getName() + " Energy: " + getEnergy() + " Score: " + getScore();
  }

}
