/*
 * This is the binary tree class
* This class has a root Node, height, and size property
* It has a method to add Nodes to the Tree object, method to 
* Traverse the tree, and a method to fibd the min and max vaule in the tree.
 */
package treetraversal;

/**
 *
 * @author Idris Bowman
 * last edited 03/14/18
 */
public class BT {
    private Node root; //The first Node in the binary tree 
    private int height; // The height of the tree
    private int size = 0; //The total number of Nodes in the binary tree
    
    
     BT(){
         this.root = null;
        
    }// default constuctor

    public Node getRoot() {
        return root;
    }//end getRoot()

    public int getHeight() {
        return height;
    }// end getHeight()

    public int getSize() {
        return size;
    }// end getSize()
    
//******************************************************************************    
     public void addNode(int value){
         // Create a new Node and initialize it
        Node newNode = new Node(value);
         // If there is no root this becomes root
         if (root == null) {
            root = newNode;
            this.size ++;
         }else{
             // Set root as the Node we will start
            // with as we traverse the tree
             Node focusNode = root;

            Node parent; //Future parent for our new Node
            
            while(true){
               // root is the top parent so we start there
               parent = focusNode;
                
                // Check if the new node should go on
                // the left side of the parent node
                    if (value < focusNode.getData()) {
                       // Switch focus to the left child
                    focusNode = focusNode.getLeftChild();
 
                    // If the left child has no children
                    if (focusNode == null){
                        // then place the new node on the left of it
                        parent.setLeftChild(newNode);
                        this.size ++; //add to the total number of nodes in tree
                        return; // All Done

                    }//end nested if
                    }else{// If we get here put the node on the right
                        focusNode = focusNode.getRightChild();

                    // If the right child has no children
                      if (focusNode == null) {
 
                        // then place the new node on the right of it
                        parent.setRightChild(newNode);
                        this.size ++; //add to the total number of nodes in tree
                        return; // All Done

                        
                    }//end nested if
                
            }//end else
         }//end while loop
            
         }//end outter else
         
         
     }//end addNode()
//******************************************************************************
     
  public void inOrderTraverse(Node current) {

        if (current != null) {
            // Traverse the left child
            inOrderTraverse(current.getLeftChild());
            // Visit the current node and print the data
            System.out.println(current.getData());
            // Traverse the right child
            inOrderTraverse(current.getRightChild());
 
        }//end if 
    }//end inOrderTraverseTree()
  //****************************************************************************
    public void preorderTraverse(Node current) {

        if (current != null) {

            // Visit the current node and print the data
            System.out.println(current.getData());
             // Traverse the left child
            preorderTraverse(current.getLeftChild());
             // Traverse the right child
            preorderTraverse(current.getRightChild());

        }//end if 

    }//end preorderTraverseTree()
 //*****************************************************************************       
   public void postOrderTraverse(Node current) {

        if (current != null) {

             // Traverse the left child
            postOrderTraverse(current.getLeftChild());
             // Traverse the right child
            postOrderTraverse(current.getRightChild());
            // Visit the current node and print the data
            System.out.println(current.getData());
   }//end if 

    }//end postOrderTraverseTree()    
//****************************************************************************** 
   public Node searchByValue(int value){
       //start at the top of the tree
       Node current = root;
       
       // while current number not equal to the search value
       while(current.getData() != value ){
           
           // start search on left side of tree
           if(value < current.getData()){

               current = current.getLeftChild();   
           }else{
           //search on right side of tree
               current = current.getRightChild();   
           }//end else
           
           //if we visit every Node and the vaule does not match the vaule is 
           // not in the tree
           if(current == null){
               //print a message if vaule is not found
               System.out.println("The key value " + value 
                       + " was not found in the tree");
               return null;
           }//end if
           
       }//end while loop
       
       //print a message if vaule is found
               System.out.println("The key value " + value 
                       + " was found in the tree");
               
       return current;//return the node if found  
   } //end searchByValue()
//******************************************************************************
   public int maxHeight(Node root){
       //using recursion
       //exit condtion if tree is empty return -1
       if(root == null)
           return -1;
       
       //calculates the height of left and right subTree
      int leftHeight = maxHeight(root.getLeftChild());
      int rightHeight = maxHeight(root.getRightChild()); 

      this.height = Math.max(leftHeight,rightHeight) + 1; //set the height 
      
      //return the height
      return Math.max(leftHeight,rightHeight) + 1; 
      
   }//end maxHeight()
//******************************************************************************
public int findMin(Node root){
    //if the tree is empty
    if(root == null){
        System.out.println("Tree is empty");
           return -1;
    }//end if
    
    Node current = root;//make temp Node 
    
    //make a loop that goes until the left subtree has no
    //leftChild
    while(current.getLeftChild() != null){
        
    current = current.getLeftChild();
    }//end while loop
    
    return current.getData(); //return the min vaule
}//end findMin()

//******************************************************************************
public int findMax(Node root){
    //if the tree is empty
    if(root == null){
        System.out.println("Tree is empty");
           return -1;
    }//end if
    
    Node current = root;//make temp Node 
    
    //make a loop that goes until the left subtree has no
    //leftChild
    while(current.getRightChild() != null){
        
    current = current.getRightChild();
    }//end while loop
    
    return current.getData(); //return the min vaule
}//end findMax()
 
}// end class bt

