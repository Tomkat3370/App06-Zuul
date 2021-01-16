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
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room intracranialSpace, frontalLobe, concentrationCentre, writingCenter, olfactoryCenter, parietalLobe,
                temporalLobe, occipitalLobe, cerebellum;

        // create the primary rooms
        // TODO: Split method to primary and secondary rooms
        intracranialSpace = new Room("outside the brain");
        frontalLobe = new Room("in the control panel of personality and communication");
        parietalLobe = new Room("in the physical sensory processor");
        temporalLobe = new Room("in the auditory and emotion interpreter/memory creator");
        occipitalLobe = new Room("in the visual interpreter");
        cerebellum = new Room("in the voluntary movement coordinator");

        //create secondary rooms
        concentrationCentre = new Room("in the concentration, planning and problem solver");
        writingCenter = new Room("in the writing room");
        olfactoryCenter = new Room("in the smell recognition room");

        // initialise room exits
        intracranialSpace.setExit("east", frontalLobe);
        intracranialSpace.setExit("south", parietalLobe);
        intracranialSpace.setExit("west", temporalLobe);
        intracranialSpace.setExit("north", occipitalLobe);
        intracranialSpace.setExit("northWest", cerebellum);

        frontalLobe.setExit("west", intracranialSpace);
        temporalLobe.setExit("east", intracranialSpace);
        parietalLobe.setExit("north", intracranialSpace);
        occipitalLobe.setExit("west", intracranialSpace);
        cerebellum.setExit("southEast", intracranialSpace);

        parietalLobe.setExit("east", olfactoryCenter);

        olfactoryCenter.setExit("west", parietalLobe);

        startRoom = intracranialSpace;  // start game outside
    }

    public Room getStartRoom()
    {
        return startRoom;
    }
}


