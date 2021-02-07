import java.util.ArrayList;
/**
 * Modified and extended by Kate Gordon and Sarah Cunningham
 */
public class Rucksack
{
    private ArrayList<Items> item;
    private Player player;
    private int quantity;


    public Rucksack()
    {
       item = new ArrayList<Items>();
       quantity = 0;
    }

    public ArrayList<Items> getItem()
    {
        return item;
    }

    public void removeItem()
    {
        if (player.dropItem && item != null)
        {
            removeItem();
        }
        else
        {
            System.out.println("Your rucksack is already empty!");
        }
    }

    public void printInventory()
    {
       System.out.println("Your rucksack contains: ");
       System.out.println(item.toString());
    }


}