package sistema.empleados.jpa.test;

import sistema.empleados.jpa.dao.TbPersonaDao;

public class PersonaTest {

    public static void main(String[] args) {
        TbPersonaDao pdao = new TbPersonaDao();
        String mensaje = pdao.insertarPersona("Juan Jose", "Marquez Juarez", 34, "955678345");
        System.out.println(mensaje);
    }
}
