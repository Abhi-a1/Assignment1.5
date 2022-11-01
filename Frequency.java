import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Arrays;



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
        int input2 = 0;
        int input = 0;
        int n = 0;
        int test = 0;
        int random = 0;
        int limit = 51;
        int[] list = new int[limit];
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
        
        System.out.println("Press 1 to see frequency of one number, press 2 for a range of numbers? 1/2");
        input = scanner.nextInt();
        if (input == 1) {
            System.out.println("What numbers frequency do you want to see?");
            input = scanner.nextInt();
            System.out.println(list[input]);
        }
        else if (input == 2){
            System.out.println("What range of frequency do you want to see?");
            input = scanner.nextInt();
            input2 = scanner.nextInt();
            
            for (int i = input -1; i < input2; i++) {
                System.out.println(list[i]);
            }
    }
    else {
        System.out.println("Error");
    }
        // echo input back to console window

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
