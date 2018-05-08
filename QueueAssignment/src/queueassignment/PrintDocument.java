/*
 * This is the printDocument class it represents a document sent to a print queue
by a CCP student the object has...
1. number of pages in the document
2. name of the document
3. the J number of the person trying to print
4. the name of the student
 */
package queueassignment;

/**
 *
 * @author Idris Bowman
 * Last edited: 02/21/18
 */
public class PrintDocument {
    private int numberOfPages;
    private String nameOfDocument;
    private String jNumber; //key property
    private String studentName;
    
    public PrintDocument(int numberOfPages, String nameOfDocument, String jNumber, String studentName) {
        this.numberOfPages = numberOfPages;
        this.nameOfDocument = nameOfDocument;
        this.jNumber = jNumber;
        this.studentName = studentName;
                
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(String nameOfDocument) {
        
        this.nameOfDocument = nameOfDocument;
    }
 
    public String getName() {
        return studentName;
    }

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public String getjNumber() {
        return jNumber;
    }
    
    
    @Override
    public String toString() {
       String info;
    info = (jNumber + ":=" + nameOfDocument +" has a total number of " +numberOfPages +" pages");
    return info;  
    }//end toString()

    
}//end class PrintDocument
