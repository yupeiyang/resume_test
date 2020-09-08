package basics;

public class Demo3 {
    public static void main(String[] args) {
        /**
         * 在Java中，要想跳出多重循环，可以在外面的循环语句前定义一个标号，
         * 然后在里层循环体的代码中使用带有标号的break 语句，即可跳出外层循环。
         */
        OK:
        for(int i = 0;i<10;i++){
            for(int j = 0;j<10;j++){
                if(i == j && i == 9){
                    System.out.println(i+":"+j);
                    break OK;
                }
            }
        }

        for(int i = 0;i<10;i++){
            for(int j = 0;j<10;j++){
                if(i == j && i == 9){
                    System.out.println(i+":"+j);
                    break;
                }
                System.out.println("-----------");
            }
        }
    }
}
