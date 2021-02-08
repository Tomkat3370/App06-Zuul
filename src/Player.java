import java.util.ArrayList;

/**
 * This class is all about the player, in "Brain fog".
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


  /**
   * Constructor to create the player and their attributes such as score and energy.
   * @param name
   */
  public Player(String name)
  {
    this.name = name;
    score = 0;
    energy = 100;
    item = new ArrayList<Items>();

    dead = false;
  }

  /**
   * return the amount of energy a player has left.
   * @return
   */
  public int getEnergy()
  {
    return energy;
  }

  /**
   * return the current score of the player
   * @return
   */
  public int getScore()
  {
    return this.score;
  }

  /**
   * return the chosen name of the player
   * @return
   */
  public String getName()
  {
    return name;
  }

  /**
   * allows the user to set the players name
   * @param name
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * decreases the players energy throughout the game
   * @param decrease
   */
  public void decreaseEnergy(int decrease)
  {
    this.energy -= decrease;
    if(energy < MIN_ENERGY)
    {
      dead = true;
      System.out.println("You ran our of energy!!");
    }
  }

  /**
   * increases the players energy during the game if they eat food.
   * @param increase
   */
  public void increaseEnergy(int increase)
  {
    this.energy += increase;
    if(energy > MIN_ENERGY)
    {
      dead = false;
    }
  }

  /**
   * Increase the players score as they play the game.
   * @param amount
   */
  public void increaseScore(int amount)
  {
    score = score + amount;
  }

  /**
   * checks to see if the player is dead
   */
  public boolean isDead()
  {
    return this.dead;
  }

  /**
   * sets the player to dead
   */
  public void setDead()
  {
    this.dead = true;
  }

  /**
   * compile the players statistics during game play.
   * @return
   */
  public String toString()
  {
    return "Name: " + getName() + "\nEnergy: " + getEnergy() + "\nScore: " + getScore();
  }

  public ArrayList<Items> getItem()
  {
    return item;
  }

  /**
   * adds items to the players inventory
   * @param items
   */
  public void addItem(Items items)
  {
    if (!isCarrying(items))
    {
      this.item.add(items);
    }
  }

  /**
   * removes items from the players inventory
   * @param item
   */
  public void removeItem(Items item)
  {
    this.item.remove(item);
  }

  /**
   * assigns the item to the inventory
   * @param items
   * @return
   */
  public boolean isCarrying(Items items)
  {
    return item.contains(items);
  }

  /**
   * prints the players inventory.
   * @return
   */
  public String showInventory()
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
   * prints the players final statistics
   */
  public void print()
  {
    System.out.println("Player : " + name);
    System.out.println();
    System.out.println("Final Score: " + score);
    System.out.println();
  }

}
