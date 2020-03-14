/*
 *  Class: DistinctTokensAnalyzer
 *  Author: Andrew Diebold
 *  Create date: 10/06/2019
 *  Modification date: 10/22/2019
 *  Description: This class creates the methods for the distinct tokens in the application.
 */

package java112.analyzer;

import java.io.*;
import java.util.*;


/**<strong>This class adds distinct tokens to array and writes a file with all the
        distinct tokens on it.</strong>
 * @author Andrew Diebold
 *
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    private Set<String> distinctTokens;
    private Properties properties;


    /**
     * This is a zero parameter constructor that creates a new TreeSet
     */
    public DistinctTokensAnalyzer() {

        distinctTokens = new TreeSet<String>();

    }

    /**
     * This is a constructor for DistinctTokensAnalyzer object
     * @param properties properties object
     */
    public DistinctTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;

    }

    /**
     * This method returns the distinct tokens in a set
     * @return distinctTokens
     */
    public Set<String> getDistinctTokens() {

        return distinctTokens;

    }

    /**
     * This method adds a token(word) to an array
     * @param token token string
     */
    public void processToken(String token) {

        distinctTokens.add(token);

    }

    /**
     * This method will call another method to generate the output file
     * @param inputFile  input file entered by user
     */
    public void generateOutputFile(String inputFile) {

        String outputFile = properties.getProperty("output.directory")
                 + properties.getProperty("output.file.distinct");


        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter(outputFile)))){

            loopThroughTokens(out);


        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * This method will loop through treeset to print out tokens to text file
     * @param out   PrintWriter
     */
    private void loopThroughTokens(PrintWriter out) {

        for (String element : distinctTokens){
            out.println(element);

        }
    }
}
