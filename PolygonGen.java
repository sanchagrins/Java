/* File:	PolygonGen.java
 * Author:	sanchagrins
 * Date:	11/16/2016
 * Purpose:	Tests out Polygon class (Polygon.java)
 */

import java.util.*;

public class PolygonGen {
   public static void main(String[] args) {
      
      // Define Local Variables
      int numSides;
      double sideLength;
      double xCoord;
      double yCoord;
      double apothem;
      double perimeter;
     
      // Create an arrary to store 5 polygon objects
      Polygon[] polygon = new Polygon[2];

      // Create one Polygon Object using the default constructor
      polygon[0] = new Polygon();

      // Create Scanner object for reading input
      Scanner in = new Scanner(System.in);

      // Loop through the remaining 4 polgon objects providing input
      for (int i=1;i<polygon.length;i++) {
        
          // Create polygon object
          polygon[i] = new Polygon();

          // Obtain user input
          System.out.println("Input Regular Polygon #" + i + " Data:");
          System.out.print("\tNumber of Sides: ");
          numSides = Integer.parseInt(in.nextLine());
          polygon[i].setNumSides(numSides);

          System.out.print("\tSide Length: ");
          sideLength = Double.parseDouble(in.nextLine());
          polygon[i].setSideLength(sideLength);
          
          System.out.print("\txCoord: ");
          xCoord = Double.parseDouble(in.nextLine());
          polygon[i].setXcoord(xCoord);

          System.out.print("\tyCoord: ");
          yCoord = Double.parseDouble(in.nextLine());
          polygon[i].setYcoord(yCoord);

          polygon[i].setApothem();
      } // End for
      
      for (int i=0;i<polygon.length;i++) {
          System.out.println("*************************************");
          System.out.println("Polygon #" + (i+1) + " Results:");
          System.out.println("toString() results: " + polygon[i].toString());
          System.out.println("getNumSides() results: " + polygon[i].getNumSides());
          System.out.println("getSideLength() results: " + polygon[i].getSideLength());
          System.out.println("getXCoord() results: " + polygon[i].getXcoord());
          System.out.println("getYCoord() results: " + polygon[i].getYcoord());
          System.out.println("getApothem() results: " + polygon[i].getApothem());
          System.out.println("getPerimeter() results: " + polygon[i].getPerimeter());
      }
   } // End main()

} // End PolygonGen
