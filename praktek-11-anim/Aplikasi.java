import javax.swing.*;
import java.awt.*;
import ui.*;

public class Aplikasi extends JFrame {
    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
    }

    public Aplikasi() {
        initUI();
    }

    private void initUI() {
        MyAnimasi anim = new MyAnimasi();
        add(anim);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}