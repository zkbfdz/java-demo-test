package demo1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class NettyServer {

    public static final String IP = "127.0.0.1";

    public static final int PORT = 8888;

    public static final int BIZ_GROUP_SIZE = Runtime.getRuntime().availableProcessors() * 2;

    public static final int BIZ_THREAD_SIZE = 100;

    public static final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZ_GROUP_SIZE);

    public static final EventLoopGroup workGroup = new NioEventLoopGroup(BIZ_THREAD_SIZE);

    public static void start() throws InterruptedException {

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    public void initChannel(Channel channel) throws Exception {
                        ChannelPipeline channelPipeline = channel.pipeline();
                        channelPipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
                        channelPipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                        channelPipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                        channelPipeline.addLast(new TcpServerHandler());
                    }
                });

        ChannelFuture channelFuture = serverBootstrap.bind(IP, PORT).sync();

        channelFuture.channel().closeFuture().sync();

        System.out.println("Server start!");

    }

    public static void shutdown() {
        workGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("启动server...");
        NettyServer.start();
    }
}
