import java.util.Scanner;

// Problem Statement: Write a method to replace all spaces in a string with "%20". You may assume that the string has sufficient
// space at the end to hold the additional characters, and that you are given the true length of the string. 
// ( Note: if implementing in Java, please use a character array so that you can perform this operation in place).

// Here, we aren't using character array, we are using pre-defined functions implemented in Java.

//  ==============================
// | Input:                       |
// |                              |
// | Mr John Smith                |
// | 13                           |
//  ==============================
//  =================================
// | Output:                         |
// |                                 |
// | Mr%20John%20Smith               |    
//  =================================


class Urlify 
{ 
    public static void main(String[] args)  
    { 
        
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int trueLength = scan.nextInt();
          
        // Trim the given string, it removes all spaces from the beginning and end of a string.
        str = str.trim(); 
          
        // Replace All space (unicode is \\s) to %20, which will give us the required string.
        str = str.replaceAll("\\s", "%20");
        
        System.out.println(str); 
    } 
} 



// Also, we can implement the same using character array also which is actually asked in the problem.

public static String Urilfy(String input, int trueLength) {
    if(input == null || input == ") {
       
       input = input.substring(0, trueLength);
       String replacement = "%20";
       StringBuilder builder = new StringBuilder();
       char[] charArray = input.toCharArray();
       
       for (char c: charArray) {
           if(c != " ") {
               builder.append(c);
           }
           else {
               builder.append(replacement);
           }
       }
       
    }       
}
       
       

