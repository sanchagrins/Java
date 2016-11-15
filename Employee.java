class Employee {
    private int id = 0;
    private String firstName;
    private String lastName;
    private String email;
    public String report;

    void setID(int newValue) {
         id = newValue;
    }

    void setFirstName(String newValue) {
         firstName = newValue;
    }

    void setLastName(String newValue) {
         lastName = newValue;
    }

    void setEmail(String newValue) {
         email = newValue;
    }

    public String showData() {
         String strId = Integer.toString(id);
         report = "Name: " + firstName + " " + lastName + "\n" +
                  "Employee ID: " + strId + "\n" +
                  "Employee EmaiL: " + email + "\n";
         return report;
    }
     
    public Employee() {
         id = 9999;
         firstName = "John";
         lastName = "Doe";
         email = "doej@company-usa.com";
    }
}
