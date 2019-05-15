package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;
import util.*;
import java.sql.*;
import org.apache.log4j.Logger;

public class MainUI extends JFrame {

    Logger log = Logger.getLogger(MainUI.class.getName());

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
    public static EditUI ubahUI;
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
            log.error(e);
        }
    }

    public void refreshTable() {
        initData();
    }

    private void initUI() {
        setTitle("Aplikasi Mahasiswa");

        tambahUI = new TambahUI(this);
        ubahUI = new EditUI(this);

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

        table.setSelectionModel(new CustomSingleModeSelection());

        btnTambah.addActionListener(new BtnTambahClick());
        btnUbah.addActionListener(new BtnUbahClick());
        btnHapus.addActionListener(new BtnHapusClick());
    }

    // --- single mode selection

    private class CustomSingleModeSelection extends DefaultListSelectionModel {
        public CustomSingleModeSelection() {
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }


    // --- events

    private class BtnHapusClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String nim;
            if(table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Data yang akan dihapus harus dipilih dulu");
                return;
            }
            nim = "" + table.getValueAt(table.getSelectedRow(), 0);
            String query = "delete from mahasiswa " +
                    "where nim='" + nim + "'";
            try {
                int result = koneksi.eksekusiUpdate(query);
                if(result > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Data NIM " + nim + " telah terhapus");
                    refreshTable();
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "Data gagal dihapus");
            }
        }
    }

    private class BtnTambahClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            tambahUI.setVisible(true);
        }
    }

    private class BtnUbahClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String nim, nama, kelas;
            if(table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Silahkan pilih dulu data yang akan diubah");
                return;
            }
            nim = "" + table.getValueAt(table.getSelectedRow(), 0);
            nama = table.getValueAt(table.getSelectedRow(), 1).toString();
            kelas = (String) table.getValueAt(table.getSelectedRow(), 2);
            ubahUI.tampilkanForm(nim, nama, kelas);
        }
    }

}