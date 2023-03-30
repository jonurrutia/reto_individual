import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.PasswordAuthentication;

public class ventana {
    public ventana() throws FileNotFoundException {
        String Imagen1="i1.png";
        String Imagen2="i2.png";
        String Imagen3="i3.png";

        //El Frame
        JPanel aviso = new JPanel();
        String contrasena =JOptionPane.showInputDialog("Escriba su contraseña");
        if (!contrasena.equals("damocles")){
            JPanel error = new JPanel();
            JOptionPane.showMessageDialog(error, "Contraseña incorrecta", "¡¡Error!!", JOptionPane.ERROR_MESSAGE);

        } else {
            JFrame frame = new JFrame("Hito3");
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setSize(500, 500);
            frame.setLayout(new GridLayout(1, 2));


            //parte izquierda
            JPanel izquierda = new JPanel();
            JPanel izquierda2 = new JPanel();
            JPanel izquierda3 = new JPanel();
            izquierda.setLayout(new BoxLayout(izquierda, BoxLayout.Y_AXIS));
            String[] Array1 = {Imagen1, Imagen2, Imagen3};
            JComboBox lista = new JComboBox<>(Array1);
            lista.setPreferredSize(new Dimension(200, 25));
            JLabel label = new JLabel();
            label.setPreferredSize(new Dimension(80, 300));
            JCheckBox check = new JCheckBox();
            JLabel texto = new JLabel("Save your comment");
            JButton boton = new JButton("Save");
            izquierda2.add(check);
            izquierda2.add(texto);
            izquierda.add(lista);
            izquierda.add(label);
            izquierda.add(izquierda2);
            izquierda.add(boton);
            izquierda3.add(izquierda);
            izquierda3.setSize(300, 200);
            frame.add(izquierda3, BorderLayout.WEST);


            //Parte Derecha
            JPanel derecha = new JPanel();
            derecha.setLayout(new GridLayout(7, 1));
            JTextArea txto = new JTextArea();
            JScrollPane p1 = new JScrollPane(txto);
            p1.setPreferredSize(new Dimension(100, 20));
            derecha.add(Box.createVerticalGlue());
            derecha.add(Box.createVerticalGlue());
            derecha.add(Box.createVerticalGlue());
            derecha.add(p1);
            derecha.add(Box.createVerticalGlue());
            derecha.add(Box.createVerticalGlue());
            derecha.add(Box.createVerticalGlue());
            frame.add(derecha);


            //acciones
            lista.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String fichero = (String) lista.getSelectedItem();
                    load_combo(fichero, label);
                }

            });

            FileOutputStream file = new FileOutputStream("guardados.txt");
            DataOutputStream data = new DataOutputStream(file);

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (check.isSelected()) {
                        try {
                            String nombre = (String) lista.getSelectedItem();
                            data.write(nombre.getBytes());
                            data.write(" ".getBytes());
                            data.write(txto.getText().getBytes());
                            data.write("\n".getBytes());
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }


                    }
                }
            });
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    frame.dispose();
                    JOptionPane.showMessageDialog(frame,"Adios");

                }
            });


            //frame.pack();

            frame.setVisible(true);

        }

    }
    public void load_combo(String fichero, JLabel label){
        Image img = new ImageIcon(fichero).getImage();
        img = img.getScaledInstance(165,80,Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(img);
        label.setIcon(logo);
    }
}
