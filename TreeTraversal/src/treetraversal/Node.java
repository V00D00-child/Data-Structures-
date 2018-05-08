/*This the Node class each Node will have three parts
* 1. The data- for this software the data will be a integer value ranging from 1-1000
* 2. A pointer to the right child
* 3. A poiner to the left child
* The constuctor will only take in the data and will set the left in right child to nll
 */
package treetraversal;

/**
 *
 * @author Idris Bowman
 * last edited 03/14/18
 */
public class Node {
    private int data;
    private Node rightChild; 
    private Node leftChild;

    
    Node(){
        
    }// default constuctor
    
    Node(int data){
        this.data = data;
        this.rightChild = null;
        this.leftChild = null;
        
    }//end Node constuctor

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node right) {
        this.rightChild = right;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node left) {
        this.leftChild = left;
    }

   
   
}//end class node


