package sistema.empleados.jpa.test;

import sistema.empleados.jpa.dao.TbPersonaDAO;

public class PersonaTest {

    public static void main(String[] args) {
        TbPersonaDAO pdao = new TbPersonaDAO();
        String mensaje = pdao.insertarPersona("Juan Jose", "Marquez Juarez", 34, "955678345");
        System.out.println(mensaje);
    }
}
