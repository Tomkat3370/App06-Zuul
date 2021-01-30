import java.util.ArrayList;
import java.util.EnumSet;

public class SetItems
{
    public ArrayList<Items> items;

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
}
