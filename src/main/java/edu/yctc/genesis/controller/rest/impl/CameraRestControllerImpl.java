package edu.yctc.genesis.controller.rest.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.controller.rest.CameraRestController;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.EquipmentDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.service.FaceFunctionIService;
import edu.yctc.genesis.vo.BuildingAndFloorVO;

@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/restcamera")
/**
 * 球机管理rest实现
 * 
 * @author 15272
 */
public class CameraRestControllerImpl implements CameraRestController {

    @Autowired
    private FaceFunctionIService faceFunctionService;

    @Override
    @PostMapping("control-camera")
    public ResultDO<Void> controlCamera(@RequestBody String command) {
        if (StringUtils.isBlank(command)) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return faceFunctionService.controlCamera(command);
    }

    @Override
    @PostMapping("get-floors-by-building")
    public ResultDO<List<String>> getFloorsByBuilding(@RequestBody String building) {
        if (StringUtils.isBlank(building)) {
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        return faceFunctionService.getFloorsByBuilding(building);
    }

    @Override
    @PostMapping("get-buildings")
    public ResultDO<List<String>> getBuildings() {
        return faceFunctionService.getBuildings();
    }

    @Override
    @PostMapping("get-classroomdo-by-building-and-floor")
    public ResultDO<List<ClassroomDO>>
        getClassroomDOByBuildingAndFloor(@RequestBody BuildingAndFloorVO buildingAndFloorVO) {
        if (StringUtils.isBlank(buildingAndFloorVO.getBuilding())
            || StringUtils.isBlank(buildingAndFloorVO.getFloor())) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return faceFunctionService.getClassroomDOByBuildingAndFloor(buildingAndFloorVO.getBuilding(),
            buildingAndFloorVO.getFloor());
    }

    @Override
    @PostMapping("get-equipmentdos-by-classroom-number")
    public ResultDO<List<EquipmentDO>> getEquipmentDOsByClassroomNumber(@RequestBody String number) {
        if (StringUtils.isBlank(number)) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return faceFunctionService.getEquipmentDOsByClassroomNumber(number);
    }

    @Override
    @PostMapping("get-video-by-equipment-number")
    public ResultDO<String> getVideoByEquipmentNumber(@RequestBody String number) {
        if (StringUtils.isBlank(number)) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return faceFunctionService.getVideoByEquipmentNumber(number);
    }

}
