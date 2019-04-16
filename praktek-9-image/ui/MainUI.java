package ui;

import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {

    private ImageIcon image;
    private JLabel lbl;

    public MainUI() {
        initUI();
    }

    private void initUI() {
        image = new ImageIcon("image/foto.jpeg");
        lbl = new JLabel(image);

        getContentPane().add(lbl, BorderLayout.CENTER);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}