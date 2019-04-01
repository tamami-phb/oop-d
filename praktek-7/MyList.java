import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MyList extends JFrame {

    public MyList() {
        super("MyList App");
        initWindow();
    }

    public void initWindow() {
        setSize(300, 200);
        JList<String> data = new JList<String>();
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(data, BorderLayout.CENTER);

        String[] makanan = { "Nasi Goreng", "Mie Goreng",
          "Ketoprak" };
        makanan[3] = "Rujak";
        data.setListData(makanan);

        java.util.List<String> list = new LinkedList<String>();
        for(String mkn : makanan) {
            list.add(mkn);
        }
        Collections.sort(list);


        data.setListData(new Vector(list));

        repaint();
        setVisible(true);

        // opsi lain :
        // JFrame.HIDE_ON_CLOSE
        // JFrame.DISPOSE_ON_CLOSE
        // JFrame.DO_NOTHING_ON_CLOSE
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}