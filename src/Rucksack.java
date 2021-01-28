import java.util.ArrayList;

public class Rucksack
{
    private Items item;
    private Player player;
    private Items storedItem;


    public Rucksack()
    {
        storedItem = getItem();
    }

    public Items getItem()
    {
        return item;
    }

    private void print()
    {
        System.out.println("Rucksack:/n" + item);
    }

}
