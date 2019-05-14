package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TambahUI extends JFrame {

    private Container contentPane;
    private JPanel panelForm;
    private JPanel panelButton;
    private JLabel lblNim;
    private JLabel lblNama;
    private JLabel lblKelas;
    private JTextField txtNim;
    private JTextField txtNama;
    private JTextField txtKelas;
    private JButton btnSimpan;
    private JButton btnBatal;

    private MainUI parent;

    public TambahUI(MainUI parent) {
        this.parent = parent;
        initUI();
    }

    private void initUI() {
        setTitle("Form Tambah Data");

        contentPane = getContentPane();

        panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(3, 2));
        contentPane.add(panelForm, BorderLayout.CENTER);

        panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(1, 2));
        contentPane.add(panelButton, BorderLayout.SOUTH);

        lblNim = new JLabel("NIM");
        lblNama = new JLabel("NAMA");
        lblKelas = new JLabel("KELAS");
        txtNim = new JTextField();
        txtNama = new JTextField();
        txtKelas = new JTextField();
        panelForm.add(lblNim);
        panelForm.add(txtNim);
        panelForm.add(lblNama);
        panelForm.add(txtNama);
        panelForm.add(lblKelas);
        panelForm.add(txtKelas);

        btnSimpan = new JButton("Simpan");
        btnBatal = new JButton("Batal");
        panelButton.add(btnSimpan);
        panelButton.add(btnBatal);

        pack();

        btnSimpan.addActionListener(new BtnSimpanClick());
        btnBatal.addActionListener(new BtnBatalClick());
    }

    private void clearForm() {
        txtNim.setText("");
        txtNama.setText("");
        txtKelas.setText("");
    }


    // ----- events

    private class BtnSimpanClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String nim, nama, kelas;
            nim = txtNim.getText();
            nama = txtNama.getText();
            kelas = txtKelas.getText();
            String query = "insert into mahasiswa(nim,nama,kelas) " +
                    "values('" + nim + "','" + nama + "','" +
                    kelas + "')";
            try {
                int result = MainUI.koneksi.eksekusiUpdate(query);
                if(result > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Data baru telah tersimpan");
                    setVisible(false);
                    parent.refreshTable();
                    clearForm();
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "Simpan data baru gagal");
            }
        }
    }

    private class BtnBatalClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            setVisible(false);
            clearForm();
        }
    }

}