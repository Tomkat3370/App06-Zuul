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
 * Modified and extended by Kate Gordon and Sarah Cunningham
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
        item = new ArrayList<Items>();
        rucksack = new Rucksack();

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
        System.out.println();
        System.out.println(player.getName() + "Welcome to BrainFog!");
        System.out.println("BrainFog is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println(player.toString());
        System.out.println();
        System.out.println(currentBrainArea.getDescription());
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
                look(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            case RESTART:
                restart(command);
                break;

            case COLLECT:
                collect(command);
                break;

            case DROP:
                drop(command);
                break;

            case INVENTORY:
                inventory(command);
                break;

        }
        return wantToQuit;
    }

    private void drop(Command command)
    {
        if (player.dropItem)
        {
            System.out.println("You have dropped " + item + " from you're rucksack");
            rucksack.removeItem();
            System.out.println(player.toString());
        }
        else
        {
            System.out.println("what would you like to drop?");
        }
    }

    private void inventory(Command command)
    {
        rucksack.printInventory();
    }

    private void collect(Command command)
    {
        if (player.collectFood)
        {
            player.increaseEnergy(10);
            System.out.println("You ate food and gained 10 energy."
                    + player.toString());
        }
        else if (player.collectKey)
        {
            System.out.println("You have collected " + item + " in you're rucksack");
            rucksack.addItem();
            player.increaseScore(20);
            System.out.println(player.toString());
        }
        else if (player.collectVodka)
        {
            System.out.println("You drank " + item + "and became intoxicated");
            System.out.println("This has lost you 10 energy");
            player.decreaseEnergy(-10);
            System.out.println(player.toString());
        }
        else if (player.collectBoobyTrap)
        {
            System.out.println("It's a Trap!");
            System.out.println("You lost 20 energy!");
            player.decreaseEnergy(-20);
            System.out.println(player.toString());
        }
        else if (player.collectTrophy)
        {
            System.out.println("Congratulations!!");
            System.out.println("You have WON the Game!!");
            player.increaseScore(100);
            System.out.println(player.toString());
            System.out.println();
            System.out.println("To play again RESET the game.");
        }
        else
        {
            System.out.println("no Item available to collect");
        }

    }

    private void look(Command command)
    {
        System.out.println("You have found" + currentBrainArea.getItems());
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are in" + currentBrainArea + "/n");
        System.out.println("your goal is to collect all the keys and");
        System.out.println("tokens scattered throughout the brain /n");
        System.out.println("then make your way to the Cerebellum.");
        System.out.println("The directions you can go in from here are: /n" + currentBrainArea.getExit());
        System.out.println(player.toString());
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
            System.out.println("Where would you like to GO?");
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
            player.decreaseEnergy(-20);
            player.increaseScore(20);
            System.out.println(currentBrainArea.getDescription());
            System.out.println(player.toString());
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
