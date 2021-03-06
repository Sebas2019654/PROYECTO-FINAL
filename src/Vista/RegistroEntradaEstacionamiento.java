/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Metodos.MetodoSQLEstacionamiento;
import Metodos.MetodoSQLVehiculos;
import static Metodos.metodosSQLUsuario.con;
import static Metodos.metodosSQLUsuario.sentencia_preparada;
import Modelo.Empleados;
import Modelo.Estacionamiento;
import Vista.MenuPrincipal;
import java.awt.Toolkit;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class RegistroEntradaEstacionamiento extends javax.swing.JDialog {

    /**
     * Creates new form mBuscarPersonas
     */
    MetodoSQLVehiculos sql = new MetodoSQLVehiculos();
    MetodoSQLEstacionamiento sql2 = new MetodoSQLEstacionamiento();

    public RegistroEntradaEstacionamiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sql.mostrarJ(CBPlaca);
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
        btnSalir = new javax.swing.JButton();
        tablap = new javax.swing.JPanel();
        btnconsultar1 = new javax.swing.JButton();
        lblcodigo = new javax.swing.JLabel();
        CBArea = new javax.swing.JComboBox<>();
        lblcodigo1 = new javax.swing.JLabel();
        lblcodigo2 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        btnconsultar2 = new javax.swing.JButton();
        CBPlaca = new javax.swing.JComboBox<>();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 4, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 160, 43));

        tablap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO DE ENTRADA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18), new java.awt.Color(111, 174, 2))); // NOI18N
        tablap.setOpaque(false);

        btnconsultar1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnconsultar1.setForeground(new java.awt.Color(111, 174, 2));
        btnconsultar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/estacionamiento.png"))); // NOI18N
        btnconsultar1.setText("LIMPIAR");
        btnconsultar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnconsultar1.setContentAreaFilled(false);
        btnconsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultar1ActionPerformed(evt);
            }
        });

        lblcodigo.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo.setText("FECHA:");

        CBArea.setBackground(new java.awt.Color(51, 51, 51));
        CBArea.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CBArea.setForeground(new java.awt.Color(111, 174, 2));
        CBArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        CBArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CBArea.setOpaque(false);
        CBArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBAreaActionPerformed(evt);
            }
        });

        lblcodigo1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo1.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo1.setText("NumERO area:");

        lblcodigo2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo2.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo2.setText("PLACA");

        date.setBackground(new java.awt.Color(0, 0, 0));
        date.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 3, true));
        date.setForeground(new java.awt.Color(111, 174, 2));
        date.setDateFormatString("yyyy-MM-dd");
        date.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        btnconsultar2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnconsultar2.setForeground(new java.awt.Color(111, 174, 2));
        btnconsultar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/estacionamiento.png"))); // NOI18N
        btnconsultar2.setText("REGISTRAR");
        btnconsultar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnconsultar2.setContentAreaFilled(false);
        btnconsultar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultar2ActionPerformed(evt);
            }
        });

        CBPlaca.setBackground(new java.awt.Color(51, 51, 51));
        CBPlaca.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CBPlaca.setForeground(new java.awt.Color(111, 174, 2));
        CBPlaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        CBPlaca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CBPlaca.setOpaque(false);

        javax.swing.GroupLayout tablapLayout = new javax.swing.GroupLayout(tablap);
        tablap.setLayout(tablapLayout);
        tablapLayout.setHorizontalGroup(
            tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodigo1)
                    .addGroup(tablapLayout.createSequentialGroup()
                        .addGroup(tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablapLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblcodigo))
                            .addComponent(lblcodigo2))
                        .addGap(24, 24, 24)
                        .addGroup(tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBArea, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(345, 345, 345))
            .addGroup(tablapLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnconsultar2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnconsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tablapLayout.setVerticalGroup(
            tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablapLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblcodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnconsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsultar2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(tablap, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 430, 350));

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
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 40, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registros.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnconsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultar1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnconsultar1ActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnconsultar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultar2ActionPerformed
        int s = JOptionPane.showConfirmDialog(null, "Desea asignar el vehiculo al estacionamiento", "Si/No", 0);
        if (s == 0) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        java.util.Date entrada = cal.getTime();
        LocalTime fechaentrada = LocalTime.parse(dateFormat.format(entrada));
         java.sql.Date fecha = null;
                Date dia = date.getDate();
                if (dia != null) {
                    long d = dia.getTime();
                    fecha = new java.sql.Date(d);

                } else {
                    Date dates = new Date();
                    DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                    formato.format(dates);
                    date.setDate(dates);
                    long d = dia.getTime();
                    fecha = new java.sql.Date(d);
                }

        //ring num_area, String nro_Placa, Date fecha, LocalTime hora_entrad
        Estacionamiento emp = new Estacionamiento((String) CBArea.getSelectedItem(),(String) CBPlaca.getSelectedItem(),fecha, fechaentrada);
        sql2.guardar(emp);
        clear();
        }
    }//GEN-LAST:event_btnconsultar2ActionPerformed

    private void CBAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBAreaActionPerformed
    public void clear() {
        CBArea.setSelectedItem("Seleccione");
        CBPlaca.setSelectedItem("Seleccione");
        date.setDate(null);
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBArea;
    private javax.swing.JComboBox<String> CBPlaca;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnconsultar1;
    private javax.swing.JButton btnconsultar2;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblcodigo1;
    private javax.swing.JLabel lblcodigo2;
    private javax.swing.JPanel tablap;
    // End of variables declaration//GEN-END:variables
}
