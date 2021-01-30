import java.util.ArrayList;

public class Rucksack
{
    public Rucksack addItem;
    public Rucksack removeItem;
    private Player player;

    private final ArrayList<Item> item;
    private Rucksack inventory;

    public Rucksack(Player player)
    {
        this.player = player;
        item = new ArrayList<Item>();
    }

    public ArrayList<Item> getItem()
    {
        return item;
    }

    private void print()
    {
        System.out.println("Rucksack:/n" + item);
    }

    public void addItem()
    {
        inventory.addItem();
    }

    public void removeItem(Tokens tokens)
    {
        inventory.removeItem(tokens);
    }

    //The item quantity
    private int itemQuantity;

    public void setItemQuantity(int itemQuantity)
    {
        itemQuantity = 0;
    }

    public int getItemQuantity()
    {
        return itemQuantity;
    }

    public void increaseItemQuantity()
    {
        itemQuantity++;
    }

}