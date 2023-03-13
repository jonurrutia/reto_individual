import javax.swing.*;
import java.awt.*;

public class ventana {
    public ventana() {
        //El Frame
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        //parte izquierda
        JPanel izquierda = new JPanel();
        izquierda.setLayout(new GridLayout(1,2));
        String[] n1 = {"fgf", "gg", "ga", "gaga"};
        JComboBox lista = new JComboBox<>(n1);
        JButton bot1 = new JButton("Clear");
        bot1.setSize(new Dimension(1000,10));
        izquierda.add(lista, BorderLayout.EAST);
        izquierda.add(bot1,  BorderLayout.EAST);
        frame.add(izquierda, BorderLayout.WEST);

        //frame.pack();

        frame.setVisible(true);
    }
}
