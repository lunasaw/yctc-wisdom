package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.KnowledgePictureDO;
import org.checkerframework.checker.units.qual.K;

import java.util.List;

/**
 * @author czy@win10
 * @date 2019/11/6 13:45
 */
public class GetPictureVO {
    private int id;
    private List<KnowledgePictureDO> picture;
    private String knowledgeid;

    public String getKnowledgeid() {
        return knowledgeid;
    }

    public void setKnowledgeid(String knowledgeid) {
        this.knowledgeid = knowledgeid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<KnowledgePictureDO> getPicture() {
        return picture;
    }

    public void setPicture(List<KnowledgePictureDO> picture) {
        this.picture = picture;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GetPictureVO [id=");
        builder.append(id);
        builder.append(", picture=");
        builder.append(picture);
        builder.append(", knowledgeid=");
        builder.append(knowledgeid);
        builder.append("]");
        return builder.toString();
    }
}
