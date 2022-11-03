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
 *  Assignment:     A1 Q2
 * 
 *  Description:    Place a short description of your program here
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
        
        
        Random rand = new Random();
        String input1 = "";
        int input2 = 0;
        int input = 0;
        int n = 0;
        int store = 0;
        int test = 0;
        int random = 0;
        int limit = 51;
        int[] frequencyIndex = new int[limit];
        int[] list2 = new int[limit];
        int[] list = new int[limit];
        int[] sort = new int[limit];
        // ***** objects *****

        Scanner scanner = new Scanner(System.in);
        //NumberFormat currency = NumberFormat.getCurrencyInstance();
        // Prints random numbers into outFile.txt
           FrequencyCounter countRand = new FrequencyCounter();
           countRand.printRand();
           
           
        // file io buffers for reading and writing to text files

        //PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("outFile.txt")));
        BufferedReader fin = new BufferedReader(new FileReader("outFile.txt"));

        // ***** print banners *****

        banner = "*****************************" + nl;
        banner += "Name:        Abhi" + nl;
        banner += "Class:       CS30S" + nl;
        banner += "Assignment:  Ax Qy" + nl;
        banner += "*****************************" + nl + nl;

        System.out.println(banner);
        //fout.print(banner);

        // ***** Get Input *****
        
        // for (int i = 0; i < 1000; i++) {
            // random = rand.nextInt(limit - 1) + 1;
            // // System.out.println(random);
            // fout.print(random + " ");
        // }
         strin = fin.readLine();
        //System.out.println(strin);
        // prompt for input
        while (strin != null) {
            tokens = strin.split(delim);
            
            for (int i = 0; i < tokens.length; i++) {
               n = Integer.parseInt(tokens[i]);
               list[n]++;
               //System.out.println(n);
            }
            strin = fin.readLine();
        }
         System.out.println("List" + Arrays.toString(list));
        // read input from keyboard
        
        System.out.println("Press 1 to see frequency of one number, press 2 for a range of numbers?");
        input = scanner.nextInt();
        if (input == 1) {
            System.out.println("What numbers frequency do you want to see?");
            input = scanner.nextInt();
            System.out.println("The Frequency of " + input + " is " + list[input]);
        }
        else if (input == 2){
            System.out.println("What range of frequency do you want to see?");
            input = scanner.nextInt();
            input2 = scanner.nextInt();
            
            for (int i = input -1; i < input2; i++) {
                System.out.println("The Frequency of " + (i + 1) + " " + list[i]);
            }
    }
    else {
        System.out.println("Error");
    }
        // echo input back to console window
        
        for (int i = 0; i < limit; i++) {
            list2[i] = list[i];
         }

    System.out.println("\n----------------------------");
    System.out.println("Further frequency challenge");
    System.out.println("Press 1 to see a number that appears n times, Press 2 to see most/least frequant");
    input = scanner.nextInt();
    if (input == 1) {
        System.out.println("What frequency do you want to see that appears n times");
        input = scanner.nextInt();
        for (int i  = 0; i < limit; i++) {
            if (input == list[i]) {
                System.out.println(i + " has a frequency of " + input);
            }
        }
    } else if(input == 2) {
            System.out.println("First type in the range of frequent numbers you want to see. Ex. 5 10");
            System.out.println("Followed by 'most' or 'least' frequent");

            input = scanner.nextInt();
            input2 = scanner.nextInt();
            input1 = scanner.nextLine();
            for (int j = 0; j < limit; j++) {
                for (int k = 0; k < limit; k++) {
                    if (list2[k] > store) {
                        store = list2[k];
                        test = k;
                       // System.out.println(store + " " +  list2[k] + " " + test);
                    }
                    //System.out.println(list2[k]);
                }
                sort[j] = store;
                list2[test] = 0;
                frequencyIndex[j] = test;
                store = 0;
            }
            System.out.println("List sort" + Arrays.toString(sort));
            if (input1.contains("most")) {
                System.out.println("The most frequent input in the range of " + input + " to " + input2 + " contains these most frequent numbers: ");
                for (int i = input -1; i < input2; i++) {
                    System.out.println("The Frequency of " + frequencyIndex[i] + " showed up " + sort[i]);
                }
            }
            else if (input1.contains("least")) {
                System.out.println("The least frequent input in the range of " + input + " to " + input2 + " contains these most frequent numbers: ");
                
                for (int i = input2 -1; i >= input; i--) {
                    System.out.println("The Frequency of " + frequencyIndex[i] + " showed up " + sort[i]);
                }
            }
            else {
                System.out.println("Error");
            }
            }
        
     else {
        System.out.println("Error");
    
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
