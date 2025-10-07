/**
 * Copyright (c) 2019 Tim Kutcher
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 */
package autograder.rice;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystems;
import java.util.*;

/**
 * The main entry point to the autograder. Pretty-prints the results for all tests in all
 * files in the field tests.
 */
public final class Main {

    /**
     * The test classes to be evaluated.
     */
    private static final String[] tests = new String[]{"test.rice.EvalVisitorTest"};

    /**
     * Main entry point.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) throws ClassNotFoundException,
            IOException {
        gradeCodeCorrectness();
    }

    /**
     * Main driver function for grading code correctness. Prints the results.
     *
     * @throws ClassNotFoundException if something goes wrong
     * @throws MalformedURLException if something goes wrong
     */
    private static void gradeCodeCorrectness() throws ClassNotFoundException,
            MalformedURLException {
        Grader grader = new Grader();
        Double totalEarned = 0.0;
        Double totalPossible = 0.0;
        StringBuilder sb = new StringBuilder();

        // Run each test class, collecting the results in a giant string to print
        for (String testClassName : tests) {
            Class<?> c = getClassToGrade(testClassName);
            GraderResults results = grader.runJUnitGradedTests(c);
            totalEarned += results.getTotalEarned();
            totalPossible += results.getTotalPossible();
            sb.append(results.getPrettyResults());
        }

        // Prepend total and print per-test results
        sb.insert(0,
                "TOTAL SCORE: " + roundToTwoDecimalPlaces(totalEarned) + "/" +
                        roundToTwoDecimalPlaces(totalPossible) + "\n\n");
        System.out.println(sb.toString());
    }

    /**
     * Loads and returns the specified class.
     *
     * @param className name of the class to be loaded
     * @return a class object representing the loaded class
     * @throws ClassNotFoundException if the class could not be found in the path
     * @throws MalformedURLException  if the generated path had an invalid URL
     */
    private static Class<?> getClassToGrade(String className)
            throws ClassNotFoundException, MalformedURLException {
        URL url = FileSystems.getDefault().getPath("").toUri().toURL();
        URLClassLoader loader = new URLClassLoader(new URL[]{url});
        return loader.loadClass(className);
    }

    /**
     * Helper function for rounding a double to one decimal place.
     *
     * @param val number to be rounded
     * @return rounded version of the number
     */
    private static Double roundToTwoDecimalPlaces(Double val) {
        return (Math.round(val * 100)) / 100.0;
    }

    /**
     * This method takes as its input a path to a directory. If the input path
     * does not point to a directory, this method returns an empty set. Otherwise,
     * it returns a Set<String> containing the relative paths to all normal files
     * (not directories) that are contained within the specified directory, either
     * directly or indirectly (within a subdirectory). For example, given the input
     * “/dir1/dir2” and the following directory structure:
     *
     * dir1/
     * |---dir2/
     *      |---file1.txt
     *      |---file2.txt
     *      |---file3.txt
     *      |---dir3/
     *           |---file4.txt
     *      |---dir4/
     *           |---dir5/
     *                |---file5.txt
     *
     * ...this method returns the set containing {“file1.txt”, “file2.txt”,
     * “file3.txt”, “dir3/file4.txt”, “dir4/dir5/file5.txt”}.
     *
     * @param dirpath the path
     * @return the set of relative paths to all normal files contained within dirpath
     */
    private static Set<String> getFilenames(String dirpath) {
        // Get the absolute paths to all normal files contained within dirpath
        Set<String> fileNames = getFilenamesHelper(dirpath);

        // Only one element and it's dirpath -> return as-is
        if (fileNames.size() == 1 && fileNames.contains(dirpath)) {
            return fileNames;
        }

        // Remove dirpath + "/" from the start of each absolute path to get the relative paths
        Set<String> retval = new HashSet<>();
        for (String fileName: fileNames) {
            retval.add(fileName.substring(dirpath.length() + 1));
        }
        return retval;
    }

    /**
     * Recursive helper function for getFilenames(). Return a Set containing the absolute path
     * to every normal file that is contained, directory or indirectly, within the directory
     * pointed to by dirpath. If dirpath points to a normal file, returns the Set containing
     * only that file's absolute path.
     *
     * @param dirpath the path to the directory in which to get all files
     * @return the set of absolute paths to all normal files contained within dirpath
     */
    private static Set<String> getFilenamesHelper(String dirpath) {
        // Base case: dirpath points to a normal file rather than a directory -> return a set
        // containing only dirpath, which should be an absolute path
        File f = new File(dirpath);
        if (!f.isDirectory()) {
            return Set.of(dirpath);
        }

        // Recursive case: dirpath points to a directory -> recursively find all files
        // contained within the directory
        Set<String> retval = new HashSet<>();
        String[] filePaths = f.list();
        for (String filePath : filePaths) {
            // For each file/sub-directory in the directory pointed to by dirpath, get the
            // absolute path to each non-directory file in the sub-directory. If it's filePath
            // points to a normal file, that will send us to the base case.
            Set<String> results = getFilenamesHelper(dirpath + "/" + filePath);
            retval.addAll(results);
        }
        return retval;
    }
}