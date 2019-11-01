package edu.yctc.genesis.vo;

/**
 * courseDO和url的VO
 * 
 * @author 15272
 */
public class UrlAndCourseDOVO {

    /** url */
    private String url;
    /** 课程id */
    private long id;
    /** 课程号 */
    private String number;
    /** 课程名 */
    private String name;
    /** 课程课时总数 */
    private int lessonSum;
    /** 开课学年 */
    private String year;
    /** 开课学期 */
    private String term;
    /** 开课专业 */
    private String profession;
    /** 开课班级 */
    private String classes;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLessonSum() {
        return lessonSum;
    }

    public void setLessonSum(int lessonSum) {
        this.lessonSum = lessonSum;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UrlAndCourseDOVO [url=");
        builder.append(url);
        builder.append(", id=");
        builder.append(id);
        builder.append(", number=");
        builder.append(number);
        builder.append(", name=");
        builder.append(name);
        builder.append(", lessonSum=");
        builder.append(lessonSum);
        builder.append(", year=");
        builder.append(year);
        builder.append(", term=");
        builder.append(term);
        builder.append(", profession=");
        builder.append(profession);
        builder.append(", classes=");
        builder.append(classes);
        builder.append("]");
        return builder.toString();
    }

}
