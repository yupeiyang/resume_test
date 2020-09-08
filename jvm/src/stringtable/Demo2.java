package stringtable;

public class Demo2 {
    public static void main(String[] args) {
        int i = 0;
        try{
            for(int j = 0;j<1000;j++){
                String.valueOf(j).intern();
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(1);
        }
    }
}
