/* File:	EmployeeRecord.java
 * Author:	Stephen
 * Date:	11/15/2016
 * Purpose:	Provide code for a simple class using
 *		at least one constructor, two methods 
 *		and two fields.
 */

import java.util.*;

class EmployeeRecord {
    public static void main(String[] args) {

       // Local Varaibles
       String firstName;
       String lastName;
       String id;
       String email;
       int num;

       // Read in number of employees to add
       Scanner in = new Scanner(System.in);
       System.out.print("Enter number of employees to add: ");
       num = Integer.parseInt(in.nextLine());

       // Create new employee array
       Employee[] employee = new Employee[num];
       
       // Loops through employee array to gather input for Employee objects
       for (int i=0; i<employee.length;i++) {

          // Creates new Employee Object with default constructor
          employee[i] = new Employee();
          
          // Assigns user input to variables 
          System.out.println("--------Input Employee #" + (i+1) + " Data--------");
          System.out.print("First Name: ");
          firstName = in.nextLine();

          System.out.print("Last Name: ");
          lastName = in.nextLine();

          System.out.print("Email: ");
          email = in.nextLine();
          
          // Sends variables to setter methods
          //employee[i].setID(3802);
          employee[i].setFirstName(firstName);
          employee[i].setLastName(lastName);
          employee[i].setEmail(email);

       }
       
       System.out.println("-----------Emplyoee Report------------");
       // Loops through employee array generate report
       for (int i=0; i<employee.length;i++) {
          System.out.println(employee[i].showData());
       }
    }
}
