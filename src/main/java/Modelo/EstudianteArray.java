/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class EstudianteArray {

    private ArrayList<Estudiante> listaEstudiante;
    private DefaultTableModel modelo;

    // Constructor que acepta DefaultTableModel
    public EstudianteArray(DefaultTableModel modelo) {
        this.listaEstudiante = new ArrayList<>();
        this.modelo = modelo;
    }

public void agregarEstudiante(Estudiante estudiante, Date fechaNacimiento) {
    if (listaEstudiante.size() >= 5) {
        JOptionPane.showMessageDialog(null, "No se pueden registrar más de 5 estudiantes.");
        return;
    }

    // Calcular la edad basada en la fecha de nacimiento
    int edad = calcularEdad(fechaNacimiento);
    estudiante.setEdad(edad);  // Asigna la edad calculada

    listaEstudiante.add(estudiante);
    actualizarTabla(); // Actualizar la tabla al agregar un estudiante
    guardarDatosEnArchivo("C:\\Users\\migue\\Downloads\\Semana 05\\estudiantes.txt");
}

    // Método para calcular la edad en función de la fecha de nacimiento
    public int calcularEdad(Date fechaNacimiento) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaNacimiento);
        int añoNacimiento = cal.get(Calendar.YEAR);
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);
        return añoActual - añoNacimiento;
    }

    public void actualizarTabla() {
        // Limpiar la tabla actual
        modelo.setRowCount(0);

        // Agregar todos los estudiantes a la tabla
        for (Estudiante e : listaEstudiante) {
            modelo.addRow(new Object[]{e.getCodigo(), e.getNombre(), e.getEdad(), e.getTelefono(), e.getDireccion()});
        }
    }

    // Método para limpiar los campos del formulario
    public void limpiar(javax.swing.JTextField txtCodigo, javax.swing.JTextField txtNombre,
            javax.swing.JTextField txtTelefono, javax.swing.JTextField txtDireccion,
            com.toedter.calendar.JCalendar calendario) {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        calendario.setDate(null);
    }

    public void buscarPorNombre(String nombre) {
        // Limpiar la tabla actual
        modelo.setRowCount(0);

        // Filtrar la lista por nombre y agregar los resultados a la tabla
        for (Estudiante e : listaEstudiante) {
            if (e.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                modelo.addRow(new Object[]{e.getCodigo(), e.getNombre(), e.getEdad(), e.getTelefono(), e.getDireccion()});
            }
        }
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiante;
    }

    public void guardarDatosEnArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Estudiante estudiante : listaEstudiante) {
                writer.write(estudiante.getCodigo() + ","
                        + estudiante.getNombre() + ","
                        + estudiante.getEdad() + ","
                        + estudiante.getTelefono() + ","
                        + estudiante.getDireccion());
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Datos guardados exitosamente en " + rutaArchivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e.getMessage());
        }
    }

    public void cargarDatosDesdeArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean archivoVacio = true;

            listaEstudiante.clear();
            modelo.setRowCount(0);

            while ((linea = reader.readLine()) != null) {
                archivoVacio = false;
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    // En lugar de crear un nuevo estudiante aquí, puedes usar los datos para crear el objeto en otro lugar si es necesario.
                    Estudiante estudiante = new Estudiante(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3], datos[4]);

                    listaEstudiante.add(estudiante);
                    modelo.addRow(new Object[]{datos[0], datos[1], datos[2], datos[3], datos[4]});
                }
            }

            if (archivoVacio) {
                JOptionPane.showMessageDialog(null, "El archivo está vacío, la tabla y la lista han sido limpiadas.");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }
    }
}
