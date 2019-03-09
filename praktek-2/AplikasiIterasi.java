public class AplikasiIterasi {

    public static void main(String[] args) {
        Mahasiswa[] mhs = {
          new Mahasiswa("19001", "tamami"),
          new Mahasiswa("19002", "diva"),
          new Mahasiswa("19003", "nabila")
        };

        int a=0;
        for(; a < mhs.length ;) {
            mhs[a].cetak();
            a += 2;
        }

        int c = 2;
        System.out.println(++c);
        System.out.println(c);

        System.out.println("\n\nanother for");
        for(Mahasiswa data : mhs) {
            data.cetak();
        }
    }

}