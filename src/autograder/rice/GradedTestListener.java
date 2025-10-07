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

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.TestTag;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that extends a JUnit {@link TestExecutionListener} to check for unit test
 * methods annotated with the {@link org.junit.jupiter.api.Tag} annotation. It builds up
 * two mappings: one from each test case to its allocated points, and the other from each
 * test case to the student's earned points.
 */
public class GradedTestListener implements TestExecutionListener {

    /**
     * Mapping of each test's name to the points earned by the student for this test.
     */
    private Map<String, Double> testResults;

    /**
     * Mapping of each test's name to the total points allocated to that test.
     */
    private Map<String, Double> testPoints;

    /**
     * List of test cases that were run, saved to preserve the same ordering for printing
     * results.
     */
    private List<String> testNames;

    /**
     * Constructor for a new listener; initializes all fields to empty collections.
     */
    public GradedTestListener() {
        this.testResults = new HashMap<>();
        this.testPoints = new HashMap<>();
        this.testNames = new ArrayList<>();
    }

    /**
     * @return the map of test cases to their scores
     */
    public Map<String, Double> getTestResults() {
        return this.testResults;
    }

    /**
     * @return the map of test cases to their possible points
     */
    public Map<String, Double> getTestPoints() {
        return this.testPoints;
    }

    /**
     * @return the names of the test cases
     */
    public List<String> getTestNames() {
        return this.testNames;
    }

    /**
     * Handles a completed test case. Finds the test's tag, extracts the number of points,
     * and gives the student credit if their code passed the test.
     *
     * @param testIdentifier      identifier for the test that just finished
     * @param testExecutionResult results of the test that just finished
     */
    @Override
    public void executionFinished(TestIdentifier testIdentifier,
        TestExecutionResult testExecutionResult) {
        String fname = testIdentifier.getDisplayName();
        fname = fname.substring(0, fname.length() - 2);
        if (testIdentifier.isTest()) {
            this.testNames.add(fname);

            // Find the allocated points
            double points = 0.0;
            for (TestTag tag : testIdentifier.getTags()) {
                points = Double.parseDouble(tag.toString());
            }
            this.testPoints.put(fname, points);

            // Check the output (passed/failed); if passed, give the student credit;
            // otherwise, give them zero points.
            if (testExecutionResult.getStatus().equals(
                TestExecutionResult.Status.SUCCESSFUL)) {
                this.testResults.put(fname, points);
            } else {
                this.testResults.put(fname, 0.0);
            }
        }
    }
}