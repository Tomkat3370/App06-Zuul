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
  private int score;
  private boolean dead;
  private ArrayList<Items> item;



  public Player(String name)
  {
    this.name = name;
    score = 0;
    energy = 100;
    item = new ArrayList<Items>();

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
      System.out.println("Game Over!!");
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
    return "Name: " + getName() + "\nEnergy: " + getEnergy() + "\nScore: " + getScore();
  }

  public ArrayList<Items> getItem()
  {
    return item;
  }

  public void addItem(Items items)
  {
    if (!isCarrying(items))
    {
      this.item.add(items);
    }
  }
  public void removeItem()
  {
    this.item.remove(item);
  }

  public boolean isCarrying(Items items)
  {
    return item.contains(items);
  }

  public String showItems()
  {
    String inventory = "\n You are carrying: ";
    int count = 0;

    if(item.size() == 0)
      inventory += "nothing!";
    else
    {
      for(Items item : item)
      {
        count++;
        inventory += item;
      }
    }
    return inventory;
  }

  /**
   *
   */
  public void print()
  {
    System.out.println("Player : " + name);
    System.out.println();
    System.out.println("Final Score: " + score);
    System.out.println();
  }

}
