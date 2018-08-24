package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by kai.zhu on 2018/3/28/028.
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("D:\\profile\\nio-test.txt", "rw");
        FileChannel fileChannel = accessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(48);

        int read = fileChannel.read(byteBuffer);
        while (read != -1) {
            System.out.print("Read:" + read);
            byteBuffer.rewind();

            while (byteBuffer.hasRemaining()) {
                System.out.print((char)byteBuffer.get());
            }
            System.out.println();
            byteBuffer.clear();
            read = fileChannel.read(byteBuffer);
        }
        accessFile.close();
    }
}
