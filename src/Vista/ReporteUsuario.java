/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.conexiones;
import Metodos.metodosSQLPersonas;
import Metodos.metodosSQLUsuario;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ReporteUsuario extends javax.swing.JDialog {

    /**
     * Creates new form mBuscarPersonas
     */
    metodosSQLUsuario sql = new metodosSQLUsuario();

    public ReporteUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jUsu.setModel(sql.getDatos());
        this.setLocationRelativeTo(null);

    }

    //VARIABLES
    conexiones con = new conexiones();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    //LISTAR
    metodosSQLPersonas per = new metodosSQLPersonas();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelbotones = new javax.swing.JPanel();
        btnordenar = new javax.swing.JButton();
        btnimpimir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        tablap = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jUsu = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 4, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reportes.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 220));

        panelbotones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPORTES/USUARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18), new java.awt.Color(111, 174, 2))); // NOI18N
        panelbotones.setOpaque(false);

        btnordenar.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnordenar.setForeground(new java.awt.Color(111, 174, 2));
        btnordenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Bar_Chart_32px.png"))); // NOI18N
        btnordenar.setText("ORDENAR");
        btnordenar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnordenar.setContentAreaFilled(false);
        btnordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnordenarActionPerformed(evt);
            }
        });

        btnimpimir.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnimpimir.setForeground(new java.awt.Color(111, 174, 2));
        btnimpimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Monitor_32px.png"))); // NOI18N
        btnimpimir.setText("IMPRIMIR");
        btnimpimir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnimpimir.setContentAreaFilled(false);
        btnimpimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimpimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelbotonesLayout = new javax.swing.GroupLayout(panelbotones);
        panelbotones.setLayout(panelbotonesLayout);
        panelbotonesLayout.setHorizontalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbotonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnimpimir, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnordenar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        panelbotonesLayout.setVerticalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbotonesLayout.createSequentialGroup()
                .addGroup(panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnimpimir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnordenar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jUsu.setBackground(new java.awt.Color(111, 174, 2));
        jUsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 3, true));
        jUsu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jUsu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "APELLIDO", "USUARIO", "PASSWORD", "RANGO", "RECUPERARCODIGO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jUsu.setSelectionBackground(new java.awt.Color(102, 204, 0));
        jUsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUsuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jUsu);

        javax.swing.GroupLayout tablapLayout = new javax.swing.GroupLayout(tablap);
        tablap.setLayout(tablapLayout);
        tablapLayout.setHorizontalGroup(
            tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        tablapLayout.setVerticalGroup(
            tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablapLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void btnordenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnordenarActionPerformed

        jUsu.setModel(sql.Ordernar());
    }//GEN-LAST:event_btnordenarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnimpimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimpimirActionPerformed
        int s = JOptionPane.showConfirmDialog(null, "Esta seguro de imprimir?", "CONFIRMACION", 0);
        if (s == 0) {
            try {
                sql.imprimir();
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(ReporteUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnimpimirActionPerformed

    private void jUsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUsuMouseClicked
        // TODO add your handling code here:
        //        txtPlaca.setEditable(false);

    }//GEN-LAST:event_jUsuMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnimpimir;
    private javax.swing.JButton btnordenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jUsu;
    private javax.swing.JPanel panelbotones;
    private javax.swing.JPanel tablap;
    // End of variables declaration//GEN-END:variables
}
