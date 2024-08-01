package sistema.empleados.jpa;

import sistema.empleados.jpa.dao.PersonaDao;

public class SistemaEmpleadosJpa {

    public static void main(String[] args) {
        PersonaDao persona1 = new PersonaDao();
        System.out.println(persona1.insertarPersona("Samanta Yamilet", "Juares Alarcon", 12, "999888231"));
        System.out.println(persona1.insertarPersona("Kiara Pamela", "Alarcon Sosa", 17, "922888231"));
        System.out.println(persona1.insertarPersona("Erika Rosa", "Salvador", 56, "999123231"));
        
    }

}
