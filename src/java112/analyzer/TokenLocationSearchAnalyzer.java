/*
 *  Class: TokenLocationSearchAnalyzer
 *  Author: Andrew Diebold
 *  Create date: 11/17/2019
 *  Modification date: 11/17/2019
 *  Description: This class loads a document to search the file for certain
 *          keywords.
 */
package java112.analyzer;

import java.io.*;
import java.util.*;



/**<strong>This class will find certain keywords in the input file.</strong>
 *
 * @author Andrew Diebold
 *
 */
public class TokenLocationSearchAnalyzer implements TokenAnalyzer {

    private Map<String, List<Integer>> foundLocations;
    private Properties properties;
    private int currentTokenLocation;


    /**
     * Zero par constructor that creates a new TreeMap
     */
    public TokenLocationSearchAnalyzer() {

        foundLocations = new TreeMap<String, List<Integer>>();

    }

    /**
     * Constructor for TokenLocationSearchAnalyzer object
     * Also loads loadSearchFile method
     * @param properties properties object
     */
    public TokenLocationSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        loadKeywordFile();

    }

    /**
     * Method that retruns a map with token and locations in a list
     * @return foundLocations
     */
    public Map<String, List<Integer>> getFoundLocations() {

        return foundLocations;
    }

    /**
     * Method that checks to see if token is a keyword
     * @param token string
     */
    public void processToken(String token) {

        currentTokenLocation += 1;

        if (foundLocations.containsKey(token)) {
            foundLocations.get(token).add(currentTokenLocation);
        }

    }

    /**
     * Method that calls another method to generate the output files
     * @param inputFile input file entered by user
     */
    public void generateOutputFile(String inputFile) {

        String outputFile = properties.getProperty("output.directory")
                 + properties.getProperty("output.file.token.search.locations");


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
     * Method that loops and prints keword token and locations
     * @param out PrintWriter
     */
    private void loopThroughTokens(PrintWriter out) {

        for (Map.Entry <String, List <Integer>> entry : foundLocations.entrySet()) {
            out.println(entry.getKey() + " =");
            locationString(entry.getValue(), out);
            out.println();
        }


    }

    /**
     * Method that loads a file with the keywords to serch user input file
     */
    public void loadKeywordFile() {

        try (
            InputStream inputStream = this.getClass().getResourceAsStream(properties.getProperty("classpath.search.tokens"));
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader searchTokensReader = new BufferedReader(inputStreamReader)

        ) {
            searchTokens(searchTokensReader);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Method that reads the search tokens and puts them in a list
     * @param  searchTokensReader BufferedReader
     * @throws IOException
     */
    public void searchTokens(BufferedReader searchTokensReader) throws IOException {
        String inputLine = null;

        while (searchTokensReader.ready()) {
            inputLine = searchTokensReader.readLine().trim();
            if (inputLine.isEmpty()) {
                continue;
            }

            foundLocations.put(inputLine, new ArrayList<Integer>());
        }

    }

    /**
     * Method that creates string for keyword and its locations
     * @param value values
     * @param out   PrintWriter
     */
    public void locationString(List<Integer> value, PrintWriter out) {
        String location = null;
        int max_ouput_length = 80;
        String start = "[";
        String end = "]";

        for (Integer keywordLocation : value) {
            location = keywordLocation + ", ";

            if (start.length() + location.length() > max_ouput_length) {
                out.println(start.trim());
                start = location;
            } else {
                start = start + location;
            }
        }
        if (start.trim().endsWith(",")) {
            start = start.substring(0, start.length() - 2);
        }
        start = start + end;
        out.println(start.trim());
    }



}
