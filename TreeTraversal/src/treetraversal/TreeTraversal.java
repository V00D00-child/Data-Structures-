/*
 * The software creates a binary tree using link list.
 * 
 */
package treetraversal;

/**
 *
 * @author Idris Bowman
 * last edited 03/14/18
 */
public class TreeTraversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BT bt = new BT();// create a binary tree called bt
        int size = 10;//number to change the size of the data set 
        int[] data = new int[size];//array to hold data for the binary tree 
        
        //load random integer 1-100 into the array
        System.out.println("The 10 numbers below will go into the binary tree");
        for (int i = 0; i < data.length; i++) {
         //random nummber 1-1000
         data[i] = (int) (Math.random() * 1000 + 1);
         System.out.println(data[i]); //print numbers
         }//end loop
        
        //load the numbers into the binary tree
        for(int i = 0; i < data.length; i++){
            bt.addNode(data[i]);//add the data to the tree
        }//end for loop
        
//*********Test Traverse's******************************************************
        System.out.println("__________In-Order Traversal_____________________");
        bt.inOrderTraverse(bt.getRoot());
        
        System.out.println("__________Pre-Order Traversal____________________");
        bt.preorderTraverse(bt.getRoot());
        
        System.out.println("__________Post-Order Traversal___________________");
        bt.postOrderTraverse(bt.getRoot());
        
        
//**********Test Search vaule***************************************************
        System.out.println("____________________________________");//blank line
        
        // Search for a value that is not in the tree
        System.out.println("Is the value -1 in the binary tree?");
        bt.searchByValue(-1);
        
       // Search for a value that is in the tree
       System.out.println("Is the value " + data[2] +" in the binary tree??");
        bt.searchByValue(data[2]);

         
 //**********Test Min and Max vaules and height********************************* 
         System.out.println("____________________________________");//blank line

        // Find the height of the tree
        System.out.println("The height of the tree is " + 
                bt.maxHeight(bt.getRoot()));
        
        //Find the total nuber of Nodes in the tree
        System.out.println("Total number of nodes in the binary tree is: "
                + bt.getSize());
        
        //Find the max and min vaule
        System.out.println("The min vaule is: " + bt.findMin(bt.getRoot()));
        System.out.println("The max vaule is: " + bt.findMax(bt.getRoot()));

    }//end main method 

}//end main class
