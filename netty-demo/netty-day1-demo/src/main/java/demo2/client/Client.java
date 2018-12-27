package demo2.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ClientInitializer());
            Channel channel = b.connect("127.0.0.1", 8888).sync().channel();
            ChannelFuture lastWriteFuture = null;

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for(;;){
                String line = in.readLine();
                if (line == null) {
                    break;
                }
                channel.writeAndFlush(line + "/r/n");

                if ("bye".equalsIgnoreCase(line)) {
                    channel.closeFuture().sync();
                    break;
                }
            }

            if (lastWriteFuture != null) {
                lastWriteFuture.sync();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
