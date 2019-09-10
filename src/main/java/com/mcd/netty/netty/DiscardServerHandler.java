package com.mcd.netty.netty;

import com.mcd.netty.entity.NettyMsg;
import com.mcd.netty.service.NettyService;
import com.mcd.netty.util.NettyUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ChannelHandler.Sharable
public class DiscardServerHandler extends ChannelHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(DiscardServerHandler.class);

    @Autowired
    private NettyService nettyService;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            // 1. 数据根据分隔符拆分
            String[] dataArray = NettyUtils.splitMsg(msg, ",");
            if (dataArray == null) {
                NettyUtils.write(ctx, NettyUtils.WRITE_FAIL_MSG);
            }
            for (String s : dataArray) {
                System.out.println(s);
            }
            // 2. 绑定对象
            NettyMsg nettyMsg = NettyUtils.bindObject(NettyMsg.class,dataArray);
            // 3. 存储数据,存储成功返回客户端消息
            if(!nettyService.saveMessage(nettyMsg)){
                NettyUtils.write(ctx, NettyUtils.WRITE_SUCCESS_MSG);
            }
            NettyUtils.write(ctx, NettyUtils.WRITE_FAIL_MSG);

        } catch (RuntimeException e) {
            log.error(e.getMessage());
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 出现异常就关闭
        log.error(cause.getMessage());
        ctx.close();
    }


}
