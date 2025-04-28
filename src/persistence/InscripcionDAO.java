/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;
import java.sql.*;
import model.Inscripcion;
import model.InscripcionReporte;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author p4prika
 */
public class InscripcionDAO {
    private Connection connection;
    
    // Constructor que recibe la conexión a la base de datos
    public InscripcionDAO() {
        //this.connection = connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection = DriverManager.getConnection(DatabaseConnector.getUrl(), DatabaseConnector.getUser(), DatabaseConnector.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public List<InscripcionReporte> obtenerTalleresPorMatricula(String matricula) {
        List<InscripcionReporte> talleres = new ArrayList<>();
        String sql = "SELECT a.id_alumno, a.nombre, a.primer_apellido, a.matricula, " +
                    "t.id_taller, t.nombre, t.horario, i.total_a_pagar, i.fecha_inscripcion, i.adquirir_material " +
                    "FROM alumno a, inscripcion i, taller t " +
                    "WHERE a.id_alumno = i.id_alumno " +
                    "AND i.id_taller = t.id_taller " +
                    "AND a.matricula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Integer idTaller = rs.getInt("id_taller");
                    if (rs.wasNull()) idTaller = null;
                    Double totalAPagar = rs.getDouble("total_a_pagar");
                    if (rs.wasNull()) totalAPagar = null;
                    talleres.add(new InscripcionReporte(
                        rs.getInt("id_alumno"),
                        rs.getString("nombre"),
                        rs.getString("primer_apellido"),
                        rs.getString("matricula"),
                        idTaller,
                        rs.getString("t.nombre"),
                        rs.getString("horario"),
                        totalAPagar,
                        rs.getString("i.fecha_inscripcion"),
                        rs.getInt("i.adquirir_material")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return talleres;
    }
    
    public InscripcionReporte obtenerReporteInscripcionPorMatricula(String matricula) {
        InscripcionReporte registro = null;
        String sql = "SELECT a.id_alumno, a.nombre, a.primer_apellido, a.matricula, " +
                    "t.id_taller, t.nombre AS nombre_taller, t.horario, i.total_a_pagar, i.fecha_inscripcion, i.adquirir_material " +
                    "FROM alumno a " +
                    "LEFT JOIN inscripcion i ON a.id_alumno = i.id_alumno " +
                    "LEFT JOIN taller t ON i.id_taller = t.id_taller " +
                    "WHERE a.matricula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Leer id_taller y verificar si es NULL
                    Integer idTaller = rs.getInt("id_taller");
                    if (rs.wasNull()) {
                        idTaller = null;
                    }

                    // Leer total_a_pagar y verificar si es NULL
                    Double totalAPagar = rs.getDouble("total_a_pagar");
                    if (rs.wasNull()) {
                        totalAPagar = null;
                    }

                    registro = new InscripcionReporte(
                        rs.getInt("id_alumno"),
                        rs.getString("nombre"),
                        rs.getString("primer_apellido"),
                        rs.getString("matricula"),
                        idTaller,
                        rs.getString("nombre_taller"),
                        rs.getString("horario"),
                        totalAPagar,
                        rs.getString("i.fecha_inscripcion"),
                        rs.getInt("i.adquirir_material")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }
    
    public List<InscripcionReporte> obtenerReporteInscripciones() {
        List<InscripcionReporte> reporte = new ArrayList<>();
        String sql = "SELECT a.id_alumno, a.nombre, a.primer_apellido, a.matricula, " +
                    "t.id_taller, t.nombre AS nombre_taller, t.horario, i.total_a_pagar, i.fecha_inscripcion, i.adquirir_material " +
                    "FROM alumno a " +
                    "LEFT JOIN inscripcion i ON a.id_alumno = i.id_alumno " +
                    "LEFT JOIN taller t ON i.id_taller = t.id_taller";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Leer id_taller y verificar si es NULL
                Integer idTaller = rs.getInt("id_taller");
                if (rs.wasNull()) {
                    idTaller = null;
                }

                // Leer total_a_pagar y verificar si es NULL
                Double totalAPagar = rs.getDouble("total_a_pagar");
                if (rs.wasNull()) {
                    totalAPagar = null;
                }

                InscripcionReporte registro = new InscripcionReporte(
                    rs.getInt("id_alumno"),
                    rs.getString("nombre"),
                    rs.getString("primer_apellido"),
                    rs.getString("matricula"),
                    idTaller,
                    rs.getString("nombre_taller"),
                    rs.getString("horario"),
                    totalAPagar,
                    rs.getString("i.fecha_inscripcion"),
                    rs.getInt("i.adquirir_material")
                );
                reporte.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reporte;
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
    
    public List<Integer> obtenerTalleresInscritos(int idAlumno) {
        List<Integer> talleresInscritos = new ArrayList<>();
        String sql = "SELECT id_taller FROM inscripcion WHERE id_alumno = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idAlumno);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                talleresInscritos.add(rs.getInt("id_taller"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return talleresInscritos;
    }
}
