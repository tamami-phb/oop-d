package services;

import java.util.*;
import entity.*;

public class MahasiswaService {

    private static List<Mahasiswa> data = new LinkedList<Mahasiswa>();

    public void tambahData(Mahasiswa mhs) {
        data.add(mhs);
        System.out.println("Data sudah tersimpan");
    }

    public void ubahData(Mahasiswa mhs) {
        int idx = data.indexOf(mhs);
        if(idx >= 0) data.set(idx, mhs);
        System.out.println("Data sudah berubah");
    }

    public void hapusData() {}

    public void tampilkanData() {
        System.out.println("\n--= Isi Data =--");
        int urutan = 1;
        for(Mahasiswa mhs : data) {
            System.out.println("data ke-" + urutan++);
            System.out.println("  NIM : " + mhs.getNim());
            System.out.println("  NAMA : " + mhs.getNama());
            System.out.println("  KELAS : " + mhs.getKelas());
        }
    }

}