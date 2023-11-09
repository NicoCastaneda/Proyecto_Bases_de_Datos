package javaapplication1;

import com.sun.jdi.connect.spi.Connection;
import java.awt.*;
import java.lang.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class Pmenu extends javax.swing.JFrame {
    private Conexion conexion;    
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="12345";
    String driver="com.mysql.cj.jdbc.Driver";
    java.sql.Connection cx;
    Statement st;
    ResultSet rs;
    public Pmenu(Conexion conexion) {
        initComponents();
        this.conexion=conexion;
        String SelectedDB=(String)jTextField1.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        connectarBD = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        verBD = new javax.swing.JButton();
        CrearBD = new javax.swing.JButton();
        EliminarBD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        connectarBD.setText("Conectar");
        connectarBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                connectarBDMouseClicked(evt);
            }
        });
        connectarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectarBDActionPerformed(evt);
            }
        });

        jLabel2.setText("Escriba la base de datos a la cual se quiere conectar, crear o eliminar");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        verBD.setText("Ver Bases");
        verBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verBDMouseClicked(evt);
            }
        });
        verBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBDActionPerformed(evt);
            }
        });

        CrearBD.setText("Crear Nueva Base");
        CrearBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrearBDMouseClicked(evt);
            }
        });

        EliminarBD.setText("Eliminar Base");
        EliminarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(connectarBD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CrearBD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EliminarBD))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verBD)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CrearBD)
                        .addComponent(EliminarBD))
                    .addComponent(connectarBD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(verBD)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    private void connectarBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connectarBDMouseClicked
      String SelectedDB=(String)jTextField1.getText();
      this.dispose();
       try{
      cx=DriverManager.getConnection(url+SelectedDB , "root", "12345");  
        st=cx.createStatement();
            
        String sql= ("USE " + SelectedDB);
        st.executeUpdate(sql);
       
        System.out.println(SelectedDB);
        Conexion conexion = new Conexion(SelectedDB,"root","12345");
        conexion.conectar();
        if (conexion.getErrorConectar()==0){
            JOptionPane.showMessageDialog(null, "Se conectó a la base de datos "+SelectedDB);
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos "+SelectedDB+", es posible que no exista.\nSi desea agregar esta nueva base de datos haga click en el botón 'Crear Nueva Base'");
        }
        }catch(Exception e){
            
      }
    }//GEN-LAST:event_connectarBDMouseClicked

    private void connectarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectarBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectarBDActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        String selectedDB = (String) jTextField1.getText();
    System.out.println("Base de datos seleccionada: " + selectedDB);
    

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void verBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verBDMouseClicked
        ArrayList<String> basesDeDatos = conexion.verBases();
        StringBuilder mensaje = new StringBuilder("Bases de Datos Disponibles:\n\n");

        for (String dbName : basesDeDatos) {
            mensaje.append(dbName).append("\n");
        }

        // Muestra la lista de bases de datos en un JOptionPane
        JOptionPane.showMessageDialog(this, mensaje.toString(), "Bases de Datos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_verBDMouseClicked

    private void verBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBDActionPerformed

    }//GEN-LAST:event_verBDActionPerformed

    private void CrearBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearBDMouseClicked
        String nuevaBD = jTextField1.getText();
        Conexion cx=new Conexion(nuevaBD,"root","12345");
        cx.crearBase(nuevaBD);
    }//GEN-LAST:event_CrearBDMouseClicked

    private void EliminarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBDActionPerformed
        String bd = jTextField1.getText();
        Conexion cx=new Conexion(bd,"root","12345");
        cx.eliminarBase(bd);
    }//GEN-LAST:event_EliminarBDActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }
    public String getTextBD(){
        return jTextField1.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearBD;
    private javax.swing.JButton EliminarBD;
    private javax.swing.JButton connectarBD;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton verBD;
    // End of variables declaration//GEN-END:variables
}
