package FriendlyStudentAccomApp;

/**
 * COIT11134 2019 Term1 
 * Assignment 1 Model Solution
 * 
 * Rental abstract class
 * Meant to have concrete subclasses to represent rentals that FSA manages
 * 
 * @author Bernard Li
 */

public abstract class Rental 
{
    private String rentalID;    // rental ID for each rental property
                                // Must start with R for Rooms and W for Whole Units
                                // to be validated within the subclasses or GUI
    private String address;     // address for each rental property 
    private double weeklyPrice; // weekly rental price for each rental property
    private boolean furnished;  // whether this rental property comes furnished
    private String description; // description for each rental property
    
    private static int nextID = 1;  // used to keep track of next valid ID number that can be used.
                                    // starts at 1.
    
    // parameterised constructor
    public Rental(String rentalID, String address, double weeklyPrice, boolean furnished, String description)
    {
        this.rentalID = rentalID;
        this.address = address;
        this.weeklyPrice = weeklyPrice;
        this.furnished = furnished;
        this.description = description;
    }
            
    // standard getters and setters for private instance fields
    public String getRentalID() 
    {
        return rentalID;
    }

    public void setRentalID(String rentalID) 
    {
        this.rentalID = rentalID;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public double getWeeklyPrice() 
    {
        return weeklyPrice;
    }

    public void setWeeklyPrice(double weeklyPrice) 
    {
        this.weeklyPrice = weeklyPrice;
    }

    public boolean getFurnished() 
    {
        return furnished;
    }

    public void setFurnished(boolean furnished) 
    {
        this.furnished = furnished;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }
    
    
    // used to get next valid ID number
    // excludes prefix lettering R or W    
    // automatically increments nextID
    // limited from 1 to 9999 currently
    public static int getNextValidIDNumber()
    {
        return nextID++;
    }
    
   
    // basic toString method for easy String output for this Rental object
    @Override
    public String toString()
    {
        return String.format("%s: %s\n%s: %s\n%s: $%.2f\n%s: %s\n%s: %s",
                              "Rental ID", getRentalID(),
                              "Address", getAddress(),
                              "Weekly Price", getWeeklyPrice(),
                              "Funished", getFurnished()?"Yes":"No",
                              "Description", getDescription()
                            );
    }
    
}// end class Rental
