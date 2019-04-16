import entity.*;
import services.*;
import java.util.*;

public class Aplikasi {

    private static Scanner scanner;
    private static MahasiswaService service = new MahasiswaService();

    public static void main(String[] args) {
        int opsi = 5;
        do {
            tampilkanMenu();
            scanner = new Scanner(System.in);
            opsi = scanner.nextInt();
            proses(opsi);
        } while(opsi != 5);
    }

    private static void proses(int opsi) {
        switch(opsi) {
            case 1:
                tampilkanFormTambahData();
                break;
            case 2:
                tampilkanFormUbahData();
                break;
            case 3:
                tampilkanFormHapusData();
                break;
            case 4:
                service.tampilkanData();
                break;
        }
    }

    private static void tampilkanFormHapusData() {
        scanner = new Scanner(System.in);
        String nim;

        System.out.println("\n--= Form Hapus Data");
        System.out.print  ("NIM : ");
        nim = scanner.nextLine();
        service.hapusData(nim);
    }



    private static void tampilkanFormUbahData() {
        scanner = new Scanner(System.in);
        String nim, nama, kelas;

        System.out.println("\n--= Form Ubah Data");
        System.out.print  ("NIM : ");
        nim = scanner.nextLine();
        System.out.print("NAMA : ");
        nama = scanner.nextLine();
        System.out.print("KELAS : ");
        kelas = scanner.nextLine();
        service.ubahData(new Mahasiswa(nim, nama, kelas));
    }

    private static void tampilkanFormTambahData() {
        scanner = new Scanner(System.in);
        String nim, nama, kelas;

        System.out.println("\n--= Form Tambah Data");
        System.out.print  ("NIM : ");
        nim = scanner.nextLine();
        System.out.print("NAMA : ");
        nama = scanner.nextLine();
        System.out.print("KELAS : ");
        kelas = scanner.nextLine();
        service.tambahData(new Mahasiswa(nim, nama, kelas));
    }

    private static void tampilkanMenu() {
        System.out.println("\n--= Menu Aplikasi =--");
        System.out.println("1. Tambah Data");
        System.out.println("2. Ubah Data");
        System.out.println("3. Hapus Data");
        System.out.println("4. Tampilkan Data");
        System.out.println("5. KELUAR");
        System.out.println("----------------");
        System.out.print  ("opsi > ");
    }

}