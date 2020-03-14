/*
 *  Class: TokenAnalyzer
 *  Author: Andrew Diebold
 *  Create date: 10/06/2019
 *  Modification date: 10/22/2019
 *  Description: This class is the interface for the application.
 */

package java112.analyzer;

import java.io.*;
import java.util.*;

/**<strong>This is the interface for the program.</strong>
 * The interface has two methods that are used in the token analyzer classes.
 *
 * @author Andrew Diebold
 */
public interface TokenAnalyzer {

    /**
     * This method will be implemented in analyzer classes
     * @param token token string
     */
    void processToken(String token);

    /**
     * This method will be implemented in analyzer classes
     * @param inputFile  The file that will be entered by user
     */
    void generateOutputFile(String inputFile);

}
