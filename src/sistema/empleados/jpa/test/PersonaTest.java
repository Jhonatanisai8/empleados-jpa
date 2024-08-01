package sistema.empleados.jpa.test;

import sistema.empleados.jpa.dao.TbPersonaDao;

public class PersonaTest {

    public static void main(String[] args) {
        TbPersonaDao pdao = new TbPersonaDao();
        String mensaje = pdao.insertarPersona("Alberto Eli", "Ojeda Perez", 34, "955111345");
        System.out.println(mensaje);
    }
}
