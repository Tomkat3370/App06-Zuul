/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * Modified and extended by Kate Gordon and Sarah Cunningham
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    // TODO: Add 2 more command words
    GO("go"), QUIT("quit"),
    COLLECT("collect"), INVENTORY("inventory"),
    LOOK("look"), RESTART("restart"),
    HELP("help"), UNKNOWN("unknown"),
    DROP("drop");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
