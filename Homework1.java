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
         System.out.println("Enter your age (0-120): ");
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

    public static void main(String[] args) {  // Begin main method
        System.out.println("Welcome to the Student Survey");
        int emplidChk = Homework1.getEmplid();
        double quiz1 = Homework1.getQuiz();
        double quiz2 = Homework1.getQuiz();

        System.out.println("Student EMPLID: " + emplidChk);
        System.out.println("Quiz 1 Score:: " + quiz1);
        System.out.println("Quiz 2 Score:: " + quiz2);
    }  // End main
}  // End Homework1
