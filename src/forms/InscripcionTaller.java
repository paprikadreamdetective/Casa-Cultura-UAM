/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

/**
 *
 * @author p4prika
 */
public class InscripcionTaller extends javax.swing.JFrame {

    /**
     * Creates new form InscripcionTaller
     */
    private float costoTotal = 0;
    private final float costoDanza = 500;
    private final float costoTeatro = 600;
    private final float costoDibujo = 40;
    private final float costoRedaccion = 350;
    private final float costoLectura = 300;
    private final float costoMaterialExtra = 100;

    public InscripcionTaller() {
        initComponents();
        this.setLocationRelativeTo(null);
        jTextField4_costo_total.setEnabled(false);
        toggleHorarios("danza", false);
        toggleHorarios("teatro", false);
        toggleHorarios("dibujo", false);
        toggleHorarios("redaccion", false);
        toggleHorarios("lectura", false);

        javax.swing.ButtonGroup grupoDanza = new javax.swing.ButtonGroup();
        grupoDanza.add(jRadioButton4_horario1_taller_danza);
        grupoDanza.add(jRadioButton4_horario2_taller_danza);
        //grupoDanza.add(jCheckBox4_material_danza);

        javax.swing.ButtonGroup grupoTeatro = new javax.swing.ButtonGroup();
        grupoTeatro.add(jRadioButton4_horario1_taller_teatro);
        grupoTeatro.add(jRadioButton4_horario2_taller_teatro);
        //grupoTeatro.add(jCheckBox4_material_teatro);

        javax.swing.ButtonGroup grupoDibujo = new javax.swing.ButtonGroup();
        grupoDibujo.add(jRadioButton4_horario1_taller_dibujo);
        grupoDibujo.add(jRadioButton4_horario2_taller_dibujo);
        //grupoDibujo.add(jCheckBox4_material_dibujo);

        javax.swing.ButtonGroup grupoRedaccion = new javax.swing.ButtonGroup();
        grupoRedaccion.add(jRadioButton4_horario1_taller_redaccion);
        //grupoRedaccion.add(jCheckBox4_material_redaccion);

        javax.swing.ButtonGroup grupoLectura = new javax.swing.ButtonGroup();
        grupoLectura.add(jRadioButton4_horario1_taller_lectura);
        //grupoLectura.add(jCheckBox4_material_lectura);
        
        jRadioButton4_taller_danza.addActionListener(e -> toggleHorarios("danza", jRadioButton4_taller_danza.isSelected()));
        jRadioButton4_taller_teatro.addActionListener(e -> toggleHorarios("teatro", jRadioButton4_taller_teatro.isSelected()));
        jRadioButton4_taller_dibujo.addActionListener(e -> toggleHorarios("dibujo", jRadioButton4_taller_dibujo.isSelected()));
        jRadioButton4_taller_redaccion.addActionListener(e -> toggleHorarios("redaccion", jRadioButton4_taller_redaccion.isSelected()));
        jRadioButton4_taller_lectura.addActionListener(e -> toggleHorarios("lectura", jRadioButton4_taller_lectura.isSelected()));
        
        jRadioButton4_taller_danza.addActionListener(e -> actualizarCostoTaller(jRadioButton4_taller_danza, costoDanza));
        jRadioButton4_taller_teatro.addActionListener(e -> actualizarCostoTaller(jRadioButton4_taller_teatro, costoTeatro));
        jRadioButton4_taller_dibujo.addActionListener(e -> actualizarCostoTaller(jRadioButton4_taller_dibujo, costoDibujo));
        jRadioButton4_taller_redaccion.addActionListener(e -> actualizarCostoTaller(jRadioButton4_taller_redaccion, costoRedaccion));
        jRadioButton4_taller_lectura.addActionListener(e -> actualizarCostoTaller(jRadioButton4_taller_lectura, costoLectura));
    
        jCheckBox4_material_danza.addActionListener(e -> actualizarCostoMaterial(jCheckBox4_material_danza, costoMaterialExtra));
        jCheckBox4_material_teatro.addActionListener(e -> actualizarCostoMaterial(jCheckBox4_material_teatro, costoMaterialExtra));
        jCheckBox4_material_dibujo.addActionListener(e -> actualizarCostoMaterial(jCheckBox4_material_dibujo, costoMaterialExtra));
        jCheckBox4_material_redaccion.addActionListener(e -> actualizarCostoMaterial(jCheckBox4_material_redaccion, costoMaterialExtra));
        jCheckBox4_material_lectura.addActionListener(e -> actualizarCostoMaterial(jCheckBox4_material_lectura, costoMaterialExtra));
    }
    
