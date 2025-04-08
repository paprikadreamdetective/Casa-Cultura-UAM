/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author p4prika
 */

import persistence.UserDAO;

public class Auth {
    private UserDAO usuarioDAO;

    public Auth() {
        usuarioDAO = new UserDAO();
    }

    public boolean login(String username, String password) {
        return usuarioDAO.verificarUsuario(username, password);
    }
}
