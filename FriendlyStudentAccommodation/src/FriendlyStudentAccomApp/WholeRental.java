package FriendlyStudentAccomApp;

/**
 * COIT11134 2019 Term1 
 * Assignment 1 Model Solution

 * WholeRental class
 * subclass of Rental
 * Represents a Whole Unit in FSA's business
* 
 * @author Bernard Li
 */

public class WholeRental extends Rental
{
    private int numberOfRooms;      // number of rooms in this rental property 
    private int numberOfBathrooms;  // number of bathrooms in this rental property 
    private boolean garageSpace;    // whether this rental property has garage space
    private boolean petsAllowed;    // whether this rental property allows pets

    public final static String PREFIX = "W";  // prefix letter used for rental ID
    
    // parameterised constructor
    public WholeRental(String rentalID, String address, double weeklyPrice, boolean furnished, String description, int numberOfRooms, int numberOfBathrooms, boolean garageSpace, boolean petsAllowed) 
    {
        super(rentalID, address, weeklyPrice, furnished, description);
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.garageSpace = garageSpace;
        this.petsAllowed = petsAllowed;
    }

    // standard getters and setters for private instance fields
    public int getNumberOfRooms() 
    {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) 
    {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfBathrooms() 
    {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) 
    {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public boolean getGarageSpace() 
    {
        return garageSpace;
    }

    public void setGarageSpace(boolean garageSpace) 
    {
        this.garageSpace = garageSpace;
    }

    public boolean getPetsAllowed() 
    {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) 
    {
        this.petsAllowed = petsAllowed;
    }
    
    // basic toString method for easy String output for this Rental object
    @Override
    public String toString()
    {
        return "Type: Whole Unit Rental" + "\n" + super.toString() + "\n" +
               String.format("%s: %d\n%s: %d\n%s: %s\n%s: %s",
                              "Number of Rooms", getNumberOfRooms(),
                              "Number of Bathrooms", getNumberOfBathrooms(),
                              "Garage Space", getGarageSpace()?"Yes":"No",
                              "Pets Allowed", getPetsAllowed()?"Yes":"No"
                            );
    }    
    
}// end class WholeRental
