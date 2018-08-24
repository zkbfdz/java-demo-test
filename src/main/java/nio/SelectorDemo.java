package nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by kai.zhu on 2018/3/28/028.
 */
public class SelectorDemo {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);

    }
}
