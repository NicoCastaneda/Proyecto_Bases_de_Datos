package javaapplication1;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private int errorConectar=0;
    String bd="";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="12345";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    Statement st;
    ResultSet rs;

public Conexion(String bd, String user, String password){  
    this.bd=bd;
    this.user=user;
    this.password=password;
    this.errorConectar=0;
} 

public Connection conectar(){
        try {
            cx=DriverManager.getConnection(url+bd, user, password);
           MenuBD m=new MenuBD();             
           m.setVisible(true);
        
        } catch (SQLException ex) {
            errorConectar=1;
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return cx;
}
public int getErrorConectar(){
    return errorConectar;
}
public Connection crearBase(String bd){
    try { 
        cx=DriverManager.getConnection(url, "root", "12345");  
        st=cx.createStatement();
            
        String sql= ("CREATE DATABASE " + bd);
        st.executeUpdate(sql);
        
        JOptionPane.showMessageDialog(null, "Se creó la base de datos "+bd);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo crear la base de datos\n\n"+ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return cx;  
}
public Connection eliminarBase(String bd){
    try { 
        cx=DriverManager.getConnection(url, "root", "12345");  
        st=cx.createStatement();
            
        String sql= ("DROP DATABASE " + bd);
        st.executeUpdate(sql);
        
        JOptionPane.showMessageDialog(null, "Se eliminó la base de datos "+bd);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la base de datos\n\n"+ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return cx;  
}
public ArrayList<String> verBases(){
    ArrayList<String> listaBD = new ArrayList<>();
     try {    
         cx = DriverManager.getConnection(url, user, password);
            String sql = "SELECT schema_name FROM information_schema.schemata";// Consulta SQL para seleccionar los nombres de las bases de datos
            Statement st = cx.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Agrega los nombres de las bases de datos a la lista
            while (rs.next()) {
                listaBD.add(rs.getString("schema_name"));
            }

            rs.close();
            st.close();
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaBD;
}
  
public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    public static void main(String[] args) {
      
    }
}