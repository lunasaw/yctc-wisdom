package edu.yctc.genesis.constant.entity.year;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * 学年枚举
 * 
 * @author 15272
 */
public class Year {

    public static final String FIRST_YEAR = "2017-2018学年";
    public static final String SECOND_YEAR = "2018-2019学年";
    public static final String THIRD_YEAR = "2019-2020学年";

    public static final List<String> ALL_YEAR = ImmutableList.of(FIRST_YEAR, SECOND_YEAR, THIRD_YEAR);

    public static boolean isLegal(String year) {
        for (String string : ALL_YEAR) {
            if (string.equals(year)) {
                return true;
            }
        }
        return false;
    }
}
