package edu.yctc.genesis.util;

import java.util.List;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.constant.entity.statescore.StateScore;
import edu.yctc.genesis.constant.entity.studentstate.StudentState;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.StudentStateDO;

public class ClassScoreUtil {

    public static ResultDO<Double> calculateScoreByState(List<StudentStateDO> list) {

        double score = 0;

        // 参数检验
        for (StudentStateDO stateDO : list) {
            if (StudentState.isLegal(stateDO.getState()) == false) {
                return new ResultDO<Double>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                    null);
            }
        }
        for (StudentStateDO stateDO : list) {
            score += getScoreByState(stateDO.getState());
        }
        return new ResultDO<Double>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, score);
    }

    public static double getScoreByState(int state) {
        switch (state) {
            case StudentState.LISTENING:
                return StateScore.LISTENING_SCORE;
            case StudentState.DAZE:
                return StateScore.DAZE_SCORE;
            case StudentState.PLAY_MOBILE_PHONE:
                return StateScore.PLAY_MOBILE_PHONE_SCORE;
            case StudentState.SLEEP:
                return StateScore.SLEEP_SCORE;
            default:
                return 0;
        }
    }
}
