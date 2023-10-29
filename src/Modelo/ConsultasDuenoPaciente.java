package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConsultasDuenoPaciente extends Conexion {

    public boolean registrar(DuenoPaciente dp) {

        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "INSERT INTO dueno_paciente (IDENTIFICACION, NOMBRES, APELLIDOS, DIRECCION, TELEFONO, CORREO)VALUE(?, ?, ?, ?, ?, ?)";

        try {

            ps = con.prepareStatement(sql);

            ps.setInt(1, dp.getIdentificacion());
            ps.setString(2, dp.getNombres());
            ps.setString(3, dp.getApellidos());
            ps.setString(4, dp.getDireccion());
            ps.setString(5, dp.getTelefono());
            ps.setString(6, dp.getCorreo());

            ps.execute();

            //JOptionPane.showMessageDialog(null, "Se inserto correctamente el dueño del paciente");
            
            return true;

        } catch (Exception e) {

            //JOptionPane.showMessageDialog(null, "No se inserto correctamente el dueño del paciente, error: " + e.toString());
            System.err.println(e);
            
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "No se cerro, error: " + e.toString());
                System.err.println(e);
            }
        }
    }
    
    
    
    public boolean modificar(DuenoPaciente dp) {

        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "UPDATE dueno_paciente SET IDENTIFICACION = ?, NOMBRES = ?, APELLIDOS = ?, DIRECCION = ?, TELEFONO = ?, CORREO = ? WHERE ID_DUENO_PACIENTE = ?";

        try {

            ps = con.prepareStatement(sql);

            ps.setInt(1, dp.getIdentificacion());
            ps.setString(2, dp.getNombres());
            ps.setString(3, dp.getApellidos());
            ps.setString(4, dp.getDireccion());
            ps.setString(5, dp.getTelefono());
            ps.setString(6, dp.getCorreo());
            ps.setInt(7, dp.getId());

            ps.execute();

            //JOptionPane.showMessageDialog(null, "Se modifico correctamente el dueño del paciente");
            
            return true;

        } catch (Exception e) {

            //JOptionPane.showMessageDialog(null, "No se modifico correctamente el dueño del paciente, error: " + e.toString());
            System.err.println(e);
            
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "No se cerro, error: " + e.toString());
                System.err.println(e);
            }
        }
    }
    
    
    
    public boolean eliminar(DuenoPaciente dp) {

        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "DELETE FROM dueno_paciente WHERE ID_DUENO_PACIENTE = ?";

        try {

            ps = con.prepareStatement(sql);

            ps.setInt(1, dp.getId());

            ps.execute();

            //JOptionPane.showMessageDialog(null, "Se elimino correctamente el dueño del paciente");
            
            return true;

        } catch (Exception e) {

            //JOptionPane.showMessageDialog(null, "No se elimino correctamente el dueño del paciente, error: " + e.toString());
            System.err.println(e);
            
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "No se cerro, error: " + e.toString());
                System.err.println(e);
            }
        }
    }
    
    
    
    public boolean buscar(DuenoPaciente dp) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT * FROM dueno_paciente WHERE IDENTIFICACION = ?";

        try {

            ps = con.prepareStatement(sql);

            ps.setInt(1, dp.getIdentificacion());

            rs = ps.executeQuery();
            
            if(rs.next()){
                dp.setId(Integer.parseInt(rs.getString("ID_DUENO_PACIENTE")));
                dp.setIdentificacion(Integer.parseInt(rs.getString("IDENTIFICACION")));
                dp.setNombres(rs.getString("NOMBRES"));
                dp.setApellidos(rs.getString("APELLIDOS"));
                dp.setDireccion(rs.getString("DIRECCION"));
                dp.setTelefono(rs.getString("TELEFONO"));
                dp.setCorreo(rs.getString("CORREO"));
                return true;
            }

            //JOptionPane.showMessageDialog(null, "Se encontro correctamente el dueño del paciente");
            
            return false;

        } catch (Exception e) {

            //JOptionPane.showMessageDialog(null, "No se encontro correctamente el dueño del paciente, error: " + e.toString());
            System.err.println(e);
            
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "No se cerro, error: " + e.toString());
                System.err.println(e);
            }
        }
    }
}
