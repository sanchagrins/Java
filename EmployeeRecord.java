import java.util.*;

class EmployeeRecord {
    public static void main(String[] args) {
       String firstName;
       String lastName;
       String id;
       String email;
       int num;

       Scanner in = new Scanner(System.in);
       System.out.print("Enter number of employees to add: ");
       num = Integer.parseInt(in.nextLine());

       Employee[] employee = new Employee[num];
       //Employee employee1 = new Employee();
       //System.out.println(employee.length);
       
       for (int i=0; i<employee.length;i++) {
          employee[i] = new Employee();
          
          System.out.println("--------Input Employee #" + (i+1) + " Data--------");

          System.out.print("First Name: ");
          firstName = in.nextLine();

          System.out.print("Last Name: ");
          lastName = in.nextLine();

          System.out.print("Email: ");
          email = in.nextLine();
          
          employee[i].setID(3802);
          employee[i].setFirstName(firstName);
          employee[i].setLastName(lastName);
          employee[i].setEmail(email);

       }
       
//       System.out.println(employee[1].showData());
       for (int i=0; i<employee.length;i++) {
          System.out.println(employee[i].showData());
       }
    }
}
