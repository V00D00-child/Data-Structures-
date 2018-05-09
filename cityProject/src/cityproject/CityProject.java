/* CityProject.java  -- project class file with the project's main method   
 *  
 * This software package creates a graph of cities in the Unitied States with
 * links between the cities. Each city is a vertex in the graph.
 * Each link between cities is an edge in the graph.   The data for the cities and
 * links are read into arrays from data files, which should be in the project folder.
 * The files are CSV files, which can be read and edited in Excel.
 *
 * The main class for the project is the CityProject class.   Other class include:
 * 
 *   Vertex - clas for each Vertex in a graph.
 *   City extends Vertex - Each City is a Vertex with added properties.  Each City
 *      has a unique name, and X and Y cooordinates for location on a 1500 by 900 Canvas.
 *   Edge - an edge in the graph, with a source, destination, and length.
 *   AjacencyNode - a node for a linked list of cities directly connected to each City.
 *      Each City has a linked list of adjacnt cities, created from the info in the 
 *      data files, with destination City and distance data in the node, and a 
 *      link to the next node. 
 *   CityMap - extends Canvas, a map of the graph on a 1500 by 900 GUI Canvas.
 *      A CityMap object in instantiated in the drawMap method in the CityProject class.
 * 
 * The main method in the CityProject class calls methods to reads City and Edge 
 * data from data files into arrays, set up the adjacency list in each instance 
 * of City, print a list of Vertex cities and their Edges, then draw a map of the graph.
 *
 * created for use by students in CSCI 211 at Community Colle of Philadelphia
 * copyright 2014 by C. herbert.  last edited Nov. 23, 2014 by C. Herbert
 */
package cityproject;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class CityProject {

    // main metod for the project
    public static void main(String[] args) {
        // Opening message for user
        JOptionPane.showMessageDialog(null, "This software package creates a "
                + "graph of cities in the Unitied States with\n"
                + "links between the cities..\nPlease enter two cities to find the shortest path between them!");

        City[] cities = new City[200]; //array of cities (Vertices) max = 200
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new City();
        }

        Edge[] links = new Edge[2000];// array of links  (Edges)  max = 2000
        for (int i = 0; i < links.length; i++) {
            links[i] = new Edge();
        }

        int cityCount; //    actual number of cities
        int linkCount; //    actual number of links

        // load cities into an array from a datafile
        cityCount = readCities(cities);

        // load links into an array from a datafile
        linkCount = readLinks(links, cities);

        // create the adjacency list for each city based on the link array
        createAdjacencyLists(cityCount, cities, linkCount, links);

        // print adjacency lists for all cities
        PrintAdjacencyLists(cityCount, cities);
        // draw a map of the cities and links
        drawMap(cityCount, cities, linkCount, links);

//************************************************************************ 
        //print blank line
        System.out.println("____________________________________________________");

        //Gets the source and destination  from the user
        String citySource = getInput("s");
        String cityDestination  = getInput("d");

        //set the source and destination
        City soure = findCityByName(citySource, cities, cityCount,"s");
        City destination = findCityByName(cityDestination, cities, cityCount,"d");

        //Run dijkstraAlgorithm
        dijkstraAlgorithm(soure,cities, cityCount);

        //add to the reults to a stack a
        addToStack(destination, soure, citySource, cityDestination);
    } // end main
//************************************************************************ 

    /*
     method to get user input
     */
    public static String getInput(String option) {
        Scanner sc = new Scanner(System.in);//create scanner
        String userSource;

        if(option.equals("s")){
            // get the user’s source cities with an input dialog window 
        userSource = JOptionPane.showInputDialog("Please enter a source city followed by the state initials");
        }else{
          // get the user’s destination cities with an input dialog window 
        userSource = JOptionPane.showInputDialog("Please enter a destination city followed by the state initials");  
        }
        

        return userSource;

    }//end getInput()
//************************************************************************
    /*
     This method takes the reults form dijkstraAlgorithm and pushs and pop the 
     results
     */

    public static void addToStack(City destination, City soure, String citySource, String cityDestionation) {

        int stackCount = 0;//this will keep count of the number of elements in the stack

        //create the stack
        Stack stack = new Stack();

        //check to see if stack is empty 
        stack.isEmpty();

        /*
         start at the destination city and add each ImmediatePredecessor to stack 
         until you reach the source city
         */
        while (destination.getImmediatePredecessor() != soure) {

            //add the data to the stack
            stack.push(destination.getImmediatePredecessor().getName());

            //update the ImmediatePredecessor
            destination = destination.getImmediatePredecessor();

            stackCount++;//incrrese the stack count

        }//end loop

        //print blank line
        System.out.println("____________________________________________________");

        /*
         create array to hold the names the route cities  when they are popped of
         the stack
         */
        String[] route = new String[stackCount];

        //remove all the items from the stack and load into the new array
        for (int i = 0; i < stackCount; i++) {

            route[i] = stack.pop();

        }//end for loop

        //print blank line
        System.out.println("____________________________________________________");

        //print results for which cities to go to 
        System.out.println("To get from " + citySource + " to " + cityDestionation);
        for (int i = 0; i < stackCount; i++) {

            //print the names
            System.out.println("Go to : " + route[i] + " then....");

        }//end for loop

        System.out.println("Finally go to " + cityDestionation + "\n" + "Congrats you have arrived");
        
        //  message for user
        JOptionPane.showMessageDialog(null, "Results are in the output window");

    }//end addToStack()
    //************************************************************************