        private void actualizarCostoTaller(javax.swing.JRadioButton taller, float costo_taller) {
            if (taller.isSelected()) {
                costoTotal += costo_taller;
            } else {
                costoTotal -= costo_taller;
            }
            actualizarCampoCosto();
        }
    
        private void actualizarCostoMaterial(javax.swing.JCheckBox material, float costo_material) {
            if (material.isSelected()) {
                costoTotal += costo_material;
            } else {
                costoTotal -= costo_material; 
            }
            actualizarCampoCosto();
        }
    
    private void actualizarCampoCosto() {
        jTextField4_costo_total.setText("$" + costoTotal);
    }


    
    private void toggleHorarios(String taller, boolean visible) {
        switch(taller) {
            case "danza":
                jRadioButton4_horario1_taller_danza.setVisible(visible);
                jRadioButton4_horario2_taller_danza.setVisible(visible);
                jCheckBox4_material_danza.setVisible(visible);
                break;
            case "teatro":
                jRadioButton4_horario1_taller_teatro.setVisible(visible);
                jRadioButton4_horario2_taller_teatro.setVisible(visible);
                jCheckBox4_material_teatro.setVisible(visible);
                break;
            case "dibujo":
                jRadioButton4_horario1_taller_dibujo.setVisible(visible);
                jRadioButton4_horario2_taller_dibujo.setVisible(visible);
                jCheckBox4_material_dibujo.setVisible(visible);
                break;
            case "redaccion":
                jRadioButton4_horario1_taller_redaccion.setVisible(visible);
                jCheckBox4_material_redaccion.setVisible(visible);
                break;
            case "lectura":
                jRadioButton4_horario1_taller_lectura.setVisible(visible);
                jCheckBox4_material_lectura.setVisible(visible);
                break;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField4_busqueda_asistente = new javax.swing.JTextField();
        jButton4_buscar_asistente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4_select_taller_y_horario = new javax.swing.JPanel();
        jButton4_confirmar_inscripcion = new javax.swing.JButton();
        jRadioButton4_taller_danza = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton4_taller_teatro = new javax.swing.JRadioButton();
        jRadioButton4_taller_dibujo = new javax.swing.JRadioButton();
        jRadioButton4_taller_redaccion = new javax.swing.JRadioButton();
        jRadioButton4_taller_lectura = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton4_horario1_taller_danza = new javax.swing.JRadioButton();
        jRadioButton4_horario2_taller_danza = new javax.swing.JRadioButton();
        jRadioButton4_horario1_taller_teatro = new javax.swing.JRadioButton();
        jRadioButton4_horario2_taller_teatro = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton4_horario1_taller_dibujo = new javax.swing.JRadioButton();
        jRadioButton4_horario2_taller_dibujo = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton4_horario1_taller_redaccion = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton4_horario1_taller_lectura = new javax.swing.JRadioButton();
        jCheckBox4_material_danza = new javax.swing.JCheckBox();
        jCheckBox4_material_teatro = new javax.swing.JCheckBox();
        jCheckBox4_material_dibujo = new javax.swing.JCheckBox();
        jCheckBox4_material_redaccion = new javax.swing.JCheckBox();
        jCheckBox4_material_lectura = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jTextField4_costo_total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Buscar alumno a inscribir");

        jTextField4_busqueda_asistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4_busqueda_asistenteActionPerformed(evt);
            }
        });

        jButton4_buscar_asistente.setBackground(new java.awt.Color(255, 51, 51));
        jButton4_buscar_asistente.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton4_buscar_asistente.setForeground(new java.awt.Color(255, 255, 255));
        jButton4_buscar_asistente.setText("Buscar");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4_select_taller_y_horario.setBackground(new java.awt.Color(255, 255, 255));

        jButton4_confirmar_inscripcion.setBackground(new java.awt.Color(255, 51, 51));
        jButton4_confirmar_inscripcion.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton4_confirmar_inscripcion.setForeground(new java.awt.Color(255, 255, 255));
        jButton4_confirmar_inscripcion.setText("Confirmar inscripcion");

        jRadioButton4_taller_danza.setText("Danza");

        jLabel2.setText("Seleccionar taller");

        jRadioButton4_taller_teatro.setText("Teatro");

        jRadioButton4_taller_dibujo.setText("Dibujo");

        jRadioButton4_taller_redaccion.setText("Redaccion");

        jRadioButton4_taller_lectura.setText("Lectura");
        jRadioButton4_taller_lectura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4_taller_lecturaActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccionar horario");

        jRadioButton4_horario1_taller_danza.setText("Lunes, Miercoles y Viernes 15:30 a 17:30");

        jRadioButton4_horario2_taller_danza.setText("Martes y Jueves 17:30 a 19:30");

        jRadioButton4_horario1_taller_teatro.setText("Lunes, Miercoles y Viernes 15:30 a 17:30");

        jRadioButton4_horario2_taller_teatro.setText("Martes y Jueves 17:30 a 19:30");

        jLabel4.setText("Seleccionar horario");

        jRadioButton4_horario1_taller_dibujo.setText("Lunes, Miercoles y Viernes 15:30 a 17:30");
        jRadioButton4_horario1_taller_dibujo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4_horario1_taller_dibujoActionPerformed(evt);
            }
        });

        jRadioButton4_horario2_taller_dibujo.setText("Martes y Jueves 17:30 a 19:30");

        jLabel5.setText("Seleccionar horario");

        jLabel6.setText("Seleccionar horario");

        jRadioButton4_horario1_taller_redaccion.setText("Martes y Jueves 16:30 a 18:30");

        jLabel7.setText("Seleccionar horario");

        jRadioButton4_horario1_taller_lectura.setText("Martes y Viernes 14:30 a 16:30");

        jCheckBox4_material_danza.setText("Material");

        jCheckBox4_material_teatro.setText("Material");

        jCheckBox4_material_dibujo.setText("Material");

        jCheckBox4_material_redaccion.setText("Material");

        jCheckBox4_material_lectura.setText("Material");

        jLabel8.setText("Costo total");

        javax.swing.GroupLayout jPanel4_select_taller_y_horarioLayout = new javax.swing.GroupLayout(jPanel4_select_taller_y_horario);
        jPanel4_select_taller_y_horario.setLayout(jPanel4_select_taller_y_horarioLayout);
        jPanel4_select_taller_y_horarioLayout.setHorizontalGroup(
            jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4_confirmar_inscripcion))
                    .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jRadioButton4_taller_lectura)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jRadioButton4_taller_redaccion)
                            .addComponent(jRadioButton4_taller_dibujo)
                            .addComponent(jRadioButton4_taller_teatro)
                            .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRadioButton4_horario1_taller_teatro)
                                    .addComponent(jRadioButton4_horario1_taller_danza)
                                    .addComponent(jRadioButton4_horario1_taller_dibujo)
                                    .addComponent(jRadioButton4_horario1_taller_lectura)
                                    .addComponent(jRadioButton4_horario1_taller_redaccion))
                                .addGap(78, 78, 78)
                                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                                        .addComponent(jRadioButton4_horario2_taller_danza)
                                        .addGap(81, 81, 81)
                                        .addComponent(jCheckBox4_material_danza))
                                    .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                                        .addComponent(jRadioButton4_horario2_taller_teatro)
                                        .addGap(81, 81, 81)
                                        .addComponent(jCheckBox4_material_teatro))
                                    .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                                        .addComponent(jRadioButton4_horario2_taller_dibujo)
                                        .addGap(81, 81, 81)
                                        .addComponent(jCheckBox4_material_dibujo))
                                    .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                                        .addGap(296, 296, 296)
                                        .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox4_material_redaccion)
                                            .addComponent(jCheckBox4_material_lectura)))))
                            .addComponent(jLabel3)
                            .addComponent(jRadioButton4_taller_danza)
                            .addComponent(jLabel2)
                            .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4_costo_total, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 102, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4_select_taller_y_horarioLayout.setVerticalGroup(
            jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4_taller_danza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton4_horario2_taller_danza)
                        .addComponent(jCheckBox4_material_danza))
                    .addComponent(jRadioButton4_horario1_taller_danza))
                .addGap(13, 13, 13)
                .addComponent(jRadioButton4_taller_teatro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4_horario1_taller_teatro)
                    .addComponent(jRadioButton4_horario2_taller_teatro)
                    .addComponent(jCheckBox4_material_teatro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4_taller_dibujo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton4_horario2_taller_dibujo)
                        .addComponent(jCheckBox4_material_dibujo))
                    .addComponent(jRadioButton4_horario1_taller_dibujo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4_taller_redaccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4_horario1_taller_redaccion)
                    .addComponent(jCheckBox4_material_redaccion))
                .addGap(2, 2, 2)
                .addComponent(jRadioButton4_taller_lectura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4_horario1_taller_lectura)
                    .addComponent(jCheckBox4_material_lectura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4_costo_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4_confirmar_inscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4_select_taller_y_horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField4_busqueda_asistente, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4_buscar_asistente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4_busqueda_asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4_buscar_asistente))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4_select_taller_y_horario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton4_taller_lecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4_taller_lecturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4_taller_lecturaActionPerformed

    private void jRadioButton4_horario1_taller_dibujoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4_horario1_taller_dibujoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4_horario1_taller_dibujoActionPerformed

    private void jTextField4_busqueda_asistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4_busqueda_asistenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4_busqueda_asistenteActionPerformed

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
            java.util.logging.Logger.getLogger(InscripcionTaller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InscripcionTaller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InscripcionTaller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InscripcionTaller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InscripcionTaller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4_buscar_asistente;
    private javax.swing.JButton jButton4_confirmar_inscripcion;
    private javax.swing.JCheckBox jCheckBox4_material_danza;
    private javax.swing.JCheckBox jCheckBox4_material_dibujo;
    private javax.swing.JCheckBox jCheckBox4_material_lectura;
    private javax.swing.JCheckBox jCheckBox4_material_redaccion;
    private javax.swing.JCheckBox jCheckBox4_material_teatro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4_select_taller_y_horario;
    private javax.swing.JRadioButton jRadioButton4_horario1_taller_danza;
    private javax.swing.JRadioButton jRadioButton4_horario1_taller_dibujo;
    private javax.swing.JRadioButton jRadioButton4_horario1_taller_lectura;
    private javax.swing.JRadioButton jRadioButton4_horario1_taller_redaccion;
    private javax.swing.JRadioButton jRadioButton4_horario1_taller_teatro;
    private javax.swing.JRadioButton jRadioButton4_horario2_taller_danza;
    private javax.swing.JRadioButton jRadioButton4_horario2_taller_dibujo;
    private javax.swing.JRadioButton jRadioButton4_horario2_taller_teatro;
    private javax.swing.JRadioButton jRadioButton4_taller_danza;
    private javax.swing.JRadioButton jRadioButton4_taller_dibujo;
    private javax.swing.JRadioButton jRadioButton4_taller_lectura;
    private javax.swing.JRadioButton jRadioButton4_taller_redaccion;
    private javax.swing.JRadioButton jRadioButton4_taller_teatro;
    private javax.swing.JTextField jTextField4_busqueda_asistente;
    private javax.swing.JTextField jTextField4_costo_total;
    // End of variables declaration//GEN-END:variables
}
