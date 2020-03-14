package java112.labs1;
import java.io.*;

public class LabSix {




        public static void main(String[] args) {
            if (args.length != 2) {
                System.out.println("Please enter two arguments on the command line, an input file name and an output file name");
            } else {
                LabSix lab = new LabSix();
                lab.run(args[0], args[1]);
            }



    }

    public void run(String inputFile, String outputFile) {
        BufferedReader inputReader = null;
        PrintWriter writer = null;

        try (
            BufferedReader input = new BufferedReader(new FileReader(inputFile));
            PrintWriter output = new PrintWriter(new BufferedWriter(
            new FileWriter(outputFile)))) {

                while (input.ready()) {
                    output.println(input.readLine());
                }
            } catch (FileNotFoundException fileNotFound) {
                fileNotFound.printStackTrace();
            } catch (IOException inputOutputException) {
                inputOutputException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
    }


}