/*
     This method takes the name of a city given by the user 
     and matches it the the city in the cities array if the city
     the user enters in not in the array let the user know 
     */

    public static City findCityByName(String cityName, City[] cities, int cityCount,String option) {

        City target = null;//the city that we want to match to the user input
        boolean found = false;//flag to end loop

        while (!found) {
            //set the cityName equal to the target city 
            for (int i = 0; i < cityCount; i++) {

                if (cities[i].getName().equals(cityName)) {
                    target = cities[i];
                    found = true;

                }//end if

            }//end loop
            if (!found) {
            // error message dialog box with custom title and the error icon
                JOptionPane.showMessageDialog(null, "The city " + cityName + " is not in the list"
                        + "of cities. Please try again",
                        "City not found Warning", JOptionPane.ERROR_MESSAGE);
                
               //print message to screen
                System.out.println("The city " + cityName + " is not in the list"
                        + "of cities. Please try again");

                cityName = getInput(option);//get input again
            }//end if
        }//end outter loop

        return target;//return the target city

    }//end findCityByName()

//************************************************************************
    public static void dijkstraAlgorithm(City soure, City[] cities, int visitCount) {

        City currentCity = soure;   //set current city equal to the soure city
        int uCount = visitCount;    // this will count the cities in the set U

        //set the bestDistance of the source city to zero
        currentCity.setBestDistance(0);
        currentCity.setImmediatePredecessor(soure);

        /*
         loop to start dijkstraAlgorithm
         If the set U(set of unvisted cites) is not empty keep the loop going 
         */
        while (uCount != 0) {
            /*commented out test case
             //test to make sure currentCity is update each time through the loop   
             //System.out.println("This is the new min city" + currentCity.toString());//new current
             */

            //make djacencyNode equalthe head of the AdjacencyNode list for the current city
            AdjacencyNode currentAj = currentCity.getAdjacencyListHead();

            //loop through the AdjacencyNode list for the currentCity
            while (currentAj != null) {

                //make varaible to hold newBestDistance 
                int newBestDistance = currentCity.getBestDistance()
                        + currentAj.getcDistance();

                /*
                 check to see if there is a shortest path between currentCity
                 and each AdjacencyNode. If there is update the AdjacencyNode city best 
                 distacance to the new distance and set the currentCity as
                 the ImmediatePredecessor for the currentAj city.
                
                 */
                if (newBestDistance < currentAj.getCity().getBestDistance()) {

                    //update the best distance of the currentAj city
                    currentAj.getCity().setBestDistance(newBestDistance);

                    //make currentCity the ImmediatePredecessor to the currentAj city
                    currentAj.getCity().setImmediatePredecessor(currentCity);

                }//end if newBestDistance

                //updae the AdjacencyNode to the next node in the Adjacency list
                currentAj = currentAj.getNext();

            }//end loop through the current city Adjacency list

            //mark currrentCity as visted
            currentCity.setVisited(true);

            //update visitCount
            uCount--;

            /*
             Update the current city to be the city in U(unvisted cities) 
             with the shortest bestDistance
             */
            currentCity = findMinBDCity(visitCount, cities);

        }//end outter loop to start dijkstraAlgorithm

    }//end dijkstraAlgorithm()

