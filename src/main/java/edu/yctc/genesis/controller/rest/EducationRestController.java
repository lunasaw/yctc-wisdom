package edu.yctc.genesis.controller.rest;

import org.springframework.web.multipart.MultipartFile;

import edu.yctc.genesis.entity.ResultDO;

public interface EducationRestController {

    /**
     * excel导入学生信息
     * 
     * @param multipartFile
     * @return
     */
    public ResultDO<Void> uploadStudents(MultipartFile multipartFile);

    // TODO 球机管理接口
}
