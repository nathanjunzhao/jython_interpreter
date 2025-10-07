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

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import java.util.List;
import java.util.Map;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

/**
 * A class to encompass the process of running and grading JUnit tests.
 */
public class Grader {

    /**
     * Runs JUnit tests and attaches a GradedTestListener to listen for all tests
     * with tags and store the scores of each.
     *
     * @param testSuite the class containing the tests.
     * @return a GraderResults object encapsulating the results
     */
    public GraderResults runJUnitGradedTests(Class testSuite) {
        // Run all test cases in the input class, listening to their results
        GradedTestListener listener = new GradedTestListener();
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
            .selectors(selectClass(testSuite)).build();
        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        launcher.execute(testPlan, listener);

        // Extract the results from the listener
        Map<String, Double> results = listener.getTestResults();
        Map<String, Double> testPoints = listener.getTestPoints();
        List<String> testNames = listener.getTestNames();

        // Get the results as a string, ready to be pretty-printed
        String prettyResults = this.getResultString(testSuite.getName(), results,
            testPoints, testNames);

        Double totalEarned = this.grade(results);
        Double totalPosisble = this.grade(testPoints);
        return new GraderResults(totalPosisble, totalEarned, prettyResults);
    }

    /**
     * Aggregates all of the test methods' scores to get the total score for a given test
     * file.
     *
     * @param results per-method results of testing
     * @return the sum of the values in results
     */
    private Double grade(Map<String, Double> results) {
        Double retval = 0.0;
        for (Double d : results.values()) {
            retval += d;
        }
        return retval;
    }

    /**
     * Helper function for rounding a double to one decimal place.
     *
     * @param val number to be rounded
     * @return rounded version of the number
     */
    private Double roundToTwoDecimalPlaces(Double val) {
        return (Math.round(val * 100)) / 100.0;
    }

    /**
     * Gets a nicely formatted string, which can be used to print the results.
     *
     * @param testClassName the name of the test class that was executed
     * @param results       per-method results of testing
     * @param testPoints    per-method possible points
     */
    private String getResultString(String testClassName, Map<String, Double> results,
        Map<String, Double> testPoints, List<String> testCaseNames) {
        // Add up the points earned (total) and possible (totalPossible) across all tests
        Double total = this.grade(results);
        Double totalPossible = this.grade(testPoints);

        // Build a string to pretty-print the results
        StringBuilder sb = new StringBuilder();

        // Show the total score
        sb.append("\tTEST CLASS: ").append(testClassName).append("\n");
        sb.append("\tCLASS SCORE: ").append(this.roundToTwoDecimalPlaces(total))
            .append("/").append(this.roundToTwoDecimalPlaces(totalPossible)).append("\n");

        // Show the results of each individual test case
        for (String key : testCaseNames) {
            int numTabs = (int) Math.ceil((44 - key.length() - 1) / 4.0);
            String correctness = (results.get(key).equals(0.0) ? "FAILED" : "passed");
            sb.append("\t\t").append(key).append(":");
            sb.append("\t".repeat(Math.max(0, numTabs)));
            sb.append(correctness).append("\t(").append(this.roundToTwoDecimalPlaces(
                results.get(key))).append("/").append(this.roundToTwoDecimalPlaces(
                testPoints.get(key))).append(")\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}