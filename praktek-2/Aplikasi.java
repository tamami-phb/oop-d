public class Aplikasi {

    public static void main(String[] args) {
        int angka = 0;

        if(args.length == 1) {
            angka = new Integer(args[0]);
            String hasil = (angka % 2 == 0) ? "genap" : "ganjil";
            System.out.println(angka + " : " + hasil);
        } else {
            System.out.println("Gunakan : java Aplikasi {angka}");
        }
    }

}