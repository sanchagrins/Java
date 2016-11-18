/* File:	TestPolygon.java
 * Author:	sanchagrins
 * Date:	11/16/2016
 * Purpose:	Tests out Polygon class (Polygon.java)
 */

import java.util.*;
import java.io.*;

public class PolygonGen {

   public static int getNumSides() {
      int sides;

      try {
        Scanner in = new Scanner(System.in);
        System.out.print("\tNumber of Sides: ");
        sides = in.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid entry. Incorrect data type." +
                           " Please input type integer (Ex: 5)");
        sides = PolygonGen.getNumSides();
      }
      return sides;
   } // End getNumSides

   public static double getSideLength() {
      double length;

      try {
        Scanner in = new Scanner(System.in);
        System.out.print("\tSide Length: ");
        length = in.nextDouble();
      } catch (InputMismatchException e) {
        System.out.println("Invalid entry. Incorrect data type." +
                           " Please input type double (Ex: 0.0)");
        length = PolygonGen.getSideLength();
      }
      return length;
   } // End getLength

   public static double getX() {
      double x;

      try {
        Scanner in = new Scanner(System.in);
        System.out.print("\txCoord: ");
        x = in.nextDouble();
      } catch (InputMismatchException e) {
        System.out.println("Invalid entry. Incorrect data type." +
                           " Please input type double (Ex: 0.0)");
        x = PolygonGen.getX();
      }
      return x;
   } // End getX

   public static double getY() {
      double y;

      try {
        Scanner in = new Scanner(System.in);
        System.out.print("\tyCoord: ");
        y = in.nextDouble();
      } catch (InputMismatchException e) {
        System.out.println("Invalid entry. Incorrect data type." +
                           " Please input type double (Ex: 0.0)");
        y = PolygonGen.getY();
      }
      return y;
   } // End getY()

   public static void main(String[] args) {
      
      // Define Local Variables
      int numSides;
      double sideLength;
      double xCoord;
      double yCoord;
      double apothem;
      double perimeter;
     
      // Create an arrary to store 5 polygon objects
      Polygon[] polygon = new Polygon[5];

      // Create one Polygon Object using the default constructor
      polygon[0] = new Polygon();

      // Create Scanner object for reading input
      Scanner in = new Scanner(System.in);
      System.out.println("Regular Polygon #1 Data: Atuomatically generated " + 
                         "with the default constructor.");

      // Loop through the remaining 4 polgon objects providing input
      for (int i=1;i<polygon.length;i++) {
        
          // Create polygon object
          polygon[i] = new Polygon();

          // Obtain user input
          System.out.println("Regular Polygon #" + (i+1) + " Data:");
          
          numSides = PolygonGen.getNumSides();
          polygon[i].setNumSides(numSides);

          sideLength = PolygonGen.getSideLength();
          polygon[i].setSideLength(sideLength);
          
          xCoord = PolygonGen.getX();
          polygon[i].setXcoord(xCoord);

          yCoord = PolygonGen.getY();
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
          System.out.println("getArea() results: " + polygon[i].getArea());
      }
   } // End main()

} // End PolygonGen
