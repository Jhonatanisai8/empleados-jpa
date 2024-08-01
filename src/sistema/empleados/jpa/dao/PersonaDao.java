/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.empleados.jpa.dao;

/**
 *
 * @author User
 */
import sistema.empleados.jpa.controlador.TbpersonaJpaController;
import sistema.empleados.jpa.entity.Tbpersona;

public class PersonaDao {

    private TbpersonaJpaController tjc = new TbpersonaJpaController();
    private Tbpersona persona = new Tbpersona();

    /*
    métodos
     */
    private String mensaje = "";
    public String insertarPersona(String nombres, String apellidos, int edad, String telefono) {
        try {
            persona.setIdtbpersona(Integer.BYTES);
            persona.setNombres(nombres);
            persona.setApellidos(apellidos);
            persona.setEdad(edad);
            persona.setTelefono(telefono);

            tjc.create(persona);
            
            
            mensaje = "guardado";
        } catch (Exception e) {
            mensaje = "no se pudo guardar persona";
            System.out.println("no se pudo guardar ocurrio un error =>"+e.getMessage());
        }
        return mensaje;
    }

    public String actualizarPersona() {
        return null;
    }

    public String eliminarPersona() {
        return null;
    }
}
