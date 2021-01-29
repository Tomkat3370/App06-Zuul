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
        frontalLobe.setItem(Items.KEY);

    }

    /**
     * Create all the primary rooms and link their exits together.
     */
    private void createRooms()
    {
        intracranialSpace = new BrainArea("outside the brain");

        frontalLobe = new BrainArea("in the control panel of personality and communication");
        //Rooms inside frontalLobe
        concentrationCentre = new BrainArea("in the concentration, planning and problem solver");
        writingCentre = new BrainArea("in the writing room");
        olfactoryCentre = new BrainArea("in the smell recognition room");

        parietalLobe = new BrainArea("in the physical sensory processor");
        //Rooms inside temporalLobe
        hearingCentre = new BrainArea("in the hearing room");
        memoryCentre = new BrainArea("in the memories room");
        musicCentre = new BrainArea("in the music room");

        temporalLobe = new BrainArea("in the auditory and emotion interpreter/memory creator");
        //Rooms inside parietalLobe
        touchCentre = new BrainArea("in the touch room");
        tasteCentre = new BrainArea("in the tasting room");
        puzzleCentre = new BrainArea("in the puzzle room");

        occipitalLobe = new BrainArea("in the visual interpreter");
        //Rooms inside occipitalLobe
        visionCentre = new BrainArea("in the vision room");
        readingCentre = new BrainArea("in the reading room");

        cerebellum = new BrainArea("in the voluntary movement coordinator");

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


