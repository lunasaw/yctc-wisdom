package edu.yctc.genesis.vo;

public class UserIdAndYearAndTermVO {

    /** userId */
    private long userId;

    /** 学年 */
    private String year;

    /** 学期 */
    private int term;

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("YearAndTermVO [userId=");
        builder.append(userId);
        builder.append(", year=");
        builder.append(year);
        builder.append(", term=");
        builder.append(term);
        builder.append("]");
        return builder.toString();
    }

}
