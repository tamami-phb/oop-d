import java.util.*;

public class AplikasiCari {

    public static void main(String[] args) {
        List<Integer> data = new LinkedList<Integer>();

        data.add(4);
        data.add(2);
        data.add(8);
        data.add(7);
        data.add(3);
        data.add(5);
        data.add(1);

        System.out.println("data asli: ");
        for(int i : data) {
            System.out.println(i);
        }

        Collections.sort(data);
        System.out.println("\ndata terurut: ");
        for(int i : data) {
            System.out.println(i);
        }

        System.out.println("\ndata 5 -> " +
                Collections.binarySearch(data, 5));
        System.out.println("\ndata 6 -> " + Collections.binarySearch(data, 6));

    }

}