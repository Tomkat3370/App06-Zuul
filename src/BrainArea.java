import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * Modified and extended by Kate Gordon and Sarah Cunningham
 */

public class BrainArea
{
    private String name;

    private String description;
    // String is the key to a room in that direction
    // east would be an exit that goes to the Room
    private HashMap<String, BrainArea> exits;
    private Items item;


    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public BrainArea(String description)
    {
        this.description = description;
        exits = new HashMap<>();
        name = null;
    }


    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, BrainArea neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room
     * in direction "direction". If there is no room in that
     * direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public BrainArea getExit(String direction)
    {
        return exits.get(direction);
    }

    public void printSetItems()
    {
        System.out.println("Items that cam be found in \nthis room are: "
                + item);
    }

    public void setItem(Items item)
    {
        this.item = item;
    }

    public Items getItem()
    {
        return item;
    }

    public void removeItem()
    {
        item = Items.NONE;
    }

    public HashMap<String, BrainArea> getExit()
    {
        return exits;
    }

    public String getName()
    {
        return name;
    }

    public void addItem()
    {
        addItem();
    }
}
