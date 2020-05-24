import java.util.Arrays;
import java.util.Scanner;

// Problem Statement: Given two strings. Write a method to decide if one is a permutation of other.

// Approach : The problem seems to be very tough because of the word permutation, but it is very simple.
// First, input two strings, if one is a permutation of other then their length must be same. 
// After that sort these strings and compare if they are equal.
// If they are equal after sorting then "One is a permutation of other.", otherwise "One is not a permutation of other."
//  ==============================
// | Input:                       |
// |                              |
// | abcd                         |
// | cdab                         |
//  ==============================
//  =================================
// | Output:                         |
// |                                 |
// | One is a permutation of other.  |
//  =================================


public class CheckPermutation
{
  public static boolean checkPermutation(String str1,String str2)
  {   
    if(str1.length() != str2.length())
      return false;
    else
    {
      char stringArray1[] = str1.toCharArray();
      char stringArray2[] = str2.toCharArray();
      Arrays.sort(stringArray1);
      Arrays.sort(stringArray2);
      String str1_1 = new String(stringArray1);
      String str2_2 = new String(stringArray2);
      if(str1_1.equals(str2_2))
        return true;
    }
    return false;
  }
    public static void main(String[] args)
    {
      String str1 = "";
      String str2 = "";
      Scanner input = new Scanner(System.in);
      str1 = input.next();
      str2 = input.next();
      boolean result = checkPermutation(str1,str2);
      if(result)
        System.out.println("One is a permutation of other.");
      else
        System.out.println("One is not a permutation of other.");
    }  
}
