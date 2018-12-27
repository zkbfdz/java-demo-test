package demo2.client;

import demo2.server.ServerHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ClientInitializer extends ChannelInitializer<SocketChannel> {

    public static final StringDecoder DECODER = new StringDecoder();

    public static final StringEncoder ENCODER = new StringEncoder();

    public static final ClientHandler CLIENT_HANDLER  = new ClientHandler();

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipeline.addLast(DECODER);
        pipeline.addLast(ENCODER);
        pipeline.addLast(CLIENT_HANDLER);
    }
}
