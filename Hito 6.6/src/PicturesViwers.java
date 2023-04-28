import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class PicturesViwers extends JFrame {

    public PicturesViwers(){
        JFrame panel_principal = new JFrame();
        panel_principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel_principal.setSize(525,525);
        panel_principal.setLayout(new GridLayout(2,2));
        Conexion c1 = new Conexion();

        JPanel p1 = new JPanel();
        Statement verificar= null;
        String[] nombres = new String[3];
        try {
            verificar = c1.getConn().createStatement();
            ResultSet rs = verificar.executeQuery("select Name from Photographers_table");
            int contador =0;
            while (rs.next()){
                nombres[contador]=rs.getString("Name");
                contador++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
        JLabel texto1 = new JLabel("Photographer:");
        JComboBox lista1 = new JComboBox<>(nombres);
        lista1.setMaximumSize(new Dimension(100,20));
        p1.add(texto1);
        p1.add(lista1);
        panel_principal.add(p1);


        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
        JLabel texto2 = new JLabel("Photos after:");
        JXDatePicker lista2 = new JXDatePicker();
        lista2.setMaximumSize(new Dimension(100,20));
        p2.add(texto2);
        p2.add(lista2);
        panel_principal.add(p2);



        JPanel p3 = new JPanel();
        JList listaNombres=new JList();
        DefaultListModel modelo = new DefaultListModel();
        listaNombres.setModel(modelo);
        listaNombres.setPreferredSize(new Dimension(250,250));
        p3.add(listaNombres);
        panel_principal.add(p3);





        JPanel p4 = new JPanel();
        JLabel l1 = new JLabel();
        p4.add(l1);
        panel_principal.add(p4);



        lista1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String[] titulos = new String[100];
                String fecha;

                int contador = 0;
                String nombre = lista1.getSelectedItem().toString();
                Statement verificar2 = null;
                ResultSet rs=null;
                try {
                    modelo.removeAllElements();
                    verificar2 = c1.getConn().createStatement();
                    if (lista2.getDate()==null){
                         rs = verificar2.executeQuery("select Title from Pictures_table where PhotographerID in (select PhotographerID from Photographers_table where Name = '"+ nombre+"');");
                    }
                    else {
                        fecha = new SimpleDateFormat("yyyy-MM-dd").format(lista2.getDate());
                         rs = verificar2.executeQuery("select Title from Pictures_table where Date > '" + fecha + "' and PhotographerID in (select PhotographerID from Photographers_table where Name = '" + nombre + "');");
                    }
                    while (rs.next()){
                        modelo.addElement(rs.getString("Title"));
                        contador++;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }



            }
        });

        listaNombres.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if (!listSelectionEvent.getValueIsAdjusting()) {
                    String file = "";
                    String titulo = (String) listaNombres.getSelectedValue();
                    Statement verificar3 = null;
                    try {
                        verificar3 = c1.getConn().createStatement();
                        ResultSet rs = verificar3.executeQuery("select File from Pictures_table where Title = '" + titulo + "'");
                        while (rs.next()) {
                            file = rs.getString("File");
                        }
                        l1.setIcon(new ImageIcon(file));


                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });



        panel_principal.setVisible(true);


    }



}
