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

    private void setItems()
    {
        frontalLobe.setItem(Items.BANANA);
        frontalLobe.setItem(Items.CHEESE);
        frontalLobe.setItem(Items.FRONTAL_KEY);

        concentrationCentre.setItem(Items.CONCENTRATION_TOKEN);
        concentrationCentre.setItem(Items.CRACKERS);

        writingCentre.setItem(Items.WRITING_TOKEN);
        writingCentre.setItem(Items.SPINACH);

        olfactoryCentre.setItem(Items.OLFACTORY_TOKEN);
        olfactoryCentre.setItem(Items.BANANA);

        parietalLobe.setItem(Items.CRACKERS);
        parietalLobe.setItem(Items.CHEESE);
        parietalLobe.setItem(Items.PARIETAL_KEY);

        hearingCentre.setItem(Items.BANANA);
        hearingCentre.setItem(Items.HEARING_TOKEN);

        memoryCentre.setItem(Items.SPINACH);
        memoryCentre.setItem(Items.MEMORY_TOKEN);

        musicCentre.setItem(Items.CRACKERS);
        musicCentre.setItem(Items.MUSIC_TOKEN);

        temporalLobe.setItem(Items.SPINACH);
        temporalLobe.setItem(Items.TEMPORAL_KEY);
        temporalLobe.setItem(Items.CHEESE);

        touchCentre.setItem(Items.BANANA);
        touchCentre.setItem(Items.TOUCH_TOKEN);

        tasteCentre.setItem(Items.CRACKERS);
        tasteCentre.setItem(Items.TASTE_TOKEN);

        puzzleCentre.setItem(Items.BANANA);
        puzzleCentre.setItem(Items.PUZZLE_TOKEN);

        occipitalLobe.setItem(Items.SPINACH);
        occipitalLobe.setItem(Items.CRACKERS);
        occipitalLobe.setItem(Items.OCCIPITAL_KEY);

        visionCentre.setItem(Items.CHEESE);
        visionCentre.setItem(Items.VISION_TOKEN);

        readingCentre.setItem(Items.BANANA);
        readingCentre.setItem(Items.READING_TOKEN);

        cerebellum.setItem(Items.TROPHY);
    }

    /**
     * Create all the primary rooms and link their exits together.
     */
    private void createRooms()
    {
        intracranialSpace = new BrainArea("You are in the Intracranial Space of the Brain." +
                "From here you can access all areas of the Brain.");

        frontalLobe = new BrainArea("You are in the frontal lobe. This is the control " +
                "panel of personality and communication. From here you can access the concentration, " +
                "writing and olfactory centres of the Brain");
        //Rooms inside frontalLobe
        concentrationCentre = new BrainArea("You have entered the concentration centre. You must" +
                "complete the puzzle to receive the token for this room.");
        writingCentre = new BrainArea("You have entered the writing center. You must " +
                 "complete the puzzle to receive the token from here.");
        olfactoryCentre = new BrainArea("You have entered the concentration centre. You must" +
                 "complete the puzzle to receive the token from here.");

        parietalLobe = new BrainArea("You are in the parietal lobe." +
                " This is the  the physical sensory processor. From here you can access the " +
                "concentration, writing and olfactory centres of the Brain");
        //Rooms inside parietalLobe
        hearingCentre = new BrainArea("You have entered the hearing room. You must complete" +
                "the puzzle to receive the token from here.");
        memoryCentre = new BrainArea("You have entered the memories room. You must complete" +
                "the puzzle to receive the token from here.");
        musicCentre = new BrainArea("You have entered the music room. You must complete" +
                "the puzzle to receive the token from here.");

        temporalLobe = new BrainArea("You have entered the auditory and emotion interpreter" +
                "/memory creator. From here you can access the touch, taste and puzzle centres of the Brain..");
        //Rooms inside temporalLobe
        touchCentre = new BrainArea("You have entered the touch room. You must complete" +
                "the puzzle to receive the token from here.");
        tasteCentre = new BrainArea("You have entered the tasting room. You must complete" +
                "the puzzle to receive the token from here.");
        puzzleCentre = new BrainArea("You have entered the puzzle room. You must complete" +
                "the puzzle to receive the token from here.");

        occipitalLobe = new BrainArea("You have entered the occipital lobe, the visual interpreter" +
                "of the Brain. From here you can access the vision and reading centres of the Brain");
        //Rooms inside occipitalLobe
        visionCentre = new BrainArea("You have entered the vision room. You must complete" +
                "the puzzle to receive the token from here");
        readingCentre = new BrainArea("You have entered the reading room. You must complete" +
                "the puzzle to receive the token from here.");

        cerebellum = new BrainArea("You have entered the cerebellun, the voluntary " +
                "movement coordinator. This is the final room in the game. CONGRATULATIONS YOU WIN!!");

        setExits();

        startBrainArea = intracranialSpace;  // start game outside
    }

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

    public BrainArea getStartRoom()

    {
        return startBrainArea;
    }

}


