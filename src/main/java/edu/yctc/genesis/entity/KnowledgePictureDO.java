package edu.yctc.genesis.entity;

import edu.yctc.genesis.vo.GetPictureVO;

import java.util.List;

/**
 * @author czy@win10
 * @date 2019/11/6 14:22
 */
public class KnowledgePictureDO {
    private  int id;

    private String picture;

    private long knowledgeid;

    public KnowledgePictureDO(String picture, long knowledgeid) {
        this.picture = picture;
        this.knowledgeid = knowledgeid;
    }

    public KnowledgePictureDO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getKnowledgeid() {
        return knowledgeid;
    }

    public void setKnowledgeid(long knowledgeid) {
        this.knowledgeid = knowledgeid;
    }

    public KnowledgePictureDO(int id, String picture, long knowledgeid) {
        this.id = id;
        this.picture = picture;
        this.knowledgeid = knowledgeid;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("KnowledgePictureDO [id=");
        builder.append(id);
        builder.append(", picture=");
        builder.append(picture);
        builder.append(", knowledgeid=");
        builder.append(knowledgeid);
        builder.append("]");
        return builder.toString();
    }
}
