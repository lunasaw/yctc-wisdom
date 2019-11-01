package edu.yctc.genesis.controller.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import edu.yctc.genesis.entity.NewsDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.vo.NewsDOAndUrlVO;
import edu.yctc.genesis.vo.SendNewsVO;

public interface NewsRestController {

    /**
     * 获得用户消息列表
     *
     * @param httpSession
     * @return
     */
    public ResultDO<Map<Integer, List<NewsDOAndUrlVO>>> showNews(HttpSession httpSession);

    /**
     * 将某条信息变更为已读
     *
     * @param newsId
     * @param httpSession
     * @return
     */
    public ResultDO<Void> turnTOReaded(String newsId, HttpSession httpSession);

    /**
     * 将某条信息变更为未读
     *
     * @param newsId
     * @param httpSession
     * @return
     */
    @Deprecated
    public ResultDO<Void> turnTOUnread(String newsId, HttpSession httpSession);

    /**
     * 全部变更为已读
     *
     * @param httpSession
     * @return
     */
    public ResultDO<Void> turnAllToReaded(HttpSession httpSession);

    /**
     * 全部变更为未读
     *
     * @param httpSession
     * @return
     */
    @Deprecated
    public ResultDO<Void> turnAllToUnread(HttpSession httpSession);

    /**
     * 给用户推送消息
     *
     * @param sendNewsVO
     * @return
     */
    public ResultDO<Void> sendNewsToUser(SendNewsVO sendNewsVO);

    /**
     * 通过id返回newsDO
     *
     * @param id
     * @return
     */
    public ResultDO<NewsDO> getNewsDOById(long id);

    /**
     * 删除所有已读通知
     * 
     * @param httpSession
     * @return
     */
    public ResultDO<Void> deleteAllReadedNews(HttpSession httpSession);
}
