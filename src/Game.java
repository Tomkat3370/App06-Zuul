import java.util.ArrayList;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Derek and Andrei
 */

public class Game 
{
    private Parser parser;
    private BrainArea currentBrainArea;
    private Map map;
    private Player player;
    private Rucksack rucksack;

    private ArrayList<Items> item;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        map = new Map();
        currentBrainArea = map.getStartRoom();
        getPlayer();
        item = new ArrayList<>();

        play();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void getPlayer()
    {
        String name = parser.getString("Please enter your name >") ;
        player = new Player(name);
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        //TODO: Add Instructions and Player Starting Status to print method
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentBrainArea.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
// TODO: Add new commands
        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case LOOK:
                lookAround(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            case RESTART:
                restart(command);

            case COLLECT:
                collect(command);

            case EXCHANGE:
                exchange(command, TOKEN);
        }
        return wantToQuit;
    }

    private void exchange(Command command, Items TOKEN, Items KEY)
    {
        if(TOKEN == 3)
        {
            rucksack.removeItem(TOKEN);
            rucksack.addItem(KEY);
            System.out.println("You have successfully exchanged your tokens for a key");
            System.out.println("You can now access the next room.");
        }
    }

    private void lookAround(Command command)
    {
        currentBrainArea.printItem();
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        //TODO: Add Game Goal
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        BrainArea nextBrainArea = currentBrainArea.getExit(direction);

        if (nextBrainArea == null)
        {
            System.out.println("There is no door!");
        }
        else
            {

            currentBrainArea = nextBrainArea;
            System.out.println(currentBrainArea.getLongDescription());
        }
    }

    private boolean collect(Command command)
    {
        if(command.hasSecondWord())
        {
            System.out.println("You have collected" + item);
            //TODO Add item to rucksack??
            return true;
        }
        else
        {
            System.out.println("collect what?");
            return false;
        }
    }

    public void addItem()
    {
        if (player.collectItem)
        {
            System.out.println("You have stored " + item + " in you're rucksack");
            Rucksack addItem = rucksack.addItem;
        }
        else
        {
            System.out.println("no Item available to add");
        }
    }

    public Items removeItem()
    {
        if ()
        {
            System.out.println("You have removed " + item + " from you're rucksack");
            Rucksack removeitem = rucksack.removeItem;
        }
        else
        {
            System.out.println("no Item available to add");
        }
    }

    private boolean restart(Command command)
    {
        if(command.hasSecondWord())
        {
            System.out.println("restart what?");
            return false;
        }
        else
        {
            return true;  // signal that we want to restart the game
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
