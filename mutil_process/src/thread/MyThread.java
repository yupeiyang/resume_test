package thread;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class MyThread extends Thread {
    @Override
    public void run() {
        String name = getName();
        System.out.println("Thread : "+name);
        Thread thread = Thread.currentThread();
        Thread thread1 = new Thread();
        thread1.setName("yupeiyang");
        String thread1name = thread1.getName();
        System.out.println("Thread : "+thread);
        System.out.println("Thread1 : "+thread1);
        System.out.println("Thread1 : "+thread1name);
    }
}
