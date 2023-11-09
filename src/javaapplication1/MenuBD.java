package javaapplication1;

import com.sun.jdi.connect.spi.Connection;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.sql.*;
import java.util.ArrayList;

public class MenuBD extends javax.swing.JFrame {

    private Pmenu pmenu;
    public MenuBD() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        verTablasBtn = new javax.swing.JButton();
        TextoNombreBD = new javax.swing.JLabel();
        jComboBoxTablas = new javax.swing.JComboBox<>();
        eliminarTablaBtn = new javax.swing.JButton();
        crearTablaBtn = new javax.swing.JButton();
        describirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        verTablasBtn.setText("Ver Tabla");
        verTablasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTablasBtnActionPerformed(evt);
            }
        });

        TextoNombreBD.setText("Seleccione la tabla a la cual desea acceder");

        jComboBoxTablas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        eliminarTablaBtn.setText("Eliminar");

        crearTablaBtn.setText("Crear Nueva Tabla");

        describirBtn.setText("Describir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(describirBtn)
                    .addComponent(jComboBoxTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verTablasBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarTablaBtn))
                    .addComponent(crearTablaBtn)
                    .addComponent(TextoNombreBD))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(TextoNombreBD)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verTablasBtn)
                    .addComponent(eliminarTablaBtn))
                .addGap(33, 33, 33)
                .addComponent(describirBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crearTablaBtn)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verTablasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTablasBtnActionPerformed
tablas t = new tablas();        // TODO add your handling code here:
t.setVisible(true);
this.dispose();
    }//GEN-LAST:event_verTablasBtnActionPerformed
/*
    private void cargarTablas() {
        Conexion cx;
        Pmenu p=new Pmenu(cx);
        String bd = p.getTextBD(); // Obtiene el nombre de la base de datos seleccionada
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        try {
            String url="jdbc:mysql://localhost:3306/";
            String user="root";
            String password="12345";
            
            Connection c = (Connection) DriverManager.getConnection(url+bd, user, password);
            Statement st = ;

            //obtener los nombres de las tablas en la bd
            String query = "SHOW TABLES";
            ResultSet resultSet = st.executeQuery(query);

            //agrega los nombres de las tablas al combo box
            while (resultSet.next()) {
                String tableName = resultSet.getString(1);
                model.addElement(tableName);
            }

            // Cierra las conexiones y asigna el modelo al JComboBox
            resultSet.close();
            st.close();
            c.close();
        } catch (SQLException ex) {
        }

        jComboBoxTablas.setModel(model);
    }*/
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            private Conexion Conexion;
            public void run() {
                MenuBD menu= new MenuBD();
                menu.setVisible(true);    
            }
        });
        
    }  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TextoNombreBD;
    private javax.swing.JButton crearTablaBtn;
    private javax.swing.JButton describirBtn;
    private javax.swing.JButton eliminarTablaBtn;
    private javax.swing.JComboBox<String> jComboBoxTablas;
    private javax.swing.JButton verTablasBtn;
    // End of variables declaration//GEN-END:variables
}
