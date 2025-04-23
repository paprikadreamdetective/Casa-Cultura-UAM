/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import persistence.AsistenteDAO;
import model.Asistente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author p4prika
 */
public class ActualizarAsistente extends javax.swing.JFrame {

    /**
     * Creates new form ActualizarAsistente
     */
    private javax.swing.ButtonGroup generoButtonGroup;
    public ActualizarAsistente() {
        initComponents();
        setTitle("Casa de la Cultura – UAM Azcapotzalco:: Actualizar informacion de un asistente");
        jButton3_update_actualizar.setEnabled(false);
        this.setLocationRelativeTo(null);
        jTable3_actualizar_asistentes.setDefaultEditor(Object.class, null);
        cargarAsistentesEnTabla();
        deshabilitarTextFields();
        // Configurar el ButtonGroup para los botones de radio
        generoButtonGroup = new javax.swing.ButtonGroup();
        generoButtonGroup.add(jRadioButton3_update_femenino);
        generoButtonGroup.add(jRadioButton3_update_masculino);
        generoButtonGroup.add(jRadioButton3_update_otro);
    }
    
    public void cargarAsistentesEnTabla() {
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Matrícula", "Nombre", "Primer Apellido", "Segundo Apellido", "Edad", "Genero", "Teléfono", "Telefono de Emergencia", "Direccion"});
        
        List<Asistente> listaAsistentes = new ArrayList<>();
        listaAsistentes = new AsistenteDAO().obtenerTodosLosAsistentes();

        // Iterar sobre la lista de asistentes y añadir cada uno como una fila en la tabla
        for (Asistente asistente : listaAsistentes) {
            modelo.addRow(new Object[]{
                asistente.getMatricula(),
                asistente.getNombre(),
                asistente.getPrimerApellido(),
                asistente.getSegundoApellido(),
                asistente.getEdad(),
                asistente.getGenero(),
                asistente.getTelefonoContacto(),
                asistente.getTelefonoEmergencia(),
                asistente.getDireccion()
            });
        }

        jTable3_actualizar_asistentes.setModel(modelo);
}
    
