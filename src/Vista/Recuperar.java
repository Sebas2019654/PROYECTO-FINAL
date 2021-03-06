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
import java.awt.Toolkit;
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
public class Recuperar extends javax.swing.JDialog {

    /**
     * Creates new form mBuscarPersonas
     */
    public Recuperar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        panelbotones = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtrecuperar = new javax.swing.JTextField();
        btnrecuperar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 4, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelbotones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECUPERAR USUARIO/CONTRASE??A", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18), new java.awt.Color(111, 174, 2))); // NOI18N
        panelbotones.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(111, 174, 2));
        jLabel7.setText("Para recuperar su usuario y contrase??a debe introducir su codigo ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(111, 174, 2));
        jLabel8.setText("de recuperaci??n.");

        jPanel2.setBackground(new java.awt.Color(33, 33, 33));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 3, true));

        txtrecuperar.setBackground(new java.awt.Color(51, 51, 51));
        txtrecuperar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtrecuperar.setForeground(new java.awt.Color(111, 174, 2));
        txtrecuperar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 174, 2)));
        txtrecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrecuperarActionPerformed(evt);
            }
        });
        txtrecuperar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrecuperarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrecuperarKeyTyped(evt);
            }
        });

        btnrecuperar.setBackground(new java.awt.Color(255, 255, 255));
        btnrecuperar.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnrecuperar.setForeground(new java.awt.Color(111, 174, 2));
        btnrecuperar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trabajo-en-equipo.png"))); // NOI18N
        btnrecuperar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnrecuperar.setContentAreaFilled(false);
        btnrecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecuperarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(txtrecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnrecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtrecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnrecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout panelbotonesLayout = new javax.swing.GroupLayout(panelbotones);
        panelbotones.setLayout(panelbotonesLayout);
        panelbotonesLayout.setHorizontalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbotonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelbotonesLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        panelbotonesLayout.setVerticalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.add(panelbotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 680, 210));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtrecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrecuperarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrecuperarActionPerformed
    metodosSQLUsuario metodos = new metodosSQLUsuario();
    private void txtrecuperarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrecuperarKeyReleased
        //MENOR A 10 CARACTERES
        if (txtrecuperar.getText().length() == 11) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "??Debe tener 10 letras!", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            txtrecuperar.setText("");
        }
        //VALIDACIONES
        Character validar = evt.getKeyChar();
        //NO TENGAN NUMEROS
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "??Ingrese solo letras!", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            txtrecuperar.setText("");
        }
    }//GEN-LAST:event_txtrecuperarKeyReleased

    private void txtrecuperarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrecuperarKeyTyped
         
    }//GEN-LAST:event_txtrecuperarKeyTyped

    private void btnrecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecuperarActionPerformed
        String busqueda_user = metodos.RecuperarUsuario(txtrecuperar.getText());
         if (busqueda_user.equals("No existe")) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "CODIGO INVALIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtrecuperar.setText("");
        } else {
             getToolkit().beep();
             JOptionPane.showMessageDialog(this, "RECUPERADO CON EXITO \n" + busqueda_user,"USUARIO RECUPERADO",JOptionPane.INFORMATION_MESSAGE);
             txtrecuperar.setText("");
       
        }
    }//GEN-LAST:event_btnrecuperarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnrecuperar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelbotones;
    private javax.swing.JTextField txtrecuperar;
    // End of variables declaration//GEN-END:variables
}
