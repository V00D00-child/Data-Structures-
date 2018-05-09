/*
 * This class has a Node object that has the data and a pointer to the net node
the link list
 */

package linkedlistzipcode;

/**
 *
 * @author Idris Bowman
 * Last edited 02/10/18
 */
public class Node {
    
    private ZipCode zipCode; //Zipcode object
    private Node next; //the next node in the list that current node will point to
    
    Node(){
        
    }// default constuctor
    
    Node(ZipCode zipCode, Node next){
        this.zipCode = zipCode;
        this.next = next;
        
    }//end Node

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }
    
    @Override
    public String toString(){
      
        return  zipCode.toString();
    }//end toString()
    

}//end class Node
