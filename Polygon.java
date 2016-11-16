/* File:	Polygon.java
 * Author:	sanchagrins
 * Date:	11/16/2015
 * Purpose:	Class file for TestPolygon.java
 */

class Polygon {
   
   // Field Declaration
   private int numSides;
   private double sideLength;
   private double xCoord;
   private double yCoord;
   private double apothem;
   private double perimeter;

   // No Argument Constructor
   public Polygon(){
       numSides = 4;
       sideLength = 10.0;
       xCoord = 0.0;
       yCoord = 0.0;
       apothem = 5.0;
       perimeter = 20.0;
   }

   // Polygon Constructor
   public Polygon(int sides, double len, double x, double y, double apoth, double per) {
       numSides = sides;
       sideLength = len;
       xCoord = x;
       yCoord = y;
       apothem = apoth;
       perimeter = per;
   }

   // numSides Setter Method
   void setNumSides(int newValue) {
       numSides = newValue;
   }

   // sideLength Setter Method
   void setSideLength(double newValue) {
       sideLength = newValue;
   }

   // xCoord Setter Method
   void setXcoord(double newValue) {
       xCoord = newValue;
   }

   // yCoord Setter Method
   void setYcoord(double newValue) {
       yCoord = newValue;
   }

   // apothem Setter Method
   void setApothem() {
       apothem = sideLength/(2*Math.tan(Math.PI/numSides));
   }

   // numSides getter method
   public int getNumSides() {
       return numSides;
   }

   // sideLength getter method
   public double getSideLength() {
       return sideLength;
   }

   // xCoord getter method
   public double getXcoord() {
       return xCoord;
   }

   // yCoord getter method
   public double getYcoord() {
       return yCoord;
   }

   // perimeter getter method
   public double getPerimeter() {
       perimeter = numSides * sideLength;
       return perimeter;
   }
 
   // Calculate apothem
   public double getApothem() {
       return apothem;
   }

   // Calculates polygon area
   public double getArea() {
       double area = .5 * apothem * perimeter;
       return area;
   }

   // converts/Displays fields as String
   public String toString() {
       String strNumSides = Integer.toString(numSides);
       String strSideLength = Double.toString(sideLength);
       String strXcoord = Double.toString(xCoord);
       String strYcoord = Double.toString(yCoord);
       String strApothem = Double.toString(apothem);
       String strPerimeter = Double.toString(perimeter);

       String convertedFields = "(numSides=" + strNumSides +
                                ", sideLength=" + strSideLength +
                                ", xcoord=" + strXcoord +
                                ", ycoord=" + strYcoord +
                                ", apothem=" + apothem + ")";
       return convertedFields;
    }
}
 
