/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author angelrg
 */
public class CargarArchivos extends javax.swing.JFrame {

    /**
     * Creates new form inicio
     */
    public CargarArchivos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cursosButton4 = new javax.swing.JButton();
        listaCursosTextField4 = new javax.swing.JTextField();
        cursosButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        listaCursosTextField5 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        listaDocentesTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        docentesButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        listaCursosTextField = new javax.swing.JTextField();
        cursosButton = new javax.swing.JButton();
        listaSalonesTextField = new javax.swing.JTextField();
        salonesButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cursosDocenteButton = new javax.swing.JButton();
        listaCursosTextField2 = new javax.swing.JTextField();
        salonCursosButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        listaCursosTextField3 = new javax.swing.JTextField();
        recursoSalonButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        listaCursosTextField7 = new javax.swing.JTextField();

        cursosButton4.setText("Buscar archivo");
        cursosButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursosButton4ActionPerformed(evt);
            }
        });

        cursosButton5.setText("Buscar archivo");
        cursosButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursosButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Cargar Relacion Salon-Curso");

        jLabel8.setText("Cargar Relacion Curso-Docente");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cargar Archivos");

        jLabel1.setText("Facultad o Division:");

        jLabel2.setText("Cargar docentes");

        docentesButton.setText("Buscar archivo");

        jLabel3.setText("Cargar Cursos");

        cursosButton.setText("Buscar archivo");
        cursosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursosButtonActionPerformed(evt);
            }
        });

        salonesButton.setText("Buscar archivo");
        salonesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salonesButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Cargar Salones");

        jButton1.setText("Cancel");

        jButton2.setText("Generar Horario");

        cursosDocenteButton.setText("Buscar archivo");
        cursosDocenteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursosDocenteButtonActionPerformed(evt);
            }
        });

        salonCursosButton.setText("Buscar archivo");
        salonCursosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salonCursosButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Cargar Relacion Salon-Curso");

        jLabel6.setText("Cargar Relacion Curso-Docente");

        recursoSalonButton.setText("Buscar archivo");
        recursoSalonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recursoSalonButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Cargar Recursos y su ubicacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listaCursosTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(recursoSalonButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(listaCursosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listaSalonesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(listaDocentesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(docentesButton))
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cursosButton)
                                .addComponent(salonesButton))
                            .addComponent(jLabel6)
                            .addComponent(listaCursosTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(listaCursosTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cursosDocenteButton))
                                .addComponent(salonCursosButton))
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaDocentesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(docentesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaCursosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cursosButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaSalonesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salonesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaCursosTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cursosDocenteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaCursosTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salonCursosButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaCursosTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recursoSalonButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cursosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursosButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cursosButtonActionPerformed

    private void salonesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salonesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salonesButtonActionPerformed

    private void cursosDocenteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursosDocenteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cursosDocenteButtonActionPerformed

    private void salonCursosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salonCursosButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salonCursosButtonActionPerformed

    private void cursosButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursosButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cursosButton4ActionPerformed

    private void cursosButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursosButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cursosButton5ActionPerformed

    private void recursoSalonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recursoSalonButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recursoSalonButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cursosButton;
    private javax.swing.JButton cursosButton4;
    private javax.swing.JButton cursosButton5;
    private javax.swing.JButton cursosDocenteButton;
    private javax.swing.JButton docentesButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField listaCursosTextField;
    private javax.swing.JTextField listaCursosTextField2;
    private javax.swing.JTextField listaCursosTextField3;
    private javax.swing.JTextField listaCursosTextField4;
    private javax.swing.JTextField listaCursosTextField5;
    private javax.swing.JTextField listaCursosTextField7;
    private javax.swing.JTextField listaDocentesTextField;
    private javax.swing.JTextField listaSalonesTextField;
    private javax.swing.JButton recursoSalonButton;
    private javax.swing.JButton salonCursosButton;
    private javax.swing.JButton salonesButton;
    // End of variables declaration//GEN-END:variables
}
