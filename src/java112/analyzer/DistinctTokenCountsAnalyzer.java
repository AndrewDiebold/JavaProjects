/*
 *  Class: DistinctTokenCountsAnalyzer
 *  Author: Andrew Diebold
 *  Create date: 10/22/2019
 *  Modification date: 10/22/2019
 *  Description: This class counts how many instances of distinct tokens
 */

package java112.analyzer;

import java.io.*;
import java.util.*;



/**<strong>This class adds distinct tokens to array, counts how many times each token
        is present and writes a file with all the
        distinct tokens on it.</strong>
 * @author Andrew Diebold
 *
 */
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer {

    private Properties properties;
    private Map<String, Integer> distinctTokenCounts;

    /**
     * This is a zero parameter constructor that creates a new TreeMap
     */
    public DistinctTokenCountsAnalyzer() {

        distinctTokenCounts = new TreeMap<String, Integer>();

    }

    /**
     * This is a constructor for DistinctTokenCountsAnalyzer object
     * @param properties  properties object
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * This method returns the distinct tokens and counts in a map
     * @return distinctTokenCounts
     */
    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    /**
     * This method checks to see if token is present, if so adds to that token count
     * and moves on to the next to token to check.
     * @param token token string
     */
    public void processToken(String token) {

        int distinctTokenAmount = 1;

        if (distinctTokenCounts.containsKey(token)) {

            distinctTokenAmount = distinctTokenCounts.get(token);
            distinctTokenAmount++;
        }
        distinctTokenCounts.put(token, distinctTokenAmount);


    }

    /**
     * This method will call another method to generate the output file
     * @param inputFile  input file string
     */
    public void generateOutputFile(String inputFile) {

        String outputFile = properties.getProperty("output.directory")
                 + properties.getProperty("output.file.distinct.counts");


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
     * This method will loop through treemap to print out tokens to text file
     * @param out   PrintWriter
     */
    private void loopThroughTokens(PrintWriter out) {

        for (Map.Entry<String, Integer> entry : distinctTokenCounts.entrySet()) {
            out.println(entry.getKey() + "\t" + entry.getValue());
        }

    }


}
