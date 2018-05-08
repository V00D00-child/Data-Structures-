/*
 * This is the QueueElement class it is the node that will hold
the data that will be in the queue.

 */
package queueassignment;

/**
 *
 * @author Idris Bowman
 * Last edited: 02/21/18
 */
public class QueueElement {
    
    private PrintDocument printDocument; //PrintDocument object
    private QueueElement next; //the next node in the list that current node will point to
    
    QueueElement(){
        
    }// default constuctor
    
    QueueElement(PrintDocument printDocument, QueueElement next){
        this.printDocument = printDocument;
        this.next = next;
        
    }//end Node

    public QueueElement getNext() {
        return next;
    }

    public void setNext(QueueElement next) {
        this.next = next;
    }

    public PrintDocument getPrintDocument() {
        return printDocument;
    }
    
    @Override
    public String toString(){
      
        return  printDocument.toString();
    }//end toString()
    
    
}//end class QueueElement
