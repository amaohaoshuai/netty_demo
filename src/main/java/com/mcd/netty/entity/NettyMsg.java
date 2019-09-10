package com.mcd.netty.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class NettyMsg {

    // 设备编号 使用UUID
    private String facilityId;
    // 设备名称
    private String facilityName;
    // 经度
    private double longitude;
    // 纬度
    private double latitude;
    // 高程
    private double height;
    // RTK状态 例如4，5
    private int RTKStatus;
    // 卫星数量
    private int satelliteCount;
    // 入库时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date saveTime;

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getRTKStatus() {
        return RTKStatus;
    }

    public void setRTKStatus(int RTKStatus) {
        this.RTKStatus = RTKStatus;
    }

    public int getSatelliteCount() {
        return satelliteCount;
    }

    public void setSatelliteCount(int satelliteCount) {
        this.satelliteCount = satelliteCount;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "facilityId='" + facilityId + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", height=" + height +
                ", RTKStatus=" + RTKStatus +
                ", satelliteCount=" + satelliteCount +
                ", saveTime=" + saveTime +
                '}';
    }
}
