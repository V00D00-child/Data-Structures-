/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityproject;

/**
 *
 * @author Owner
 */
public class Stack {
    
 private int top;
    private int count = 0;
    private String[] dataArray = new String[400];

    public Stack() {
        top = -1;
    }

    public int getCount() {
        return count;
    }
    
    //**************************************************************************
    public boolean isEmpty() {
        
        //check to see if stack is empty
        if (this.top == -1) {
            System.out.println("Stack is empty");
        } 
        return true;
    }//end isEmpty()
    
    //**************************************************************************
    public boolean isFull() {
        
        //check to see if the stack is full
        //the stack is full if the amount of items are greater than the size of the data array
        if (this.top >= dataArray.length -1) {
            System.out.println("Out of Stack space");
        } 
        return false;
    }//end isFull()

    //**************************************************************************
    
    public void push(String newItem) {
        //check to see if stack is full
        if(isFull()){
            System.out.println("Out of Stack space");
            }else{
            //if stack is not full add item to stack 
            this.dataArray[top +1] = newItem;
            
           //print meassage to user to inform them that the item was succefully popped
           System.out.println(newItem + " was added to the stack");             
            //move the top pointer to point to the item that was just pushed
            this.top++;
            this.count ++; //increase the count by 1
        }
        
    }//end push()

    //**************************************************************************
    public String pop() {
        
        //make the vaule equal to the top elments in the stack
        String vaule = this.dataArray[top]; 
        this.top --;//move the top down to the next element
        this.count --;//decrease the count
        
        //print meassage to user to inform them that the item was succefully popped
        System.out.println(vaule + " was removed from the stack"); 
        return vaule;  //return the string vaule that was popped
    }//end pop()
    //**************************************************************************

    public void displayStack() {

       for(int i = this.top; i > -1; i-- ){
           //print stack staring at the top item woring down
            System.out.println(dataArray[i]);           
       }//end for loop

    } // end displayStack()
    
}//end class Stack 
