package mina;

import org.apache.mina.core.service.IoConnector;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by kai.zhu on 2018/3/28/028.
 */
public class TCPClient {

    public static void main(String[] args) {
        IoConnector ioConnector = new NioSocketConnector();

        ioConnector.setConnectTimeoutMillis(30000);

        ioConnector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"), LineDelimiter.WINDOWS.getValue(), LineDelimiter.WINDOWS.getValue())));

        ioConnector.setHandler(new TcpClientHandler("你好, \r\n 大家好!"));

        ioConnector.connect(new InetSocketAddress("127.0.0.1", 9124));
    }
}
