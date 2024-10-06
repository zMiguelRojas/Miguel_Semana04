/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

public class Estudiante {
    private String codigo;
    private String nombre;
    private int edad; // Cambiado a int para que coincida con Integer.parseInt
    private String telefono;
    private String direccion;

    public Estudiante(String codigo, String nombre, int edad, String telefono, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
    }


    // Constructor con edad
    public Estudiante(String codigo, String nombre, String telefono, String direccion, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.edad = edad;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
}