import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ventana {
    public ventana() {
        String fichero1="python.txt";
        String fichero2="c.txt";
        String fichero3="java.txt";

        //El Frame
        JFrame frame = new JFrame("Hito2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        //parte izquierda
        JPanel izquierda = new JPanel();
        String[] Array1 = {fichero1, fichero2, fichero3};
        JComboBox lista = new JComboBox<>(Array1);
        lista.setPreferredSize(new Dimension(200,25));
        JButton bot1 = new JButton("Clear");
        bot1.setSize(new Dimension(1000,10));
        izquierda.add(lista, BorderLayout.EAST);
        izquierda.add(bot1,  BorderLayout.EAST);
        frame.add(izquierda, BorderLayout.WEST);



        //parte de la derecha
        JPanel derecha = new JPanel();
        derecha.setLayout(new BoxLayout(derecha, BoxLayout.Y_AXIS));
        JTextArea texto = new JTextArea("");
        texto.setEditable(false);
        JScrollPane Area = new JScrollPane(texto);
        Area.setPreferredSize(new Dimension(350,350));
        JButton boton = new JButton("Close");
        derecha.add(Area);
        derecha.add(boton);
        frame.add(derecha);

        JOptionPane error = new JOptionPane();


        //acciones
        lista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fichero = (String) lista.getSelectedItem();

                try{
                    String contenido = new String(Files.readAllBytes(Paths.get(fichero)));
                    texto.setText(contenido);
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(error,"No existe el archivo");
                }
            }
        });
        bot1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText("");
            }
        });
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        //frame.pack();

        frame.setVisible(true);
    }
}
