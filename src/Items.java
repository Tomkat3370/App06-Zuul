import java.util.ArrayList;

/**
 * Representations for all Items in the game.
 * Modified and extended by Kate Gordon and Sarah Cunningham
 */
public enum Items
{
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


