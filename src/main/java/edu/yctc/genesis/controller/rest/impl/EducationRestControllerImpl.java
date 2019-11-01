package edu.yctc.genesis.controller.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.controller.rest.EducationRestController;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.service.UploadIService;

/**
 * 教务管理rest请求
 * 
 * @author 15272
 */
@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/resteducation")
public class EducationRestControllerImpl implements EducationRestController {

    @Autowired
    UploadIService uploadService;

    @Override
    @PostMapping("import-students")
    public ResultDO<Void> uploadStudents(@RequestBody MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return new ResultDO<>(false, ResultCode.FILE_EMPTY, ResultCode.MSG_FILE_EMPTY);
        }
        return uploadService.uploadStudents(multipartFile);
    }

}
