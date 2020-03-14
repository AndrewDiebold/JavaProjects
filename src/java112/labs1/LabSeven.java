
package java112.labs1;
import java.io.*;
import java.util.*;


public class LabSeven {

    public ArrayList<String> list;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line, an output file name");
        } else {
            LabSeven lab = new LabSeven();
            lab.run(args[0]);

        }
    }

    public void run(String outputFile) {
        list = new ArrayList<String>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");


        writeListToOutputFile(outputFile);



    }

    public void writeListToOutputFile(String outputFile) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));

            for (String element : list){
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
