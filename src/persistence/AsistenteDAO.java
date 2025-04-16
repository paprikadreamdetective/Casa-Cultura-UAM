/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;
import java.sql.*;
import model.Asistente;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author p4prika
 */
public class AsistenteDAO {
    private Connection conexion;
    private final String URL = "jdbc:mysql://localhost:3306/culturadb";
    private final String USER = "root";
    private final String PASSWORD = "kali"; 

    /*public AsistenteDAO(Connection conexion) {
        this.conexion = conexion;
    }*/
    
    public AsistenteDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Asistente buscarAsistentePorMatricula(String matricula) {
        String sql = "SELECT * FROM alumno WHERE matricula = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Asistente(
                    rs.getString("matricula"),
                    rs.getString("nombre"),
                    rs.getString("primer_apellido"),
                    rs.getString("segundo_apellido"),
                    rs.getInt("edad"),
                    rs.getString("genero"),
                    rs.getString("direccion"),
                    rs.getString("telefono_contacto"),
                    rs.getString("telefono_emergencia")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // No encontrado
    }

    public List<Asistente> obtenerTodosLosAsistentes() {
        List<Asistente> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumno";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Asistente asistente = new Asistente(
                    rs.getString("matricula"),
                    rs.getString("nombre"),
                    rs.getString("primer_apellido"),
                    rs.getString("segundo_apellido"),
                    rs.getInt("edad"),
                    rs.getString("genero"),
                    rs.getString("direccion"),
                    rs.getString("telefono_contacto"),
                    rs.getString("telefono_emergencia")
                );
                lista.add(asistente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insertar(Asistente asistente) {
        String sql = "INSERT INTO alumno (matricula, nombre, primer_apellido, segundo_apellido, edad, genero, direccion, telefono_contacto, telefono_emergencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, asistente.getMatricula());
            stmt.setString(2, asistente.getNombre());
            stmt.setString(3, asistente.getPrimerApellido());
            stmt.setString(4, asistente.getSegundoApellido());
            stmt.setInt(5, asistente.getEdad());
            stmt.setString(6, asistente.getGenero());
            stmt.setString(7, asistente.getDireccion());
            stmt.setString(8, asistente.getTelefonoContacto());
            stmt.setString(9, asistente.getTelefonoEmergencia());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Asistente asistente) {
        String sql = "UPDATE alumno SET nombre = ?, primer_apellido = ?, segundo_apellido = ?, edad = ?, genero = ?, direccion = ?, telefono_contacto = ?, telefono_emergencia = ? WHERE matricula = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, asistente.getNombre());
            stmt.setString(2, asistente.getPrimerApellido());
            stmt.setString(3, asistente.getSegundoApellido());
            stmt.setInt(4, asistente.getEdad());
            stmt.setString(5, asistente.getGenero());
            stmt.setString(6, asistente.getDireccion());
            stmt.setString(7, asistente.getTelefonoContacto());
            stmt.setString(8, asistente.getTelefonoEmergencia());
            stmt.setString(9, asistente.getMatricula());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(String matricula) {
        String sql = "DELETE FROM alumno WHERE matricula = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
