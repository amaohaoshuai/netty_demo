package com.mcd.netty.service.impl;

import com.mcd.netty.dao.NettyDao;
import com.mcd.netty.entity.NettyMsg;
import com.mcd.netty.service.NettyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class NettyServiceImpl implements NettyService {

    private static final Logger log = LoggerFactory.getLogger(NettyServiceImpl.class);

    @Autowired
    private NettyDao nettyDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveMessage(NettyMsg nettyMsg) {
        try {

            nettyMsg.setSaveTime(new Date());

            // 1.判断是否有数据
            if (nettyDao.getMessageByFacilityId(nettyMsg.getFacilityId()) == null) {
                if (nettyDao.saveMessage(nettyMsg) != 1) {
                    throw new RuntimeException("存储失败");
                }
            } else if (nettyDao.updateMessage(nettyMsg) != 1) {
                throw new RuntimeException("更新失败");
            }

            return true;
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            throw new RuntimeException("数据存储失败");
        }
    }

    @Override
    public List<NettyMsg> getAllFacility() {
        return nettyDao.getAllFacility();
    }
}
