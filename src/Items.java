/**
 * Representations for all Items in the game.
 *
 * Modified and extended by Kate Gordon and Sarah Cunningham
 * Date 29/01/2021
 */
public enum Items
{
        NONE("none"),

        FOOD("food"),

        TROPHY("trophy"),

        KEY("key"),

        VODKA("vodka"),

        BOOBY_TRAP("booby-trap");

        // The command string.
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
}


