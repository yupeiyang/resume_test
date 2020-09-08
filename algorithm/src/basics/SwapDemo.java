package basics;

public class SwapDemo {
    public static void main(String[] args) {
        int num1 = 100,num2 = 1000;

        System.out.println("num1 = "+num1);
        System.out.println("num2 = "+num2);

        swap(num1,num2);

        System.out.println("num1 = "+num1);
        System.out.println("num2 = "+num2);
    }

    static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }
}
