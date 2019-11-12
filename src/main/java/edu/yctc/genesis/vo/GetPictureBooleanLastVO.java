package edu.yctc.genesis.vo;

/**
 * @author czy@win10
 * @date 2019/11/11 21:17
 */
public class GetPictureBooleanLastVO {
    private int id;
    private int pictureid;
    private int pictureBoolean;
    private int knowledgeid;
    public GetPictureBooleanLastVO() {
    }

    public GetPictureBooleanLastVO(int pictureid, int pictureBoolean) {
        this.pictureid = pictureid;
        this.pictureBoolean = pictureBoolean;
    }

    public GetPictureBooleanLastVO(int id, int pictureid, int pictureBoolean) {
        this.id = id;
        this.pictureid = pictureid;
        this.pictureBoolean = pictureBoolean;
    }

    public GetPictureBooleanLastVO(int id, int pictureid, int pictureBoolean, int knowledgeid) {
        this.id = id;
        this.pictureid = pictureid;
        this.pictureBoolean = pictureBoolean;
        this.knowledgeid = knowledgeid;
    }

    public int getKnowledgeid() {
        return knowledgeid;
    }

    public void setKnowledgeid(int knowledgeid) {
        this.knowledgeid = knowledgeid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPictureid() {
        return pictureid;
    }

    public void setPictureid(int pictureid) {
        this.pictureid = pictureid;
    }

    public int getPictureBoolean() {
        return pictureBoolean;
    }

    public void setPictureBoolean(int pictureBoolean) {
        this.pictureBoolean = pictureBoolean;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GetPictureBooleanLastVO [pictureid=");
        builder.append(pictureid);
        builder.append(", pictureBoolean=");
        builder.append(pictureBoolean);
        builder.append("]");
        return builder.toString();
    }
}
