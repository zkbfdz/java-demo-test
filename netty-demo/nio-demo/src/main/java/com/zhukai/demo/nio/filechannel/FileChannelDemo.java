package com.zhukai.demo.nio.filechannel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelDemo {

    public static void main(String[] args) {
        FileChannel fc = null;
        try {
            fc = new FileInputStream(new File("d://备忘录.txt")).getChannel();
            ByteBuffer bf = ByteBuffer.allocate(1024);
            CharBuffer cbf = CharBuffer.allocate(1024);
            CharsetDecoder charsetDecoder = Charset.forName("utf-8").newDecoder();
            fc.read(bf);
            bf.flip();
            charsetDecoder.decode(bf,cbf,false);
            cbf.flip();
            while (cbf.hasRemaining()) {

                System.err.print(cbf.get());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fc.isOpen()) {
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
