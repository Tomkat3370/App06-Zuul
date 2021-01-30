import java.util.ArrayList;
import java.util.EnumSet;

/**
 * SetItems class is to create sets of items.
 */

abstract class ItemSets
{
    private String setName;
    private String itemSet;
    public ArrayList<Items> items;

    /**
     * Constructor to create item sets.
     * @param name
     * @param itemSet
     */
    public ItemSets(String name, String itemSet)
    {
     ArrayList<Items> items = new ArrayList<>();
     itemSet = null;
     name = setName;
    }

    /**
     * Method to create sets
     */
    public abstract void createSet();
    {
        //Create Sets
        EnumSet<Items> tokenSet, keySet, foodSet;

        //Add elements to the sets
        tokenSet = EnumSet.of(Items.CONCENTRATION_TOKEN, Items.WRITING_TOKEN,
                Items.OLFACTORY_TOKEN, Items.HEARING_TOKEN, Items.MEMORY_TOKEN,
                Items.MUSIC_TOKEN, Items.TOUCH_TOKEN, Items.TASTE_TOKEN,
                Items.PUZZLE_TOKEN, Items.VISION_TOKEN, Items.READING_TOKEN);

        keySet = EnumSet.of(Items.FRONTAL_KEY, Items.PARIETAL_KEY, Items.TEMPORAL_KEY,
                Items.OCCIPITAL_KEY, Items.CEREBELLUM_KEY);

        foodSet = EnumSet.of(Items.CHEESE, Items.BANANA, Items.CRACKERS, Items.SPINACH);
        }

    /**
     * @return get item set.
     */
    public String getItemSet()
    {
        return itemSet;
    }

    /**
     * @param setName
     */
    public void setSetName(String setName)
    {
        this.setName = setName;
    }

    /**
     * @return set name
     */
    public String getSetName()
    {
        return setName;
    }

    /**
     * @return string
     */
     public String toString()
    {
        return "ItemSet:" + itemSet + "/n";
    }

    /**
    * print sets of items
    */
    private void print()
    {
        System.out.println("Item Sets: " + toString() + "/n");
    }


}
