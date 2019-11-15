package edu.yctc.genesis.dao;

import edu.yctc.genesis.entity.KnowledgePictureDO;
import edu.yctc.genesis.vo.GetBooleanByPictureVO;
import edu.yctc.genesis.vo.GetPictureBooleanLastVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author czy@win10
 * @date 2019/11/6 14:10
 */
@Mapper
public interface PictureKnowledgeDAO {
    /**
     * 插入知识点图片信息
     *
     * @param KnowledgePictureDO
     */
    public void insertbypicture(KnowledgePictureDO KnowledgePictureDO);

    /**
     * 知识点id查询图片集合
     *
     * @param id
     * @return
     */
    public List<KnowledgePictureDO> PictureByKnowledgeId (long id);

    /**
     * id删除图片
     *
     * @param id
     */
    public void deleteById(long id);

    /*
        @param pictureId
       通过图片id获取GetBooleanByPictureid
        */
    public GetPictureBooleanLastVO GetBooleanByPictureid(long pictureId);
}
