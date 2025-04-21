/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;
import model.Inscripcion;
import persistence.InscripcionDAO;
import persistence.AsistenteDAO;
import model.Asistente;
import java.util.Date;
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
    private Asistente alumnoSeleccionado; // Almacena el alumno encontrado
    private InscripcionDAO inscripcionDAO; // DAO para inscripciones
    private AsistenteDAO alumnoDAO; // DAO para alumnos

    public InscripcionTaller() {
        initComponents();
        this.setLocationRelativeTo(null);
        jTextField4_costo_total.setEnabled(false);
        toggleHorarios("danza", false);
        toggleHorarios("teatro", false);
        toggleHorarios("dibujo", false);
        toggleHorarios("redaccion", false);
        toggleHorarios("lectura", false);
        
        inscripcionDAO = new InscripcionDAO();
        alumnoDAO = new AsistenteDAO();

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
                jLabel_danza_select.setVisible(visible);
                jRadioButton4_horario1_taller_danza.setVisible(visible);
                jRadioButton4_horario2_taller_danza.setVisible(visible);
                jCheckBox4_material_danza.setVisible(visible);
                jCheckBox4_material_danza.setSelected(visible);
                break;
            case "teatro":
                jLabel_teatro_select.setVisible(visible);
                jRadioButton4_horario1_taller_teatro.setVisible(visible);
                jRadioButton4_horario2_taller_teatro.setVisible(visible);
                jCheckBox4_material_teatro.setVisible(visible);
                break;
            case "dibujo":
                jLabel_dibujo_select.setVisible(visible);
                jRadioButton4_horario1_taller_dibujo.setVisible(visible);
                jRadioButton4_horario2_taller_dibujo.setVisible(visible);
                jCheckBox4_material_dibujo.setVisible(visible);
                break;
            case "redaccion":
                jLabel_redaccion_select.setVisible(visible);
                jRadioButton4_horario1_taller_redaccion.setVisible(visible);
                jCheckBox4_material_redaccion.setVisible(visible);
                break;
            case "lectura":
                jLabel_lectura_select.setVisible(visible);
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
        jRadioButton4_taller_danza = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton4_taller_teatro = new javax.swing.JRadioButton();
        jRadioButton4_taller_dibujo = new javax.swing.JRadioButton();
        jRadioButton4_taller_redaccion = new javax.swing.JRadioButton();
        jRadioButton4_taller_lectura = new javax.swing.JRadioButton();
        jLabel_danza_select = new javax.swing.JLabel();
        jRadioButton4_horario1_taller_danza = new javax.swing.JRadioButton();
        jRadioButton4_horario2_taller_danza = new javax.swing.JRadioButton();
        jRadioButton4_horario1_taller_teatro = new javax.swing.JRadioButton();
        jRadioButton4_horario2_taller_teatro = new javax.swing.JRadioButton();
        jLabel_teatro_select = new javax.swing.JLabel();
        jRadioButton4_horario1_taller_dibujo = new javax.swing.JRadioButton();
        jRadioButton4_horario2_taller_dibujo = new javax.swing.JRadioButton();
        jLabel_dibujo_select = new javax.swing.JLabel();
        jLabel_redaccion_select = new javax.swing.JLabel();
        jRadioButton4_horario1_taller_redaccion = new javax.swing.JRadioButton();
        jLabel_lectura_select = new javax.swing.JLabel();
        jRadioButton4_horario1_taller_lectura = new javax.swing.JRadioButton();
        jCheckBox4_material_danza = new javax.swing.JCheckBox();
        jCheckBox4_material_teatro = new javax.swing.JCheckBox();
        jCheckBox4_material_dibujo = new javax.swing.JCheckBox();
        jCheckBox4_material_redaccion = new javax.swing.JCheckBox();
        jCheckBox4_material_lectura = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jTextField4_costo_total = new javax.swing.JTextField();
        jButton4_confirmar_inscripcion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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
        jButton4_buscar_asistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_buscar_asistenteActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4_select_taller_y_horario.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel_danza_select.setText("Seleccionar horario");

        jRadioButton4_horario1_taller_danza.setText("Lunes, Miercoles y Viernes 15:30 a 17:30");

        jRadioButton4_horario2_taller_danza.setText("Martes y Jueves 17:30 a 19:30");

        jRadioButton4_horario1_taller_teatro.setText("Lunes, Miercoles y Viernes 15:30 a 17:30");

        jRadioButton4_horario2_taller_teatro.setText("Martes y Jueves 17:30 a 19:30");

        jLabel_teatro_select.setText("Seleccionar horario");

        jRadioButton4_horario1_taller_dibujo.setText("Lunes, Miercoles y Viernes 15:30 a 17:30");
        jRadioButton4_horario1_taller_dibujo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4_horario1_taller_dibujoActionPerformed(evt);
            }
        });

        jRadioButton4_horario2_taller_dibujo.setText("Martes y Jueves 17:30 a 19:30");

        jLabel_dibujo_select.setText("Seleccionar horario");

        jLabel_redaccion_select.setText("Seleccionar horario");

        jRadioButton4_horario1_taller_redaccion.setText("Martes y Jueves 16:30 a 18:30");

        jLabel_lectura_select.setText("Seleccionar horario");

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
                .addGap(19, 19, 19)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_danza_select)
                    .addComponent(jRadioButton4_taller_danza)
                    .addComponent(jLabel_lectura_select)
                    .addComponent(jRadioButton4_taller_lectura)
                    .addComponent(jLabel_redaccion_select)
                    .addComponent(jLabel_dibujo_select)
                    .addComponent(jLabel_teatro_select)
                    .addComponent(jRadioButton4_taller_redaccion)
                    .addComponent(jRadioButton4_taller_dibujo)
                    .addComponent(jRadioButton4_taller_teatro)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4_costo_total, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                                .addComponent(jRadioButton4_horario1_taller_danza)
                                .addGap(78, 78, 78)
                                .addComponent(jRadioButton4_horario2_taller_danza)
                                .addGap(81, 81, 81)
                                .addComponent(jCheckBox4_material_danza))
                            .addGroup(jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRadioButton4_horario1_taller_teatro)
                                    .addComponent(jRadioButton4_horario1_taller_dibujo)
                                    .addComponent(jRadioButton4_horario1_taller_lectura)
                                    .addComponent(jRadioButton4_horario1_taller_redaccion))
                                .addGap(78, 78, 78)
                                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                            .addComponent(jCheckBox4_material_lectura))))))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel4_select_taller_y_horarioLayout.setVerticalGroup(
            jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4_select_taller_y_horarioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addComponent(jRadioButton4_taller_danza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_danza_select)
                .addGap(3, 3, 3)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton4_horario2_taller_danza)
                        .addComponent(jCheckBox4_material_danza))
                    .addComponent(jRadioButton4_horario1_taller_danza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4_taller_teatro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_teatro_select)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4_horario1_taller_teatro)
                    .addComponent(jRadioButton4_horario2_taller_teatro)
                    .addComponent(jCheckBox4_material_teatro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4_taller_dibujo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_dibujo_select)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton4_horario2_taller_dibujo)
                        .addComponent(jCheckBox4_material_dibujo))
                    .addComponent(jRadioButton4_horario1_taller_dibujo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4_taller_redaccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_redaccion_select)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4_horario1_taller_redaccion)
                    .addComponent(jCheckBox4_material_redaccion))
                .addGap(2, 2, 2)
                .addComponent(jRadioButton4_taller_lectura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_lectura_select)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4_horario1_taller_lectura)
                    .addComponent(jCheckBox4_material_lectura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel4_select_taller_y_horarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4_costo_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        jButton4_confirmar_inscripcion.setBackground(new java.awt.Color(255, 51, 51));
        jButton4_confirmar_inscripcion.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton4_confirmar_inscripcion.setForeground(new java.awt.Color(255, 255, 255));
        jButton4_confirmar_inscripcion.setText("Confirmar inscripcion");
        jButton4_confirmar_inscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_confirmar_inscripcionActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(978, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4_confirmar_inscripcion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4_select_taller_y_horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField4_busqueda_asistente, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4_buscar_asistente)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4_confirmar_inscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
    
    private void limpiarFormulario() {
        jTextField4_busqueda_asistente.setText("");
        jTextField4_costo_total.setText("");
        costoTotal = 0;
        alumnoSeleccionado = null;
        jRadioButton4_taller_danza.setSelected(false);
        jRadioButton4_taller_teatro.setSelected(false);
        jRadioButton4_taller_dibujo.setSelected(false);
        jRadioButton4_taller_redaccion.setSelected(false);
        jRadioButton4_taller_lectura.setSelected(false);
        toggleHorarios("danza", false);
        toggleHorarios("teatro", false);
        toggleHorarios("dibujo", false);
        toggleHorarios("redaccion", false);
        toggleHorarios("lectura", false);
    }
    
    private void jButton4_confirmar_inscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_confirmar_inscripcionActionPerformed
        // TODO add your handling code here:
        /*javax.swing.JOptionPane.showMessageDialog(null, "¡Asistente inscrito correctamente!", 
                                  "Inscripcion Exitosa", 
                                  javax.swing.JOptionPane.INFORMATION_MESSAGE);*/
        if (alumnoSeleccionado == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, busque y seleccione un alumno primero.", 
                                          "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        java.util.List<Integer> talleresInscritos = inscripcionDAO.obtenerTalleresInscritos(alumnoSeleccionado.getIdAlumno());

        // Determinar el taller y horario seleccionados
        int idTaller = 0;
        boolean adquirirMaterial = false;
        String tallerSeleccionado = "";
        if (jRadioButton4_taller_danza.isSelected()) {
            adquirirMaterial = jCheckBox4_material_danza.isSelected();
            tallerSeleccionado = "danza";
            if (jRadioButton4_horario1_taller_danza.isSelected()) {
                idTaller = 1; // Danza, horario 1
            } else if (jRadioButton4_horario2_taller_danza.isSelected()) {
                idTaller = 2; // Danza, horario 2
            }
        } else if (jRadioButton4_taller_teatro.isSelected()) {
            adquirirMaterial = jCheckBox4_material_teatro.isSelected();
            tallerSeleccionado = "teatro";
            if (jRadioButton4_horario1_taller_teatro.isSelected()) {
                idTaller = 9; // Teatro, horario 1
            } else if (jRadioButton4_horario2_taller_teatro.isSelected()) {
                idTaller = 10; // Teatro, horario 2
            }
        } else if (jRadioButton4_taller_dibujo.isSelected()) {
            adquirirMaterial = jCheckBox4_material_dibujo.isSelected();
            tallerSeleccionado = "dibujo";
            if (jRadioButton4_horario1_taller_dibujo.isSelected()) {
                idTaller = 7; // Dibujo, horario 1
            } else if (jRadioButton4_horario2_taller_dibujo.isSelected()) {
                idTaller = 8; // Dibujo, horario 2
            }
        } else if (jRadioButton4_taller_redaccion.isSelected()) {
            adquirirMaterial = jCheckBox4_material_redaccion.isSelected();
            tallerSeleccionado = "redaccion";
            if (jRadioButton4_horario1_taller_redaccion.isSelected()) {
                idTaller = 5; // Redacción, horario 1
            } 
        } else if (jRadioButton4_taller_lectura.isSelected()) {
            adquirirMaterial = jCheckBox4_material_lectura.isSelected();
            tallerSeleccionado = "lectura";
            if (jRadioButton4_horario1_taller_lectura.isSelected()) {
                idTaller = 3; // Lectura, horario 1
            }
        }

        if (idTaller == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione un taller y un horario.", 
                                          "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (talleresInscritos.contains(idTaller)) {
            javax.swing.JOptionPane.showMessageDialog(this, "El alumno ya está inscrito en el taller de " + tallerSeleccionado + ".", 
                                          "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            
            return;
        }

        // Crear objeto Inscripcion
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setIdAlumno(alumnoSeleccionado.getIdAlumno());
        inscripcion.setIdTaller(idTaller);
        inscripcion.setAdquirirMaterial(adquirirMaterial);
        inscripcion.setFechaInscripcion(new Date());
        inscripcion.setTotalAPagar(costoTotal);

        // Guardar inscripción
        if (inscripcionDAO.insertar(inscripcion)) {
            javax.swing.JOptionPane.showMessageDialog(this, "¡Asistente inscrito correctamente en el taller de " + tallerSeleccionado + "!", 
                                          "Inscripción Exitosa", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al realizar la inscripción.", 
                                          "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4_confirmar_inscripcionActionPerformed

    private void jButton4_buscar_asistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_buscar_asistenteActionPerformed
        // TODO add your handling code here:
        String matricula = jTextField4_busqueda_asistente.getText().trim();
        if (matricula.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese una matrícula.", 
                                          "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        alumnoSeleccionado = alumnoDAO.buscarAsistentePorMatricula(matricula);
        if (alumnoSeleccionado != null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Alumno encontrado: " + alumnoSeleccionado.getNombre() + " " + 
                                          alumnoSeleccionado.getPrimerApellido() + " " + alumnoSeleccionado.getIdAlumno(), 
                                          "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            // Mostrar datos del alumno en la interfaz si tienes campos para ello
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró un alumno con esa matrícula.", 
                                          "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            alumnoSeleccionado = null;
        }
    }//GEN-LAST:event_jButton4_buscar_asistenteActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4_buscar_asistente;
    private javax.swing.JButton jButton4_confirmar_inscripcion;
    private javax.swing.JCheckBox jCheckBox4_material_danza;
    private javax.swing.JCheckBox jCheckBox4_material_dibujo;
    private javax.swing.JCheckBox jCheckBox4_material_lectura;
    private javax.swing.JCheckBox jCheckBox4_material_redaccion;
    private javax.swing.JCheckBox jCheckBox4_material_teatro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_danza_select;
    private javax.swing.JLabel jLabel_dibujo_select;
    private javax.swing.JLabel jLabel_lectura_select;
    private javax.swing.JLabel jLabel_redaccion_select;
    private javax.swing.JLabel jLabel_teatro_select;
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
