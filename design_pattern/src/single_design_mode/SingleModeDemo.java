package single_design_mode;

public class SingleModeDemo {
    public static void main(String[] args) {
        SingleMode singleMode = SingleMode.getInstance();
        singleMode.showMessage();
    }
}
