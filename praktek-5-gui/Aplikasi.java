import javax.swing.*;
import java.awt.*;

public class Aplikasi {

    public static void main(String[] args) {
        JFrame frame = new JFrame("halo");
        frame.setSize(300, 200);

        frame.setLayout(new BorderLayout());

        JLabel lblNama = new JLabel();
        lblNama.setText("tamami");
        frame.add(lblNama, BorderLayout.WEST);

        JButton btnSimpan = new JButton("Simpan");
        frame.add(btnSimpan, BorderLayout.EAST);

        frame.setVisible(true);
    }

}