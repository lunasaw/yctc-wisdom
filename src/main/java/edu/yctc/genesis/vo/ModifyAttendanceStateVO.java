package edu.yctc.genesis.vo;

public class ModifyAttendanceStateVO {

    /** 用户id */
    private long userId;
    /** 课时id */
    private long lessonId;
    /** 出勤情况 */
    private String attendState;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }

    public String getAttendState() {
        return attendState;
    }

    public void setAttendState(String attendState) {
        this.attendState = attendState;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ModifyAttendanceStateVO [userId=");
        builder.append(userId);
        builder.append(", lessonId=");
        builder.append(lessonId);
        builder.append(", attendState=");
        builder.append(attendState);
        builder.append("]");
        return builder.toString();
    }

}
