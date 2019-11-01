package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.UserDO;

public class TeacherDOAndUrlVO {

    /** userDO */
    private UserDO userDO;
    /** url */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TeacherDOAndUrlVO [teacherDO=");
        builder.append(userDO);
        builder.append(", url=");
        builder.append(url);
        builder.append("]");
        return builder.toString();
    }

}
