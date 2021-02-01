import java.util.ArrayList;
/**
 * Modified and extended by Kate Gordon and Sarah Cunningham
 */
public class Rucksack
{
    public Rucksack addItem;
    public Rucksack removeItem;
    private Player player;

    private ArrayList<Items> item;
    private Rucksack inventory;

    public Rucksack(Player player)
    {
        this.player = player;
        item = new ArrayList<Items>();
    }

    public ArrayList<Items> getItem()
    {
        return item;
    }

    void print()
    {
        System.out.println("Rucksack:/n" + item);
    }

    public void addItem()
    {
        inventory.addItem();
    }

    public void removeItem()
    {
        inventory.removeItem();
    }

    public void printInventory()
    {
        inventory.printInventory();
    }
}