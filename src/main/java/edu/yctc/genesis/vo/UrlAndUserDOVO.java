package edu.yctc.genesis.vo;

/**
 * @author dell
 */
public class UrlAndUserDOVO {

    /** url */
    private String url;
    /** 用户id */
    private long id;
    /** 学院 */
    private String academy;
    /** 班级 */
    private String classes;
    /** 学号/工号 */
    private String number;
    /** 姓名 */
    private String name;
    /** 性别 */
    private String sex;
    /** 身份证 */
    private String idCardNumber;
    /** 手机号 */
    private String phone;
    /** 邮箱 */
    private String mail;
    /** 人脸照url */
    private String picture;
    /** 人脸标识 */
    private String faceToken;

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

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UrlAndUserDOVO [url=");
        builder.append(url);
        builder.append(", id=");
        builder.append(id);
        builder.append(", academy=");
        builder.append(academy);
        builder.append(", number=");
        builder.append(number);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }

}
