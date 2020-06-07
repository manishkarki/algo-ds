package com.algo.dummy.main;

/**
 * @author mkarki
 */
public class HomeworkAssignment {
    private int earnedMarks;

    private int possibleMarks;

    private String submitterName;

    private String letterGrade;        //derived //

    //constructor ..............//
    public HomeworkAssignment(int possibleMarks) {
        this.possibleMarks = possibleMarks;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

    public String getLetterGrade() {
        float earnedPercentage = (this.earnedMarks * 100.0f) / this.possibleMarks;
        if (earnedPercentage >= 90) {
            return "A";
        }
        if (earnedPercentage < 90 && earnedPercentage >= 80) {
            return "B";
        }
        if (earnedPercentage < 80 && earnedPercentage >= 70) {
            return "C";
        }
        if (earnedPercentage < 70 && earnedPercentage >= 60) {
            return "D";
        }
        return "F";

    }

    public static void main(String[] args) {
        HomeworkAssignment homeworkAssignment = new HomeworkAssignment(100);
        homeworkAssignment.setEarnedMarks(91);
        System.out.println(homeworkAssignment.getLetterGrade());
    }

}
