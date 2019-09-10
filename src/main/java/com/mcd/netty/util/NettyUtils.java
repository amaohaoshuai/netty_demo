package com.mcd.netty.util;

import com.mcd.netty.entity.NettyMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyUtils {

    private static final Logger log = LoggerFactory.getLogger(NettyUtils.class);

    public static final String WRITE_SUCCESS_MSG = "received success";

    public static final String WRITE_FAIL_MSG = "received fail";


    public static String[] splitMsg(Object msg, String regex) {

        String message = ((ByteBuf) msg).toString(CharsetUtil.UTF_8);

        if ("".equals(message) || message == null) {
            return null;
        }
        return message.split(regex);
    }

    public static void write(ChannelHandlerContext ctx, String msg) {
        ctx.write(
                ctx.alloc().buffer(4 * msg.length())
                        .writeBytes(msg.getBytes())
        );
        ctx.flush();
    }

    public static NettyMsg bindObject(Class nettyMsgName, String[] dataArray) {
        try {
            Class clazz = Class.forName(nettyMsgName.getName());
            NettyMsg nettyMsg = (NettyMsg) clazz.newInstance();
            nettyMsg.setFacilityId(dataArray[0]);
            nettyMsg.setFacilityName(dataArray[1]);
            nettyMsg.setLongitude(Double.parseDouble(dataArray[2]));
            nettyMsg.setLatitude(Double.parseDouble(dataArray[3]));
            nettyMsg.setHeight(Double.parseDouble(dataArray[4]));
            nettyMsg.setRTKStatus(Integer.parseInt(dataArray[5]));
            nettyMsg.setSatelliteCount(Integer.parseInt(dataArray[6]));
            return nettyMsg;
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        } catch (IllegalAccessException e) {
            log.error(e.getMessage());
        } catch (InstantiationException e) {
            log.error(e.getMessage());
        }
        return null;
    }


}
