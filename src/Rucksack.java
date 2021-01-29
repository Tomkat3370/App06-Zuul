import java.util.ArrayList;

public class Rucksack
{
    public Rucksack addItem;
    private Player player;

    private ArrayList<Items> item;


    public Rucksack()
    {
        item = new ArrayList<>();
    }

    public ArrayList<Items> getItem()
    {
        return item;
    }



    public Items removeItem()
    {

    }

    private void print()
    {
        System.out.println("Rucksack:/n" + item);
    }

}
