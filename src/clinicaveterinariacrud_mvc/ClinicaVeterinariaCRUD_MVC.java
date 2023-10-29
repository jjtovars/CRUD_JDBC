package clinicaveterinariacrud_mvc;

import Controlador.CtrlDuenoPaciente;
import Modelo.ConsultasDuenoPaciente;
import Modelo.DuenoPaciente;
import Vista.frmDuenoPaciente;

public class ClinicaVeterinariaCRUD_MVC {

    public static void main(String[] args) {
        
        DuenoPaciente mod = new DuenoPaciente();
        ConsultasDuenoPaciente modC = new ConsultasDuenoPaciente();
        frmDuenoPaciente frm = new frmDuenoPaciente();
        
        CtrlDuenoPaciente ctrl = new CtrlDuenoPaciente(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
