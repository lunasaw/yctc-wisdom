package edu.yctc.genesis.vo;

/**
 * @author czy@win10
 * @date 2019/11/11 20:41
 */
public class GetBooleanByPictureVO {
    private int id;
    private int prictureId;
    private boolean check;
    private int knowledgeid;
    private String knowledge;

    public GetBooleanByPictureVO() {
    }

    public GetBooleanByPictureVO(int prictureId, boolean check) {
        this.prictureId = prictureId;
        this.check = check;

    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public GetBooleanByPictureVO(int id, int prictureId, boolean check) {
        this.id = id;
        this.prictureId = prictureId;
        this.check = check;
    }

    public GetBooleanByPictureVO(int id, int prictureId, boolean check, int knowledgeid) {
        this.id = id;
        this.prictureId = prictureId;
        this.check = check;
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

    public int getPrictureId() {
        return prictureId;
    }

    public void setPrictureId(int prictureId) {
        this.prictureId = prictureId;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
