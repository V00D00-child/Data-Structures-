/*
 * This software was made to test the five common sorts with eachother with 
increasing data sets
 */
package benchmarkingprojectal;

/**
 *
 * @author Idris Bowman
 * Last edited 02/05/18
 */
public class BenchMarkingProjectAl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        int size = 100;//this number to change the size of the data set
        int[] dataSet = new int[size];//array to hold random numbers
        double[] sortTime = new double[100];//array to hold elapsed times in milliseconds
        
        //Test case**************************************
        String sortName = "bubble";
        runSort(dataSet, sortTime, sortName, "bubble.csv");
        displayArray(dataSet,sortTime,sortName);
        
        //Test case**************************************
        String sortName2 = "quick";
        runSort(dataSet, sortTime, sortName2, "quick.csv");
        displayArray(dataSet,sortTime,sortName2);
        
        //Test case**************************************
        String sortName3 = "merge";
        runSort(dataSet, sortTime, sortName3, "merge.csv");
        displayArray(dataSet,sortTime,sortName3);
        
        //Test case**************************************
        String sortName4 = "selection";
        runSort(dataSet, sortTime, sortName4, "selection.csv");
        displayArray(dataSet,sortTime,sortName4);
        
        //Test case**************************************
        String sortName5 = "insertion";
        runSort(dataSet, sortTime, sortName5, "insertion.csv");
        displayArray(dataSet,sortTime,sortName5);

          
    }//end main method
    
 //*****************************************************************************   
    public static void displayArray(int[] dataSet,double[] sortTime,String sortName) {

        //*******test code print array of times to screen *************
         System.out.println("--------------"+sortName+" sort -------");
         for (int i = 0; i < sortTime.length; i++) {
         //random nummber 1-10,000
         System.out.println(dataSet[i]);

         }//end loop
          System.out.println("------------------------------------");
            
    } // end displayArray()
 //*****************************************************************************
    
    public static double calculateTime(long start, long end){
        double duration = (double) (end - start)/ 1000000;
        return duration;
        
    }//end calculateTime()
 //*****************************************************************************
    /* Create a writeCSV method
     * This method writes an duration to a CSV text file, 
     * ,String fileName
     */
    public static void writeCSV(double[] sortTime, String fileName) throws Exception {
        // create a File class object and give the file the name trail-100.csv
        java.io.File trailCSV = new java.io.File(fileName);

        // Create a PrintWriter text output stream and link it to the File  
        java.io.PrintWriter outfile = new java.io.PrintWriter(trailCSV);
        // iterate the elements actually used 
        for (int i = 0; i < sortTime.length; i++) {
            outfile.write(sortTime[i] + "\n");
        } // end for
        outfile.close();

    } // end writeCSV()
    
 //*****************************************************************************
    
     public static void runSort(int[] dataSet,double[] sortTime,String sortName,String fileName) throws Exception{
        int trials = 100;
        
        for (int i = 0; i < dataSet.length; i++) {
         //random nummber 1-10,000
         dataSet[i] = (int) (Math.random() * 100000 + 1);
         }//end loop
       
        //display the list before its sorted
        displayArray(dataSet,sortTime,sortName);


         //crete loop to run 100 trials
         for (int i = 0; i < trials; i++) {

            switch (sortName) {
                case "selection":
                    {
                        // Start timer in nanoseconds
                        long startTimeSelection = System.nanoTime();
                        //Call the Selection Sort method and pass it the data set
                        selectionSortIntegers(dataSet);
                        //Stop the timer and calculate the elapsed time in nanoseconds
                        long endTime = System.nanoTime();
                        sortTime[i] = calculateTime(startTimeSelection,endTime);
                        break;
                    } //end if
                case "bubble":
                {
                    // Start timer in nanoseconds
                    long startTimeBubble = System.nanoTime();
                    //Call the bubble Sort method and pass it the data set
                    bubbleSortIntegers(dataSet);
                    //Stop the timer and calculate the elapsed time in nanoseconds
                    long endTime = System.nanoTime();
                    sortTime[i] = calculateTime(startTimeBubble,endTime);
                        break;
                    } //end if
                case "quick":
                {
                    // Start timer in nanoseconds
                    long startTimeQuick = System.nanoTime();
                    //Call the Quick Sort method and pass it the data set
                    quickSortIntegers(dataSet, 0, dataSet.length - 1);
                    //Stop the timer and calculate the elapsed time in nanoseconds
                    long endTime = System.nanoTime();
                    sortTime[i] = calculateTime(startTimeQuick,endTime);
                        break;
                    } //end if
                case "merge":
                {
                    int[] tempMergeSort = new int[dataSet.length];
                    // Start timer in nanoseconds
                    long startTimeMerge = System.nanoTime();
                    //Call the Merge Sort method and pass it the data set
                    mergeSortIntegers(dataSet, tempMergeSort, 0, (dataSet.length - 1));
                    //Stop the timer and calculate the elapsed time in nanoseconds
                    long endTime = System.nanoTime();
                    sortTime[i] = calculateTime(startTimeMerge,endTime);
                        break;
                    } //end if
                case "insertion":
                {
                    // Start timer in nanoseconds
                    long startTimeInsertion = System.nanoTime();
                    //Call the Selection Sort method and pass it the data set
                    insertionSortIntegers(dataSet);
                    //Stop the timer and calculate the elapsed time in nanoseconds
                    long endTime = System.nanoTime();
                    sortTime[i] = calculateTime(startTimeInsertion,endTime);
                        break;
                    } //end if
            }
         
         }//end loop for test trails

         //writes final elapsed time to a CSV text file
         writeCSV(sortTime,fileName);
         
         //********************************************************************** 
    }//end sortName()
     
     /* Create a bubble sort method
     * 
     * 
     */
    public static int[] bubbleSortIntegers(int[] numbers) {

        boolean swapped; // a boolean variable to keep track of when array values are swapped
        int i; // used as a loop counter
        int temp; // a catalyst variable for swapping values of variables

        do //the post-test loop will repeat another pass through the list when swapped in true
        {
            swapped = false; //will be set to false every time the loop starts

            for (i = 0; i < (numbers.length - 1); i++) // a pass through the array to the second-to-last element
            {
                // if the two items are out of order
                if (numbers[i + 1] < numbers[i]) {
                    // swap the two items and set swapped to true
                    temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    swapped = true;
                } // end if
            } // end for
        } while (swapped); // the outer loop will repeat if swapped is true – another pass

        return numbers;

    }//end bubbleSortIntegers()

