/*
 * This class hold the link list object
 */
package linkedlistzipcode;

import java.util.Scanner;

/**
 *
 * @author Idris Bowman
 */
public class LinkedList {

    private Node head;//fist link in lisr will always start as a null value
    int count = 0; //count number of nodes in list

    public LinkedList() {

        this.head = null;

    }//end LinkedList()

//******************************************************************************   
    //return the first element in the list
    private Node getFirst() {
        if (this.head == null) {
            System.out.println("The list is empty");
            return null;
        } else {
            return this.head;
        }
    }//end getFirst()
//******************************************************************************

    /**
     * Returns the last element in the list.
     *
     */
    private Node getLast() {
        if (this.head == null) {
            System.out.println("The list is empty");
            return null;
        }//end if
        Node current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        return current;
    }//end getLast()

//******************************************************************************   
    //find out of list is empty
    public boolean isEmpty() {
        //check that the list is not empty
        if (this.head == null) {
            System.out.println("The list is empty");

        }else{
            System.out.println("The list has " + this.count + " zipcodes");
        }//end else
        return (this.head == null);

    }//end isEmpty()

//******************************************************************************
    private void addFirst(Node newNode) {
       this.head = newNode;
    }//end addFirst()

    //******************************************************************************
    /**
     * Inserts a new node to the end of this list.
     *
     *
     */
    private void addToEnd(Node newNode) {
        //make sure head does not equal null
        if (this.head == null) {
            addFirst(newNode);

        } else {

            Node current = this.head;
            while (current.getNext() != null) {

                current = current.getNext();
            }//end while loop
            
            //make the current.next point the new node in the list
            current.setNext(newNode); 

        }//end if else

    }//addToEnd()

//******************************************************************************   
    //remove the fisrt elment in the list and return the data
    private Node removeFromHead() {
        Node current = this.head;
        this.head = this.head.getNext();//head will now equal the next item in the list
        return current; //return the removed data

    }// end removeFromHead()

//******************************************************************************   
    //searh list for a certin item by the strings name
    public void seacrhByName() {
        
        //create a scanner to get user input
        Scanner scanner = new Scanner(System.in); 
        
        // get the users input
        System.out.println("Please enter the zipcode you want to search for");
        String target = scanner.nextLine();
        
        //a  pointer to ech node in the list
        Node current = this.head.getNext();
        // true if the target is found in the list 
        boolean found = false;

        // iterate the lsit, starting at the head
        while (current != null) {
            if (current.getZipCode().getZipcode().equals(target)) {

                //print the data
                System.out.println("We found the zipcode you were looking for: " + current.toString());
                found = true;
            }//end if

            //go to next node in the list
            current = current.getNext();

        }//end while loop
        if (!found) {
            //print npt found message
            System.out.println("The zipcode you entered is not in the list");
        }//end if

    }//endseacrhByName()
//******************************************************************************    
    //load zipcode into list 

    public void buildList() throws Exception {

        // declare temporary variables to hold Zipcode properties read from a file
        String tempzipcode;
        String tempTown;
        String tempCounty;

        // Create a File class object linked to the name of the file to be read
        java.io.File zipcodedata = new java.io.File("zipcodes.txt");

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(zipcodedata);

        /* This loop reads data into the zipcode array.
         * 
         */
        while (infile.hasNextLine()) {
            // read data from the file into temporary variables
            tempzipcode = infile.nextLine();
            tempTown = infile.nextLine();
            tempCounty = infile.nextLine();
            
            //increase count
            this.count ++;

            //creat a zipcode object and load the read varibles into it
            ZipCode zipCode = new ZipCode(tempzipcode, tempTown, tempCounty);

            // instantiate a List with this Zipcode list as  the data
            Node newNode = new Node(zipCode, null);

            // add the new Node to the linked list
            // LinkedList in an instance of the linked list of zipcodes 
            addToEnd(newNode);
            

            
        } // end while
        infile.close();

        //set the count equal to the member variable count 
        //this.count = count;
        //return count;
    } // buildList()

//******************************************************************************
    public void displayZipcode() {

        Node current = this.head.getNext();

        while (current != null) {
            System.out.println(current.toString()); //print the current node           
            current = current.getNext();//go to the next node in the list 

        }//end while

    } // end displayStates()
    
     //******************************************************************************
    /* This method will print the users options
         * 
         */
    public void printActions() {

        //print a list of actions for the user to chooice from
        System.out.println("---Available actions----------------------");
        System.out.println("Press 0 - To exist the program\n"
                + "Press 1 - To print list of zipcodes\n"
                + "Press 2 - To check if list is empty\n"
                + "Press 3 - To search list for a zipcode\n"
                + "----------------------------------------------------"
        );
        
        
       

    }//end printActions()
    
    

}//end class LinkedList
