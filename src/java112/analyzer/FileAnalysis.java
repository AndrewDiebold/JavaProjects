/*
 *  Class: FileAnalysis
 *  Author: Andrew Diebold
 *  Create date: 10/06/2019
 *  Modification date: 10/22/2019
 *  Description: This class is the main processing class for the application.
 */

package java112.analyzer;

import java112.utilities.*;
import java.io.*;
import java.util.*;

/**<strong>This is the main processing class for the application.</strong>
 * This class will have methods that will test the arguments, call methods that preform
 * such tasks as create instances of analyzer classes, open the input file, loop the input file
 * pass the generated tokens and call the output files.
 *
 * @author Andrew Diebold
 *
 */
public class FileAnalysis implements PropertiesLoader {

    private static final int VALID_ARGS = 2;



    private ArrayList<TokenAnalyzer> analyzers;

    /**
     * The analyze method will call other methods to perform tasks.
     * @param arguments the user entered text file on the command line
     */
    public void analyze(String[] arguments) throws Exception {

        if (arguments.length != VALID_ARGS) {
            System.out.println("Please enter one arguments on the command line, a file name");
            return;

        }


        initializeAnalyzers(loadProperties(arguments[1]));
        openInputFile(arguments[0]);
        writeOutputFiles(arguments[0]);
    }

    /**
     * This method will initialize the analyzer classes
     * @param properties properties from properties file
     */
    public void initializeAnalyzers(Properties properties) {


        analyzers = new ArrayList<TokenAnalyzer>();

        analyzers.add(new FileSummaryAnalyzer(properties));
        analyzers.add(new DistinctTokensAnalyzer(properties));
        analyzers.add(new LargestTokensAnalyzer(properties));
        analyzers.add(new DistinctTokenCountsAnalyzer(properties));
        analyzers.add(new TokenLengthsAnalyzer(properties));
        analyzers.add(new TokenLocationSearchAnalyzer(properties));
    }






    /**
     * This method will open the file entered on command line by user
     * @param inputFile user ented text file on command line
     */
    public void openInputFile(String inputFile) {



        try (BufferedReader input = new BufferedReader(new FileReader(inputFile))){

            loopInputFile(input);

        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    /**
     * This method will loop through the entered text file, split the lines, and
     * add tokens to an array that will be passed to the analyzer classes
     * @param  input       user ented text file
     * @throws IOException
     */
    public void loopInputFile(BufferedReader input) throws IOException {

        String inputLine;
        String token;
        String[] tokenArray = null;

        while (input.ready()) {

            inputLine = input.readLine();
            tokenArray = inputLine.split("\\W");

            passTokensToAnalyzers(tokenArray);


        }
    }

    /**
     * This method passes generated tokens to analyzer classes
     * @param tokenArray array that holds tokens
     */
    public void passTokensToAnalyzers(String[] tokenArray) {

        for (String element : tokenArray) {

            if (!element.isEmpty()) {
                processTokens(element);
            }
        }
    }

    /**
     * This method loops through all analyzer classes and calls processTokens methods
     * @param token token string
     */
    private void processTokens(String token) {

            for (TokenAnalyzer anAnalyzer : analyzers) {
                anAnalyzer.processToken(token);
            }
        }




    /**
     * This method calls the generated output files to write them to output folder
     * @param inputFile user ented text file on command line
     */
    public void writeOutputFiles(String inputFile) {

        for (TokenAnalyzer anAnalyzer : analyzers) {
            anAnalyzer.generateOutputFile(inputFile);
        }
    }
}
