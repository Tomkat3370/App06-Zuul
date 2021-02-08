import java.util.Set;
import java.util.HashMap;

/**
 * Class BrainArea - a brain area in an adventure game.
 *
 * This class is part of the "Brain fog" application.
 * "Brain fog" is a very simple, text based adventure game.
 *
 * A "Brain Area" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 *
 * Modified and extended by Kate Gordon and Sarah Cunningham
 * Date 29/01/2021
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
     * Create a brain area described "description". Initially, it has
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
     * Define an exit from this brain area.
     * @param direction The direction of the exit.
     * @param neighbor  The brain area to which the exit leads.
     */
    public void setExit(String direction, BrainArea neighbor)
    {
        exits.put(direction, neighbor);
    }

     /**
     * Return a description of the brain area in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A description of this brain area
     */
    public String getDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the brain area's exits, for example
     * "Exits: forwards".
     * @return Details of the brain area's exits.
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
     * Return the brain area that is reached if we go from this brain area
     * in direction "direction". If there is no brain area in that
     * direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public BrainArea getExit(String direction)
    {
        return exits.get(direction);
    }

    /**
     * print the items that can be found in each brain area
     */
    public void printSetItems()
    {
        System.out.println("Items that cam be found in \nthis brain area are: "
                + item);
    }

    /**
     * set the items in each brain area
     * @param item
     */
    public void setItem(Items item)
    {
        this.item = item;
    }

    /**
     * return the items assigned to each brain area
     * @return
     */
    public Items getItem()
    {
        return item;
    }

    /**
     * allows for an item to be removed from a brain area once collected by the player.
     */
    public void removeItem()
    {
        item = Items.NONE;
    }

    public HashMap<String, BrainArea> getExit()
    {
        return exits;
    }

    /**
     * returns the name of the current brain area
     * @return
     */
    public String getName()
    {
        return name;
    }
}
