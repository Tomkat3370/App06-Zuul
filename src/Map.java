public class Map
{
    private Room startRoom;

    /**
     * Constructor for game map
     */
    public Map()
    {
        createRooms();
    }

    /**
     * Create all the primary rooms and link their exits together.
     */
    private void createRooms()
    {
        Room intracranialSpace, frontalLobe,parietalLobe, temporalLobe, occipitalLobe, cerebellum, concentrationCentre, writingCentre, olfactoryCentre, hearingCentre, memoryCentre, musicCentre,
                touchCentre, tasteCentre, puzzleCentre, visionCentre, readingCentre;

        // create all rooms
        // TODO: Split method to primary and secondary rooms
        intracranialSpace = new Room("outside the brain");

        frontalLobe = new Room("in the control panel of personality and communication");
        //Rooms inside frontalLobe
        concentrationCentre = new Room("in the concentration, planning and problem solver");
        writingCentre = new Room("in the writing room");
        olfactoryCentre = new Room("in the smell recognition room");

        parietalLobe = new Room("in the physical sensory processor");
        //Rooms inside temporalLobe
        hearingCentre = new Room("in the hearing room");
        memoryCentre = new Room("in the memories room");
        musicCentre = new Room("in the music room");

        temporalLobe = new Room("in the auditory and emotion interpreter/memory creator");
        //Rooms inside parietalLobe
        touchCentre = new Room("in the touch room");
        tasteCentre = new Room("in the tasting room");
        puzzleCentre = new Room("in the puzzle room");

        occipitalLobe = new Room("in the visual interpreter");
        //Rooms inside occipitalLobe
        visionCentre = new Room("in the vision room");
        readingCentre = new Room("in the reading room");

        cerebellum = new Room("in the voluntary movement coordinator");

        // initialise room exits
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

            startRoom = intracranialSpace;  // start game outside
    }

    public Room getStartRoom()

    {
        return startRoom;
    }

}


