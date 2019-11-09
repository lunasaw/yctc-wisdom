package edu.yctc.genesis.vo;

/**
 * @author czy@win10
 * @date 2019/11/8 20:21
 */
public class StudentsLessonStateVO {
    private int LISTENING;
    private int PLAY_MOBILE_PHONE;
    private int DAZE;
    private int SLEEP;

    public StudentsLessonStateVO() {
    }

    public int getLISTENING() {
        return LISTENING;
    }

    public void setLISTENING(int LISTENING) {
        this.LISTENING = LISTENING;
    }

    public int getPLAY_MOBILE_PHONE() {
        return PLAY_MOBILE_PHONE;
    }

    public void setPLAY_MOBILE_PHONE(int PLAY_MOBILE_PHONE) {
        this.PLAY_MOBILE_PHONE = PLAY_MOBILE_PHONE;
    }

    public int getDAZE() {
        return DAZE;
    }

    public void setDAZE(int DAZE) {
        this.DAZE = DAZE;
    }

    public int getSLEEP() {
        return SLEEP;
    }

    public void setSLEEP(int SLEEP) {
        this.SLEEP = SLEEP;
    }
}
