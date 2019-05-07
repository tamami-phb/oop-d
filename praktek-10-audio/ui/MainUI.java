package ui;

import services.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class MainUI extends JFrame {

    private MyPlayer player;
    private JButton btnPutar;
    private JButton btnJeda;
    private JButton btnLanjutkan;
    private JButton btnHentikan;
    private Container contentPane;

    public MainUI() {
        initUI();
        try {
            player = new MyPlayer("audio/sample.au");
        } catch(UnsupportedAudioFileException e) {
            JOptionPane.showMessageDialog(this,
                    "Berkas Tidak didukung");
        } catch(LineUnavailableException e) {
            JOptionPane.showMessageDialog(this,
                    "Hubungi developer");
        } catch(IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Kesalahan Input Output");
        }
    }

    private void initUI() {
        setTitle("MusiQu");
        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        btnPutar = new JButton("Putar");
        btnJeda = new JButton("Jeda");
        btnLanjutkan = new JButton("Lanjutkan");
        btnHentikan = new JButton("Hentikan");

        contentPane.add(btnPutar);
        contentPane.add(btnJeda);
        contentPane.add(btnLanjutkan);
        contentPane.add(btnHentikan);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}