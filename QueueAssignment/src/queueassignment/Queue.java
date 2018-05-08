/*
 *This is the Queue class the methods in this class will
1. set the data in a queue element
2. return the data in a queue element
3. set the pointer to the next element
4. return the pointer to the next element
 */
package queueassignment;

/**
 *
 * @author Idris Bowman
  * Last edited: 02/21/18
 */
public class Queue {

    private QueueElement head;//fist link in lisr will always start as a null value
    private QueueElement tail;//last link in lisr will always start as a null value
    int count = 0; //count number of nodes in list

    public Queue() {

        this.head = null;
        this.tail = null;

    }//end Queue()

    public int getCount() {
        return count;
    }

    //******************************************************************************   
    //return the first element in the queue
    public QueueElement getFirst() {
        if (this.head == null) {
            System.out.println("The list is empty");
            return null;
        } else {
            return this.head;
        }
    }//end getFirst()

    //******************************************************************************   
    //find out if queue is empty
    public boolean isEmpty() {
        //check that the list is not empty
        if (this.head == null ) {
            System.out.println("The print queue is empty");
        }//end if
        return false;

    }//end isEmpty()

    //******************************************************************************

    public void enqueue(QueueElement newElement) {
        //make sure head does not equal null
        if (this.head == null) {
        this.head = newElement;
        this.tail = newElement;
        System.out.println(newElement.getPrintDocument().getjNumber()+" was added to the print Queue");

        this.count ++;
        
        } else {
            
            this.tail.setNext(newElement);
            this.tail = newElement;
            System.out.println(newElement.getPrintDocument().getjNumber()+" was added to the print Queue");
            this.count++; // increment the size of the queue
        }//end if else

    }//enqueue()
//******************************************************************************
   //remove the fisrt elment in the dequeue and return the data
    public QueueElement dequeue() {
      
        QueueElement currentPrint = this.head;
        this.head = this.head.getNext();//head will now equal the next item in the list
        System.out.println(currentPrint.getPrintDocument().getjNumber()+" was removed from the print Queue");
        this.count --; // decrease the size of the queue
        
        return currentPrint; //return the removed data
       
    }// end dequeue()
 //******************************************************************************
    public void displayQueue() {

        QueueElement currentPrint = this.head;

        while (currentPrint != null) {
            System.out.println(currentPrint.toString()); //print the current node           
            currentPrint = currentPrint.getNext();//go to the next node in the list 

        }//end while

    } // end displayStates()
}//end Queue
