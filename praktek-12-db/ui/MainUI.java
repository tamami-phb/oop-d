package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;
import util.*;
import java.sql.*;

public class MainUI extends JFrame {

    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnTambah;
    private JButton btnUbah;
    private JButton btnHapus;
    private JPanel panelButton;
    private Container contentPane;
    private Vector columnNames;
    private Vector data;
    private DefaultTableModel tableModel;

    public static TambahUI tambahUI;
    public static Koneksi koneksi;

    public MainUI() {
        koneksi = new Koneksi();
        initUI();
        initData();
    }

    private void initData() {
        String query = "select * from mahasiswa";
        try {
            ResultSet result = koneksi.eksekusiQuery(query);
            data = new Vector();
            while(result.next()) {
                Vector row = new Vector();
                row.add(result.getString(1));
                row.add(result.getString(2));
                row.add(result.getString(3));
                data.add(row);
            }
            tableModel.setDataVector(data, columnNames);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Ada kesalahan query");
        }
    }

    public void refreshTable() {
        initData();
    }

    private void initUI() {
        setTitle("Aplikasi Mahasiswa");

        tambahUI = new TambahUI(this);

        contentPane = getContentPane();

        columnNames = new Vector();
        columnNames.add("NIM");
        columnNames.add("NAMA");
        columnNames.add("KELAS");
        data = new Vector();
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
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

        btnTambah.addActionListener(new BtnTambahClick());
    }


    // --- events

    private class BtnTambahClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            tambahUI.setVisible(true);
        }
    }

}