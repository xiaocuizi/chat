package com.gemini.chat.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

/**
 * HiServer服务器端
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/2 20:53
 */
@Component
public class HiServer {

    // 线程组
    private EventLoopGroup mainGroup;
    // 从线程组
    private EventLoopGroup workerGroup;

    private ServerBootstrap serverBootstrap;

    private ChannelFuture channelFuture;

    // 初始化
    public HiServer() {
        // 线程组
        mainGroup = new NioEventLoopGroup(1);
        // 从线程组
        workerGroup = new NioEventLoopGroup(2);
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(mainGroup, workerGroup);
        serverBootstrap.channel(NioServerSocketChannel.class)
                .childHandler(new HiServerInitializer());
    }

    public void start() {
        try {
            ChannelFuture channelFuture = serverBootstrap.bind(8088);
            System.err.println("服务器已启动.............");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        channelFuture.channel().closeFuture().sync();
    }

    public void shutdown() {
        mainGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    private static class SingletonHiServer {
        static final HiServer instance = new HiServer();
    }

    public static HiServer getInstance() {
        return SingletonHiServer.instance;
    }

}
