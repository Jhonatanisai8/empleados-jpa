package sistema.empleados.jpa.dao;

import sistema.empleados.jpa.controlador.TbpersonaJpaController;
import sistema.empleados.jpa.entity.Tbpersona;

public class tbPersonaDAO {

    private TbpersonaJpaController tjc = new TbpersonaJpaController();
    private  Tbpersona persona = new Tbpersona();
    /*
    métodos
     */
    public String insertarPersona(String nombres,String apellidos,int edad,String telefono) {
        try {
            persona.setIdtbpersona(Integer.BYTES);
            persona.setNombres(nombres);
            persona.setApellidos(apellidos);
            persona.setEdad(edad);
            persona.setTelefono(telefono);

            tjc.create(persona);
        } catch (Exception e) {
            
        }
        return null;
    }

    public String actualizarPersona() {
        return null;
    }

    public String eliminarPersona() {
        return null;
    }
}
