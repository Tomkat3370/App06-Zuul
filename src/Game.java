/**
 *  This class is the main class of the "Brain Fog" application.
 *  "Brain Fog" is a very simple, text based adventure game.  Users
 *  can walk around inside the human brain and collect items, making
 *  their way to the cerebellum to get the trophy and win the game
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
 * Date 29/01/2021
 */

public class Game 
{
    private Parser parser;
    private BrainArea currentBrainArea;
    private Map map;
    private Player player;
    private Items item;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        map = new Map();
        currentBrainArea = map.getStartRoom();

        getPlayer();

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

            if (player.isDead())
            {
                System.out.println("GAME OVER");
                finished = true;
            }
        }
        
        System.out.println("Thank you for playing.  Good bye.");
        player.print();
    }

    /**
     * method to initialise player
     */
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
        System.out.println(player.getName() + " Welcome to BrainFog!");
        System.out.println("BrainFog is a new, text orientated adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
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

            case INVENTORY:
                inventory(command);
                break;

            case USE:
                    use(command);
                break;

        }
        return wantToQuit;
    }

    /**
     * Method for the command inventory
     * @param command
     */
    private void inventory(Command command)
    {
        System.out.println(player.showInventory());
    }

    /**
     * Method for the command collect
     * @param command
     */
    private void collect(Command command)
    {
        item = currentBrainArea.getItem();
        System.out.println(item.toString());
        String object = command.getSecondWord();
        System.out.println(player.toString());

        if (object == null)
        {
            System.out.println("what would you like to collect");
        }
        else if(item == Items.NONE)
        {
            System.out.println("there is nothing here to collect");
        }
        else
        {
            currentBrainArea.removeItem();
            player.addItem(item);
            player.increaseScore(20);
            System.out.println("You have collected " + item);
        }

        player.showInventory();
    }

    /**
     * Method for the command use
     * @param command
     */
    private void use(Command command)
    {
        player.showInventory();

        if (player.isCarrying(Items.NONE))
        {
            System.out.println(" you are carrying nothing!");
            player.showInventory();
            System.out.println(player.toString());
        }
        else if (player.isCarrying(Items.FOOD))
        {
            player.increaseEnergy(20);
            player.increaseScore(10);
            System.out.println("You ate food, increasing your energy by 20");
            player.removeItem(item);
            System.out.println(player.toString());
        }
        else if (player.isCarrying(Items.VODKA))
        {
            player.decreaseEnergy(15);
            System.out.println("You drank vodka, decreasing your energy by 15");
            player.removeItem(item);
            System.out.println(player.toString());
        }
        else if (player.isCarrying(Items.BOOBY_TRAP))
        {
            player.decreaseEnergy(25);
            System.out.println("You fell in a booby-trap, decreasing your energy by 25");
            player.removeItem(item);
            System.out.println(player.toString());
        }
        else if (player.isCarrying(Items.KEY))
        {
            player.increaseScore(50);
            System.out.println("You have unlocked the next Brain Area ");
            System.out.println("and increased your score by 50");
            player.removeItem(item);
            System.out.println(player.toString());
        }
        else if (player.isCarrying(Items.TROPHY))
        {
            player.increaseScore(1000);
            System.out.println("Congratulations You WIN!!!");
            System.out.println(player.toString());
        }
        else
        {
            System.out.println("What would you like to use?");
            System.out.println(player.toString());
            System.out.println(player.showInventory());
        }
    }

    /**
     * Method for the command look
     * @param command
     */
    private void look(Command command)
    {
        System.out.println("You have found " + currentBrainArea.getItem());
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("your goal is to collect all the keys");
        System.out.println("scattered throughout the brain ");
        System.out.println("then make your way to the Cerebellum.");
        System.out.println();
        System.out.println("You are in" + currentBrainArea.getDescription());
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
        System.out.println();
        System.out.println(player.toString());
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
            System.out.println("Where would you like to go?");
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
            player.decreaseEnergy(20);
            player.increaseScore(20);
            System.out.println(currentBrainArea.getDescription());
            System.out.println(player.toString());
            currentBrainArea.printSetItems();
        }
    }

    /**
     * Method for the command restart
     * @param command
     */
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
        else
        {
            return true;  // signal that we want to quit
        }
    }

}