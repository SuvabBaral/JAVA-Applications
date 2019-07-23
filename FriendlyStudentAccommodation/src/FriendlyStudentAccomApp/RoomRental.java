package FriendlyStudentAccomApp;

/**
 * COIT11134 2019 Term1 
 * Assignment 1 Model Solution
 * 
 * RoomRental class
 * subclass of Rental
 * Represents a Room in FSA's business
 * 
 * @author Bernard Li
 */

public class RoomRental extends Rental
{
    private boolean couplesAllowed;     // whether this rental property allows couples to stay
    private boolean attachedBathroom;   // whether this rental property comes with an attached bathroom
    
    public final static String PREFIX = "R";  // prefix letter used for rental ID

    // parameterised constructor
    public RoomRental(String rentalID, String address, double weeklyPrice, boolean furnished, String description, boolean couplesAllowed, boolean attachedBathroom) 
    {
        super(rentalID, address, weeklyPrice, furnished, description);
        this.couplesAllowed = couplesAllowed;
        this.attachedBathroom = attachedBathroom;
    }
    
    // standard getters and setters for private instance fields
    public boolean getCouplesAllowed() 
    {
        return couplesAllowed;
    }

    public void setCouplesAllowed(boolean couplesAllowed) 
    {
        this.couplesAllowed = couplesAllowed;
    }

    public boolean getAttachedBathroom() 
    {
        return attachedBathroom;
    }

    public void setAttachedBathroom(boolean attachedBathroom) 
    {
        this.attachedBathroom = attachedBathroom;
    }
    
    // basic toString method for easy String output for this Rental object
    @Override
    public String toString()
    {
        return "Type: Room Rental" + "\n" + super.toString() + "\n" +
               String.format("%s: %s\n%s: %s",
                              "Couples Allowed", getCouplesAllowed()?"Yes":"No",
                              "Attached Bathroom", getAttachedBathroom()?"Yes":"No"
                            );
    }    

}// end class RoomRental
