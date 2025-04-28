/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;
import java.sql.*;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
/**
 *
 * @author p4prika
 */
public class DatabaseConnector {
    private static final Properties props = new Properties();
    
    static {
        try (InputStream input = DatabaseConnector.class.getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new IOException("No se encontró db.properties");
            }
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String getUrl() {
        return props.getProperty("db.url");
    }
    
    public static String getUser() {
        return props.getProperty("db.user");
    }
    
    public static String getPassword() {
        return props.getProperty("db.password");
    }
}
