package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.BuildingFloorDO;

public class BuildingFloorAndUrlVO {

    /** buildingFloorDO */
    private BuildingFloorDO buildingFloorDO;
    /** url */
    private String url;

    public BuildingFloorDO getBuildingFloorDO() {
        return buildingFloorDO;
    }

    public void setBuildingFloorDO(BuildingFloorDO buildingFloorDO) {
        this.buildingFloorDO = buildingFloorDO;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BuildingFloorAndUrlVO [buildingFloorDO=");
        builder.append(buildingFloorDO);
        builder.append(", url=");
        builder.append(url);
        builder.append("]");
        return builder.toString();
    }
}
