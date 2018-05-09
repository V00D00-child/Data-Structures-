/*
 * This software creates a stack that takes a array of Strings for its data
 * In the main method I create a array of String and call methods from the Stack
 *class to push, pop, print, the data in the stack.
 */
package stackassignment;

/**
 *
 * @author Idris Bowman
 * Last edited: 02/21/18
 */
public class StackAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Create the stack object and make sure it is empty
        Stack stack = new Stack();
        stack.isEmpty();

        //make array of names that will be the data for the stack
        String[] names = {"Joe", "Mary", "John","Idris","Kate", "Imani", "Anita"};
        
        //Make an array to hold the String after they come out the stack
        String[] namesReverse = new String[names.length]; 
        
        //blank line
        System.out.println("__________________________________________________");
        System.out.println("The follwing names will go into the Stack ");
        //print the names before they are added to the stack
        for (int i = 0; i < names.length; i++) {
            
           //print the names
             System.out.println(names[i]);
             
        }//end for loop
        
 //*********PUSH items**************************************************************           
        
        //blank line
        System.out.println("__________________________________________________");
        
        //add each name  to the stack
        for (int i = 0; i < names.length; i++) {
            //add the data to the stack
            stack.push(names[i]);
        }//end for loop
        
        //print size of stack
         System.out.println("The stack has a total of " + stack.getCount()+ " elements");

        //check to see if stack is empty and full
        stack.isEmpty();
        stack.isFull();
        
 //*********POP items**************************************************************     
        
        //blank line
        System.out.println("__________________________________________________");
        System.out.println("Each item in the stack will be removed until the stack is empty");

        //remove all the items from the stack and load into the new array
       for (int i = 0; i < names.length; i++) {
            
             namesReverse[i] = stack.pop();
             
        }//end for loop
       
        //check to see if stack is empty 
        stack.isEmpty();
        System.out.println("The stack has a total of " + stack.getCount()+ " elements");
        
         //blank line
        System.out.println("__________________________________________________");
        System.out.println("Now the String array will be in reverse ");
        for (int i = 0; i < names.length; i++) {
            
           //print the names
             System.out.println(namesReverse[i]);
             
        }//end for loop
        

    }//end main method

}//end main class
