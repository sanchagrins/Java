/* File:	Employee.java
 * Author:	Stephen
 * Date:	11/15/2016
 * Purpose:	Class file for EmployeeRecord.java
 */


class Employee {

    // Field Declaration
    private int id = 0;
    private String firstName;
    private String lastName;
    private String email;
    public String report;

    // Setter Method for Employee Id
    void setID(int newValue) {
         id = newValue;
    }

    // Setter Method for Employee First Name
    void setFirstName(String newValue) {
         firstName = newValue;
    }

    // Setter Method for Employee Last Name
    void setLastName(String newValue) {
         lastName = newValue;
    }
    
    // Setter Method for Employee Email
    void setEmail(String newValue) {
         email = newValue;
    }

    // Getter Method for Emplyoee Report
    public String showData() {
         String strId = Integer.toString(id);
         report = "Name: " + firstName + " " + lastName + "\n" +
                  "Employee ID: " + strId + "\n" +
                  "Employee EmaiL: " + email + "\n";
         return report;
    }

    // Default Constructor
    public Employee() {
         id = 9999;
         firstName = "John";
         lastName = "Doe";
         email = "doej@company-usa.com";
    }
}
