/*
 * This software takes zipcode objects and load them into a linked
list. Giving the user the option to load, print and search the list of zipcodes
 */
package linkedlistzipcode;
import java.util.Scanner;

/**
 *
 * @author Idris Bowman
 */
public class LinkedListZipCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
      //create the list object
       LinkedList zipCode = new LinkedList();
       
       //creat scanner called userInput to get user input
       Scanner userInput = new Scanner(System.in);
       
       //build the linked list
       zipCode.buildList();
     
       
        //boolean that will be used to start and end program
        boolean quit = false;

        //Print a list list of options for the user to chooice from
        zipCode.printActions();

        while (!quit) {
            //get the users chooice 
            System.out.println("Please choose your action:");
            int action = userInput.nextInt();

            //if the users pick is out of bounds let the user know
            //and ask them to enter another number
            if (action < 0 || action > 3) {
                System.out.println("Please enter 0, 1, 2 or 3\n");
                System.out.println("Please choose your action:");
                action = userInput.nextInt();
                
            }//end if statement

            //This is a switch statement that alllows the user to print,and
            //search link list of zipcodes
            switch (action) {
                case 0:
                    System.out.println("\nShutting down....");
                    quit = true;
                    break;
                case 1:
                    //Display the list of zipcode 
                      zipCode.displayZipcode();
                    break;
                    
                    case 2:
                    //check if list is empty
                    zipCode.isEmpty(); //check to see if list is empty

                    break;
                case 3:
                    //search list of zipcodes
                    zipCode.seacrhByName();

                    break;
                    
                default :
                    break;

            }//end switch

        }//end while loop
        
        
    }//end main method
   
}//end main class
