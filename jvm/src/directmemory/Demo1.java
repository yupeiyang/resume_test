package directmemory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo1 {
    static final String FROM = "E:\\temp_demo\\111.mp4";
    static final String TO = "E:\\temp_demo\\222.mp4";
    static final int _1Mb = 1024*1024;

    public static void main(String[] args) {
        io();
        directBuffer();
    }

    private static void directBuffer(){
        long start = System.nanoTime();
        try(FileChannel from = new FileInputStream(FROM).getChannel();
            FileChannel to = new FileOutputStream(TO).getChannel();)
        {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Mb);
            while(true){
                int len = from.read(byteBuffer);
                if(len == -1){
                    break;
                }
                byteBuffer.flip();
                to.write(byteBuffer);
                byteBuffer.clear();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        long end = System.nanoTime();

        System.out.println("directBuffer 用时："+(end - start) / 1000_000.0);
    }

    private static void io(){
        long start = System.nanoTime();
        try(FileInputStream from = new FileInputStream(FROM);
            FileOutputStream to = new FileOutputStream(TO);){
            byte[] buf = new byte[_1Mb];
            while (true){
                int len = from.read(buf);
                if(len == -1){
                    break;
                }
                to.write(buf,0,len);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        long end = System.nanoTime();

        System.out.println("io 用时："+(end - start) / 1000_000.0);
    }
}
