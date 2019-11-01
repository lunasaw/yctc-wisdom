package edu.yctc.genesis.vo;

public class ModifyClassDOVO {

    /** id */
    private long id;
    /** 学院 */
    private String academy;
    /** 专业 */
    private String profession;
    /** 班级 */
    private String number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ModifyClassDOVO [id=");
        builder.append(id);
        builder.append(", academy=");
        builder.append(academy);
        builder.append(", profession=");
        builder.append(profession);
        builder.append(", number=");
        builder.append(number);
        builder.append("]");
        return builder.toString();
    }

}
