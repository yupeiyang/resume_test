package mainthread;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class MyThread1 extends Thread {
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}