package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MainUI extends JFrame {

    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnTambah;
    private JButton btnUbah;
    private JButton btnHapus;
    private JPanel panelButton;
    private Container contentPane;
    private Vector columnNames;

    public MainUI() {
        initUI();
    }

    private void initUI() {
        setTitle("Aplikasi Mahasiswa");

        contentPane = getContentPane();

        columnNames = new Vector();
        columnNames.add("NIM");
        columnNames.add("NAMA");
        columnNames.add("KELAS");
        table = new JTable(null, columnNames);
        scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        btnTambah = new JButton("Tambah");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");
        panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(1,3));
        panelButton.add(btnTambah);
        panelButton.add(btnUbah);
        panelButton.add(btnHapus);
        contentPane.add(panelButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}