//*******************************************************************************
    /*
     This method finds the city in U(unvisited  cities) 
     with the shortest bestDistance
     */
    public static City findMinBDCity(int visitCount, City[] cities) {

        //This will the city in U with shortest bestDistance
        City minDistanceCity = null;

        int cityMin = -1;

        //loop through the cities
        for (int i = 0; i < visitCount; i++) {

            //find city with smallest bestDistance thats in U(unvisted cities)
            if ((cities[i].getVisited() == false) && ((cityMin == -1)
                    || (cities[i].getBestDistance() < cities[cityMin].getBestDistance()))) {

                //update the min
                cityMin = i;

                //set the current city to equal the minDistanceCity
                minDistanceCity = cities[cityMin];

            }//end if the find all unvisted cities
        }//end loop through the cities

        return minDistanceCity;

    }//end findMinBDCity()

    //**************************************************************************
    // method to read city data into an array from a data file
    public static int readCities(City[] cities) {

        int count = 0; // number of cities[] elements with data

        String[][] cityData = new String[123][3]; // holds data from the city file
        String delimiter = ",";                   // the delimiter in a csv file
        String line;                              // a String to hold each line from the file

        String fileName = "cities.csv";           // the file to be opened  

        try {
            // Create a Scanner to read the input from a file
            Scanner infile = new Scanner(new File(fileName));

            /* This while loop reads lines of text into an array. it uses a Scanner class 
             * boolean function hasNextLine() to see if there is another line in the file.
             */
            while (infile.hasNextLine()) {
                // read the line 
                line = infile.nextLine();

                // split the line into separate objects and store them in a row in the array
                cityData[count] = line.split(delimiter);

                // read data from the 2D array into an array of City objects
                cities[count].setName(cityData[count][0]);
                cities[count].setX(Integer.parseInt(cityData[count][1]));
                cities[count].setY(Integer.parseInt(cityData[count][2]));

                count++;
            }// end while

            infile.close();

        } catch (IOException e) {
            // error message dialog box with custom title and the error icon
            JOptionPane.showMessageDialog(null, "File I/O error:" + fileName, "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;

    } // end loadCities()
    //*************************************************************************

    // method to read link data into an array from a data file
    public static int readLinks(Edge[] links, City[] cities) {
        int count = 0; // number of links[] elements with data

        String[][] CityLinkArray = new String[695][3]; // holds data from the link file
        String delimiter = ",";                       // the delimiter in a csv file
        String line;				      // a String to hold each line from the file

        String fileName = "links.csv";                // the file to be opened  

        try {
            // Create a Scanner to read the input from a file
            Scanner infile = new Scanner(new File(fileName));

            /* This while loop reads lines of text into an array. it uses a Scanner class 
             * boolean function hasNextLine() to see if there another line in the file.
             */
            while (infile.hasNextLine()) {
                // read the line 
                line = infile.nextLine();

                // split the line into separate objects and store them in a row in the array
                CityLinkArray[count] = line.split(delimiter);

                // read link data from the 2D array into an array of Edge objects
                // set source to vertex with city name in source column
                links[count].setSource(findCity(cities, CityLinkArray[count][0]));
                // set destination to vertex with city name in destination column
                links[count].setDestination(findCity(cities, CityLinkArray[count][1]));
                //set length to integer valuein length column
                links[count].setLength(Integer.parseInt(CityLinkArray[count][2]));

                count++;

            }// end while

        } catch (IOException e) {
            // error message dialog box with custom title and the error icon
            JOptionPane.showMessageDialog(null, "File I/O error:" + fileName, "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;
    } // end loadLinks()
    //*************************************************************************

    // method to find the City onject with the given city name
    public static City findCity(City[] cities, String n) {
        int index = 0;  // loop counter
        // go through the cities array until the name is found
        // the name will be in the list

        while (cities[index].getName().compareTo(n) != 0) {

            index++;
        }// end while()
        return cities[index];

    } // end  findCity()

// method to create an adjacency lists for each city
    public static void createAdjacencyLists(int cityCount, City[] cities, int linkCount, Edge[] links) {

        AdjacencyNode temp = new AdjacencyNode();

        // iterate city array
        for (int i = 0; i < cityCount; i++) {

            //iterate link array
            for (int j = 0; j < linkCount; j++) {
                // if the currentl link's source is the current city
                if (links[j].getSource() == cities[i]) {

                    /* create a node for the link and inseert it into the adjancency list
                     * as the new head of the list. 
                     */
                    // temporarily store the current value of the list's head
                    temp = cities[i].getAdjacencyListHead();
                    //create a new node
                    AdjacencyNode newNode = new AdjacencyNode();
                    // add city and distance data
                    newNode.setCity(links[j].getDestination());
                    newNode.setDistance(links[j].getLength());
                    // point newNode to the previous list head
                    newNode.setNext(temp);

                    // set the new head of the list to newNode
                    cities[i].setAdjacencyListHead(newNode);

                }  // end if
            } // end for j
        } // end for i

    } // end createAdjacencyLists()

    // method to print adjacency lists
    public static void PrintAdjacencyLists(int cityCount, City[] cities) {

        System.out.println("List of Edges in the Graph of Cities by Source City");
        // iterate array of cities
        for (int i = 0; i < cityCount; i++) {

            // set current to adjacency list for this city    
            AdjacencyNode current = cities[i].getAdjacencyListHead();

            // print city name
            System.out.println("\nFrom " + cities[i].getName());

            // iterate adjacency list and print each node's data
            while (current != null) {
                System.out.println("\t" + current.toString());
                current = current.getNext();
            } // end while (current != null) 

        }   // end for i 

    } // end PrintAdjacencyLists()

    // method to draw the graph (map of cities and links)
    static void drawMap(int cCount, City[] c, int lCount, Edge[] l) {
        CityMap canvas1 = new CityMap(cCount, c, lCount, l);

        int width = 1500; // width of the Canvas
        int height = 900; // heightof the Canvas 

        // set up a JFrame to hold the canvas
        JFrame frame = new JFrame();
        frame.setTitle("U.S. Cities");
        frame.setSize(width, height);
        frame.setLocation(10, 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the canvas to the frame as a content panel
        frame.getContentPane().add(canvas1);
        frame.setVisible(true);

    } // end drawMap() 

} // end class cityProject
