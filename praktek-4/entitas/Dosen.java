package entitas;

public class Dosen extends Personal {

    private String nid;

    public Dosen() {
        super("na", "na");
    }

    public Dosen(String nid, String nama) {
        super("na", nama);
        this.nid = nid;
    }

    public void cetak() {
        System.out.println(nid + " : " + getNama());
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }
}