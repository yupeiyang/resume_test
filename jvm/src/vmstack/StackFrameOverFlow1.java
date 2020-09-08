package vmstack;

/**
 * 演示栈帧过多导致的内存溢出：方法的递归调用
 * @author ypy
 */
public class StackFrameOverFlow1 {
    private static int count;

    public static void main(String[] args) {
        try{
            method1();
        }catch(Throwable e){
            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void method1(){
        count++;
        method1();
    }
}
