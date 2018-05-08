/*This software creates and test a PrintDocument class for a queue of 
QueueElement objects.
To test the software I created 4 PrintDocument objects, added them to the 
Queue, removed the first two PrintDocument and showed the size of the Queue.
 *
 */
package queueassignment;


/**
 *
 * @author Idris Bowman
 * Last edited: 02/21/18
 */
public class QueueAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create the Queue Object abd check if queue is empty
        Queue printQueue = new Queue();
        printQueue.isEmpty();
        
        System.out.println("Begin adding documents to Queue");
        System.out.println("________________________________________");

        //create the printJob objects with Number of pages, documnetName,Jnumber,name)
        PrintDocument printDocument1 = new PrintDocument(4, "Math Homework", "J60039433", "Idrs Bowman");
        PrintDocument printDocument2 = new PrintDocument(1, "English Homework", "J55960030", "James Smith");
        PrintDocument printDocument3 = new PrintDocument(0, "Science Homework", "J567019321", "Kenny Johnson");
        PrintDocument printDocument4 = new PrintDocument(8, "Computer Science Homework", "J77789046", "Kelly Brown");


        //add printJob obeject into QueueElement
        QueueElement q1 = new QueueElement(printDocument1, null);
        QueueElement q2 = new QueueElement(printDocument2, null);
        QueueElement q3 = new QueueElement(printDocument3, null);
        QueueElement q4 = new QueueElement(printDocument4, null);

        //add the printJob objects to the queue 
        printQueue.enqueue(q1);
        printQueue.enqueue(q2);
        printQueue.enqueue(q3);
        printQueue.enqueue(q4);

        //check if queue is empty
        printQueue.isEmpty();

        System.out.println("________________________________________");
        System.out.println("Display Queue");
        //print the the queue data and size
        printQueue.displayQueue();//will show name, jnumber,doucumentName and studentName
        System.out.println("Your print queue has " + printQueue.getCount() + " doucuments waiting to print.");

        System.out.println("________________________________________");
        System.out.println("The first documnet will now exit the Queue");

        //remove 1 object from  the queue
        printQueue.dequeue(); //it should remove the first QueueElement in the list q1
        
        System.out.println("Your print queue has " + printQueue.getCount() + " doucuments waiting to print.");
        
        //remove the remaining nodes from the Queue
        System.out.println("________________________________________");
        System.out.println("The remaining documnet will now exit the Queue");
        printQueue.dequeue(); 
        printQueue.dequeue(); 
        printQueue.dequeue(); 
        System.out.println("Your print queue has " + printQueue.getCount() + " doucuments waiting to print.");

        


    }//end main method

}//end ,ain class
