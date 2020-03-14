/*
 *  Class: LargestTokensAnalyzer
 *  Author: Andrew Diebold
 *  Create date: 10/22/2019
 *  Modification date: 10/22/2019
 *  Description: This class finds the larger token sizes
 */
package java112.analyzer;

import java.io.*;
import java.util.*;



/**<strong>This class will loop through tokens and find ones of a certain size.</strong>\
 *
 * @author Andrew Diebold
 *
 */
public class LargestTokensAnalyzer implements TokenAnalyzer {


    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;


    /**
     * This is a zero parameter constructor that creates a new TreeSet
     */
    public LargestTokensAnalyzer() {

        largestTokens = new TreeSet<String>();

    }

    /**
     * This is a constructor for LargestTokensAnalyzer object
     * @param properties properties object
     */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        minimumTokenLength = Integer.parseInt(
                properties.getProperty("largest.words.minimum.length"));
    }

    /**
     * This method returns the largest tokens in a set
     * @return distinctTokens
     */
    public Set<String> getLargestTokens() {

        return largestTokens;
    }

    /**
     * This method adds the distinct tokens in a set after comparing the size
     * @param token token string
     */
    public void processToken(String token) {

        if (token.length() >= minimumTokenLength) {
            largestTokens.add(token);
        }

    }

    /**
     * This method will call another method to generate the output file
     * @param inputFile  input file entered by user
     */
    public void generateOutputFile(String inputFile) {

        String outputFile = properties.getProperty("output.directory")
                 + properties.getProperty("output.file.largest.words");


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
     * This method will loop through set to print out tokens to text file
     * @param out PrintWriter
     */
    private void loopThroughTokens(PrintWriter out) {

        for (String element : largestTokens){
            out.println(element);

        }
    }


}
