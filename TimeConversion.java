package timeconversion;
import java.io.*;
import java.util.*;

public class TimeConversion {

    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in);
        String time = sc.next();
        sc.close();
        char[] timeArray = time.toCharArray(); // Create an array of characters
        int[] intArray = new int[timeArray.length]; // Create an array of integers
        for(i=0;i<10;i++){ // Array length will always be 10
            if(Character.isDigit(time.charAt(i))){ //If element is a digit, add it to the intArray
                int newInt = (int)time.charAt(i); // Cast to an integer
                int numericValue = Character.getNumericValue(newInt); // Get number value from ASCII value
                intArray[i]=numericValue; // Store the value in the intArray
            }
        }
        if(timeArray[8]== 'P' && intArray[0] == 0){ // Check if PM and that time is less than 10
            intArray[1] = 12 + intArray[1]; // Add 12 to the second element in the array           
            }
        else if(timeArray[8] == 'P' && intArray[0] != 0 && intArray[1] != 2){ // Check if it's PM and if it's 10 or 11
            intArray[0]= 1 + intArray[0]; // Add 1 to the first digit to simulate adding 12
            intArray[1]= 2 + intArray[1]; // Add 2 to the second digit to simulate adding 12
        }
        else if(timeArray[8] == 'A' && intArray[0] == 1 && intArray[1] == 2){ // Check if it's 12AM
            intArray[0] = 0; // Change first element to 0, for 24-hour time
            intArray[1] = 0; // Change second element to 0, for 24-hour time
        }
        for(i=0;i<8;i++){
            if(i==2 || i==5){ // Print colon at locations 2 and 5
                System.out.print(":");
            }
            else if(i==0 && intArray[i]==0 && intArray[i+1] > 9){ // Don't print values of a single array element that are greater than 9
                continue;
            }
            
            else{
                System.out.print(intArray[i]); // Print the array values at i
            }
        }
    }
}