//****************************************************************************** 
    /* Create a selection sort method
     * 
     * 
     */
    public static int[] selectionSortIntegers(int[] array) {

        // location in the array where we will insert the minimum from the remainder of the list
        int spot;

        // location of the minimum value in the remainder of the list
        int minimum;

        // a catalyst variable for swapping values of variables
        int temp;
        int i;

        // the outer loop – if the list has n items, we make n passes
        for (spot = 0; spot < array.length; spot++) {

            // find the minimum value in the remainder of the list
            // initialize the minimum to be the first value in the remainder of the list
            minimum = spot;

            // i iterates from spot to the end of the list – one pass
            for (i = spot + 1; i < array.length; i++) {
                if (array[i] < array[minimum]) // location of the minimum so far for this pass through the remainder of the list
                {
                    minimum = i;
                }//end if

            }//end nested for

            //swap the value
            temp = array[spot];
            array[spot] = array[minimum];
            array[minimum] = temp;
        }//end for loop

        return array;
    }//end SelectionSortIntegers()
//******************************************************************************
    /* Create a Insertion sort method
     * 
     * 
     */

    public static void insertionSortIntegers(int[] array) {

        int c;//loop counter

        int value; // the next value from the unsorted list to be inserted into the sorted list 
        int i; // i is a pointer to an item in the sorted list; originally the sorted list is just a[0]

        for (i = 1; i < array.length; i++) //iterate the entire list
        {
            value = array[i]; // the next item from the original list, which will be added to the new list

         // set the pointer to the beginning of the unsorted list. We will work down (left) from here  
            // go from the current item backwards in the array to find where it goes
            while (i > 0 && array[i - 1] > (value)) {

                array[i] = array[i - 1]; //move the current item to the right; this is not the insertion spot yet 
                i--; // go left to the next item in the array
            }//end while loop

            array[i] = value; // insert value in the correct spot.
        }//end loop

    }//end InsertionSort()
