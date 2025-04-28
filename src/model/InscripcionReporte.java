/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author p4prika
 */
public class InscripcionReporte {
    private int idAlumno;
    private String nombre;
    private String primerApellido;
    private String matricula;
    private Integer idTaller; // Puede ser null si no está inscrito
    private String nombreTaller;
    private String horario;
    private Double totalAPagar; // Puede ser null si no está inscrito
    private String fechaInscripcion;
    private int adquirioMaterial;

    // Constructor
    public InscripcionReporte(int idAlumno, String nombre, String primerApellido, String matricula,
                              Integer idTaller, String nombreTaller, String horario, Double totalAPagar, String fechaInscripcion, int adquirioMaterial) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.matricula = matricula;
        this.idTaller = idTaller;
        this.nombreTaller = nombreTaller;
        this.horario = horario;
        this.totalAPagar = totalAPagar;
        this.adquirioMaterial = adquirioMaterial;
        this.fechaInscripcion = fechaInscripcion;
    }

    // Getters
    public int getIdAlumno() {
        return idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public Integer getIdTaller() {
        return idTaller;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public String getHorario() {
        return horario;
    }

    public Double getTotalAPagar() {
        return totalAPagar;
    }
    
    public String getFechaInscripcion() {
        return fechaInscripcion;
    }
    
    public int getAdquirioMaterial() {
        return adquirioMaterial;
    }
}
