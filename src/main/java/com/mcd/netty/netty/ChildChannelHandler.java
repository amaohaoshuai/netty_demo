package com.mcd.netty.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Autowired
    private DiscardServerHandler discardServerHandler;

    public void initChannel(SocketChannel socketChannel) throws Exception {
        // 定义分隔符为$$（字符串末尾分割）
        ByteBuf delimiter = Unpooled.copiedBuffer("$$".getBytes());
        // 添加分隔符解码器，通过分隔符来解决拆包粘包的问题
        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(2048, delimiter));
        // 自定义解码器，用来获取数据并做持久化处理
        socketChannel.pipeline().addLast(discardServerHandler);
    }
}