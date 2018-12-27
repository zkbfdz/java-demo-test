package demo2.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    public static final StringDecoder DECODER = new StringDecoder();

    public static final StringEncoder ENCODER = new StringEncoder();

    public static final ServerHandler SERVER_HANDLER = new ServerHandler();

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        //编码,解码
        pipeline.addLast(DECODER);
        pipeline.addLast(ENCODER);

        pipeline.addLast(SERVER_HANDLER);
    }
}
