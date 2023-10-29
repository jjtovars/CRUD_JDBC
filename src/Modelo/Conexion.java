package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    private String usuario = "root";
    private String password = "Joseles10";
    private String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
    private Connection con = null;
    //Statement statement;
    //ResultSet rs;
    
    public Connection getConnection(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection(this.url,this.usuario,this.password);
            //JOptionPane.showMessageDialog(null, "La conexion se ha realizado con exito");
            
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "error al conectarse a la base de datos, error: "+ e.toString());
            System.err.println(e);
        }
        return con;
    }
}
