/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package averagebestworst;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class AverageBestWorst {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        double[] data = new double[100];
        double average = 0;               //average test score
        double max = 0;                   //maximum test score
        double min = 0;                   //minimum test score
        
        load(data);
        print(data);
        calculateAvergae(data);
        calculateMin(data);
        calculateMax(data);
        //PrintResults(average,max,min,data);
        
    }//end 
    
    public static double[] load(double[] array) throws FileNotFoundException{
        int i; // a loop counter
        
        // declare temporary variables to hold BoardSquare properties read from a file
        double data;    
        
        // Create a File class object linked to the name of the file to be read
        java.io.File squareFile = new java.io.File("quick.csv");

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(squareFile);

        
        /* This loop reads data into the square array.
         * Each item of data is a separate line in the file.
         * There are 40 sets of data for the 40 squares.
         */
        for( i=0; i<100; i++)
        {
            // read data from the file into temporary variables
            // read Strings directly; parse integers
            data  = infile.nextDouble();
            
            // intialze each square with the BoardSquare constructor
            array[i] =data ;
            
        } // end for
        infile.close();  
        
        return array;
    }//end laod
//**********************************************************************    
   public static double calculateAvergae(double[] array)
{
   double average;    //average of scores
    double sum =0;     //sum of all scores
   
   //loop to calculate sum
   for(int i=0; i< array.length; i++)
       {
        //add each array to the sum   
        sum = sum + array[i];  
        
       }//end loop to calculate sum
    
   // calculates the average array
    average = sum/array.length;
    System.out.println("this is the average: " + average);
   return average;
   
}//end calculateAvergae
//*****************************************************************************
public static double calculateMax(double[] array)
{
    double max = array[0];  //maximum array
    
    // loop to calculates the maximum array  
    for (int i= 1; i< array.length;i++)
    {
      if (array[i] > max)
      max = array[i];
       
    }
         System.out.println("this is the worst case: " + max);

    return max;
    
}// end calculateMax
//******************************************************************************
public static double calculateMin(double[] array)
{
    double min = array[0];   //minimun array 
    
    // loop to calculates the minimum array 
    for (int i= 1; i< array.length;i++)
    {
         if (array[i] < min)
         
         min = array[i];
       
    }
        System.out.println("this is the best case: " + min);

     
    return min;
} // end calculateMin

public static void PrintResults(double average, double max, double min, double array[])
{
    //print maximum score
    System.out.println("Your max is: "+ max);
    
    //print minimum score
    System.out.println("Your lowest is: "+ min);
    
    //pritn average score
    System.out.println("Your average is: "+ average);
    
    
}//end printRestlyt

public static void print(double[]array){
    for (int i= 1; i< array.length;i++)
    {
      System.out.print(array[i] + "\n");
       
    }
}//end print



    
}//end main class
