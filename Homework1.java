/* File:	Homework1.java
 * Author:	Stephen Sanchagrin
 * Date:	10/25/2016
 * Purpose:	Demonstrate objectives learned in Week 2
 */

// Import required Java classes
import java.io.*;
import java.util.*;

public class Homework1 {
    public static int getEmplid () {  // Obtains/error checks EMPLID
       int emplid = 0;

       try {  // try/catch to verify correct data type
         Scanner scannerIn = new Scanner(System.in);       
         System.out.print("Enter your Student EMPLID (0-999999): ");
         emplid = scannerIn.nextInt();
       } catch (InputMismatchException e) {
         System.out.println("Invalid entry. Incorrect data type.");
         emplid = Homework1.getEmplid();
       }  // End try/catch

       if ((emplid >= 0) && (emplid <= 999999)) {  // Verifies correct EMPLID range
          return emplid;
       } else {
          System.out.println("EMPLID out of range (0-999999).");
          System.exit(0);
       }  // End if

       return emplid;
    }  // End getEmplid

    public static double getQuiz() {  // Obtains/Error Checks Quiz Grade
       double quizGrade = 0.0;

       try {  // try/catch to verify correct data type
         Scanner scannerIn = new Scanner(System.in);
         System.out.print("Enter your Quiz 1 percentage score (0.0-100.0): ");
         quizGrade = scannerIn.nextDouble();
       } catch (InputMismatchException e) {
         System.out.println("Invalid entry. Incorrect data type");
         quizGrade = Homework1.getQuiz();
       }  // End try/catch
       
       if ((quizGrade >= 0.0) && (quizGrade <= 100.0)) {  // Verifies correct quize range
         return quizGrade;
       } else {
         System.out.println("Quiz percentage is out of range (0.0-100.0)");
         System.exit(0);
       }  // End if/else
       return quizGrade;
    }  // End getQuiz

    public static int getAge() {  // Obtains/Error Checks Age
       int userAge = 0;
       
       try {  // try/catch to verify correct data type
         Scanner scannerIn = new Scanner(System.in);
         System.out.print("Enter your age (0-120): ");
         userAge = scannerIn.nextInt();
       } catch (InputMismatchException e) {
         System.out.println("Invalid entry. Incorrect data type.");
         userAge = Homework1.getAge();
       }  // End try/catch
       
       if ((userAge >= 0) && (userAge <= 120)) {  // Verifies correct age range
         return userAge;
       } else {
         System.out.println("Age is out of range (0-120)");
         System.exit(0);
       }  // End if/else
       return userAge;
    }  // End getAge
    
    public static double getTemp() {  // OBtains/Error Checks Age
       double temp = 0.0;
       final double COLDEST_TEMP = -128.6;  // Coldest Temperature recorded on Earth
       final double HOTTEST_TEMP = 134.1;  // Highest recorded tempurature on Earth
       
       try {  // try/catch to verify correct data type
         Scanner scannerIn = new Scanner(System.in);
         System.out.print("Enter current temperature in Fahrenheit (32.0): ");
         temp = scannerIn.nextDouble();
       } catch (InputMismatchException e) {
         System.out.println("Invalid entry. Incorrect data type.");
         temp = Homework1.getTemp();
       }  // End try/catch
       
       if ((temp > COLDEST_TEMP) && (temp < HOTTEST_TEMP)) {  // Verrifies correct temp range
         double tempC = tempConv(temp);
         return tempC;
       } else {
         System.out.println("Temperature is out of range for recorded temperatures on earth.");
         System.exit(0);
       }  // End if/else
       return temp;
    }  // End getTemp

    public static double tempConv (double tempF) {  // Converts Farenheit to Celsius
       double tempC = 0.0; 
       tempC = ((tempF-32.0)*(.5556));
       return tempC;
    }

    public static void main(String[] args) {  // Begin main method
        System.out.println("Welcome to the Student Survey");
        int emplidChk = Homework1.getEmplid();
        double quiz1 = Homework1.getQuiz();
        double quiz2 = Homework1.getQuiz();
        int age = Homework1.getAge();
        double tempConverted = Homework1.getTemp();

        System.out.println("Thank you for completing our survey.\n");
        System.out.println("\n***************************************");
        System.out.println("*            Survey Results           *");
        System.out.println("***************************************");
        System.out.println("Student EMPLID: " + emplidChk);
        System.out.println("Quiz 1 Score: " + quiz1);
        System.out.println("Quiz 2 Score: " + quiz2);
        System.out.println("Age: " + age);
        System.out.println("Temperature in F: " + tempConverted);
        System.out.println("***************************************");
    }  // End main
}  // End Homework1
