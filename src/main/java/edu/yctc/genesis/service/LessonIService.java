package edu.yctc.genesis.service;

import java.util.List;

import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;

public interface LessonIService {

    /**
     * 通过lessonId获得视频播放url
     * 
     * @param lessonId
     * @return
     */
    // public ResultDO<String> getVideoUrlByLessonId(long lessonId);

    /**
     * 通过lessonId获取这节课所有上课的学生
     * 
     * @param lessonId
     * @return
     */
    public ResultDO<List<UserDO>> getAllStudentsAtLesson(long lessonId);
}
