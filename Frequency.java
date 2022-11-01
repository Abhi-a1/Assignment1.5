import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.Random;


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
        int random = 0;
        int limit = 50;
        // ***** objects *****

        //Scanner scanner = new Scanner(System.in);
        //NumberFormat currency = NumberFormat.getCurrencyInstance();

        // file io buffers for reading and writing to text files

        //BufferedReader fin = new BufferedReader(new FileReader("filename.txt"));
        PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("outFile.txt")));

        // ***** print banners *****

        banner = "*****************************" + nl;
        banner += "Name:        Abhi" + nl;
        banner += "Class:       CS30S" + nl;
        banner += "Assignment:  Ax Qy" + nl;
        banner += "*****************************" + nl + nl;

        System.out.println(banner);
        fout.print(banner);

        // ***** Get Input *****
        
            for (int i = 0; i < 1000; i++) {
            random = rand.nextInt(limit - 1) + 1;
            System.out.println(random);
            fout.print(random);
        }
    
        // prompt for input
        
        // read input from keyboard
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
