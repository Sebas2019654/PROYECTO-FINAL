/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Metodos.MetodoSQLVehiculos;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ReporteVehiculo extends javax.swing.JDialog {

    /**
     * Creates new form mBuscarPersonas
     */
    MetodoSQLVehiculos sql = new MetodoSQLVehiculos();

    public ReporteVehiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jVehiculos.setModel(sql.getDatos());
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelbotones = new javax.swing.JPanel();
        btnconsultar1 = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        tablap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jVehiculos = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 4, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelbotones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPORTES/VEHICULO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18), new java.awt.Color(111, 174, 2))); // NOI18N
        panelbotones.setOpaque(false);

        btnconsultar1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnconsultar1.setForeground(new java.awt.Color(111, 174, 2));
        btnconsultar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Bar_Chart_32px.png"))); // NOI18N
        btnconsultar1.setText("ORDENAR");
        btnconsultar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnconsultar1.setContentAreaFilled(false);
        btnconsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultar1ActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(111, 174, 2));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Monitor_32px.png"))); // NOI18N
        btnActualizar.setText("IMPRIMIR");
        btnActualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelbotonesLayout = new javax.swing.GroupLayout(panelbotones);
        panelbotones.setLayout(panelbotonesLayout);
        panelbotonesLayout.setHorizontalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnconsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        panelbotonesLayout.setVerticalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbotonesLayout.createSequentialGroup()
                .addGroup(panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnconsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jPanel1.add(panelbotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 420, 80));

        btnSalir.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(111, 174, 2));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Home_32px.png"))); // NOI18N
        btnSalir.setText("REGRESAR");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 160, 43));

        tablap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMINA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18), new java.awt.Color(111, 174, 2))); // NOI18N
        tablap.setOpaque(false);

        jVehiculos.setBackground(new java.awt.Color(111, 174, 2));
        jVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PLACA", "Tipo", "Marca", "Modelo", "Matricula", "Color"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jVehiculos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jVehiculosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jVehiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jVehiculos);

        javax.swing.GroupLayout tablapLayout = new javax.swing.GroupLayout(tablap);
        tablap.setLayout(tablapLayout);
        tablapLayout.setHorizontalGroup(
            tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );
        tablapLayout.setVerticalGroup(
            tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(tablap, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 560, 200));

        btnCerrar.setBackground(new java.awt.Color(0, 0, 0));
        btnCerrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Delete_32px.png"))); // NOI18N
        btnCerrar.setAutoscrolls(true);
        btnCerrar.setBorder(null);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.setOpaque(true);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 40, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reportes.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnconsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultar1ActionPerformed
        // TODO add your handling code here:
        jVehiculos.setModel(sql.Ordernar());
    }//GEN-LAST:event_btnconsultar1ActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int s = JOptionPane.showConfirmDialog(null, "Esta seguro de imprimir?", "CONFIRMACION", 0);
        if (s == 0) {
            try {
                sql.imprimir();
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(ReportePersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jVehiculosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jVehiculosAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jVehiculosAncestorAdded

    private void jVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jVehiculosMouseClicked

    }//GEN-LAST:event_jVehiculosMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnconsultar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jVehiculos;
    private javax.swing.JPanel panelbotones;
    private javax.swing.JPanel tablap;
    // End of variables declaration//GEN-END:variables
}