    public void busquedaDeAsistente(String matricula) {
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
        //modelo.setColumnIdentifiers(new String[]{"Matrícula", "Nombre", "Apellido", "Teléfono", "Correo"});
        modelo.setColumnIdentifiers(new String[]{"Matrícula", "Nombre", "Primer Apellido", "Segundo Apellido", "Edad", "Genero", "Teléfono", "Telefono de Emergencia", "Direccion"});
        
        Asistente asistente = new Asistente();
        asistente = new AsistenteDAO().buscarAsistentePorMatricula(matricula);
        boolean encontrado = asistente != null;

        if (encontrado) {
            modelo.addRow(new Object[]{
                asistente.getMatricula(),
                asistente.getNombre(),
                asistente.getPrimerApellido(),
                asistente.getSegundoApellido(),
                asistente.getEdad(),
                asistente.getGenero(),
                asistente.getTelefonoContacto(),
                asistente.getTelefonoEmergencia(),
                asistente.getDireccion()
            });
        }

        jTable3_actualizar_asistentes.setModel(modelo);

        if (!encontrado) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró el registro.", "Búsqueda", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            deshabilitarTextFields();
            jButton3_update_actualizar.setEnabled(false);
            
            jTextField3_update_nombre.setText("");
            jTextField3_update_1erapellido.setText("");
            jTextField3_update_2doapellido.setText("");
            jTextField3_update_edad.setText("");
            jTextField3_update_direccion.setText("");
            jTextField3_update_telcontacto.setText("");
            jTextField3_update_telemergencia.setText("");
            generoButtonGroup.clearSelection();
        } else {
            habilitarTextFields();
            llenarTextFields(modelo.getDataVector().elementAt(0));
            jButton3_update_actualizar.setEnabled(true);
        }
    }
    
    public void deshabilitarTextFields() {
        jTextField3_update_nombre.setEnabled(false);
        jTextField3_update_1erapellido.setEnabled(false);
        jTextField3_update_2doapellido.setEnabled(false);
        jTextField3_update_edad.setEnabled(false);
        jTextField3_update_direccion.setEnabled(false);
        jTextField3_update_telcontacto.setEnabled(false);
        jTextField3_update_telemergencia.setEnabled(false);
        jRadioButton3_update_femenino.setEnabled(false);
        jRadioButton3_update_masculino.setEnabled(false);
        jRadioButton3_update_otro.setEnabled(false);
    }
    
    public void habilitarTextFields() {
        jTextField3_update_nombre.setEnabled(true);
        jTextField3_update_1erapellido.setEnabled(true);
        jTextField3_update_2doapellido.setEnabled(true);
        jTextField3_update_edad.setEnabled(true);
        jTextField3_update_direccion.setEnabled(true);
        jTextField3_update_telcontacto.setEnabled(true);
        jTextField3_update_telemergencia.setEnabled(true);
        jRadioButton3_update_femenino.setEnabled(true);
        jRadioButton3_update_masculino.setEnabled(true);
        jRadioButton3_update_otro.setEnabled(true);
    }
    
    public void llenarTextFields(java.util.Vector datos) {
        jTextField3_update_nombre.setText(datos.get(1).toString()); // Nombre
        jTextField3_update_1erapellido.setText(datos.get(2).toString()); // Primer Apellido
        jTextField3_update_2doapellido.setText(datos.get(3).toString()); // Segundo Apellido
        jTextField3_update_edad.setText(datos.get(4).toString()); // Edad
        // Género
        String genero = datos.get(5).toString();
        if (genero.equalsIgnoreCase("Femenino")) {
            jRadioButton3_update_femenino.setSelected(true);
        } else if (genero.equalsIgnoreCase("Masculino")) {
            jRadioButton3_update_masculino.setSelected(true);
        } else {
            jRadioButton3_update_otro.setSelected(true);
        }
        jTextField3_update_telcontacto.setText(datos.get(6).toString()); // Teléfono
        jTextField3_update_telemergencia.setText(datos.get(7).toString()); // Teléfono de Emergencia
        jTextField3_update_direccion.setText(datos.get(8).toString()); // Dirección
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3_actualizar_asistentes = new javax.swing.JTable();
        jTextField3_actualizar_busqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3_actualizar_buscar = new javax.swing.JButton();
        jTextField3_update_nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3_update_1erapellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3_update_2doapellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3_update_edad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3_update_telcontacto = new javax.swing.JTextField();
        jTextField3_update_telemergencia = new javax.swing.JTextField();
        jRadioButton3_update_masculino = new javax.swing.JRadioButton();
        jRadioButton3_update_femenino = new javax.swing.JRadioButton();
        jRadioButton3_update_otro = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField3_update_direccion = new javax.swing.JTextField();
        jButton3_update_actualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTable3_actualizar_asistentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable3_actualizar_asistentes);

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel2.setText("Introduzca la matricula del asistente:");

        jButton3_actualizar_buscar.setBackground(new java.awt.Color(255, 51, 51));
        jButton3_actualizar_buscar.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton3_actualizar_buscar.setForeground(new java.awt.Color(255, 255, 255));
        jButton3_actualizar_buscar.setText("Buscar");
        jButton3_actualizar_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_actualizar_buscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre(s)");

        jLabel3.setText("Primer Apellido");

        jLabel4.setText("Segundo Apellido");

        jLabel5.setText("Edad");

        jLabel6.setText("Telefono de contacto");

        jLabel7.setText("Telefono de emergencia");

        jLabel8.setText("Direccion");

        jRadioButton3_update_masculino.setText("Masculino");

        jRadioButton3_update_femenino.setText("Femenino");

        jRadioButton3_update_otro.setText("Otro");

        jLabel9.setText("Genero");

        jButton3_update_actualizar.setBackground(new java.awt.Color(255, 51, 51));
        jButton3_update_actualizar.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jButton3_update_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton3_update_actualizar.setText("Actualizar");
        jButton3_update_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_update_actualizarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField3_update_telcontacto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField3_update_nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3_update_telemergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3_update_1erapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton3_update_masculino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                        .addComponent(jRadioButton3_update_femenino)
                                        .addGap(93, 93, 93))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jTextField3_update_2doapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton3_update_otro)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jTextField3_update_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3_update_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3_actualizar_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3_actualizar_buscar))
                    .addComponent(jTextField3_update_direccion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3_actualizar_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3_actualizar_buscar))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField3_update_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3_update_1erapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField3_update_2doapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3_update_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3_update_telcontacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3_update_telemergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3_update_masculino)
                    .addComponent(jRadioButton3_update_femenino)
                    .addComponent(jRadioButton3_update_otro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3_update_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3_update_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3_actualizar_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_actualizar_buscarActionPerformed
        // TODO add your handling code here:
                                                  
    String matricula = jTextField3_actualizar_busqueda.getText().trim();
    if (!matricula.isEmpty()) {
        busquedaDeAsistente(matricula);
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Introduce una matrícula.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
    }


    }//GEN-LAST:event_jButton3_actualizar_buscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                null,
                "¿Estás seguro de que deseas cancelar la operacion?",
                "Cancelar",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE
        );
        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            System.out.println("Registro cancelado. Redirigiendo al dashboard...");
            //new LoginForm().setVisible(true);
            this.dispose();
            // Aquí puedes llamar a tu método para cerrar sesión o abrir la pantalla de login
        } else {
            System.out.println("Operación cancelada.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3_update_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_update_actualizarActionPerformed
        // TODO add your handling code here:
        String matricula = jTextField3_actualizar_busqueda.getText().trim(); 
        String nombre = jTextField3_update_nombre.getText().trim();
        String primerApellido = jTextField3_update_1erapellido.getText().trim();
        String segundoApellido = jTextField3_update_2doapellido.getText().trim();
        String edadStr = jTextField3_update_edad.getText().trim();
        String direccion = jTextField3_update_direccion.getText().trim();
        String telefonoContacto = jTextField3_update_telcontacto.getText().trim();
        String telefonoEmergencia = jTextField3_update_telemergencia.getText().trim();
        String genero = "";
        if (jRadioButton3_update_femenino.isSelected()) {
            genero = "Femenino";
        } else if (jRadioButton3_update_masculino.isSelected()) {
            genero = "Masculino";
        } else if (jRadioButton3_update_otro.isSelected()) {
            genero = "Otro";
        }

        if (nombre.isEmpty() || primerApellido.isEmpty() || segundoApellido.isEmpty() || edadStr.isEmpty() || 
            direccion.isEmpty() || telefonoContacto.isEmpty() || telefonoEmergencia.isEmpty() || genero.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        int edad;
        try {
            edad = Integer.parseInt(edadStr);
            if (edad <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "La edad debe ser un número positivo.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "La edad debe ser un número válido.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un objeto Asistente con los datos actualizados
        Asistente asistente = new Asistente(matricula, nombre, primerApellido, segundoApellido, edad, genero, 
                                            direccion, telefonoContacto, telefonoEmergencia);
        
        
        // Actualizar en la base de datos
        AsistenteDAO asistenteDAO = new AsistenteDAO();
        boolean actualizado = asistenteDAO.actualizar(asistente);
        
        
        if (actualizado) {
            jButton3_update_actualizar.setEnabled(false);
            jTextField3_actualizar_busqueda.setText("");
            javax.swing.JOptionPane.showMessageDialog(this, "¡Asistente actualizado correctamente!", 
                                                      "Actualización exitosa", 
                                                      javax.swing.JOptionPane.INFORMATION_MESSAGE);
            // Refrescar la tabla
            //busquedaDeAsistente(matricula); // Volver a buscar para actualizar la tabla
            // Opcionalmente, puedes recargar toda la tabla con cargarAsistentesEnTabla();
            //jButton3_actualizar_buscar.setText("");
            jTextField3_update_nombre.setText("");
            jTextField3_update_1erapellido.setText("");
            jTextField3_update_2doapellido.setText("");
            jTextField3_update_edad.setText("");
            jTextField3_update_direccion.setText("");
            jTextField3_update_telcontacto.setText("");
            jTextField3_update_telemergencia.setText("");
            /*jRadioButton3_update_femenino.setText("");
            jRadioButton3_update_masculino.setEnabled(true);
            jRadioButton3_update_otro.setEnabled(true);*/
            generoButtonGroup.clearSelection();
            deshabilitarTextFields();
            cargarAsistentesEnTabla();
            
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar el asistente.", 
                                                      "Error", 
                                                      javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3_update_actualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ActualizarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarAsistente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3_actualizar_buscar;
    private javax.swing.JButton jButton3_update_actualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton3_update_femenino;
    private javax.swing.JRadioButton jRadioButton3_update_masculino;
    private javax.swing.JRadioButton jRadioButton3_update_otro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable3_actualizar_asistentes;
    private javax.swing.JTextField jTextField3_actualizar_busqueda;
    private javax.swing.JTextField jTextField3_update_1erapellido;
    private javax.swing.JTextField jTextField3_update_2doapellido;
    private javax.swing.JTextField jTextField3_update_direccion;
    private javax.swing.JTextField jTextField3_update_edad;
    private javax.swing.JTextField jTextField3_update_nombre;
    private javax.swing.JTextField jTextField3_update_telcontacto;
    private javax.swing.JTextField jTextField3_update_telemergencia;
    // End of variables declaration//GEN-END:variables
}
