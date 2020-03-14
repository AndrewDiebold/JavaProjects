
package java112.labs1;
import java.io.*;
import java.util.*;


public class LabEight {

    public TreeSet<String> set;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line, an output file name");
        } else {
            LabEight lab = new LabEight();
            lab.run(args[0]);

        }
    }

    public void run(String outputFile) {
        set = new TreeSet<String>();

        set.add("one");
        set.add("one");
        set.add("five");
        set.add("two");
        set.add("four");
        set.add("two");
        set.add("three");
        set.add("three");
        set.add("four");
        set.add("three");


        writeListToOutputFile(outputFile);



    }

    public void writeListToOutputFile(String outputFile) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));

            for (String element : set){
            writer.println(element);
            }

        } catch (IOException ioException) {
            System.out.println("There was a problem writing the file");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem");
            exception.printStackTrace();
        } finally {
            if (writer != null) {
            writer.close();
            }
        }


    }


}
