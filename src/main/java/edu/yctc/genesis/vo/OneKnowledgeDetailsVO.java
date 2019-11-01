package edu.yctc.genesis.vo;

import java.util.Date;

public class OneKnowledgeDetailsVO {

    /** 知识点id */
    private Long knowledgeId;
    /** 知识点描述 */
    private String content;
    /** 预计时长 */
    private Double length;
    /** 认真听课人数 */
    private Integer sumForCareful;
    /** 本班所有人数 */
    private Integer sum;
    /** 知识点开始时间 */
    private Date scanStartTime;
    /** 知识点结束时间 */
    private Date scanEndTime;

    public Long getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Long knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getSumForCareful() {
        return sumForCareful;
    }

    public void setSumForCareful(Integer sumForCareful) {
        this.sumForCareful = sumForCareful;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Date getScanStartTime() {
        return scanStartTime;
    }

    public void setScanStartTime(Date scanStartTime) {
        this.scanStartTime = scanStartTime;
    }

    public Date getScanEndTime() {
        return scanEndTime;
    }

    public void setScanEndTime(Date scanEndTime) {
        this.scanEndTime = scanEndTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OneKnowledgeDetailsVO [knowledgeId=");
        builder.append(knowledgeId);
        builder.append(", content=");
        builder.append(content);
        builder.append(", length=");
        builder.append(length);
        builder.append(", sumForCareful=");
        builder.append(sumForCareful);
        builder.append(", sum=");
        builder.append(sum);
        builder.append(", scanStartTime=");
        builder.append(scanStartTime);
        builder.append(", scanEndTime=");
        builder.append(scanEndTime);
        builder.append("]");
        return builder.toString();
    }

}
