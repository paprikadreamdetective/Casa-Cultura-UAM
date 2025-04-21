/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @author p4prika
 */
public class Inscripcion {
    private int idInscripcion;
    private int idAlumno;
    private int idTaller;
    private boolean adquirirMaterial;
    private Date fechaInscripcion;
    private double totalAPagar;

    // Constructor vacío
    public Inscripcion() {
    }

    // Constructor completo
    public Inscripcion(int idInscripcion, int idAlumno, int idTaller, boolean adquirirMaterial, 
                       Date fechaInscripcion, double totalAPagar) {
        this.idInscripcion = idInscripcion;
        this.idAlumno = idAlumno;
        this.idTaller = idTaller;
        this.adquirirMaterial = adquirirMaterial;
        this.fechaInscripcion = fechaInscripcion;
        this.totalAPagar = totalAPagar;
    }

    // Getters y Setters
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(int idTaller) {
        this.idTaller = idTaller;
    }

    public boolean isAdquirirMaterial() {
        return adquirirMaterial;
    }

    public void setAdquirirMaterial(boolean adquirirMaterial) {
        this.adquirirMaterial = adquirirMaterial;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
}
