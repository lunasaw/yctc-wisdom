package edu.yctc.genesis.constant.entity.floor;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * 楼层枚举
 * 
 * @author 15272
 */
public class Floor {

    public static final String FIRST_FLOOR = "一楼";
    public static final String SECOND_FLOOR = "二楼";
    public static final String THIRD_FLOOR = "三楼";
    public static final String FOURTH_FLOOR = "四楼";
    public static final String FIFTH_FLOOR = "五楼";
    public static final String SIXTH_FLOOR = "六楼";
    public static final String SEVENTH_FLOOR = "七楼";
    public static final String EIGHTH_FLOOR = "八楼";
    public static final String NINETH_FLOOR = "九楼";
    public static final String TENTH_FLOOR = "十楼";
    public static final String ELEVENTH_FLOOR = "十一楼";
    public static final String TWELVFTH_FLOOR = "十二楼";
    public static final String THIRTENNTH_FLOOR = "十三楼";
    public static final String FOURTENNTH_FLOOR = "十四楼";
    public static final String FIFTEENTH_FLOOR = "十五楼";
    public static final String SIXTEENTH_FLOOR = "十六楼";
    public static final String SEVENTEENTH_FLOOR = "十七楼";

    public static final List<String> ALL_FLOOR = ImmutableList.of(FIRST_FLOOR, SECOND_FLOOR, THIRD_FLOOR,
        FOURTH_FLOOR, FIFTH_FLOOR, SIXTH_FLOOR,
        SEVENTH_FLOOR, EIGHTH_FLOOR, NINETH_FLOOR,
        TENTH_FLOOR, ELEVENTH_FLOOR, TWELVFTH_FLOOR,
        THIRTENNTH_FLOOR, FOURTENNTH_FLOOR,
        FIFTEENTH_FLOOR, SIXTEENTH_FLOOR,
        SEVENTEENTH_FLOOR);

    public static boolean isLegal(String floor) {
        for (String string : ALL_FLOOR) {
            if (string.equals(floor)) {
                return true;
            }
        }
        return false;
    }
}
