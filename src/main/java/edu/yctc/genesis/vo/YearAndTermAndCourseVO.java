package edu.yctc.genesis.vo;

public class YearAndTermAndCourseVO {

    /** 学年 */
    private String year;

    /** 学期 */
    private int term;

    /** 课程名 */
    private String courseName;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("YearAndTermAndCourseVO [year=");
        builder.append(year);
        builder.append(", term=");
        builder.append(term);
        builder.append(", course=");
        builder.append(courseName);
        builder.append("]");
        return builder.toString();
    }
}
