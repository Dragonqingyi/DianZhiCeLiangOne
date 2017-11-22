import java.awt.*;

public class test {
    Frame frame = new Frame();
    Label l1 = new Label("1");
    Label l2 = new Label("2");
    Button b = new Button("hhahah");
    Panel panel = new Panel();
    public void init(){
        panel.add(l1);
        panel.add(l2);
        panel.add(b);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new test().init();
    }
}
