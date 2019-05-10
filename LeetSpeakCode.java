import java.io.*;
import java.util.*;
public class LeetSpeakCode {
   public static void main (String[] args) throws FileNotFoundException {
      Scanner input = new Scanner (new File("lincoln.txt"));
      PrintStream output = new PrintStream (new File("leet.txt"));
      leetSpeak(input, output);  
      input.close();
   }
   
   public static void leetSpeak (Scanner input, PrintStream output) {
      while (input.hasNextLine()) {
         String line = input.nextLine();
         line = line.replace("o", "0");
         line = line.replace("l", "1");
         line = line.replace("e", "3");
         line = line.replace("a", "4");
         line = line.replace("t", "7");
         line = line.replace("e", "3");
         Scanner LineScan = new Scanner (line);
         if (!LineScan.hasNext()) { // if the line doesnt have words
            output.println(); // print a blank line
         }
         while (LineScan.hasNext()) {
            String word = LineScan.next();
            if (word.endsWith("s")){
               word = word.substring(0, word.length() - 1) + "Z";
            }
            output.print("(" + word + ")" + " "); // put a () around each word
            if (!LineScan.hasNext()) { // start a new line after printing all the words on the current line
               output.println();
            }
         }         
      }
   }
}