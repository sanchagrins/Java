/* File:	FromLoop.java
 * Author:	Stephen
 * Date:	11/09/2016
 * Purpose:	Adaptation of Coursera exercise for Python.
 * 		Reads through a file and finds all lines that
 *              start with "From :" and extracts/stores
 *              unique email addresses using Regular Expressions.
 */

import java.io.*;  // Imports BufferReader and FileReader classes
import java.util.regex.*;  // Imports Pattern and Matcher classes
import java.util.*;  // Imports for ArraryList and HashSet

public class FromLoop {
    public static void main(String[] args) throws java.io.IOException {

      //  Declare Local Variables
      int count = 0;
      int emailNum;
      String line;
      String pattern = "\\S+@\\S+";

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Create List Container to store emails 
      ArrayList<String> l = new ArrayList<String>();
      
      //  Read in the file
      FileReader in = new FileReader("mbox-short.txt");
      BufferedReader br = new BufferedReader(in);

      //  Loops through file line by line
      while ((line = br.readLine()) != null) {
 
            //  Extracts lines that start with "From: "
            if (line.startsWith("From: ")) {
               // Creates Regular Expression Matcher
               Matcher m = r.matcher(line); 

               // Searches line for Regular Expression
               if (m.find()) {
                  l.add(m.group(0));  //  Adds email to list
               }  // End if
            }  // End if
            count++;
      }  // End While
      
      // Removes duplicates from list by creating a new HashSet
      ArrayList<String> newList = new ArrayList<String>(new HashSet<String>(l));

      // Reports number of emails found
      emailNum = newList.size();
      System.out.println("-----Unique Emails-----");
      newList.forEach(System.out::println);
      System.out.println("-----------------------");
      System.out.println(emailNum + " unique emails found in " + count + " lines.");
    }  // End Main
}  //  End FromLoop

