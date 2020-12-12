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
        Room intracranialSpace, frontalLobe, concentrationCentre, writingCenter, olfactoryCenter parietalLobe, temporalLobe, occipitalLobe, cerebellum;

        // create the rooms
        intracranialSpace = new Room("outside the brain");
        frontalLobe = new Room("in the control panel of personality and communication");
        concentrationCentre = new Room("in the concentration, planning and problem solver");
        writingCenter = new Room("in the writing room");
        olfactoryCenter = new Room("in the smell recognition room");
        parietalLobe = new Room("in the physical sensory processor");
        temporalLobe = new Room("in the auditory and emotion interpreter/memory creator");
        occipitalLobe = new Room("in the visual interpreter");
        cerebellum = new Room("in the voluntary movement coordinator");

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        startRoom = outside;  // start game outside
    }

    public Room getStartRoom()
    {
        return startRoom;
    }
}


