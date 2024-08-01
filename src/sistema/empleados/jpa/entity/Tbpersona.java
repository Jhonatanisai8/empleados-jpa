package sistema.empleados.jpa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jhonatan
 */
@Entity
@Table(name = "tbpersona")
@NamedQueries({
    @NamedQuery(name = "Tbpersona.findAll", query = "SELECT t FROM Tbpersona t"),
    @NamedQuery(name = "Tbpersona.findByIdtbpersona", query = "SELECT t FROM Tbpersona t WHERE t.idtbpersona = :idtbpersona"),
    @NamedQuery(name = "Tbpersona.findByNombres", query = "SELECT t FROM Tbpersona t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "Tbpersona.findByApellidos", query = "SELECT t FROM Tbpersona t WHERE t.apellidos = :apellidos"),
    @NamedQuery(name = "Tbpersona.findByEdad", query = "SELECT t FROM Tbpersona t WHERE t.edad = :edad"),
    @NamedQuery(name = "Tbpersona.findByTelefono", query = "SELECT t FROM Tbpersona t WHERE t.telefono = :telefono")})
public class Tbpersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbpersona")
    private Integer idtbpersona;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;

    public Tbpersona() {
    }

    public Tbpersona(Integer idtbpersona) {
        this.idtbpersona = idtbpersona;
    }

    public Tbpersona(Integer idtbpersona, String nombres, String apellidos, int edad, String telefono) {
        this.idtbpersona = idtbpersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
    }

    public Integer getIdtbpersona() {
        return idtbpersona;
    }

    public void setIdtbpersona(Integer idtbpersona) {
        this.idtbpersona = idtbpersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
