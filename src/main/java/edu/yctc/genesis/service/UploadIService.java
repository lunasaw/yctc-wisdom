package edu.yctc.genesis.service;

import org.springframework.web.multipart.MultipartFile;

import edu.yctc.genesis.entity.ResultDO;

public interface UploadIService {

    /**
     * 导入学生信息
     * 
     * @param multipartFile
     * @return
     */
    public ResultDO<Void> uploadStudents(MultipartFile multipartFile);
}
