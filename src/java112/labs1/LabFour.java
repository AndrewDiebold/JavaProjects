package java112.labs1;
import java.io.*;
import java.util.*;

public class LabFour{



    public static void main(String[] args){


        LabFour lab = new LabFour();

        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            lab.run(args[0]);
        }
    }

    public void run(String inputFile) {

        LabFour lab = new LabFour();





        loopLines(inputFile);

    }

    public void loopLines(String inputFile) {

        BufferedReader in = null;
        Set<String> set = new TreeSet<>();


        try {

            in = new BufferedReader(new FileReader(inputFile));

            String read = null;
                while ((read = in.readLine()) != null) {
                    String[] splited = read.split("\\s+");
                    for (String part : splited) {
                        System.out.println(part);
                    }

                    for (String v : splited) {
                        set.add(v);

                    }

                }










        } catch (FileNotFoundException fileNotFound){
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception generalException) {
            generalException.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        System.out.println("   ");
        System.out.println(set);




    }




}
