/*
 * This is the zipcode class that holds the data for the zipcode object
 */
package linkedlistzipcode;

/**
 *
 * @author Idris Bowman
 * las edited 02/10/18
 */
public class ZipCode {

    private String zipcode;    
    private String town;   
    private String county;      
    
    // constructors
    public ZipCode() 
    {
        zipcode = "";
        town = "";
        county = "";

    } // end Zipcode()

    public ZipCode(String zipcode, String town, String county) {
        this.zipcode = zipcode;
        this.town = town;
        this.county = county;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
    
    @Override
    public String toString() {
       String info;
    info = (zipcode +", "+town+", "+county);
    return info;  
    }//end toString()


}//end class Zipcode

