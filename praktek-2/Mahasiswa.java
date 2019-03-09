public class Mahasiswa {

    private String nim;
    private String nama;

    //Mahasiswa() {
    //    nim = "19000";
    //    nama = "tidak ada";
    //}

    Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    void cetak() {
        System.out.println(nim + " : " + nama);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}