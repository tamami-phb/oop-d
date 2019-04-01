import javax.swing.*;
import java.awt.*;

public class Aplikasi {

    public static void main(String[] args) {
        MyUI.nama = "tamami";
        MyUI app = new MyUI();

        Aplikasi aplikasi = new Aplikasi();
        Aplikasi.MyAnotherUI objekUI = aplikasi.new MyAnotherUI();
        objekUI.nama = "tamami";
    }

    static class MyUI extends JFrame {

        public static String nama;

        public MyUI() {
            super("Aplikasi Static");
            MyUI.nama = "budi";
            setSize(300, 200);
            BorderLayout layout = new BorderLayout();
            setLayout(layout);
            add(new JLabel(MyUI.nama), BorderLayout.CENTER);
            setVisible(true);

            MyUI.nama = "caca";
        }

    }

    public class MyAnotherUI extends JFrame {
        public String nama;

        public MyAnotherUI() {
            super("Aplikasi non-Static");
            nama = "budi";
            setSize(300, 200);
            BorderLayout layout = new BorderLayout();
            setLayout(layout);
            add(new JLabel(MyUI.nama), BorderLayout.CENTER);
            setVisible(true);
        }
    }

}