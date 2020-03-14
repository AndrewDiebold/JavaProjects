/*
 *  Class: Driver
 *  Author: Andrew Diebold
 *  Create date: 10/06/2019
 *  Modification date: 10/22/2019
 *  Description: This class drives the whole application.
 */


package java112.analyzer;

import java.io.*;
import java.util.*;



/**<strong>This program takes a text file and counts the total tokens(words) in
        the file</strong>
 * @author Andrew Diebold
 *
 */
public class Driver {

    /**
     * this is the main file that runs the whole program.
     * Instantiate the main processing class and run it.
     * @param args text file the user wants to tokenize.
     *
     */
    public static void main(String[] args) throws Exception {

        FileAnalysis analysis = new FileAnalysis();

        analysis.analyze(args);
    }
}
