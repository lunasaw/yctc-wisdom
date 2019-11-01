package edu.yctc.genesis.vo;

public class YearAndTermVO {

    /** 学年 */
    private String year;

    /** 学期 */
    private int term;

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
        builder.append("YearAndTermVO [year=");
        builder.append(year);
        builder.append(", term=");
        builder.append(term);
        builder.append("]");
        return builder.toString();
    }

}
