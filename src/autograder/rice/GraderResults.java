package autograder.rice;

/**
 * A class to encapsulate the results of running Grader.runJUnitGradedTests.
 */
public class GraderResults {

    /**
     * The total possible points to earn.
     */
    private Double totalPossible;

    /**
     * The total points earned by the student.
     */
    private Double totalEarned;

    /**
     * A string that includes all of the individual test results, nicely formatted.
     */
    private String prettyResults;

    /**
     * Constructor for GraderResults; initializes all fields.
     *
     * @param totalPossible the total possible points to earn
     * @param totalEarned   the total points earned by the student
     * @param prettyResults a string that includes all of the individual test results,
     *                      nicely formatted
     */
    public GraderResults(Double totalPossible, Double totalEarned, String prettyResults) {
        this.totalPossible = totalPossible;
        this.totalEarned = totalEarned;
        this.prettyResults = prettyResults;
    }

    /**
     * @return the total possible points to earn
     */
    public Double getTotalPossible() {
        return this.totalPossible;
    }

    /**
     * @return the total points earned by the student
     */
    public Double getTotalEarned() {
        return this.totalEarned;
    }

    /**
     * @return a string that includes all of the individual test results, nicely formatted
     */
    public String getPrettyResults() {
        return this.prettyResults;
    }
}