//******************************************************************************
     /* Create a quck sort method
     * 
     * 
     */

    // the recursive quicksort method, which calls the partition method
    public static void quickSortIntegers(int[] theArray, int startIndex, int endIndex) {
        int pivotIndex;      // the index of pivot returned by the quicksort partition

        // if the set has more than one element, then partition
        if (startIndex < endIndex) {
            // partition and return the pivotIndex
            pivotIndex = partition(theArray, startIndex, endIndex);
            // quicksort the low set
            quickSortIntegers(theArray, startIndex, pivotIndex - 1);
            // quiclsort the high set
            quickSortIntegers(theArray, pivotIndex + 1, endIndex);
        } // end if
    } // end quickSortIntegers()
    //************************************************************************

    // This method performs quicksort partitioning on theArray set of elements in an array.
    public static int partition(int[] a, int startIndex, int endIndex) {

        int pivotIndex;             // the index of the chosen pivot element
        int pivot;                  // the value of the chosen pivot
        int midIndex = startIndex;  // boundary element between high and low sets

        // select the center element in the set as the pivot by integer averaging
        pivotIndex = (startIndex + endIndex) / 2;
        pivot = a[pivotIndex];

        // put the pivot at the end of the set so it is out of the way
        swap(a, pivotIndex, endIndex);

        // iterate the set, up to but not including last element
        for (int i = startIndex; i < endIndex; i++) {
            // if theArray[i] is less than the pivot
            if (a[i] < pivot) {

                // put theArray[i] in the low half and increment current Index
                swap(a, i, midIndex);
                midIndex = midIndex + 1;
            } // end if
        } // end for 

        // partitioning complete -- move pivot from end to middle
        swap(a, midIndex, endIndex);

        // return index of pivot
        return midIndex;

    } // end partition
    //************************************************************************

    // This method swaps two elements in an integer array
    public static void swap(int[] a, int first, int second) {

        int c;  // theArray catalyst variable used for the swap

        c = a[first];
        a[first] = a[second];
        a[second] = c;

    } // end Swap()
    //************************************************************************

    public static void mergeSortIntegers(int[] a, int[] temp, int low, int high) {
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted

        int mid;  // the middle of the array – last item in low half

        // if high > low then there is more than one item in the list to be sorted
        if (high > low) {

            // split into two halves and mergeSort each part
            // find middle (last element in low half)   
            mid = (low + high) / 2;
            mergeSortIntegers(a, temp, low, mid);
            mergeSortIntegers(a, temp, mid + 1, high);

            // merge the two halves back together, sorting while merging
            merge(a, temp, low, mid, high);
        } // end if 

        return;
    }// end mergerSort()
    //********************************************************************

    /* This method merges the two halves of the set being sorted back together.
     * the low half goes from a[low] to a[mid]
     * the high half goes from a[mid+1] to a[high]
     * (High and low only refer to index numbers, not the values in the array.)
     * 
     * The work of sorting occurs as the two halves are merged back into one 
     * sorted set.
     * 
     * This version of mergesort copies the set to be sorted into the same 
     * locations in a temporary array, then sorts them as it puts them back.
     * Some versions of mergesort sort into the temporary array then copy it back.
     */
    public static void merge(int[] a, int[] temp, int low, int mid, int high) {
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted
        //  mid is the middle of the array – last item in low half

        // copy the two sets from a[] to the same locations in the temporary array
        for (int i = low; i <= high; i++) {
            temp[i] = a[i];
        }

        //set up necessary pointers 
        int lowP = low;         // pointer to current item in low half
        int highP = mid + 1;    // pointer to current item in high half
        int aP = low;           // pointer to where each item will be put back in a[]

        // while the pointers have not yet reached the end of either half
        while ((lowP <= mid) && (highP <= high)) {

            // if current item in low half <= current item in high half 
            if (temp[lowP] <= temp[highP]) {
                // move item at lowP back to array a and increment low pointer
                a[aP] = temp[lowP];
                lowP++;
            } else {
                // move item at highP back to array a and increment high pointer
                a[aP] = temp[highP];
                highP++;
            } // end if..else

            // increment pointer for location in original array
            aP++;
        } // end while

        /* When the while loop is done, either the low half or the high half is done. 
         * We now simply move back everything in the half not yet done.
         * Remember, each half is already in order itself.
         */
        // if lowP has reached end of low half, then low half is done, move rest of high half
        if (lowP > mid) {
            for (int i = highP; i <= high; i++) {
                a[aP] = temp[i];
                aP++;
            } // end for
        } else // high half is done, move rest of low half
        {
            for (int i = lowP; i <= mid; i++) {
                a[aP] = temp[i];
                aP++;
            }// end for
        }
        return;
    } // end merge()
    // *************************************************************
    
}//end main class
