import javax.swing.*;
import java.awt.*;

public class ventana {

    public  ventana (){
        //El Frame
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());

        //La parte de arriba
        JCheckBox box1 = new JCheckBox("katniss");
        JCheckBox box2 = new JCheckBox("peeta");
        JPanel Arriba = new JPanel();
        Arriba.add(box1, BorderLayout.CENTER);
        Arriba.add(box2, BorderLayout.CENTER);
        frame.add(Arriba, BorderLayout.NORTH);

        //parte del medio
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(2,2,0,0));
        JLabel l1 = new JLabel(new ImageIcon("descarga.jpg"));
        JLabel l2 = new JLabel(new ImageIcon("descarga.jpg"));
        JLabel l3 = new JLabel(new ImageIcon("descarga.jpg"));
        JLabel l4 = new JLabel(new ImageIcon("descarga.jpg"));
        centro.add(l1);
        centro.add(l2);
        centro.add(l3);
        centro.add(l4);
        frame.add(centro, BorderLayout.CENTER);


        //parte de abajo
        JPanel abajo = new JPanel();
        abajo.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton boton1 = new JButton("But 1");
        JButton boton2= new JButton("But 2");
        boton2.setSize(50,20);
        boton1.setSize(50,20);
        abajo.add(boton1, BorderLayout.WEST);
        abajo.add(boton2);
        frame.add(abajo, BorderLayout.SOUTH);


        //parte de la derecha
        JPanel derecha = new JPanel();
        derecha.setLayout(new BoxLayout(derecha, BoxLayout.Y_AXIS));
        JRadioButton [] array1 = {new JRadioButton("OPT 1", true),  new JRadioButton("OPT 1"), new JRadioButton("OPT 1")};
        ButtonGroup b1 = new ButtonGroup();
        derecha.add(Box.createVerticalGlue());
        for (JRadioButton j : array1){
            b1.add(j);
            derecha.add(j);
        }
        derecha.add(Box.createVerticalGlue());
        frame.add(derecha, BorderLayout.EAST,1);

        //frame.pack();

        frame.setVisible(true);
    }
}
