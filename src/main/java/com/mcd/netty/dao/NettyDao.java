package com.mcd.netty.dao;

import com.mcd.netty.entity.NettyMsg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NettyDao {
    NettyMsg getMessageByFacilityId(@Param("facilityId") String facilityId);

    int saveMessage(NettyMsg nettyMsg);

    int updateMessage(NettyMsg nettyMsg);

    List<NettyMsg> getAllFacility();
}
