import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;



/** ***************************************************
 *  Name:           Abhi
 *  Class:          CS30S
 * 
 *  Assignment:     A1 Q5
 * 
 *  Description:    Generating 1000 random number that are less than 50. Using
 *                  these numbers to see the frequency and other features. Sorting
 *                  from greatest to lowest and vice versa.
 * 
 *************************************************************/

public class Frequency {

    public static void main(String[] args) throws IOException{
        // ***** constants *******

        // ***** variables *****

        String banner = "";             // output banner
        String prompt = "";             // prompt for user input

        String strin = "";              // string fro keyboard input
        String strout = "";             // string for formatted output

        String delim = "[ ]+";          // delimiter for splitting input records
        String[] tokens = null;         // used to split input records

        // a new line character that works on every computer system
        String nl = System.lineSeparator();
        BufferedReader fin = null;  // declare the file input variable

        
        String input1 = ""; // to see if input is "greatest" or "least"
        int input2 = 0; // to see range of frequency
        int input = 0;  // general input
        int n = 0;  // using as index
        int store = 0;  // store
        int location = 0;   // to get frequency index 
        int counter = 0;    // universal use in this program
        int limit = 51;
        
        // arrays
        int[] frequencyIndex2 = new int[limit]; // for flipped frequency index
        int[] frequencyIndex = new int[limit];  // normal frequency index
        
        int[] list2 = new int[limit];   // list with all numbers
        
        int[] sort = new int[limit];    // sorted from greatest to least
        // ***** objects *****

        Scanner scanner = new Scanner(System.in);
        //NumberFormat currency = NumberFormat.getCurrencyInstance();
        // Prints random numbers into outFile.txt
           FrequencyCounter countRand = new FrequencyCounter();
           countRand.printRand();
           
           
        // file io buffers for reading and writing to text files

        //PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("outFile.txt")));
           try {
        fin = new BufferedReader(new FileReader("outFile.txt"));
    }catch(FileNotFoundException e) {
            System.out.println("file not found");
    }

        // ***** print banners *****

        banner = "*****************************" + nl;
        banner += "Name:        Abhi" + nl;
        banner += "Class:       CS30S" + nl;
        banner += "Assignment:  A1 Q5" + nl;
        banner += "*****************************" + nl + nl;

        System.out.println(banner);
        //fout.print(banner);

        // ***** Get Input *****
        
         strin = fin.readLine();
        // prompt for input
        while (strin != null) {
            tokens = strin.split(delim);
            
            for (int i = 0; i < tokens.length; i++) {
               n = Integer.parseInt(tokens[i]);
               list2[n]++;
               //System.out.println(n);
            }
            strin = fin.readLine();
        }
         // System.out.println("List" + Arrays.toString(list2));
        // read input from keyboard
        
        System.out.println("Press 1 to see frequency of one number, press 2 for a range of numbers?");
        input = scanner.nextInt();
        if (input == 1) {
            System.out.println("What numbers frequency do you want to see?");
            input = scanner.nextInt();
            System.out.println("The Frequency of " + input + " is " + list2[input]);
        }
        else if (input == 2){
            System.out.println("What range of frequency do you want to see?");
            input = scanner.nextInt();
            input2 = scanner.nextInt();
            
            for (int i = input -1; i < input2; i++) {
                System.out.println("The Frequency of " + (i + 1) + " " + list2[i]);
            }
    }
    else {
        System.out.println("Error");    // if some other number inputed
    }
        // echo input back to console window
      
        // Further frequency challenge
    System.out.println("\n----------------------------");
    System.out.println("Further frequency challenge");
    System.out.println("Press 1 to see a number that appears n times, Press 2 to see most/least frequant");
    input = scanner.nextInt();
    if (input == 1) {
        System.out.println("What frequency do you want to see that appears n times");
        input = scanner.nextInt();
        // loops through list2 and tries to find a match. If no match found counter = 0
        for (int i  = 0; i < limit; i++) {
            if (input == list2[i]) {
                System.out.println(i + " has a frequency of " + input);
                counter++;
            } 
        }
        if (counter == 0) {
            System.out.println("No number contains the frequency of " + input);
            counter = 0;    // to use for other processing
        }
    } else if(input == 2) {
            System.out.println("First type in the range of frequent numbers you want to see. Ex. 5 10");
            System.out.println("Followed by 'most' or 'least' frequent");

            input = scanner.nextInt();  // first range
            input2 = scanner.nextInt(); // second range
            input1 = scanner.nextLine();    // most or least
            
            // Sort from greatest to least
            for (int j = 0; j < limit; j++) {
                
                // inefficent - loops through it multiple times to sort from greatest to least
                for (int k = 0; k < limit; k++) {
                    // will loop through list2. Trying to find greatest number and sorting it
                    if (list2[k] > store) {
                        store = list2[k];   // store will change to the greatest number
                        location = k;
                       // System.out.println(store + " " +  list2[k] + " " + test);
                    }
                    //System.out.println(list2[k]);
                }
                sort[j] = store;    // the greatest number will be stored in index as it loops
                list2[location] = 0;    // test will be the value of k - how many times it has looped. The number will be removed and replaced by 0.
                frequencyIndex[j] = location;   // to get the location of the sorted numbers
                store = 0;  // reset store
            }
            
            // System.out.println("List sort" + Arrays.toString(sort));
            // System.out.println("List frequency" + Arrays.toString(frequencyIndex));
            
            // Calculations
            // keeps organization as it is
            if (input1.contains("most")) {
                System.out.println("The most frequent input in the range of " + input + " to " + input2 + " contains these most frequent numbers: ");
                for (int i = input -1; i < input2; i++) {
                    System.out.println("The Frequency of " + frequencyIndex[i] + " showed up " + sort[i]);
                }
            }
            // flips the sort array to get least to most
            else if (input1.contains("least")) {
                System.out.println("The least frequent input in the range of " + input + " to " + input2 + " contains these most frequent numbers: ");
                System.out.println(input2 + " " + input);
                // flip the sorted from least to greatest and flip frequencyIndex aswell
                for (int i = 50; i >= 0; i--) {
                    list2[counter] = sort[i];   // as counter goes up i goes down
                    frequencyIndex2[counter] = frequencyIndex[i];   // same for this
                    counter++;
                }
                // System.out.println("List frequency" + Arrays.toString(frequencyIndex2));
                for (int i = input2; i >= input; i--) {
                    System.out.println("The Frequency of " + frequencyIndex2[i] + " showed up " + list2[i]);
                }
            }
            else {
                System.out.println("Error");    // if input does not contain least or most
            }
            }
        
     else {
        System.out.println("Error");    // if input is anything other than 1 or 2
        
    }
        // ***** Main Processing *****

        // ***** Print Formatted Output *****

        // ***** Closing Message *****

        System.out.println();
        System.out.println("end of processing");
        //fout.println("End of Processing");

        // **** close io buffers *****

        //fin.close();
        //fout.close();
    } // end main 

} // end FormatTemplate
