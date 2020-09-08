package communicate_thread;

public class TestDemo1 {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        new ChiHuo(baoZi).start();
        new BaoZiPu(baoZi).start();
    }
}
