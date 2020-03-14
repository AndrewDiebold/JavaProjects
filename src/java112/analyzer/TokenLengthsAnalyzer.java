/*
 *  Class: TokenLengthsAnalyzer
 *  Author: Andrew Diebold
 *  Create date: 10/22/2019
 *  Modification date: 10/22/2019
 *  Description: This class finds the token lengths and creates count and Histogram
 */
package java112.analyzer;

import java.io.*;
import java.util.*;



/**<strong>This class will loop through tokens and find ones of a certain size.</strong>\
 *
 * @author Andrew Diebold
 *
 */
public class TokenLengthsAnalyzer implements TokenAnalyzer {


    private Properties properties;
    private Map<Integer, Integer> tokenLengths;



    /**
     * Zero parameter constructor that creates a new TreeMap
     */
    public TokenLengthsAnalyzer() {

        tokenLengths = new TreeMap<Integer, Integer>();

    }

    /**
     * Constructor for TokenLengthsAnalyzer object
     * @param properties properties object
     */
    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;

    }

    /**
     * Method that returns a map with the lengths and number of tokens
     * @return tokenLengths
     */
    public Map<Integer, Integer> getTokenLengths() {

        return tokenLengths;
    }

    /**
     * Method that adds token lengths and tokens to the tokenLengths TreeMap
     * @param token string
     */
    public void processToken(String token) {

        Integer length = token.length();

        if (tokenLengths.containsKey(length)) {
            Integer newLength = (tokenLengths.get(length) + 1);
            tokenLengths.replace(length, newLength);
        } else {
            tokenLengths.put(length, 1);
        }

    }

    /**
     * Method that calls another method to generate the output files
     * @param inputFile input file entered by user
     */
    public void generateOutputFile(String inputFile) {

        String outputFile = properties.getProperty("output.directory")
                 + properties.getProperty("output.file.token.lengths");


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
     * Method that loops through map to print out tokens as well as lengths and
     *      a Histogram
     * @param out PrintWriter
     */
    private void loopThroughTokens(PrintWriter out) {

        for (Map.Entry <Integer, Integer> token : tokenLengths.entrySet()) {
            out.println(token.getKey() + "\t" + token.getValue());
        }
        out.println();
        out.println("Histogram:");

        starOutput(out);
    }

    /**
     * Method that converts lengths to stars
     * @param  number map value
     * @return String
     */
    public String convertToStars(int number) {
        double MAX_CHARACTERS = 80;
        double maxNumber = Collections.max(tokenLengths.values()) / MAX_CHARACTERS;
        double starsNumber = number / maxNumber;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < starsNumber; i++) {
            output.append('*');
        }
        return output.toString();
    }

    /**
     * Method that prints out the stars
     * @param out PrintWriter
     */
    public void starOutput(PrintWriter out) {

        for (Map.Entry <Integer, Integer> star : tokenLengths.entrySet()) {
            out.println(star.getKey() + " " + convertToStars(star.getValue()));
        }
    }


}
