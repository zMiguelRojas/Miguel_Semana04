/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Controlador;

import Modelo.Estudiante;
import Modelo.EstudianteArray;
import Vista.Registro;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Controlador {

    private EstudianteArray gestor;
    private Registro vista;

    public Controlador(Registro vista, EstudianteArray gestor) {
        this.vista = vista;
        this.gestor = gestor;

        // Asignar eventos usando los getters de los botones
        this.vista.getBtnGuardar().addActionListener(e -> guardarEstudiante());
        this.vista.getBtnBuscar().addActionListener(e -> buscarPorNombre());
        this.vista.getCargarDatos().addActionListener(e -> cargarDatosDesdeArchivo());
    }

public void guardarEstudiante() {
    // Usar los getters para acceder a los campos
    if (vista.getTxtCodigo().getText().isEmpty() || 
        vista.getTxtNombre().getText().isEmpty() ||
        vista.getTxtTelefono().getText().isEmpty() || 
        vista.getCalendario().getDate() == null || 
        vista.getTxtDireccion().getText().isEmpty()) {
        JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.");
        return;
    }

    // Crear un nuevo estudiante y asignar los valores de los campos
Estudiante estudiante = new Estudiante(
    vista.getTxtCodigo().getText(),
    vista.getTxtNombre().getText(),
    vista.getTxtTelefono().getText(),
    vista.getTxtDireccion().getText(),
    0 // Puedes pasar 0 temporalmente, ya que la edad se calculará en EstudianteArray
);

    // Agregar el estudiante al gestor, pasando la fecha de nacimiento
    gestor.agregarEstudiante(estudiante, vista.getCalendario().getDate());

    // Limpiar los campos después de guardar
    gestor.limpiar(vista.getTxtCodigo(), vista.getTxtNombre(), vista.getTxtTelefono(), vista.getTxtDireccion(), vista.getCalendario());

    // Actualizar la tabla
    gestor.actualizarTabla();
    
    String rutaArchivo = "C:\\Users\\migue\\Downloads\\Semana 05\\estudiantes.txt";
    gestor.guardarDatosEnArchivo(rutaArchivo);
}


    public void buscarPorNombre() {
        String nombreBuscado = vista.getTxtBuscador().getText();
        gestor.buscarPorNombre(nombreBuscado); // Actualiza la tabla según el texto buscado
    }

    public void cargarDatosDesdeArchivo() {
        // Cargar los datos desde el archivo al iniciar el programa
        String rutaArchivo = "C:\\Users\\migue\\Downloads\\Semana 05\\estudiantes.txt";
        gestor.cargarDatosDesdeArchivo(rutaArchivo);
    }

    private int calcularEdad(Date fechaNacimiento) {
        Calendar nacimiento = Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);
        
        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);

        // Verificar si ya cumplió años este año
        if (hoy.get(Calendar.DAY_OF_YEAR) < nacimiento.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }
        
        return edad;
    }
}
