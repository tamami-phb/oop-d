import entitas.*;

public class Aplikasi {

    public static void main(String[] args) {
        Mahasiswa[] dataMhs = {
          new Mahasiswa("19001", "tamami"),
          new Mahasiswa("19002", "diva"),
          new Mahasiswa("19003", "nabila")
        };

        for(Mahasiswa mhs : dataMhs) {
            mhs.cetak();
            //System.out.println(mhs.getNama());
        }

        System.out.println();
        Dosen dosen = new Dosen();
        dosen.setNid("1984001");
        dosen.setNama("honda");
        dosen.cetak();

        System.out.println();
        Personal[] dataPerson = {
          new Mahasiswa("19001", "tamami"),
          new Dosen("1984001", "honda"),
          new Mahasiswa("19002", "diva"),
          new Dosen("1988001", "shizuka"),
          new Dosen("1991001", "mazda")
        };
        for(Personal personal : dataPerson) {
            personal.cetak();
        }
    }

}