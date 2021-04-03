
/**
 * Métodos de Listas Simples enfocados en la información personal básica de una Persona
 * 
 * Manejo de Listas Simples mediante Nodos_Apuntadores haciendo uno de estructuras de datos en poo y excepciones en Java
 * 
 * By: Volkmar A Carrillo P
 * e-mail: carrillo.ramklov@gmail.com
 * fecha-publicación: 03/04/2021
 */
package Logica;

public class Nodo {
    //Atributos
    private String nombres, apellidos, direccion, email;
    private int cedula, edad;
    private long telefono;
    private Nodo sig;
    
    //Constructor
    public Nodo(String nombres, String apellidos, String direccion, String email, int cedula, int edad, long telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.cedula = cedula;
        this.edad = edad;
        this.telefono = telefono;
        this.sig = null;
    }
    
    //Métodos
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

}
