package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {

    private JLabel lblNim;
    private JLabel lblNama;
    private JLabel lblJurusan;
    private JTextField txtNim;
    private JTextField txtNama;
    private JTextField txtJurusan;
    private JButton btnProses;
    private JPanel panel;
    private Container contentPane;

    public MainUI() {
        initUI();
    }

    public void initUI() {
        lblNim = new JLabel("NIM");
        lblNama = new JLabel("NAMA");
        lblJurusan = new JLabel("JURUSAN");
        txtNim = new JTextField();
        txtNama = new JTextField();
        txtJurusan = new JTextField();
        btnProses = new JButton("Proses");

        panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        panel.add(lblNim); panel.add(txtNim);
        panel.add(lblNama); panel.add(txtNama);
        panel.add(lblJurusan); panel.add(txtJurusan);

        contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(btnProses, BorderLayout.SOUTH);

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnProses.addActionListener(new BtnProsesClick());
    }

    private class BtnProsesClick implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(null,
                    txtNim.getText() + " : " +
                    txtNama.getText() + " : " +
                    txtJurusan.getText());
        }
    }

}