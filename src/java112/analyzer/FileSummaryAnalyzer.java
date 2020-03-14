/*
 *  Class: FileSummaryAnalyzer
 *  Author: Andrew Diebold
 *  Create date: 10/06/2019
 *  Modification date: 10/22/2019
 *  Description: This class counts total tokens and creates summary output.
 */

package java112.analyzer;

import java.io.*;
import java.util.*;


/**<strong>This class will create a file summary and count the total tokens.</strong>\
 *
 * @author Andrew Diebold
 *
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {

    private int totalTokensCount;
    private Properties properties;

    /**
     * This is a zero constructor method
     */
    public FileSummaryAnalyzer(){

    }

    /**
     * This is a constructor for FileSummaryAnalyzer object
     * @param properties properties object
     */
    public FileSummaryAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * This method returns the total token count
     * @return the total token count
     */
    public int getTotalTokensCount() {

        return totalTokensCount;

    }

    /**
     * This method counts the total tokens
     * @param token token string
     */
    public void processToken(String token) {

        totalTokensCount++;

    }

    /**
     * This method writes summary output file
     * @param inputFile  input file entered by user
     */
    public void generateOutputFile(String inputFile) {

        String outputFile = properties.getProperty("output.directory")
                 + properties.getProperty("output.file.summary");

        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter(outputFile)))){

            outputSummary(out, inputFile);

        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

    /**
     * This method generates the summary output file
     * @param out        PrintWriter
     * @param inputFile  input file entered by user
     */
    public void outputSummary(PrintWriter out, String inputFile) {

        Date date = new Date();
        File file = new File(inputFile);
        Long lastModified = file.lastModified();
        Date dateModified = new Date(lastModified);

        out.println(properties.getProperty("application.name"));
        out.println(properties.getProperty("author"));
        out.println(properties.getProperty("author.email.address"));
        out.println("File: " + file.getAbsolutePath());
        out.println("Date of analysis: " + date);
        out.println("Last Modified: " + dateModified);
        out.println("File Size: " + file.length());
        out.println("File URI: " + file.toURI().toString());
        out.println("Total token count: " + totalTokensCount);


    }
}
