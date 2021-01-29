public enum Items
{
    //TODO: Create Key fragments and items.... class might work better??
    /**
     * TOKENs are collected in each secondary room and are traded for KEYs to the next primary room.
     *   Each TOKEN and KEY collected will increase the player experience. Food can be collected
     *   in each room to increase the player energy.
     */

        CONCENTRATION_TOKEN("token"), WRITING_TOKEN("token"), OLFACTORY_TOKEN("token"),
        HEARING_TOKEN("token"), MEMORY_TOKEN("token"), MUSIC_TOKEN("token"),
        TOUCH_TOKEN("touch token"), TASTE_TOKEN("token"), PUZZLE_TOKEN("token"),
        VISION_TOKEN("token"), READING_TOKEN("reading token"),

        FRONTAL_KEY("key"), TEMPORAL_KEY("key"), PARIETAL_KEY("key"),
        OCCIPITAL_KEY("key"), CEREBELLUM_KEY("key"),

        BANANA("food"), CHEESE("food"), CRACKERS("food"), SPINACH("food");


    // The item string.
    private String itemString;

    /**
     * Initialise with the corresponding command string.
     * @param itemString The command string.
     */
    Items(String itemString)
    {
        this.itemString = itemString;
    }

    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return itemString;
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

    public void increaseItemQuantity(int i)
    {
        itemQuantity ++;
    }
}
