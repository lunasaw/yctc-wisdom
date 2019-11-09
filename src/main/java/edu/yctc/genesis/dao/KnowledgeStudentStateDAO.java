package edu.yctc.genesis.dao;

import java.util.Date;
import java.util.List;

import edu.yctc.genesis.entity.StateLessonDO;
import edu.yctc.genesis.vo.StudentsLessonStateVO;
import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.KnowledgeStudentStateDO;

@Mapper
public interface KnowledgeStudentStateDAO {

    /**
     * 插入信息
     * 
     * @param knowledgeStudentStateDO
     */
    public void insert(KnowledgeStudentStateDO knowledgeStudentStateDO);

    /**
     * 通过id获取
     * 
     * @param id
     * @return
     */
    public KnowledgeStudentStateDO getKnowledgeStudentStateDOById(long id);

    /**
     * 更新
     * 
     * @param knowledgeStudentStateDO
     */
    public void update(KnowledgeStudentStateDO knowledgeStudentStateDO);

    /**
     * 删除
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过userId和lessonId获取状态集
     * 
     * @param userId
     * @param lessonId
     * @return
     */
    public List<KnowledgeStudentStateDO> getKnowledgeStudentStateDOsByUserIdAndLessonId(long userId, long lessonId);

    /**
     * 更新扫描结束时间
     * 
     * @param knowledgeStudentStateDO
     */
    public void updateScanEndTime(KnowledgeStudentStateDO knowledgeStudentStateDO);

    /**
     * 通过lessonId获取总人数
     * 
     * @param lessonId
     * @return
     */
    public Integer getSumByLessonId(long lessonId, long knowledgeId);

    /**
     * 通过lessonId获取认真听课人数
     * 
     * @param lessonId
     * @return
     */
    public Integer getSumOfCarefulByLessonId(long lessonId, long knowledgeId);

    /**
     * 通过knowledgeId获取知识点开始讲授时间
     * 
     * @param knowledgeId
     * @return
     */
    public Date getScanStartTimeByKnowledgeId(long knowledgeId);

    /**
     * 通过knowledgeId获取知识点结束讲授时间
     * 
     * @param knowledgeId
     * @return
     */
    public Date getScanEndTimeByKnowledgeId(long knowledgeId);

    /**
     * 通过knowledgeId获取KnowledgeStudentStateDO集
     * 
     * @param knowledgeId
     * @return
     */
    public List<KnowledgeStudentStateDO> getKnowledgeStudentStateDOListByKnowledgeId(long knowledgeId);

    /**
     * 更新知识点检测完成时间
     * 
     * @param lessonId
     * @param knowledgeId
     */
    public void updateScanEndTimeByLessonIdAndKnowledgeId(long lessonId, long knowledgeId);

    /*
    通过lessonid获得该堂课的所有知识点的学生状态人数
     */
    public List<StateLessonDO> getKnowledgeStudentStateLessonStateVO(long lessonId, long knowledgeId);
}
