package ista.cursoM4A.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String correo;
    private Date f_nacimiento;

    @ManyToOne
    private Roles rol;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<UsuCarrera> usuCarreras;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<UsuUnidad> usuUnidades;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getF_nacimiento() {
        return f_nacimiento;
    }
    public void setF_nacimiento(Date f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }
    public Roles getRol() {
        return rol;
    }
    public void setRol(Roles rol) {
        this.rol = rol;
    }
    public List<UsuCarrera> getUsuCarreras() {
        return usuCarreras;
    }
    public void setUsuCarreras(List<UsuCarrera> usuCarreras) {
        this.usuCarreras = usuCarreras;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public List<UsuUnidad> getUsuUnidades() {
        return usuUnidades;
    }
    public void setUsuUnidades(List<UsuUnidad> usuUnidades) {
        this.usuUnidades = usuUnidades;
    }
}
