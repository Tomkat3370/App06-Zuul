import java.util.ArrayList;
/**
 * Modified and extended by Kate Gordon and Sarah Cunningham
 */
public class Rucksack
{
      private final ArrayList<Items> item;

    public Rucksack()
    {
        item = new ArrayList<>();
    }

    public void getItem()
    {
    }

    void print()
    {
        System.out.println("Rucksack:/n" + item);
    }

    public void addItem()
    {
        getItem();
    }

    public void removeItem()
    {
        removeItem();
    }

    public void printInventory()
    {
       System.out.println("Your rucksack contains" + item.toString());
    }
}