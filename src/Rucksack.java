import java.util.ArrayList;

public class Rucksack
{
    public Rucksack addItem;
    public Rucksack removeItem;
    private Player player;

    private ArrayList<Items> item;
    private Rucksack inventory;

    public Rucksack()
    {
        item = new ArrayList<>();
    }

    public ArrayList<Items> getItem()
    {
        return item;
    }


    private void print()
    {
        System.out.println("Rucksack:/n" + item);
    }

    public void removeItem()
    {
       inventory.removeItem();
    }

    public void addItem()
    {
        inventory.addItem();
    }

}
