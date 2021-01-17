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

        // create the primary rooms
        // TODO: Split method to primary and secondary rooms
        intracranialSpace = new Room("outside the brain");
        frontalLobe = new Room("in the control panel of personality and communication");
        parietalLobe = new Room("in the physical sensory processor");
        temporalLobe = new Room("in the auditory and emotion interpreter/memory creator");
        occipitalLobe = new Room("in the visual interpreter");
        cerebellum = new Room("in the voluntary movement coordinator");

        //Rooms inside frontalLobe
        concentrationCentre = new Room("in the concentration, planning and problem solver");
        writingCentre = new Room("in the writing room");
        olfactoryCentre = new Room("in the smell recognition room");

        //Rooms inside temporalLobe
        hearingCentre = new Room("in the hearing room");
        memoryCentre = new Room("in the memories room");
        musicCentre = new Room("in the music room");

        //Rooms inside parietalLobe
        touchCentre = new Room("in the touch room");
        tasteCentre = new Room("in the tasting room");
        puzzleCentre = new Room("in the puzzle room");

        //Rooms inside occipitalLobe
        visionCentre = new Room("in the vision room");
        readingCentre = new Room("in the reading room");

        // initialise room exits
        intracranialSpace.setExit("forward", frontalLobe);
        intracranialSpace.setExit("left", parietalLobe);
        intracranialSpace.setExit("right", temporalLobe);
        intracranialSpace.setExit("up", occipitalLobe);
        intracranialSpace.setExit("down", cerebellum);

        frontalLobe.setExit("backward", intracranialSpace);
        frontalLobe.setExit("forward", concentrationCentre);
        frontalLobe.setExit("left", writingCentre);
        frontalLobe.setExit("right", olfactoryCentre);

        temporalLobe.setExit("backward", intracranialSpace);
        temporalLobe.setExit("forward", hearingCentre);
        temporalLobe.setExit("left", memoryCentre);
        temporalLobe.setExit("right", musicCentre);

        parietalLobe.setExit("backward", intracranialSpace);
        parietalLobe.setExit("forward", touchCentre);
        parietalLobe.setExit("left", tasteCentre);
        parietalLobe.setExit("right", puzzleCentre);

        occipitalLobe.setExit("backward", intracranialSpace);
        occipitalLobe.setExit("left", visionCentre);
        occipitalLobe.setExit("right", readingCentre);

        cerebellum.setExit("backward", intracranialSpace);

        startRoom = intracranialSpace;  // start game outside
    }

    public Room getStartRoom()

    {
        return startRoom;
    }

}


