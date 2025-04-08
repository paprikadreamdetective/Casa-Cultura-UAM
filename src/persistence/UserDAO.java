/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

/**
 *
 * @author p4prika
 */
import java.sql.*;

public class UserDAO {
    private final String URL = "jdbc:mysql://localhost:3306/culturadb";
    private final String USER = "root";
    private final String PASSWORD = "kali"; 
    private Connection conn;
    
    public UserDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean verificarUsuario(String username, String password) {
        String sql = "SELECT * FROM usuario WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password); // OJO: aquí iría hasheado idealmente

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // si hay una fila, el user es válido
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void cerrarConexion() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
