package edu.yctc.genesis.constant.entity.term;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * 学期枚举
 * 
 * @author 15272
 */
public class Term {

    /** 上学期 */
    public static final int FIRSTSEMESTER = 0;

    /** 下学期 */
    public static final int SECONDSEMESTER = 1;

    public static final List<Integer> ALL_TERM = ImmutableList.of(FIRSTSEMESTER, SECONDSEMESTER);

    public static boolean isLegal(int term) {
        for (Integer integer : ALL_TERM) {
            if (integer == term) {
                return true;
            }
        }
        return false;
    }
}
