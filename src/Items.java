import java.util.ArrayList;
import java.util.EnumSet;
enum Items
{
    CONCENTRATION_TOKEN, WRITING_TOKEN, OLFACTORY_TOKEN,
    HEARING_TOKEN, MEMORY_TOKEN, MUSIC_TOKEN, TOUCH_TOKEN,
    TASTE_TOKEN, PUZZLE_TOKEN, VISION_TOKEN, READING_TOKEN,

    FRONTAL_KEY, TEMPORAL_KEY, PARIETAL_KEY,
    OCCIPITAL_KEY, CEREBELLUM_KEY,

    BANANA, CHEESE, CRACKERS, SPINACH,

    TROPHY;


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
        itemQuantity ++;
    }
}
