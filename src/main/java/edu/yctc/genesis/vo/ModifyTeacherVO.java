package edu.yctc.genesis.vo;

public class ModifyTeacherVO {

    /** 用户id（教师） */
    private long id;
    /** 学院 */
    private String academy;
    /** 学号 */
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
    /** 人脸标识 */
    private String faceToken;

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

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TeacherDO [id=");
        builder.append(id);
        builder.append(", academy=");
        builder.append(academy);
        builder.append(", number=");
        builder.append(number);
        builder.append(", name=");
        builder.append(name);
        builder.append(", sex=");
        builder.append(sex);
        builder.append(", idCardNumber=");
        builder.append(idCardNumber);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", mail=");
        builder.append(mail);
        builder.append(", faceToken=");
        builder.append(faceToken);
        builder.append("]");
        return builder.toString();
    }
}
