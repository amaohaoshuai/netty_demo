package com.mcd.netty.service;

import com.mcd.netty.entity.NettyMsg;

import java.util.List;

public interface NettyService {


    boolean saveMessage(NettyMsg nettyMsg);

    List<NettyMsg> getAllFacility();
}
