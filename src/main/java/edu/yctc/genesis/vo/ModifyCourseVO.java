package edu.yctc.genesis.vo;

public class ModifyCourseVO {

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
    /** 开课学期 ，{@link edu.yctc.genesis.constant.entity.term.Term} */
    private int term;
    /** 开课专业id */
    private String profession;
    /** 开课班级 */
    private String classId;

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

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ModifyCourseVO [id=");
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
        builder.append(", classId=");
        builder.append(classId);
        builder.append("]");
        return builder.toString();
    }

}
