/**
 * This class creates the different brain areas within
 * the map, for the application.
 *
 *  Author Kate Gordon and Sarah Cunningham
 *  Date 29/01/2021
 */

public class Map
{
    private BrainArea intracranialSpace, frontalLobe,parietalLobe, temporalLobe,
            occipitalLobe, cerebellum, concentrationCentre, writingCentre,
            olfactoryCentre, hearingCentre, memoryCentre, musicCentre,
            touchCentre, tasteCentre, puzzleCentre, visionCentre, readingCentre;

    private BrainArea startBrainArea;

    /**
     * Constructor for game map
     */
    public Map()
    {
        createRooms();
        setItems();
    }


    /**
     * Method to create all the brain areas and their descriptions
     */
    private void createRooms()
    {
        intracranialSpace = new BrainArea("You are in the Intracranial Space of the Brain.\n" +
                "From here you can access all areas of the Brain.");

        frontalLobe = new BrainArea("You are in the frontal lobe. This is the control \n" +
                "panel of personality and communication.\n From here you can access: " +
                "\nthe concentration centre, \nthe writing centre and \nthe olfactory centre");
        //Rooms inside frontalLobe
        concentrationCentre = new BrainArea("You have entered the concentration centre.");
        writingCentre = new BrainArea("You have entered the writing center.");
        olfactoryCentre = new BrainArea("You have entered the concentration centre.");

        parietalLobe = new BrainArea("You are in the parietal lobe." +
                " This is the  the physical sensory processor." +
                "\nFrom here you can access: \nthe concentration centre," +
                "\nthe writing centre and \nthe olfactory centre");
        //Rooms inside parietalLobe
        hearingCentre = new BrainArea("You have entered the hearing centre");
        memoryCentre = new BrainArea("You have entered the memories centre");
        musicCentre = new BrainArea("You have entered the music centre");

        temporalLobe = new BrainArea("You have entered the temporal lobe." +
                "This is the auditory and emotion interpreter and memory creator." +
                "\nFrom here you can access \nthe touch centre,\n the taste centre" +
                "and \n the puzzle centre");
        //Rooms inside temporalLobe
        touchCentre = new BrainArea("You have entered the touch centre");
        tasteCentre = new BrainArea("You have entered the tasting centre");
        puzzleCentre = new BrainArea("You have entered the puzzle centre.");

        occipitalLobe = new BrainArea("You have entered the occipital lobe, " +
                "\nthe visual interpreter of the Brain. From here you can access: " +
                "\nthe vision centre and \n the reading centre");
        //Rooms inside occipitalLobe
        visionCentre = new BrainArea("You have entered the vision room.");
        readingCentre = new BrainArea("You have entered the reading room.");

        cerebellum = new BrainArea("You have entered the Cerebellum,\n the voluntary " +
                "movement coordinator. \nThis is the final room in the game.\n\n CONGRATULATIONS YOU WIN!!");

        setExits();

        startBrainArea = intracranialSpace;  // start game outside
    }

    /**
     *Method to initialise the exits of each brain area, linking them together.
     */
    private void setExits()
    {
        intracranialSpace.setExit("forward", frontalLobe);
        intracranialSpace.setExit("left", parietalLobe);
        intracranialSpace.setExit("right", temporalLobe);
        intracranialSpace.setExit("up", occipitalLobe);
        intracranialSpace.setExit("down", cerebellum);

        frontalLobe.setExit("back", intracranialSpace);
        frontalLobe.setExit("forward", concentrationCentre);
        frontalLobe.setExit("left", writingCentre);
        frontalLobe.setExit("right", olfactoryCentre);

        concentrationCentre.setExit("back", frontalLobe);
        writingCentre.setExit("back", frontalLobe);
        olfactoryCentre.setExit("back", frontalLobe);

        temporalLobe.setExit("back", intracranialSpace);
        temporalLobe.setExit("forward", hearingCentre);
        temporalLobe.setExit("left", memoryCentre);
        temporalLobe.setExit("right", musicCentre);

        hearingCentre.setExit("back", temporalLobe);
        memoryCentre.setExit("back", temporalLobe);
        musicCentre.setExit("back", temporalLobe);

        parietalLobe.setExit("back", intracranialSpace);
        parietalLobe.setExit("forward", touchCentre);
        parietalLobe.setExit("left", tasteCentre);
        parietalLobe.setExit("right", puzzleCentre);

        touchCentre.setExit("back", parietalLobe);
        tasteCentre.setExit("back", parietalLobe);
        puzzleCentre.setExit("back", parietalLobe);

        occipitalLobe.setExit("back", intracranialSpace);
        occipitalLobe.setExit("left", visionCentre);
        occipitalLobe.setExit("right", readingCentre);

        visionCentre.setExit("back", occipitalLobe);
        readingCentre.setExit("back", occipitalLobe);

        cerebellum.setExit("back", intracranialSpace);
    }

    /**
     * Method to set items that are pre-existing in the brain areas.
     */

    private void setItems()
    {
        frontalLobe.setItem(Items.KEY);

        concentrationCentre.setItem(Items.FOOD);

        writingCentre.setItem(Items.VODKA);

        olfactoryCentre.setItem(Items.BOOBY_TRAP);

        parietalLobe.setItem(Items.KEY);

        hearingCentre.setItem(Items.FOOD);

        memoryCentre.setItem(Items.BOOBY_TRAP);

        musicCentre.setItem(Items.VODKA);

        temporalLobe.setItem(Items.KEY);

        touchCentre.setItem(Items.BOOBY_TRAP);

        tasteCentre.setItem(Items.VODKA);

        puzzleCentre.setItem(Items.FOOD);

        occipitalLobe.setItem(Items.KEY);

        visionCentre.setItem(Items.VODKA);

        readingCentre.setItem(Items.FOOD);

        cerebellum.setItem(Items.TROPHY);
    }

    /**
     * Method to create the starting point of the application.
     */
    public BrainArea getStartRoom()

    {
        return startBrainArea;
    }

}


