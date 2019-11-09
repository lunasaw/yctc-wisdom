package edu.yctc.genesis.entity;

/**
 * @author czy@win10
 * @date 2019/11/8 21:01
 */
public class StateLessonDO {

    private int state;
    private long lessonId;

    public StateLessonDO() {
    }

    public StateLessonDO(int state, long lessonId) {
        this.state = state;
        this.lessonId = lessonId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }
}
