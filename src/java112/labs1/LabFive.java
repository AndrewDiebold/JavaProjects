package java112.labs1;
import java.io.*;

public class LabFive {




        public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, "
            + "a file name and a message");
        } else {
            LabFive lab = new LabFive ();
            lab.run(args[0], args[1]);
        }

    }

    public void run(String TestFile, String message) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(TestFile)));
            writer.println(message);
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
