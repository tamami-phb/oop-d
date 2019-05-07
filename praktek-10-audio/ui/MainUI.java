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

        btnPutar.addActionListener(new BtnPutarClick());
        btnHentikan.addActionListener(new BtnHentikanClick());
        btnJeda.addActionListener(new BtnJedaClick());
        btnLanjutkan.addActionListener(new BtnLanjutkanClick());

        btnPutar.setEnabled(true);
        btnHentikan.setEnabled(false);
        btnJeda.setEnabled(false);
        btnLanjutkan.setEnabled(false);
    }


    // --- events

    private class BtnJedaClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            player.pause();
            btnJeda.setEnabled(false);
            btnLanjutkan.setEnabled(true);
            btnPutar.setEnabled(false);
            btnHentikan.setEnabled(true);
        }
    }

    private class BtnLanjutkanClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            try {
                player.resume();
                btnLanjutkan.setEnabled(false);
                btnPutar.setEnabled(false);
                btnJeda.setEnabled(true);
                btnHentikan.setEnabled(true);
            } catch(UnsupportedAudioFileException e) {
                JOptionPane.showMessageDialog(null,
                        "Berkas Tidak didukung");
            } catch(LineUnavailableException e) {
                JOptionPane.showMessageDialog(null,
                        "Hubungi developer");
            } catch(IOException e) {
                JOptionPane.showMessageDialog(null,
                        "Kesalahan Input Output");
            }
        }
    }

    private class BtnPutarClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            try {
                player.play();
                btnPutar.setEnabled(false);
                btnJeda.setEnabled(true);
                btnLanjutkan.setEnabled(false);
                btnHentikan.setEnabled(true);
            } catch(UnsupportedAudioFileException e) {
                JOptionPane.showMessageDialog(null,
                        "Berkas Tidak didukung");
            } catch(LineUnavailableException e) {
                JOptionPane.showMessageDialog(null,
                        "Hubungi developer");
            } catch(IOException e) {
                JOptionPane.showMessageDialog(null,
                        "Kesalahan Input Output");
            }
        }
    }

    private class BtnHentikanClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            player.stop();
            btnPutar.setEnabled(true);
            btnJeda.setEnabled(false);
            btnLanjutkan.setEnabled(false);
            btnHentikan.setEnabled(false);
        }
    }

}