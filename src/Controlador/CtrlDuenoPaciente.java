package Controlador;

import Modelo.ConsultasDuenoPaciente;
import Modelo.DuenoPaciente;
import Vista.frmDuenoPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlDuenoPaciente implements ActionListener {
    
    private DuenoPaciente mod;
    private ConsultasDuenoPaciente modC;
    private frmDuenoPaciente frm;
    
    public CtrlDuenoPaciente(DuenoPaciente mod, ConsultasDuenoPaciente modC, frmDuenoPaciente frm){ //CONSTRUCTOR
        
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }
    
    public void iniciar(){
        frm.setTitle("Dueño Paciente"); // titulo
        frm.setLocationRelativeTo(null); //Formulario centrado
        frm.txtId.setVisible(false); //Para que no se vea el Text Field de Id 
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == frm.btnGuardar){
            mod.setIdentificacion(Integer.parseInt(frm.txtIdentificacion.getText()));
            mod.setNombres(frm.txtNombres.getText());
            mod.setApellidos(frm.txtApellidos.getText());
            mod.setDireccion(frm.txtDireccion.getText());
            mod.setTelefono(frm.txtTelefono.getText());
            mod.setCorreo(frm.txtCorreo.getText());
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        
        if(e.getSource() == frm.btnModificar){
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setIdentificacion(Integer.parseInt(frm.txtIdentificacion.getText()));
            mod.setNombres(frm.txtNombres.getText());
            mod.setApellidos(frm.txtApellidos.getText());
            mod.setDireccion(frm.txtDireccion.getText());
            mod.setTelefono(frm.txtTelefono.getText());
            mod.setCorreo(frm.txtCorreo.getText());
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        
        if(e.getSource() == frm.btnEliminar){
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        
        if(e.getSource() == frm.btnBuscar){
            
            mod.setIdentificacion(Integer.parseInt(frm.txtIdentificacion.getText()));
                      
            if(modC.buscar(mod)){
                
                 frm.txtId.setText(String.valueOf(mod.getId()));
                 frm.txtIdentificacion.setText(String.valueOf(mod.getIdentificacion()));
                 frm.txtNombres.setText(mod.getNombres());
                 frm.txtApellidos.setText(mod.getApellidos());
                 frm.txtDireccion.setText(mod.getDireccion());
                 frm.txtTelefono.setText(mod.getTelefono());
                 frm.txtCorreo.setText(mod.getCorreo());
                
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
        
        
        if(e.getSource() == frm.btnLimpiar){
                limpiar();
            }
    }
    
    public void limpiar(){
        
        frm.txtId.setText(null);
        frm.txtIdentificacion.setText(null);
        frm.txtNombres.setText(null);
        frm.txtApellidos.setText(null);
        frm.txtDireccion.setText(null);
        frm.txtTelefono.setText(null);
        frm.txtCorreo.setText(null);
    }
}
