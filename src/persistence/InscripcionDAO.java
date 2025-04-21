/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;
import java.sql.*;
import model.Inscripcion;
/**
 *
 * @author p4prika
 */
public class InscripcionDAO {
    private Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/culturadb";
    private final String USER = "root";
    private final String PASSWORD = "kali"; 

    // Constructor que recibe la conexión a la base de datos
    public InscripcionDAO() {
        //this.connection = connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertar(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripcion (id_alumno, id_taller, adquirir_material, fecha_inscripcion, total_a_pagar) " +
                    "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, inscripcion.getIdAlumno());
            stmt.setInt(2, inscripcion.getIdTaller());
            stmt.setBoolean(3, inscripcion.isAdquirirMaterial());
            stmt.setDate(4, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
            stmt.setDouble(5, inscripcion.getTotalAPagar());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Inscripcion inscripcion) {
        String sql = "UPDATE inscripcion SET id_alumno = ?, id_taller = ?, adquirir_material = ?, " +
                    "fecha_inscripcion = ?, total_a_pagar = ? WHERE id_inscripcion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, inscripcion.getIdAlumno());
            stmt.setInt(2, inscripcion.getIdTaller());
            stmt.setBoolean(3, inscripcion.isAdquirirMaterial());
            stmt.setDate(4, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
            stmt.setDouble(5, inscripcion.getTotalAPagar());
            stmt.setInt(6, inscripcion.getIdInscripcion());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int idInscripcion) {
        String sql = "DELETE FROM inscripcion WHERE id_inscripcion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idInscripcion);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
